package com.app.animals3D;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.animals3D.helper.Animal;
import com.app.animals3D.helper.AnimalsAdapter;
import com.app.animals3D.helper.SoundsHelper;
import com.app.animals3D.helper.onClickAction;

public class ActivitySounds extends AppCompatActivity {

    private static final String TAG = ActivitySounds.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3d);

        GridView gridView = this.findViewById(R.id.gridView1);
        AnimalsAdapter gridAdapter = new AnimalsAdapter(ActivitySounds.this, Animal.list_of_animals, onClickAction.SOUND);
        gridView.setAdapter(gridAdapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Stop sounds");
        SoundsHelper.getInstance().getInstance().stop();
    }
}
