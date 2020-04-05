package com.example.animals.helper;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import com.example.animals.R;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;

public class ArAvailability {
  /**
   * Check ArCoreApk.checkAvailability() to determine if the specific AR functionality can be used.
   */
  public static boolean isARSupported(final android.content.Context context) {
    ArCoreApk.Availability availability = ArCoreApk.getInstance().checkAvailability(context);
    if (availability.isTransient()) {
      // Re-query at 5Hz while compatibility is checked in the background.
      new Handler()
          .postDelayed(
              new Runnable() {
                @Override
                public void run() {
                  isARSupported(context);
                }
              },
              200);
    }
    if (!availability.isSupported()) { // Unsupported or unknown.
      Toast.makeText(context, R.string.Logging_ARCore_error_not_installed, Toast.LENGTH_LONG)
          .show();
      return false;
    }
    return true;
  }

  /**
   * Check ArCoreApk.checkAvailability() to determine if the specific AR functionality can be used.
   */
  public static boolean isARInstalled(Activity applicationActivity) {
    try {
      switch (ArCoreApk.getInstance().requestInstall(applicationActivity, true)) {
        case INSTALLED:
          // Success, create the AR session.
          return true;
        case INSTALL_REQUESTED:
          return false;
      }
    } catch (UnavailableUserDeclinedInstallationException
        | UnavailableDeviceNotCompatibleException e) {
      Log.e(applicationActivity.getClass().getSimpleName(), "Exception: " + e.toString());
      e.printStackTrace();
      return false;
    }
    return true;
  }
}
