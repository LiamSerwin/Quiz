package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ScoreActivity extends AppCompatActivity {
private TextView textViewScore;
private Button playAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        wireWidgets();
        Intent lastIntent = getIntent();
        int score = lastIntent.getIntExtra(MainActivity.EXTRA_SCORE, -1);
        textViewScore.setText(getString(R.string.score_textView) + ": " + score + "/10");
        setListener();

    }

    private void setListener() {
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void wireWidgets() {
        textViewScore = findViewById(R.id.textView_score_score);
        playAgain = findViewById(R.id.button_score_play_again);
    }
}
