package com.example.galaxygang_marsmadness_round2;
//import the pre-existing intent class in java
import android.content.Intent;
import android.provider.MediaStore;
import android.content.Context;
import android.content.pm.PackageManager;
import android.app.Activity;


public class Camera extends Activity{
    //extends activity allows you to use instances of app.Activity from java import

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
            imageView.setImageBitmap(imageBitmap);
        }
    }



}
