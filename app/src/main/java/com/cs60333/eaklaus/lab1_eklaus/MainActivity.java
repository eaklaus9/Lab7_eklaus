package com.cs60333.eaklaus.lab1_eklaus;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;


public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitle("ND Athletics");
        setSupportActionBar(myToolbar);

        dbHelper = new DBHelper(this.getApplicationContext());
        dbHelper.onUpgrade(dbHelper.getWritableDatabase(), 1, 2);

        ArrayList<String[]> games = new MyCsvFileReader(this).readCsvFile(R.raw.schedule);

        for (int i = 0; i < games.size(); i++) {
            String[] game = games.get(i);

            String teamlogo = String.valueOf(game[0]);
            ContentValues contentValueslogo = new ContentValues();
            contentValueslogo.put(dbHelper.COL_LOGO, teamlogo);
            dbHelper.insertData("Teams", contentValueslogo);

            String teamname = String.valueOf(game[1]);
            ContentValues contentValuesname = new ContentValues();
            contentValuesname.put(dbHelper.COL_NAME, teamname);
            dbHelper.insertData("Teams", contentValuesname);

            String teammascot = String.valueOf(game[5]);
            ContentValues contentValuesmascot = new ContentValues();
            contentValuesmascot.put(dbHelper.COL_MASCOT, teammascot);
            dbHelper.insertData("Teams", contentValuesmascot);

            String teamrecord = String.valueOf(game[7]);
            ContentValues contentValuesrecord = new ContentValues();
            contentValuesrecord.put(dbHelper.COL_RECORD, teamrecord);
            dbHelper.insertData("Teams", contentValuesrecord);

        }

        final ArrayList<Team> teams = new ArrayList<>();


        for (int i = 0; i < games.size(); i++) {
            String[] game = games.get(i);
            Team team = new Team(game[0], game[1], game[2], game[3], game[4], game[5], game[6], game[7], game[8]);
            teams.add(team);
        }

        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(this, teams);
        ListView scheduleListView = (ListView) findViewById(R.id.scheduleListView);
        scheduleListView.setAdapter(scheduleAdapter);

        AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                i.putExtra("team", teams.get(position));
                startActivity(i);
            }
        };

        scheduleListView.setOnItemClickListener(clickListener);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public StringBuilder gameSchedule(){
        StringBuilder sb = new StringBuilder();
        return sb.append(R.raw.schedule);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();

        if (res_id == R.id.share) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(android.content.Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "BasketBall Matches");
            shareIntent.putExtra(Intent.EXTRA_TEXT, gameSchedule().toString());
            startActivity(Intent.createChooser(shareIntent, "Share via"));
        } else if (res_id == R.id.sync) {
            final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorlayout);
            Snackbar snackbar = Snackbar.make(coordinatorLayout, "Sync is not yet implemented", Snackbar.LENGTH_LONG);
            snackbar.setAction("Try Again", new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Snackbar.make(coordinatorLayout, "Wait for the next few labs. Thank you for your patience", Snackbar.LENGTH_LONG).show();
                }
            });
            snackbar.show();
        } else if (res_id == R.id.settings) {
            View view = findViewById(R.id.settings);
            registerForContextMenu(findViewById(R.id.settings));
            openContextMenu(view);
            }
        return true;
    }

    @Override
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater contextmenuInflater = getMenuInflater();
        contextmenuInflater.inflate(R.menu.floating_contextual_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int item_id = item.getItemId();
        if (item_id == R.id.women) {
            // to be implemented later
        } else if (item_id == R.id.mens){
            //to be implemented later
        } else if (item_id == R.id.oncampus){
            //to be implemented later
        } else if (item_id == R.id.offcampus){
            //to be implemented later
        }
        return false;
    }
}