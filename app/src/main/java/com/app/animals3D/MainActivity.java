package com.app.animals3D;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.app.animals3D.helper.ArCoreHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the user taps the 3D button
     */
    @SuppressWarnings("unused")
    public void open3DActivity(View view) {
        if (ArCoreHelper.isArCoreSupported(this)) {
            Intent intent = new Intent(this, Activity3D.class);
            startActivity(intent);
        }
    }

    /**
     * Called when the user taps the Sounds button
     */
    @SuppressWarnings("unused")
    public void openSoundsActivity(View view) {
        Intent intent = new Intent(this, ActivitySounds.class);
        startActivity(intent);
    }
}
