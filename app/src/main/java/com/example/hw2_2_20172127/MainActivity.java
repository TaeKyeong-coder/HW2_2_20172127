package com.example.hw2_2_20172127;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button rotationButton;
    ImageView rotationImg;
    int mDegree = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        rotationButton = (Button)findViewById(R.id.rotationButton);
        rotationImg = (ImageView)findViewById(R.id.rotationImg);

        rotationButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                mDegree = mDegree + 10;
                rotationImg.setImageBitmap(rotateImage(
                        BitmapFactory.decodeResource(getResources(),R.drawable.tkchar), mDegree
                ));
            }
        });
    }
    
    public Bitmap rotateImage(Bitmap src, float degree){
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        return Bitmap.createBitmap(src,0,0,src.getWidth(),src.getHeight(),matrix, true);
    }
}