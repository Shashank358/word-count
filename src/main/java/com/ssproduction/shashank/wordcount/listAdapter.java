package com.ssproduction.shashank.wordcount;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class listAdapter extends RecyclerView.Adapter {

    private Context context;
    private final MyCounter timer = new MyCounter(60000, 1000);


    public listAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = (View) LayoutInflater.from(context).inflate(R.layout.word_data_list, parent, false);

        return new listViewHolder(v, context);    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((listViewHolder)holder).bindView(position);

    }

    @Override
    public int getItemCount() {
        return myWords.words.length; }

    private class listViewHolder extends RecyclerView.ViewHolder {

        private TextView words;
        Context context;

        public listViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            words = (TextView) itemView.findViewById(R.id.text_words);
        }
        public void bindView(int position){
            words.setText(myWords.words[position]);

        }

    }
    public class MyCounter extends CountDownTimer {

        public MyCounter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);


        }

        @Override
        public void onFinish() {

        }

        @Override
        public void onTick(long millisUntilFinished) {

        }
    }
}





