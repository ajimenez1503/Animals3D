package com.app.animals3D.helper;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.widget.FrameLayout;

import com.app.animals3D.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class AdHelper {
    private final FrameLayout adContainerView;
    private final AdView adView;

    public AdHelper(final Activity activity, int unitId) {
        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(activity, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adView = new AdView(activity);
        adView.setAdUnitId(activity.getString(unitId));
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.i(activity.getClass().toString(), "Ad failed: " + errorCode);
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Log.i(activity.getClass().toString(), "Ad closed.");
                load();
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Log.i(activity.getClass().toString(), "Ad clicked.");
                load();
            }

            @Override
            public void onAdOpened() {
                Log.i(activity.getClass().toString(), "Ad opened.");
                load();
            }
        });


        adContainerView = activity.findViewById(R.id.adViewContainer);
        adContainerView.removeAllViews();
        adContainerView.addView(adView);


        // Since we're loading the banner based on the adContainerView size, we need to wait until this
        // view is laid out before we can get the width.
        adContainerView.post(new Runnable() {
            @Override
            public void run() {
                load();
            }
        });

        // Set the adaptive ad size on the ad view.
        adView.setAdSize(getAdSize(activity));
    }

    private AdSize getAdSize(final Activity activity) {
        // Determine the screen width (less decorations) to use for the ad width.
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = outMetrics.density;

        float adWidthPixels = adContainerView.getWidth();

        // If the ad hasn't been laid out, default to the full screen width.
        if (adWidthPixels == 0) {
            adWidthPixels = outMetrics.widthPixels;
        }

        int adWidth = (int) (adWidthPixels / density);

        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, adWidth);
    }

    private void load() {
        // Create an ad request.
        AdRequest adRequest = new AdRequest.Builder().build();
        // Start loading the ad in the background.
        adView.loadAd(adRequest);
    }

    public void pause() {
        if (adView != null) {
            adView.pause();
        }
    }

    public void resume() {
        if (adView != null) {
            adView.resume();
        }
    }

    public void destroy() {
        if (adView != null) {
            adView.destroy();
        }
    }
}
