package com.example.animals.helper;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class SoundsHelper {
    private MediaPlayer mp;

    public SoundsHelper() {
        mp = new MediaPlayer();
    }

    public void stop() {
        mp.stop();
        mp.release();
    }

    private void create(Context context, int resid) {
        mp = MediaPlayer.create(context, resid);
    }

    public void play(Context context, int resid) {
        try {
            stop();
            create(context, resid);
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(context.getClass().getSimpleName(), "Exception: " + e.toString());
        }
    }


}
