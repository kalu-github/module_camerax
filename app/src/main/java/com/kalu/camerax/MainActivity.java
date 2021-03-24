package com.kalu.camerax;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import lib.kalu.camerax.CameraxManger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.camerax).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CameraxManger.startActivity(MainActivity.this);
            }
        });
    }
}