package com.example.galaxygang_marsmadness_round2;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.text.SimpleDateFormat;

public class cameraActivity extends AppCompatActivity {

    Button btnTakePic;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        btnTakePic = findViewById(R.id.btnTakePic);
        btnTakePic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                    dispatchPictureTakerAction();
            }
        });
        imageView = findViewById(R.id.image)
    }

    private void dispatchPictureTakerAction(){
        Intent takePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePic.resolveActivity(getPackageManager()) != null){
            File photoFile = null;
            try{
                photoFile = createPhotoFile();
            }
            catch (Exception){

            }
        }

    }

    private File createPhotoFile(){
        String name = new SimpleDateFormat(pattern:)
    }


}