package com.example.jangofetthd.try2think;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public String input="";
    TextView in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        in = (TextView)findViewById(R.id.input);

    }

    public void onKeyboard(View view) {
        switch (view.getId()){
            case R.id.й: input+="й"; break;
            case R.id.ц: input+="ц"; break;
            case R.id.у: input+="у"; break;
            case R.id.к: input+="к"; break;
            case R.id.е: input+="е"; break;
            case R.id.н: input+="н"; break;
            case R.id.г: input+="г"; break;
            case R.id.ш: input+="ш"; break;
            case R.id.щ: input+="щ"; break;
            case R.id.з: input+="з"; break;
            case R.id.х: input+="х"; break;
            case R.id.ф: input+="ф"; break;
            case R.id.ы: input+="ы"; break;
            case R.id.в: input+="в"; break;
            case R.id.а: input+="а"; break;
            case R.id.п: input+="п"; break;
            case R.id.р: input+="р"; break;
            case R.id.о: input+="о"; break;
            case R.id.л: input+="л"; break;
            case R.id.д: input+="д"; break;
            case R.id.ж: input+="ж"; break;
            case R.id.э: input+="э"; break;
            case R.id.я: input+="я"; break;
            case R.id.ч: input+="ч"; break;
            case R.id.с: input+="с"; break;
            case R.id.м: input+="м"; break;
            case R.id.и: input+="и"; break;
            case R.id.т: input+="т"; break;
            case R.id.ь: input+="ь"; break;
            case R.id.б: input+="б"; break;
            case R.id.ю: input+="ю"; break;
            case R.id.backspace: if (input.length() != 0) {
                input = input.substring(0, input.length() - 1);
                Button backspace = (Button) findViewById(R.id.backspace);
                backspace.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        input = "";
                        in.setText(input);
                        return false;
                    }
                });
            }; break;
            case R.id.enter: if (v.equalsStr(input, db.sections[v.section].section[v.level].answer)) v.win(); break;
        }
        in.setText(input);
    }
}
