package com.ssproduction.shashank.wordcount.wordsPackage;


import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ssproduction.shashank.wordcount.MainActivity;
import com.ssproduction.shashank.wordcount.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class wordsList1 extends Fragment {

    private final MyCounter timer = new MyCounter(60000, 1000);

    private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,
            t21,t22,t23,t24, time;

    private Button start;
    String x,y;

    public wordsList1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_words_list1, container, false);
        t1 = (TextView) view.findViewById(R.id.word1);

        start = (Button) view.findViewById(R.id.start_btn);
        time = (TextView) view.findViewById(R.id.time_text);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.start();
            }
        });


        return view;




    }
    public class MyCounter extends CountDownTimer {

        public MyCounter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);


        }

        @Override
        public void onFinish() {
            time.setText("done!");

        }

        @Override
        public void onTick(long millisUntilFinished) {
            time.setText(millisUntilFinished / 60000 + ":" + (millisUntilFinished / 1000));
            t1.setBackground(getResources().getDrawable(R.drawable.words_back));


        }

    }

}
