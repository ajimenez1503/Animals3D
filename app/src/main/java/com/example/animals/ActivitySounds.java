package com.example.animals;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animals.helper.SoundsHelper;

public class ActivitySounds extends AppCompatActivity {

    private static final String TAG = ActivitySounds.class.getSimpleName();
    private SoundsHelper soundsHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds);
        soundsHelper = new SoundsHelper();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Stop sounds");
        soundsHelper.stop();
    }

    /**
     * Called when the user taps the Tiger button
     */
    public void playTigerSounds(View view) {
        Log.i(TAG, "Play Tiger sounds");
        soundsHelper.play(this, R.raw.tiger);
    }

    /**
     * Called when the user taps the Bear button
     */
    public void playBearSounds(View view) {
        Log.i(TAG, "Play Bear sounds");
        soundsHelper.play(this, R.raw.bear);
    }

    /**
     * Called when the user taps the Cat button
     */
    public void playCatSounds(View view) {
        Log.i(TAG, "Play Cat sounds");
        soundsHelper.play(this, R.raw.cat);
    }

    /**
     * Called when the user taps the Horse button
     */
    public void playHorseSounds(View view) {
        Log.i(TAG, "Play Horse sounds");
        soundsHelper.play(this, R.raw.horse);
    }

    /**
     * Called when the user taps the Dog button
     */
    public void playDogSounds(View view) {
        Log.i(TAG, "Play Dog sounds");
        soundsHelper.play(this, R.raw.dog);
    }

    /**
     * Called when the user taps the Duck button
     */
    public void playDuckSounds(View view) {
        Log.i(TAG, "Play Duck sounds");
        soundsHelper.play(this, R.raw.duck);
    }
}
