package com.evin.melek.numberpredictapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    ImageView imageViewResult;
    TextView textViewResult;
    Button buttonPlayAgain;

    private boolean result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        imageViewResult = findViewById(R.id.imageViewResult);
        textViewResult = findViewById(R.id.textViewResult);
        buttonPlayAgain = findViewById(R.id.buttonPlayAgain);

        result = getIntent().getBooleanExtra("result", false);

        if (result){
           textViewResult.setText("YOU ARE A WİNNER!");
           imageViewResult.setImageResource(R.drawable.winner);
        }

        else {
            textViewResult.setText("YOU ARE A LOSER!");
            imageViewResult.setImageResource(R.drawable.loser);
        }

        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ResultActivity.this, MainActivity.class));
                finish();

            }
        });

    }
}
