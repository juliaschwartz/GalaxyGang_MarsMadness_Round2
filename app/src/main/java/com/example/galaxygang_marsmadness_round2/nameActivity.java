package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.media.MediaPlayer;

/***************************************************
 * implementation for namescreen.xml
 * this is the screen where the player enters their name
 * the name will be used throughout the experience of the app
 * this screen comes between the launch screen and the home screen
 **************************************************/

public class nameActivity extends Activity implements OnClickListener{

    private EditText inputName; //this is where the user inputs their name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.namescreen);

        inputName = findViewById(R.id.name_input);

        Button next = findViewById(R.id.next);
        next.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String playerName = inputName.getText().toString(); //get the inputted name
        launchHome(playerName); //go to the home screen
    }


    private void launchHome(String name) {
        Intent home = new Intent(nameActivity.this, homeActivity.class);
        Bundle b = new Bundle();
        b.putString("name",name); //this passes along the inputted name to the home screen
        home.putExtras(b);
        startActivity(home);
    }



}