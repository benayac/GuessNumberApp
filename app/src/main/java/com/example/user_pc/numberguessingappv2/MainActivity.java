package com.example.user_pc.numberguessingappv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity{

    public static final String EXTRA_TOP = "com.example.user_pc.numberguessingappv2.EXTRA_TOP";
    public static final String EXTRA_LOW = "com.example.user_pc.numberguessingappv2.EXTRA_LOW";

    ImageButton next;
    EditText upper, lower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = findViewById(R.id.guess_btn);

        upper = findViewById(R.id.upper_bound);
        lower = findViewById(R.id.lower_bound);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(upper.getText().toString().length() > 0 && lower.getText().toString().length() > 0) {

                    openguess();

                } else {

                    toast();

                }

            }
        });

    }

    public void toast(){

        Toast.makeText(this, "Please enter a boundary!", Toast.LENGTH_SHORT).show();
    }

    public void openguess(){

        upper = findViewById(R.id.upper_bound);
        lower = findViewById(R.id.lower_bound);

        int up = Integer.parseInt(upper.getText().toString());
        int low = Integer.parseInt(lower.getText().toString());

        Intent intent = new Intent(this, guess.class);
        intent.putExtra(EXTRA_TOP, up);
        intent.putExtra(EXTRA_LOW, low);
        startActivity(intent);

    }

    }
