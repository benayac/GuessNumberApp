package com.example.user_pc.numberguessingappv2;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class guess extends AppCompatActivity implements View.OnClickListener {

    ImageButton lower_btn, bigger_btn;
    Button restart_btn;
    int guess, x, y;
    TextView tv_guess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        Intent intent = getIntent();

        y = intent.getIntExtra(MainActivity.EXTRA_TOP, 0) + 1;
        x = intent.getIntExtra(MainActivity.EXTRA_LOW, 0);

        guess = (x + y)/2;

        tv_guess = findViewById(R.id.text_angka);
        tv_guess.setText(Integer.toString(guess));

        lower_btn = findViewById(R.id.less_btn);
        bigger_btn = findViewById(R.id.greater_btn);
        restart_btn = findViewById(R.id.restart_btn);

        lower_btn.setOnClickListener(this);
        bigger_btn.setOnClickListener(this);
        restart_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.restart_btn){

            this.finish();

        }else if(view.getId() == R.id.greater_btn){

            x = guess;
            guess = (guess + y)/2;
            tv_guess.setText(Integer.toString(guess));

        } else if(view.getId() == R.id.less_btn){

            y = guess;
            guess = (guess + x)/2;
            tv_guess.setText(Integer.toString(guess));

        }

    }

}
