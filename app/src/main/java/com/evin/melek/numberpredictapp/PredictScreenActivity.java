package com.evin.melek.numberpredictapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PredictScreenActivity extends AppCompatActivity {

    Button buttonPredict;
    TextView remainingPredict,textClue;
    EditText predictText;

    private int randomNumber;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predict_screen);

        buttonPredict = findViewById(R.id.buttonPredict);
        remainingPredict = findViewById(R.id.remainingPredict);
        textClue = findViewById(R.id.textClue);
        predictText = findViewById(R.id.predictText);

        Random random = new Random();
        randomNumber = random.nextInt(101); // 0-100
        Log.e("Random Number ", String.valueOf(randomNumber));

        buttonPredict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                counter = counter - 1;
                int predict = Integer.parseInt(predictText.getText().toString());

                if (predict == randomNumber){
                    Intent intent = new Intent(PredictScreenActivity.this, ResultActivity.class);
                    intent.putExtra("result", true);
                    startActivity(intent);
                    finish();
                    return;
                }

                if (predict < randomNumber){
                    textClue.setText("Increase");
                    remainingPredict.setText("Remaining Predict: " + counter);

                }

                if (predict > randomNumber){
                    textClue.setText("Decrease");
                    remainingPredict.setText("Remaining Predict: " + counter);

                }

                if (counter == 0){
                    Intent intent = new Intent(PredictScreenActivity.this, ResultActivity.class);
                    intent.putExtra("result", false);
                    startActivity(intent);
                    finish();

                }

                predictText.setText("");
            }
        });
    }
}
