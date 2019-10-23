package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private Button truth;
    private Button falsee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WireWidgets();
        SetListners();
        Gson jason = new Gson();
        Question[] questions = jason.fromJson(jsonString, Question[].class);

    }
    private void SetListners() {
        truth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        falsee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void WireWidgets() {
        truth = findViewById(R.id.button_main_true);
        falsee = findViewById(R.id.button_main_false);

    }

    public static class Question {
        private boolean answer;
        private String question;

        public Question() {
        }
    }
}
