package com.example.animals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the user taps the 3D button
     */
    public void open3DActivity(View view) {
        Intent intent = new Intent(this, Activity3D.class);
        startActivity(intent);
    }
}
