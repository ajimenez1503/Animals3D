package com.app.animals3D.helper;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.app.animals3D.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Quiz {
    private final ArrayList<ImageButton> listOptions;
    private final ArrayList<Animal> listAnimals;
    private int score;
    private int counter;
    private TextView textView;
    private Random rand;

    private Activity activity;

    public Quiz(Activity activity) {
        this.score = 0;
        this.counter = -1;

        textView = activity.findViewById(R.id.textView2);
        listOptions = new ArrayList<>(4);
        listOptions.add((ImageButton) activity.findViewById(R.id.quiz_imageButton_animal1));
        listOptions.add((ImageButton) activity.findViewById(R.id.quiz_imageButton_animal2));
        listOptions.add((ImageButton) activity.findViewById(R.id.quiz_imageButton_animal3));
        listOptions.add((ImageButton) activity.findViewById(R.id.quiz_imageButton_animal4));

        this.listAnimals = ListAnimals.getInstance().get();
        Collections.shuffle(this.listAnimals);

        this.activity = activity;
        rand = new Random();
    }

    public void start() {
        setNextQuestion();
    }

    private void setNextQuestion() {
        if (counter >= listAnimals.size()) {
            Collections.shuffle(this.listAnimals);
            counter = 0;
        } else {
            counter++;
        }
        Animal animal = listAnimals.get(counter);

        textView.setText(animal.getName());

        // Set options
        Collections.shuffle(this.listOptions);

        // Set correct option
        listOptions.get(0).setImageResource(animal.getIdDrawable());
        listOptions.get(0).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer(R.string.correct_answer);
            }
        });

        // Set incorrect options
        for (int i = 1; i < listOptions.size(); i++) {
            int randomNumber = rand.nextInt(listAnimals.size());
            while (randomNumber == counter) {
                randomNumber = rand.nextInt(listAnimals.size());
            }
            listOptions.get(i).setImageResource(listAnimals.get(randomNumber).getIdDrawable());
            listOptions.get(i).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    answer(R.string.incorrect_answer);
                }
            });
        }
    }

    private void answer(int text) {
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();
        setNextQuestion();
    }

}
