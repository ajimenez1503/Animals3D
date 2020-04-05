package com.example.animals;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySounds extends AppCompatActivity {

    private static final String TAG = Activity3D.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds);
    }

    /**
     * Called when the user taps the Tiger button
     */
    public void playTigerSounds(View view) {
        Log.i(TAG, "Play Tiger sounds");

    }

    /**
     * Called when the user taps the Bear button
     */
    public void playBearSounds(View view) {
        Log.i(TAG, "Play Bear sounds");

    }
}
