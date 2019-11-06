package com.example.vegetablezooapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.util.ArrayList;


public class correctSplash extends AppCompatActivity {

    public static final String VEGETABLE = "veg";
    public static final String STATE = "game";
    public static final String VEG_LIST = "list";
    public static final String SCORE = "score";
    public static final String LEVEL = "level";
    private static int SPLASH_SCREEN_INT = 3000;

    private TextView scoreCount;

    private ArrayList<String> vegetables = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_splash);

        Intent intent = getIntent();
        final String veg = intent.getStringExtra(VEGETABLE);
        final int level = intent.getIntExtra(LEVEL, 0);
        final int gameState = intent.getIntExtra(STATE, 0);
        final ArrayList<String> vegetables = intent.getStringArrayListExtra(VEG_LIST);
        final int score = intent.getIntExtra(SCORE, 0);

        scoreCount = (TextView) findViewById(R.id.scoreText);
        scoreCount.setText("" + score);

        new Handler().postDelayed(new Runnable(){

            public void run(){

                if (level == 1) {
                    Intent intent2 = new Intent(correctSplash.this, GamePlayActivity.class);
                    intent2.putExtra(LEVEL, 0);
                    intent2.putExtra(GamePlayActivity.VEGETABLE, veg);
                    intent2.putExtra(GamePlayActivity.STATE, gameState);
                    intent2.putExtra(GamePlayActivity.VEG_LIST, vegetables);
                    intent2.putExtra(GamePlayActivity.SCORE, score);
                    startActivity(intent2);
                }
                else if (level == 2){
                    Intent intent2 = new Intent(correctSplash.this, GamePlayActivity2.class);
                    intent2.putExtra(LEVEL, 0);
                    intent2.putExtra(GamePlayActivity2.VEGETABLE, veg);
                    intent2.putExtra(GamePlayActivity2.STATE, gameState);
                    intent2.putExtra(GamePlayActivity2.VEG_LIST, vegetables);
                    intent2.putExtra(GamePlayActivity2.SCORE, score);
                    startActivity(intent2);
                }
            }
        },SPLASH_SCREEN_INT);
    }
}
