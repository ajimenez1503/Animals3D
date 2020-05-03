package com.app.animals3D;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.animals3D.helper.AdHelper;
import com.app.animals3D.helper.AnimalsAdapter;
import com.app.animals3D.helper.ListAnimals;
import com.app.animals3D.helper.SoundsHelper;
import com.app.animals3D.helper.onClickAction;

public class ActivitySounds extends AppCompatActivity {

    private static final String TAG = ActivitySounds.class.getSimpleName();
    private AdHelper adHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        GridView gridView = this.findViewById(R.id.gridView1);
        AnimalsAdapter gridAdapter = new AnimalsAdapter(
                ActivitySounds.this,
                onClickAction.SOUND,
                ListAnimals.getInstance().get());
        gridView.setAdapter(gridAdapter);

        // Create ad
        adHelper = new AdHelper(this, R.string.animals_sounds_banner_ad_unit_id);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Stop sounds");
        SoundsHelper.getInstance().stop();
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
