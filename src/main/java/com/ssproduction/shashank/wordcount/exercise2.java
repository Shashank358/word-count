package com.ssproduction.shashank.wordcount;

import android.os.CountDownTimer;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.ssproduction.shashank.wordcount.wordsPackage.wordsList3;
import com.ssproduction.shashank.wordcount.wordsPackage.wordsList4;
import com.ssproduction.shashank.wordcount.wordsPackage.wordsList5;

public class exercise2 extends AppCompatActivity {

    private final MyCounter timer = new MyCounter(60000, 1000);

    private Button TimerBtn;
    int i =0;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.exercise2_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Exercise 2");

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.middle_relative2, new wordsList5());
        transaction.commit();

        TimerBtn = (Button) findViewById(R.id.timer_button2);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);

        TimerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.start();
            }
        });
    }

    public class MyCounter extends CountDownTimer {

        public MyCounter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);

        }

        @Override
        public void onFinish() {
            TimerBtn.setText("done!");
            i++;
            progressBar.setProgress(100);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            TimerBtn.setText(millisUntilFinished / 60000 + ":" + (millisUntilFinished / 1000));
            // i tried this
            i++;
            progressBar.setProgress((int) i * 100 / (60000 / 1000));

            if (TimerBtn.getText().equals("0:45")) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.middle_relative2, new wordsList4());
                transaction.commit();
            }
        }
    }
}
