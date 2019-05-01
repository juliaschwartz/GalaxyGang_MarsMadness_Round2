package com.example.galaxygang_marsmadness_round2;
//import the pre-existing intent class in java
import android.content.Intent;
import android.provider.MediaStore;
import android.graphics.Bitmap;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.os.Environment;

import com.example.cleanmarsmadness.R;

/***************************************************
 * implementation for thumbnail.xmlxml
 * ********************************************/


public class Camera extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thumbnail);

        Button single = findViewById(R.id.single);
        Button multi =  findViewById(R.id.multi);

        single.setOnClickListener(this);
        multi.setOnClickListener(this);


    //extends activity allows you to use instances of app.Activity from java import

    ImageView image;

    //function that invoke an intent to capture a photo
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // returns the first activity component that can handle the intent.
            // if you start the startActivityForResult function without intent, the
            // app will crash.
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }


    //Do something with the photo!
    //Retrieve the image, display it in an ImageView
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //the photo is stored in the extras under the key "data", so retrieve that
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            image.setImageBitmap(imageBitmap);
        }
    }

    //create a collision resistant file name using a date time stamp
    String currentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name based off of the timestamp
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    //Above is a method that creates a file name for the photo based off of the timestamp
    //Next step: create & invoke the intent

    static final int REQUEST_TAKE_PHOTO = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a thumbnail activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

                System.out.println("Error occurred while creating the picture file!");

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }


}
