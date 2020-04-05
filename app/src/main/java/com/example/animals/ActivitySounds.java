package com.example.animals;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySounds extends AppCompatActivity {

    private static final String TAG = ActivitySounds.class.getSimpleName();
    MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Stop sounds");
        if (mp != null) {
            mp.stop();
            mp.release();
        }
    }

    /**
     * Called when the user taps the Tiger button
     */
    public void playTigerSounds(View view) {
        Log.i(TAG, "Play Tiger sounds");
        try {
            if (mp == null) {
                mp = MediaPlayer.create(this, R.raw.tiger);
            } else if (mp.isPlaying()) {
                mp.stop();
                mp.release();
                mp = MediaPlayer.create(this, R.raw.tiger);
            }
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Exception: " + e.toString());
        }
    }

    /**
     * Called when the user taps the Bear button
     */
    public void playBearSounds(View view) {
        Log.i(TAG, "Play Bear sounds");
        try {
            if (mp == null) {
                mp = MediaPlayer.create(this, R.raw.bear);
            } else if (mp.isPlaying()) {
                mp.stop();
                mp.release();
                mp = MediaPlayer.create(this, R.raw.bear);
            }
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Exception: " + e.toString());
        }
    }
}
