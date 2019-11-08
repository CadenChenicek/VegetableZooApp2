package com.example.vegetablezooapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class MainMenu extends AppCompatActivity {
    private static String veg;
    public static final ArrayList<String> vegetables = new ArrayList<String>();
    private static int gameState = 1;
    private static int score = 0;
    private static int level = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        vegetables.add("BEET");
        vegetables.add("LEEK");
        vegetables.add("KALE");
        vegetables.add("CORN");
        vegetables.add("PEAS");

        int random = new Random().nextInt(vegetables.size() - 1);
        veg = vegetables.get(random);
        vegetables.remove(random);
    }

    public void clickPlay(View v) {
        Intent intent = new Intent(MainMenu.this, GamePlayActivity.class);
        intent.putExtra(GamePlayActivity.VEGETABLE, veg);
        intent.putExtra(GamePlayActivity.STATE, gameState);
        intent.putExtra(GamePlayActivity.VEG_LIST, vegetables);
        intent.putExtra(GamePlayActivity.SCORE, score);
        intent.putExtra(GamePlayActivity.LEVEL, level);
        startActivity(intent);
    }

    public void clickInstruct(View v) {
        Intent intent = new Intent(MainMenu.this, InstructActivity.class);
        startActivity(intent);
    }
}