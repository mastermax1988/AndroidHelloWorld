package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int nr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        nr=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt = (TextView) findViewById(R.id.hw);
        Button btn = (Button) findViewById(R.id.btnJump);
        btn.setOnClickListener((e)->{
            nr++;
            txt.setText("Hello World! " + nr);
        });
    }
}