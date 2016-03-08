package com.example.jangofetthd.try2think;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Levels extends AppCompatActivity {

    public static Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
    public static Button[] buttons = {b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16};
    public static int[] buttonsR = {R.id.b1,R.id.b2,R.id.b3,R.id.b4,R.id.b5,R.id.b6,R.id.b7,R.id.b8,R.id.b9,R.id.b10,R.id.b11,R.id.b12,R.id.b13,R.id.b14,R.id.b15,R.id.b16};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
    }

    protected void onResume(){
        super.onResume();
        db.loadch(v.section);
        for (int i=0; i<buttons.length; i++){
            if (db.sections[v.section].section[i].status == 1) {
                buttons[i]=(Button)findViewById(buttonsR[i]);
                buttons[i].getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
            }
        }
    }

    public void onClick(View view) {
        Intent goLvL = new Intent(this, GameProcess.class);
        for (int i=0; i<16; i++) {
            if (view.getId() == buttonsR[i]) {
                    v.level = i;
                    startActivity(goLvL);
            }
        }

    }
}
