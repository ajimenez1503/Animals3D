package com.example.animals;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3D extends AppCompatActivity {

    private static final String TAG = Activity3D.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_d);
    }

    /**
     * Called when the user taps the Tiger button
     */
    public void show3DTiger(View view) {
        Log.i(TAG, "Open 3D Tiger");
    }

    /**
     * Called when the user taps the Bear button
     */
    public void show3DBear(View view) {
        Log.i(TAG, "Open 3D Bear");
    }
}
