package com.app.animals3D.helper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

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
    private final ImageView imageViewAnswer;
    private final Animation animationZoomIn;
    private int correctAnswer;
    private int incorrectAnswer;
    private int counter;

    @SuppressLint("ShowToast")
    public Quiz(Activity activity) {
        this.correctAnswer = 0;
        this.incorrectAnswer = 0;
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

        rand = new Random();

        imageViewAnswer = activity.findViewById(R.id.answerImageViewId);
        animationZoomIn = AnimationUtils.loadAnimation(activity, R.anim.zoom_in);

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
                answer(true);
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
                    answer(false);
                }
            });
        }
    }

    public void setQuestion() {
        String language = spinnerLanguage.getSelectedItem().toString();
        String animal = listAnimals.get(counter).getName(language);
        textView.setText(animal);
    }

    private void answer(boolean correct) {
        if (correct) {
            correctAnswer++;
            updateScore();
            imageViewAnswer.setImageResource(R.drawable.tick);
        } else {
            incorrectAnswer++;
            imageViewAnswer.setImageResource(R.drawable.delete);
        }
        imageViewAnswer.setVisibility(View.VISIBLE);
        imageViewAnswer.startAnimation(animationZoomIn);
        imageViewAnswer.setVisibility(View.INVISIBLE);

        setNextQuestion();

    }

    @SuppressLint("SetTextI18n")
    private void updateScore() {
        textViewScore.setText(Integer.toString(correctAnswer));
    }

}
