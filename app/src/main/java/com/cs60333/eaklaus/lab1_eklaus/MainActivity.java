package com.cs60333.eaklaus.lab1_eklaus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle("ND Athletics");

       ArrayList<String[]> games = new MyCsvFileReader(this).readCsvFile(R.raw.schedule);
        final ArrayList<Team> teams = new ArrayList<>();


        for (int i=0; i<games.size(); i++) {
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

    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();

        if (res_id == R.id.share) {
// code for sharing the schedule
        }

        else if (res_id == R.id.sync) {
// Snackbar with Try Again action
        }

        else if (res_id == R.id.settings) {
// Floating Contextual Menu with options

        }
        return true;
    }
}
