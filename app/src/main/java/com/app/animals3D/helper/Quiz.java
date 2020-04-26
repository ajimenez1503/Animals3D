package com.app.animals3D.helper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.app.animals3D.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Quiz {
    private final ArrayList<ImageButton> listOptions;
    private final ArrayList<Animal> listAnimals;
    private final TextView textView;
    private final TextView textViewScore;
    private final Spinner spinnerLanguage;
    private final Random rand;
    private final Activity activity;
    private int score;
    private int counter;

    public Quiz(Activity activity) {
        this.score = 0;
        this.counter = -1;

        textView = activity.findViewById(R.id.textView2);

        textViewScore = activity.findViewById(R.id.textViewScore);

        listOptions = new ArrayList<>(4);
        listOptions.add((ImageButton) activity.findViewById(R.id.quiz_imageButton_animal1));
        listOptions.add((ImageButton) activity.findViewById(R.id.quiz_imageButton_animal2));
        listOptions.add((ImageButton) activity.findViewById(R.id.quiz_imageButton_animal3));
        listOptions.add((ImageButton) activity.findViewById(R.id.quiz_imageButton_animal4));

        spinnerLanguage = activity.findViewById(R.id.spinner_quiz_language);

        this.listAnimals = ListAnimals.getInstance().get();
        Collections.shuffle(this.listAnimals);

        this.activity = activity;
        rand = new Random();
    }

    public void start() {
        updateScore();
        setNextQuestion();
    }

    private void setNextQuestion() {
        if (counter == listAnimals.size() - 1) {
            Collections.shuffle(this.listAnimals);
            counter = 0;
        } else {
            counter++;
        }

        setQuestion();

        // Set options
        ArrayList<Integer> choosenAnimalIndex = new ArrayList<>(4);
        Collections.shuffle(this.listOptions);

        // Set correct option
        listOptions.get(0).setImageResource(listAnimals.get(counter).getIdDrawable());
        listOptions.get(0).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer(R.string.correct_answer);
            }
        });
        choosenAnimalIndex.add(counter);

        // Set incorrect options
        for (int i = 1; i < listOptions.size(); i++) {
            int randomNumber = rand.nextInt(listAnimals.size());
            while (choosenAnimalIndex.contains(randomNumber)) {
                randomNumber = rand.nextInt(listAnimals.size());
            }
            choosenAnimalIndex.add(randomNumber);
            listOptions.get(i).setImageResource(listAnimals.get(randomNumber).getIdDrawable());
            listOptions.get(i).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    answer(R.string.incorrect_answer);
                }
            });
        }
    }

    public void setQuestion() {
        Log.i(activity.getClass().getSimpleName(), "spinner" + spinnerLanguage.getSelectedItem().toString());
        String language = spinnerLanguage.getSelectedItem().toString();
        String animal = listAnimals.get(counter).getName(language);
        textView.setText(animal);
    }

    private void answer(int text) {
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();
        if (text == R.string.correct_answer) {
            score++;
            updateScore();
        }
        setNextQuestion();

    }

    @SuppressLint("SetTextI18n")
    private void updateScore() {
        textViewScore.setText(Integer.toString(score));
    }

}
