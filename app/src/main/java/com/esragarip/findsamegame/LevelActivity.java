package com.esragarip.findsamegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelActivity extends AppCompatActivity {
    Button level1, level2, level3, level4, level5, level6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);
        level4 = findViewById(R.id.level4);
        level5 = findViewById(R.id.level5);
        level6 = findViewById(R.id.level6);
    }

    public void level(View view) {
        String levelName = "";
        Intent intent = new Intent(LevelActivity.this, MainActivity.class);
        if (view.getId() == level1.getId()) {
            levelName = "level1";
            intent.putExtra("levelName", levelName);

        } else if (view.getId() == level2.getId()) {
            levelName = "level2";
            intent.putExtra("levelName", levelName);

        } else if (view.getId() == level3.getId()) {
            levelName = "level3";
            intent.putExtra("levelName", levelName);

        } else if (view.getId() == level4.getId()) {
            levelName = "level4";
            ;
            intent.putExtra("levelName", levelName);

        } else if (view.getId() == level5.getId()) {
            levelName = "level5";
            intent.putExtra("levelName", levelName);
        } else if (view.getId() == level6.getId()) {
            levelName = "level6";
            intent.putExtra("levelName", levelName);
        }
        startActivity(intent);
    }

    public void exit(View view) {

        System.exit(0);
    }

}