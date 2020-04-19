package com.app.animals3D;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.animals3D.helper.AnimalsAdapter;
import com.app.animals3D.helper.SoundsHelper;
import com.app.animals3D.helper.onClickAction;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class ActivitySounds extends AppCompatActivity {

    private static final String TAG = ActivitySounds.class.getSimpleName();
    private AdView mAdView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        GridView gridView = this.findViewById(R.id.gridView1);
        AnimalsAdapter gridAdapter = new AnimalsAdapter(ActivitySounds.this, onClickAction.SOUND);
        gridView.setAdapter(gridAdapter);

        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView2);
        // Create an ad request.
        AdRequest adRequest = new AdRequest.Builder().build();
        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);
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
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    /**
     * Called when returning to the activity
     */
    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    /**
     * Called before the activity is destroyed
     */
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
