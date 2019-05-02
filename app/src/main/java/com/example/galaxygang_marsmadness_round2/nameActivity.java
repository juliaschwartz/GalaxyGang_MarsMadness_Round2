package com.example.galaxygang_marsmadness_round2;

import android.Manifest;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.os.Environment.getExternalStoragePublicDirectory;

/***************************************************
 * implementation for namescreen.xml
 * this is the screen where the player enters their name
 * the name will be used throughout the experience of the app
 * this screen comes between the launch screen and the home screen
 **************************************************/

public class nameActivity extends AppCompatActivity {

    private EditText inputName; //this is where the user inputs their name

    Button btnTakePic;
    ImageView imageView;
    String pathToFile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.namescreen);

        inputName = findViewById(R.id.name_input);

        btnTakePic = findViewById(R.id.btnTakePic);
        if (Build.VERSION.SDK_INT >= 23){
            requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }
        btnTakePic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dispatchPictureTakerAction();
            }
        });
        imageView = findViewById(R.id.image);

        Button next;
        next = findViewById(R.id.next);
        next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerName = inputName.getText().toString(); //get the inputted name
                launchHome(playerName); //go to the home screen
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == 1){
                Bitmap bitmap = BitmapFactory.decodeFile(pathToFile);
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    private void dispatchPictureTakerAction(){
        Intent takePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePic.resolveActivity(getPackageManager()) != null){
            File photoFile = null;
            photoFile = createPhotoFile();

            if (photoFile != null){
                pathToFile = photoFile.getAbsolutePath();
                Uri photoURI = FileProvider.getUriForFile(nameActivity.this, "com.example.galaxygang_marsmadness_round2.fileprovider",photoFile);
                takePic.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePic, 1);
            }
        }
    }

    private File createPhotoFile(){
        String name = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File storageDir = getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(name, ".jpg",storageDir);
        } catch (IOException e) {
            Log.d("mylog","Excep : " + e.toString());
        }
        return image;
    }

    private void launchHome(String name) {
        Intent home = new Intent(nameActivity.this, homeActivity.class);
        Bundle b = new Bundle();
        b.putString("name",name); //this passes along the inputted name to the home screen
        home.putExtras(b);
        startActivity(home);
    }

}