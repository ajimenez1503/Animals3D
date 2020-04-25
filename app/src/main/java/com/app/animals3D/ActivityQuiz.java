package com.app.animals3D;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.app.animals3D.helper.Quiz;

public class ActivityQuiz extends AppCompatActivity {

    private Quiz quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quiz = new Quiz(this);
        quiz.start();
    }
}
