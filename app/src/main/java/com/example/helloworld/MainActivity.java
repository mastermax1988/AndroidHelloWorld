package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int nr;
    public MainActivity()
    {
        super();
        nr=0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt = (TextView) findViewById(R.id.hw);
        Button btn = (Button) findViewById(R.id.btnJump);
        btn.setOnClickListener((e)->{
            nr++;
            txt.setText("Hello World! " + nr);
        });

        findViewById(R.id.button).setOnClickListener((e)->
        {
            Intent intent = new Intent(this,MyDraw.class);
            startActivity(intent);
        });
        findViewById(R.id.btnCam).setOnClickListener((e)->{
            Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            try {
                startActivityForResult(cam,1);
            }catch (Exception ex)
            {
                System.out.println(ex.toString());
            }
        });
        if(savedInstanceState==null)
            return;
        nr = savedInstanceState.getInt("nr");
        txt.setText("Hello World! " + nr);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        ImageView view = new ImageView(this);
        view.setImageBitmap(imageBitmap);
        setContentView(view);
        view.setOnClickListener((e)->
        {
            recreate();
        });
    }}

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("nr",nr);
        System.out.println("saveState");
    }
}