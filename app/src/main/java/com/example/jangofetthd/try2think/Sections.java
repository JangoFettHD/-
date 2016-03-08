package com.example.jangofetthd.try2think;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Sections extends AppCompatActivity {

    HashMap<String, String> section = new HashMap<String, String>();
    ArrayList<HashMap<String, String>> playlist =
            new ArrayList<HashMap<String, String>>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sections);
        lv = (ListView) findViewById(R.id.listView);
        db.P_Main_settings=getSharedPreferences(PrefsContract.db1_name, Context.MODE_PRIVATE);


        for (int i = 0; i < db.sections.length; i++) {
            section.put("name", db.sections[i].name);
            section.put("coins", Integer.toString(db.sections[i].price));
            section.put("lvls", Integer.toString(db.sections[i].lvls));
            playlist.add((HashMap<String, String>) section.clone());
        }

        SimpleAdapter simpleAdapter =
                new SimpleAdapter(this, playlist, R.layout.section,
                        new String[] {"name", "coins", "lvls"},
                        new int[] {R.id.name, R.id.coins, R.id.lvls});
        lv.setAdapter(simpleAdapter);

        final Intent go_train = new Intent(this, Levels.class);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                v.section=position;
                Log.i("SuperLog", "v.section "+v.section);
                startActivity(go_train);
            }
        });

    }

}
