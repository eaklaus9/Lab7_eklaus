package com.cs60333.eaklaus.lab1_eklaus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        final ArrayList<Team> teams = new ArrayList<>();


        Team floridastate = new Team("@mipmap/floridastate", "Florida State", "Feb 11", "Saturday, February 11, 6:00 PM",
                "Purcell Pavilion at the Joyce Center, Notre Dame, IN", "Seminoles",
                "(21-5)", "72-84", "Final");
        teams.add(floridastate);

        Team bostoncollege = new Team("@mipmap/bc", "Boston College", "Feb 14", "Tuesday, February 14, 7:00 PM",
                "Silvio O. Conte Forum, Chestnut Hill, Massachusetts","Golden Eagles",
                "(9-18)", "76-84", "Final");
        teams.add(bostoncollege);

        Team ncstate = new Team("@mipmap/ncstate", "North Carolina State", "Feb 18", "Saturday, February 18, 12:00 PM",
                "NC Arena, Raleigh, North Carolina", "Wolf Pack",
                "(14-14)", "72-81", "Final");
        teams.add(ncstate);

        Team georgiatech = new Team("@mipmap/georgiatech", "Georgia Tech", "Feb 26", "Sunday, February 26, 6:30 PM",
                "Purcell Pavilion at the Joyce Center, Notre Dame, IN", "Yellow Jackets",
                "(15-11)", "--", "--");
        teams.add(georgiatech);

        Team bostoncollege2 = new Team("@mipmap/bc", "Boston College", "Feb 14", "Tuesday, February 14, 7:00 PM",
                "Silvio O. Conte Forum, Chestnut Hill, Massachusetts","Golden Eagles",
                "(9-18)", "76-84", "Final");
        teams.add(bostoncollege2);

        Team acc = new Team("@mipmap/acc", "ACC Tournament ", "March 7",
                "TBD", "TBD", "TBD", "--", "--", "--");
        teams.add(acc);

        Team ncaa = new Team("@mipmap/basketball", "NCAA Tournament", "March 16",
                "TBD", "TBD", "TBD", "--", "--", "--");
        teams.add(ncaa);



        final ArrayList<String[]> schedule = new ArrayList<String[]>();
            schedule.add(new String[]{"@mipmap/floridastate", "Florida State", "Feb 11", "Saturday, February 11, 6:00 PM",
                    "Purcell Pavilion at the Joyce Center, Notre Dame, IN", "Seminoles",
                    "(21-5)", "72-84", "Final"});
            schedule.add(new String[]{"@mipmap/bc", "Boston College", "Feb 14", "Tuesday, February 14, 7:00 PM",
                    "Silvio O. Conte Forum, Chestnut Hill, Massachusetts", "Golden Eagles",
                    "(9-18)", "76-84", "Final"});
            schedule.add(new String[]{"@mipmap/ncstate", "North Carolina State", "Feb 18", "Saturday, February 18, 12:00 PM",
                    "NC Arena, Raleigh, North Carolina", "Wolf Pack",
                    "(14-14)", "72-81", "Final"});
            schedule.add(new String[]{"@mipmap/georgiatech", "Georgia Tech", "Feb 26", "Sunday, February 26, 6:30 PM",
                    "Purcell Pavilion at the Joyce Center, Notre Dame, IN", "Yellow Jackets",
                    "(15-11)", "--", "--"});
            schedule.add(new String[]{"@mipmap/bc", "Boston College", "March 1", "Wednesday, March 1, 8:00 PM on ESFC",
                    "Purcell Pavilion at the Joyce Center, Notre Dame, IN", "Golden Eagles",
                    "(9-18)", "--", "--"});
            schedule.add(new String[]{"@mipmap/acc", "ACC Tournament ", "March 7",
                    "TBD", "TBD", "TBD", "--", "--", "--"});
            schedule.add(new String[]{"@mipmap/basketball", "NCAA Tournament", "March 16",
                    "TBD", "TBD", "TBD", "--", "--", "--"});


        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(this, schedule);
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
}
