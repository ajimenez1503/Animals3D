package com.app.animals3D;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.app.animals3D.helper.AdHelper;
import com.app.animals3D.helper.Quiz;

public class ActivityQuiz extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Quiz quiz;
    private AdHelper adHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Create ad
        adHelper = new AdHelper(this, R.string.quiz_banner_ad_unit_id);

        Spinner spinner = findViewById(R.id.spinner_quiz_language);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.languages,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        quiz = new Quiz(this);
        quiz.start();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        quiz.setQuestion();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    /**
     * Called when leaving the activity
     */
    @Override
    public void onPause() {
        adHelper.pause();
        super.onPause();
    }

    /**
     * Called when returning to the activity
     */
    @Override
    public void onResume() {
        super.onResume();
        adHelper.resume();
    }

    /**
     * Called before the activity is destroyed
     */
    @Override
    public void onDestroy() {
        adHelper.destroy();
        super.onDestroy();

    }
}
