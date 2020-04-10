package com.app.animals3D;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.app.animals3D.helper.ArCoreHelper;
import com.app.animals3D.helper.CameraPermissionHelper;
import com.google.ar.core.Session;
import com.google.ar.core.exceptions.UnavailableApkTooOldException;
import com.google.ar.core.exceptions.UnavailableArcoreNotInstalledException;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableSdkTooOldException;

public class Activity3D extends AppCompatActivity {

    private static final String TAG = Activity3D.class.getSimpleName();
    private Session mSession = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_d);
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
     * Called when the user taps the Tiger button
     */
    public void show3DTiger(View view) {
        Log.i(TAG, "Open 3D Tiger");
        ArCoreHelper.showArObject(
                this,
                "https://storage.googleapis.com/ar-answers-in-search-models/static/Tiger/model.glb",
                "Tiger");

    }

    /**
     * Called when the user taps the Bear button
     */
    public void show3DBear(View view) {
        Log.i(TAG, "Open 3D Bear");
        ArCoreHelper.showArObject(
                this,
                "https://storage.googleapis.com/ar-answers-in-search-models/static/BrownBear/model.glb",
                "Bear");
    }

    /**
     * Called when the user taps the Cat button
     */
    public void show3DCat(View view) {
        Log.i(TAG, "Open 3D Cat");
        ArCoreHelper.showArObject(
                this,
                "https://storage.googleapis.com/ar-answers-in-search-models/static/ShortHairedCat/model.glb",
                "Cat");
    }

    /**
     * Called when the user taps the Horse button
     */
    public void show3DHorse(View view) {
        Log.i(TAG, "Open 3D Horse");
        ArCoreHelper.showArObject(
                this,
                "https://storage.googleapis.com/ar-answers-in-search-models/static/ArabianHorse/model.glb",
                "Horse");
    }

    /**
     * Called when the user taps the Dog button
     */
    public void show3DDog(View view) {
        Log.i(TAG, "Open 3D Dog");
        ArCoreHelper.showArObject(
                this,
                "https://storage.googleapis.com/ar-answers-in-search-models/static/LabradorRetriever/model.glb",
                "Dog");
    }

    /**
     * Called when the user taps the Duck button
     */
    public void show3DDuck(View view) {
        Log.i(TAG, "Open 3D Duck");
        ArCoreHelper.showArObject(
                this,
                "https://storage.googleapis.com/ar-answers-in-search-models/static/MallardDuck/model.glb",
                "Duck");
    }

    /**
     * Called when the user taps the Snake button
     */
    public void show3DSnake(View view) {
        Log.i(TAG, "Open 3D Snake");
        ArCoreHelper.showArObject(
                this,
                "https://storage.googleapis.com/ar-answers-in-search-models/static/BallPython/model.glb",
                "Snake");
    }

    /**
     * Called when the user taps the Eagle button
     */
    public void show3DEagle(View view) {
        Log.i(TAG, "Open 3D Eagle");
        ArCoreHelper.showArObject(
                this,
                "https://storage.googleapis.com/ar-answers-in-search-models/static/GoldenEagle/model.glb",
                "Eagle");
    }
}
