package com.example.vegetablezooapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class LevelTwoFinish extends AppCompatActivity {

    public static final String VEGETABLE = "veg";
    public static final String STATE = "game";
    public static final String VEG_LIST = "list";
    public static final String SCORE = "score";
    public static final String LEVEL = "level";
    private static int SPLASH_SCREEN_INT = 6000;
    private static TextView scoreCount;

    private ArrayList<String> vegetables = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two_finish);

        Intent intent = getIntent();
        final String veg;
        final int gameState = 1;
        final int level = intent.getIntExtra(LEVEL, 0) + 1;
        final ArrayList<String> vegetables = new ArrayList<String>();;
        vegetables.add("CARROT");
        vegetables.add("RADISH");
        vegetables.add("CELERY");
        vegetables.add("POTATO");
        vegetables.add("ONIONS");
        final int score = intent.getIntExtra(SCORE, 0);
        int random = new Random().nextInt(vegetables.size() - 1);

        veg = vegetables.get(random);
        vegetables.remove(random);

        scoreCount = (TextView) findViewById(R.id.scoreText);
        scoreCount.setText("" + score);

        new Handler().postDelayed(new Runnable(){

            public void run(){
                Intent intent2 = new Intent(LevelTwoFinish.this, MainMenu.class);
                startActivity(intent2);
            }
        },SPLASH_SCREEN_INT);
    }
}