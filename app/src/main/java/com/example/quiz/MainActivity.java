package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button truth;
    private Button falsee;
    private Quiz quiz;
    private TextView textView;
    public static final String EXTRA_SCORE = "score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WireWidgets();
        InputStream jsonInputStream = getResources().openRawResource(R.raw.questions);
        String jsonString = readTextFile(jsonInputStream);
        // create a gson object
        Gson gson = new Gson();
        // read your json file into an array of questions
        Question[] questions =  gson.fromJson(jsonString, Question[].class);
        // convert your array to a list using the Arrays utility class
        List<com.example.quiz.Question> questionList = Arrays.asList(questions);
        // verify that it read everything properly
        Log.d("MainActivity", "onCreate: " + questionList.toString());
        quiz = new Quiz(questionList);
        textView.setText(quiz.getQuestion());
        SetListners();

    }


    private void SetListners() {
        truth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quiz.checkAnswer(true)){
                    Toast.makeText(MainActivity.this, ":)", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, ":(", Toast.LENGTH_SHORT).show();
                }

                if(quiz.haveMoreQuestions()) {
                    quiz.nextQuestion();
                    textView.setText(quiz.getQuestion());
                }
                else
                {
                Intent scoreIntent = new Intent(MainActivity.this, ScoreActivity.class);
                scoreIntent.putExtra(EXTRA_SCORE, quiz.getScore());
                startActivity(scoreIntent);
                    quiz.setScore(0);
                    quiz.setQuestionNumber(0);


                }


            }
        });
        falsee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quiz.checkAnswer(false)){
                    Toast.makeText(MainActivity.this, ":)", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, ":(", Toast.LENGTH_SHORT).show();
                }
                if(quiz.haveMoreQuestions()) {
                    quiz.nextQuestion();
                    textView.setText(quiz.getQuestion());
                }
                else
                {
                    Intent scoreIntent = new Intent(MainActivity.this, ScoreActivity.class);
                    scoreIntent.putExtra(EXTRA_SCORE, quiz.getScore());
                    startActivity(scoreIntent);
                    quiz.setScore(0);
                    quiz.setQuestionNumber(0);




                }


            }
        });
    }



    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }


    private void WireWidgets() {
        truth = findViewById(R.id.button_main_true);
        falsee = findViewById(R.id.button_main_false);
        textView = findViewById(R.id.textView_main_question);

    }

}
