package com.app.animals3D.helper;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

//TODO: make this class singleton and access from ActivitySounds and animalsAdapter
public class SoundsHelper {
    private MediaPlayer mp;

    public SoundsHelper() {
        mp = new MediaPlayer();
    }

    public void stop() {
        if (mp.isPlaying()) {
            mp.stop();
        }
        mp.reset();
        mp.release();
    }

    private void create(Context context, int soundId) {
        mp = MediaPlayer.create(context, soundId);
    }

    public void play(Context context, int soundId) {
        try {
            stop();
            create(context, soundId);
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(context.getClass().getSimpleName(), "Exception: " + e.toString());
        }
    }


}
