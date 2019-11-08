package com.example.vegetablezooapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.TimeUtils;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GamePlayActivity2 extends AppCompatActivity {
    public static final String VEGETABLE = "veg";
    public static final String STATE = "game";
    public static final String VEG_LIST = "list";
    public static final String SCORE = "score";
    public static final String LEVEL = "level";
    private ArrayList<String> vegetables = new ArrayList<String>();

    private int level;
    private int gameState;
    private int score;
    private String scoreString;
    private String veg;

    private TextView countdownText;
    private TextView char1, char2, char3, char4, char5, char6;
    private TextView space1, space2, space3, space4, space5, space6;
    private TextView scoreCount;
    private Character[] vegLetterArray = new Character[6];


    private static final long START_TIME_IN_MILLIS = 61000;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = START_TIME_IN_MILLIS;
    private boolean timeRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        veg = intent.getStringExtra(VEGETABLE);
        gameState = intent.getIntExtra(STATE,0);
        vegetables = intent.getStringArrayListExtra(VEG_LIST);
        score = intent.getIntExtra(SCORE, 0);
        level = intent.getIntExtra(LEVEL, 0);

        if (gameState == 1){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_game_play2);

            char1 = (TextView) findViewById(R.id.letter1);
            char2 = (TextView) findViewById(R.id.letter2);
            char3 = (TextView) findViewById(R.id.letter3);
            char4 = (TextView) findViewById(R.id.letter4);
            char5 = (TextView) findViewById(R.id.letter5);
            char6 = (TextView) findViewById(R.id.letter6);

            space1 = (TextView) findViewById(R.id.letterSpace1);
            space2 = (TextView) findViewById(R.id.letterSpace2);
            space3 = (TextView) findViewById(R.id.letterSpace3);
            space4 = (TextView) findViewById(R.id.letterSpace4);
            space5 = (TextView) findViewById(R.id.letterSpace5);
            space6 = (TextView) findViewById(R.id.letterSpace6);

            char1.setOnLongClickListener(longclickListener);
            char2.setOnLongClickListener(longclickListener);
            char3.setOnLongClickListener(longclickListener);
            char4.setOnLongClickListener(longclickListener);
            char5.setOnLongClickListener(longclickListener);
            char6.setOnLongClickListener(longclickListener);

            space1.setOnDragListener(dragListener1);
            space2.setOnDragListener(dragListener2);
            space3.setOnDragListener(dragListener3);
            space4.setOnDragListener(dragListener4);
            space5.setOnDragListener(dragListener5);
            space6.setOnDragListener(dragListener6);

            scoreCount = (TextView) findViewById(R.id.scoreText);
            scoreCount.setText("" + score);

            countdownText = findViewById(R.id.countdownText);
            startTimer();

            assignLetters();

        }
        else if (gameState == 2){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_game_play2);

            char1 = (TextView) findViewById(R.id.letter1);
            char2 = (TextView) findViewById(R.id.letter2);
            char3 = (TextView) findViewById(R.id.letter3);
            char4 = (TextView) findViewById(R.id.letter4);
            char5 = (TextView) findViewById(R.id.letter5);
            char6 = (TextView) findViewById(R.id.letter6);

            space1 = (TextView) findViewById(R.id.letterSpace1);
            space2 = (TextView) findViewById(R.id.letterSpace2);
            space3 = (TextView) findViewById(R.id.letterSpace3);
            space4 = (TextView) findViewById(R.id.letterSpace4);
            space5 = (TextView) findViewById(R.id.letterSpace5);
            space6 = (TextView) findViewById(R.id.letterSpace6);

            char1.setOnLongClickListener(longclickListener);
            char2.setOnLongClickListener(longclickListener);
            char3.setOnLongClickListener(longclickListener);
            char4.setOnLongClickListener(longclickListener);
            char5.setOnLongClickListener(longclickListener);
            char6.setOnLongClickListener(longclickListener);

            space1.setOnDragListener(dragListener1);
            space2.setOnDragListener(dragListener2);
            space3.setOnDragListener(dragListener3);
            space4.setOnDragListener(dragListener4);
            space5.setOnDragListener(dragListener5);
            space6.setOnDragListener(dragListener6);

            scoreCount = (TextView) findViewById(R.id.scoreText);
            scoreCount.setText("" + score);

            countdownText = findViewById(R.id.countdownText);
            startTimer();

            assignLetters();
        }
        else if (gameState == 3){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_game_play2);

            char1 = (TextView) findViewById(R.id.letter1);
            char2 = (TextView) findViewById(R.id.letter2);
            char3 = (TextView) findViewById(R.id.letter3);
            char4 = (TextView) findViewById(R.id.letter4);
            char5 = (TextView) findViewById(R.id.letter5);
            char6 = (TextView) findViewById(R.id.letter6);

            space1 = (TextView) findViewById(R.id.letterSpace1);
            space2 = (TextView) findViewById(R.id.letterSpace2);
            space3 = (TextView) findViewById(R.id.letterSpace3);
            space4 = (TextView) findViewById(R.id.letterSpace4);
            space5 = (TextView) findViewById(R.id.letterSpace5);
            space6 = (TextView) findViewById(R.id.letterSpace6);

            char1.setOnLongClickListener(longclickListener);
            char2.setOnLongClickListener(longclickListener);
            char3.setOnLongClickListener(longclickListener);
            char4.setOnLongClickListener(longclickListener);
            char5.setOnLongClickListener(longclickListener);
            char6.setOnLongClickListener(longclickListener);

            space1.setOnDragListener(dragListener1);
            space2.setOnDragListener(dragListener2);
            space3.setOnDragListener(dragListener3);
            space4.setOnDragListener(dragListener4);
            space5.setOnDragListener(dragListener5);
            space6.setOnDragListener(dragListener6);

            scoreCount = (TextView) findViewById(R.id.scoreText);
            scoreCount.setText("" + score);

            countdownText = findViewById(R.id.countdownText);
            startTimer();

            assignLetters();
        }
    }

    private void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeRunning = false;
            }
        }.start();

        timeRunning = true;
    }

    private void updateCountDownText(){
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);

        countdownText.setText(timeLeftFormatted);
    }


    public void checkFinished(View v) {
        Character letter1 = veg.charAt(0);
        Character letter2 = veg.charAt(1);
        Character letter3 = veg.charAt(2);
        Character letter4 = veg.charAt(3);
        Character letter5 = veg.charAt(4);
        Character letter6 = veg.charAt(5);

        int random = new Random().nextInt(vegetables.size());
        veg = vegetables.get(random);
        vegetables.remove(random);

        if (letter1.toString().equals(space1.getText()) && letter2.toString().equals(space2.getText()) &&
                letter3.toString().equals(space3.getText()) && letter4.toString().equals(space4.getText()) &&
                letter5.toString().equals(space5.getText()) && letter6.toString().equals(space6.getText())){

            score += timeLeftInMillis/1000;

            if (gameState == 1){
                gameState = 2;
                Intent intent = new Intent(GamePlayActivity2.this, correctSplash.class);
                intent.putExtra(correctSplash.VEGETABLE, veg);
                intent.putExtra(correctSplash.STATE, gameState);
                intent.putExtra(correctSplash.VEG_LIST, vegetables);
                intent.putExtra(correctSplash.SCORE, score);
                intent.putExtra(correctSplash.LEVEL, level);
                startActivity(intent);
                finish();
            }
            else if (gameState == 2){
                gameState = 3;
                Intent intent = new Intent(GamePlayActivity2.this, correctSplash.class);
                intent.putExtra(correctSplash.VEGETABLE, veg);
                intent.putExtra(correctSplash.STATE, gameState);
                intent.putExtra(correctSplash.VEG_LIST, vegetables);
                intent.putExtra(correctSplash.SCORE, score);
                intent.putExtra(correctSplash.LEVEL, level);
                startActivity(intent);
                finish();
            }
            else{
                Intent intent = new Intent(GamePlayActivity2.this, LevelTwoFinish.class);
                intent.putExtra(LevelTwoFinish.VEGETABLE, veg);
                intent.putExtra(LevelTwoFinish.STATE, gameState);
                intent.putExtra(LevelTwoFinish.VEG_LIST, vegetables);
                intent.putExtra(LevelTwoFinish.SCORE, score);
                intent.putExtra(LevelTwoFinish.LEVEL, level);
                startActivity(intent);
                finish();
            }
        }
        else{
            if (gameState == 1){
                gameState = 2;
                Intent intent = new Intent(GamePlayActivity2.this, incorrectSplash.class);
                intent.putExtra(incorrectSplash.VEGETABLE, veg);
                intent.putExtra(incorrectSplash.STATE, gameState);
                intent.putExtra(incorrectSplash.VEG_LIST, vegetables);
                intent.putExtra(incorrectSplash.SCORE, score);
                intent.putExtra(incorrectSplash.LEVEL, level);
                startActivity(intent);
                finish();
            }
            else if (gameState == 2){
                gameState = 3;
                Intent intent = new Intent(GamePlayActivity2.this, incorrectSplash.class);
                intent.putExtra(incorrectSplash.VEGETABLE, veg);
                intent.putExtra(incorrectSplash.STATE, gameState);
                intent.putExtra(incorrectSplash.VEG_LIST, vegetables);
                intent.putExtra(incorrectSplash.SCORE, score);
                intent.putExtra(incorrectSplash.LEVEL, level);
                startActivity(intent);
                finish();
            }
            else{
                Intent intent = new Intent(GamePlayActivity2.this, LevelTwoFinish.class);
                intent.putExtra(LevelTwoFinish.VEGETABLE, veg);
                intent.putExtra(LevelTwoFinish.STATE, gameState);
                intent.putExtra(LevelTwoFinish.VEG_LIST, vegetables);
                intent.putExtra(LevelTwoFinish.SCORE, score);
                intent.putExtra(LevelTwoFinish.LEVEL, level);
                startActivity(intent);
                finish();
            }
        }
    }

    public void assignLetters(){
        int len = veg.length() - 1;
        for (int i = 0; i <= len; i++){
            vegLetterArray[i] = veg.charAt(i);
        }
        //char1.setText(vegLetterArray[0].toString());
        RandomizeArray(vegLetterArray);
        char1.setText(vegLetterArray[0].toString());
        char2.setText(vegLetterArray[1].toString());
        char3.setText(vegLetterArray[2].toString());
        char4.setText(vegLetterArray[3].toString());
        char5.setText(vegLetterArray[4].toString());
        char6.setText(vegLetterArray[5].toString());

    }

    public static Character[] RandomizeArray(Character[] array){
        Random rgen = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            Character temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }

    View.OnLongClickListener longclickListener = new View.OnLongClickListener(){
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder, v, 0);
            return true;
        }
    };

    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }

    class MyDragListener implements View.OnDragListener {
        Drawable enterShape = getResources().getDrawable(
                R.drawable.shape_droptarget);
        Drawable normalShape = getResources().getDrawable(R.drawable.shape);

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    v.setBackgroundDrawable(enterShape);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    v.setBackgroundDrawable(normalShape);
                    break;
                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup
                    View view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    LinearLayout container = (LinearLayout) v;
                    container.addView(view);
                    view.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    v.setBackgroundDrawable(normalShape);
                default:
                    break;
            }
            return true;
        }
    }



    View.OnDragListener dragListener1 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();

            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    final View view = (View) event.getLocalState();

                    if (view.getId() == R.id.letter1){
                        space1.setText(char1.getText());
                    }
                    else if (view.getId() == R.id.letter2){
                        space1.setText(char2.getText());
                    }
                    else if (view.getId() == R.id.letter3){
                        space1.setText(char3.getText());
                    }
                    else if (view.getId() == R.id.letter4){
                        space1.setText(char4.getText());
                    }
                    else if (view.getId() == R.id.letter5){
                        space1.setText(char5.getText());
                    }
                    else if (view.getId() == R.id.letter6){
                        space1.setText(char6.getText());
                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    break;
            }

            return true;
        }
    };

    View.OnDragListener dragListener2 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();

            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    final View view = (View) event.getLocalState();

                    if (view.getId() == R.id.letter1){
                        space2.setText(char1.getText());
                    }
                    else if (view.getId() == R.id.letter2){
                        space2.setText(char2.getText());
                    }
                    else if (view.getId() == R.id.letter3){
                        space2.setText(char3.getText());
                    }
                    else if (view.getId() == R.id.letter4){
                        space2.setText(char4.getText());
                    }
                    else if (view.getId() == R.id.letter5){
                        space2.setText(char5.getText());
                    }
                    else if (view.getId() == R.id.letter6){
                        space2.setText(char6.getText());
                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    break;
            }

            return true;
        }
    };
    View.OnDragListener dragListener3 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();

            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    final View view = (View) event.getLocalState();

                    if (view.getId() == R.id.letter1){
                        space3.setText(char1.getText());
                    }
                    else if (view.getId() == R.id.letter2){
                        space3.setText(char2.getText());
                    }
                    else if (view.getId() == R.id.letter3){
                        space3.setText(char3.getText());
                    }
                    else if (view.getId() == R.id.letter4){
                        space3.setText(char4.getText());
                    }
                    else if (view.getId() == R.id.letter5){
                        space3.setText(char5.getText());
                    }
                    else if (view.getId() == R.id.letter6){
                        space3.setText(char6.getText());
                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    break;
            }

            return true;
        }
    };
    View.OnDragListener dragListener4 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();

            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    final View view = (View) event.getLocalState();

                    if (view.getId() == R.id.letter1){
                        space4.setText(char1.getText());
                    }
                    else if (view.getId() == R.id.letter2){
                        space4.setText(char2.getText());
                    }
                    else if (view.getId() == R.id.letter3){
                        space4.setText(char3.getText());
                    }
                    else if (view.getId() == R.id.letter4){
                        space4.setText(char4.getText());
                    }
                    else if (view.getId() == R.id.letter5){
                        space4.setText(char5.getText());
                    }
                    else if (view.getId() == R.id.letter6){
                        space4.setText(char6.getText());
                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    break;
            }

            return true;
        }
    };
    View.OnDragListener dragListener5 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();

            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    final View view = (View) event.getLocalState();

                    if (view.getId() == R.id.letter1){
                        space5.setText(char1.getText());
                    }
                    else if (view.getId() == R.id.letter2){
                        space5.setText(char2.getText());
                    }
                    else if (view.getId() == R.id.letter3) {
                        space5.setText(char3.getText());
                    }
                    else if (view.getId() == R.id.letter4){
                        space5.setText(char4.getText());
                    }
                    else if (view.getId() == R.id.letter5){
                        space5.setText(char5.getText());
                    }
                    else if (view.getId() == R.id.letter6){
                        space5.setText(char6.getText());
                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    break;
            }

            return true;
        }
    };
    View.OnDragListener dragListener6 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();

            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    final View view = (View) event.getLocalState();

                    if (view.getId() == R.id.letter1){
                        space6.setText(char1.getText());
                    }
                    else if (view.getId() == R.id.letter2){
                        space6.setText(char2.getText());
                    }
                    else if (view.getId() == R.id.letter3){
                        space6.setText(char3.getText());
                    }
                    else if (view.getId() == R.id.letter4){
                        space6.setText(char4.getText());
                    }
                    else if (view.getId() == R.id.letter5){
                        space6.setText(char5.getText());
                    }
                    else if (view.getId() == R.id.letter6){
                        space6.setText(char6.getText());
                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    break;
            }

            return true;
        }
    };
}