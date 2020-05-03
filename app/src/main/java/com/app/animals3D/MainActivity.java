package com.app.animals3D;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.app.animals3D.helper.AdHelper;
import com.app.animals3D.helper.ArCoreHelper;

public class MainActivity extends AppCompatActivity {

    private AdHelper adHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create ad
        adHelper = new AdHelper(this, R.string.main_banner_ad_unit_id);
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

    /**
     * Called when the user taps the quiz button
     */
    @SuppressWarnings("unused")
    public void openQuizActivity(View view) {
        Intent intent = new Intent(this, ActivityQuiz.class);
        startActivity(intent);
    }

    /**
     * Called when leaving the activity
     */
    @Override
    public void onPause() {
        adHelper.pause();
        super.onPause();
    }

    /**
     * Called when returning to the activity
     */
    @Override
    public void onResume() {
        super.onResume();
        adHelper.resume();
    }

    /**
     * Called before the activity is destroyed
     */
    @Override
    public void onDestroy() {
        adHelper.destroy();
        super.onDestroy();

    }
}
