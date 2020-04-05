package com.example.animals.helper;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class SoundsHelper {
    private MediaPlayer mp = null;

    public void stop() {
        if (mp != null) {
            mp.stop();
            mp.release();
        }
    }

    private void create(Context context, int uri) {
        mp = MediaPlayer.create(context, uri);
    }

    public void play(Context context, int resid) {
        try {
            if (mp == null) {
                create(context, resid);
            } else if (mp.isPlaying()) {
                stop();
                create(context, resid);
            }
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(context.getClass().getSimpleName(), "Exception: " + e.toString());
        }
    }


}
