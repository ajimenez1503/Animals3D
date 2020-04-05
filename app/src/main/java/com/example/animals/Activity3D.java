package com.example.animals;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animals.helper.ArAvailability;
import com.example.animals.helper.CameraPermissionHelper;
import com.google.ar.core.Session;
import com.google.ar.core.exceptions.UnavailableApkTooOldException;
import com.google.ar.core.exceptions.UnavailableArcoreNotInstalledException;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableSdkTooOldException;

public class Activity3D extends AppCompatActivity {

    private static final String TAG = Activity3D.class.getSimpleName();
    private Session mSession = null;
    // Set to true ensures requestInstall() triggers installation if necessary.
    private boolean mUserRequestedInstall = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_d);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // ARCore requires camera permission to operate.
        if (!CameraPermissionHelper.hasCameraPermission(this)) {
            CameraPermissionHelper.requestCameraPermission(this);
            return;
        }

        if (mSession == null) {
            if (ArAvailability.isARInstalled(this)) {
                try {
                    mSession = new Session(this);
                } catch (UnavailableArcoreNotInstalledException | UnavailableApkTooOldException | UnavailableSdkTooOldException | UnavailableDeviceNotCompatibleException e) {
                    Log.e(TAG, "Exception: " + e.toString());
                    e.printStackTrace();
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] results) {
        if (!CameraPermissionHelper.hasCameraPermission(this)) {
            Toast.makeText(this, R.string.Logging_camera_persmission, Toast.LENGTH_LONG)
                    .show();
            if (!CameraPermissionHelper.shouldShowRequestPermissionRationale(this)) {
                // Permission denied with checking "Do not ask again".
                CameraPermissionHelper.launchPermissionSettings(this);
            }
            finish();
        }
    }

    /**
     * Called when the user taps the Tiger button
     */
    public void show3DTiger(View view) {
        Log.i(TAG, "Open 3D Tiger");
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        Uri intentUri =
                Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                        .appendQueryParameter("file", "https://storage.googleapis.com/ar-answers-in-search-models/static/Tiger/model.glb")
                        .appendQueryParameter("mode", "ar_only")
                        .appendQueryParameter("title", "Tiger")
                        .build();
        sceneViewerIntent.setData(intentUri);
        sceneViewerIntent.setPackage("com.google.ar.core");
        startActivity(sceneViewerIntent);
    }

    /**
     * Called when the user taps the Bear button
     */
    public void show3DBear(View view) {
        Log.i(TAG, "Open 3D Bear");
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        Uri intentUri =
                Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                        .appendQueryParameter("file", "https://storage.googleapis.com/ar-answers-in-search-models/static/BrownBear/model.glb")
                        .appendQueryParameter("mode", "ar_only")
                        .appendQueryParameter("title", "Bear")
                        .build();
        sceneViewerIntent.setData(intentUri);
        sceneViewerIntent.setPackage("com.google.ar.core");
        startActivity(sceneViewerIntent);
    }
}
