package com.app.animals3D.helper;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class SoundsHelper {
    // static variable single_instance of type Singleton
    private static SoundsHelper single_instance = null;
    private MediaPlayer mp;

    private SoundsHelper() {
        mp = new MediaPlayer();
    }

    // static method to create instance of Singleton class
    public static SoundsHelper getInstance() {
        if (single_instance == null)
            single_instance = new SoundsHelper();

        return single_instance;
    }

    public void stop() {
        if (mp.isPlaying()) {
            mp.stop();
        }
        mp.reset();
        mp.release();
        // Reset singleton instance
        single_instance = null;
    }

    private void create(Context context, int soundId) {
        mp = MediaPlayer.create(context, soundId);
    }

    void play(Context context, int soundId) {
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
