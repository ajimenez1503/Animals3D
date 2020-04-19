package com.app.animals3D;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.app.animals3D.helper.AnimalsAdapter;
import com.app.animals3D.helper.ArCoreHelper;
import com.app.animals3D.helper.CameraPermissionHelper;
import com.app.animals3D.helper.onClickAction;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.ar.core.Session;
import com.google.ar.core.exceptions.UnavailableApkTooOldException;
import com.google.ar.core.exceptions.UnavailableArcoreNotInstalledException;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableSdkTooOldException;

public class Activity3D extends AppCompatActivity {

    private static final String TAG = Activity3D.class.getSimpleName();
    private Session mSession = null;
    private AdView mAdView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        GridView gridView = this.findViewById(R.id.gridView1);
        AnimalsAdapter gridAdapter = new AnimalsAdapter(Activity3D.this, onClickAction.OBJECT3D);
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
    protected void onResume() {
        super.onResume();

        // ARCore requires camera permission to operate.
        if (CameraPermissionHelper.hasCameraPermission(this)) {
            CameraPermissionHelper.requestCameraPermission(this);
            return;
        }

        if (mSession == null) {
            if (ArCoreHelper.isArCoreInstalled(this)) {
                try {
                    mSession = new Session(this);
                } catch (UnavailableArcoreNotInstalledException
                        | UnavailableApkTooOldException
                        | UnavailableSdkTooOldException
                        | UnavailableDeviceNotCompatibleException e) {
                    Log.e(TAG, "Exception: " + e.toString());
                    e.printStackTrace();
                }
            }
        }

        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] results) {
        if (CameraPermissionHelper.hasCameraPermission(this)) {
            Toast.makeText(this, R.string.Logging_camera_permission, Toast.LENGTH_LONG).show();
            if (!CameraPermissionHelper.shouldShowRequestPermissionRationale(this)) {
                // Permission denied with checking "Do not ask again".
                CameraPermissionHelper.launchPermissionSettings(this);
            }
            finish();
        }
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
