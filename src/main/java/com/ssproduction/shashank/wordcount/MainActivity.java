package com.ssproduction.shashank.wordcount;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.provider.UserDictionary;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toolbar;

import com.ssproduction.shashank.wordcount.wordsPackage.wordsList1;
import com.ssproduction.shashank.wordcount.wordsPackage.wordsList2;
import com.ssproduction.shashank.wordcount.wordsPackage.wordsList4;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private final MyCounter timer = new MyCounter(60000, 1000);


    private Button blue;
    private ProgressBar progressBar;
    private ImageView play, pause, left, right;
    private TextView time;
    private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,
    t21,t22,t23,t24;

    int i =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar)
        findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Speed Meter");

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        pause = (ImageView) findViewById(R.id.pause_image);
        play = (ImageView) findViewById(R.id.play_image);
        left = (ImageView) findViewById(R.id.left_image);
        right = (ImageView) findViewById(R.id.right_image);
        time = (TextView) findViewById(R.id.time_text);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.middle_relative, new wordsList1());
        transaction.commit();

        progressBar.setProgress(i);

        t1 = (TextView) findViewById(R.id.word1);


        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pause.setVisibility(View.INVISIBLE);
                pause.setEnabled(false);
                play.setEnabled(true);
                play.setVisibility(View.VISIBLE);
                timer.start();

            }
        });

            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    play.setVisibility(View.INVISIBLE);
                    play.setEnabled(false);
                    pause.setVisibility(View.VISIBLE);
                    pause.setEnabled(true);
                    timer.cancel();
                }
            });

    }

    public class MyCounter extends CountDownTimer {

        public MyCounter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);

        }

        @Override
        public void onFinish() {
            time.setText("done!");
            i++;
            progressBar.setProgress(100);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            time.setText(millisUntilFinished / 60000 + ":" + (millisUntilFinished / 1000));
            // i tried this
            progressBar.setProgress(000);
            i++;
            progressBar.setProgress((int) i * 100 / (60000 / 1000));

            if (time.getText().equals("0:45")) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.middle_relative, new wordsList4());
                transaction.commit();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

            if( item.getItemId() == R.id.exercise1_item) {
                Intent intent1 = new Intent(MainActivity.this, exercise1.class);
                startActivity(intent1);
            }
            if( item.getItemId() == R.id.exercise2_item) {
                Intent intent2 = new Intent(MainActivity.this, exercise2.class);
                startActivity(intent2);
            }

            if (item.getItemId() == R.id.exercise3_item) {
                Intent intent3 = new Intent(MainActivity.this, exercise3.class);
                startActivity(intent3);
            }

        return true;
    }
}
