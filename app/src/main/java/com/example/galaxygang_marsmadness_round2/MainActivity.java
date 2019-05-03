package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.media.MediaPlayer;
import android.animation.ObjectAnimator;
import android.animation.AnimatorSet;
import android.view.animation.LinearInterpolator;

/***************************************************
 * Implementation for launch.xml:
 * This java file serves to function the introductory screen to our app. This consists of a simple text view that
 * displays the name of the game, a button labelled "blast off", and a space ship animation.
 * Once the blast off button is pressed, the space ship then quite literally blasts off, as it moves in a diagonal animation form,
 * and plays a rocket noise sound effect.
 **************************************************/

public class MainActivity extends Activity implements OnClickListener {

    private ImageView rocket;

    MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);

        rocket = findViewById(R.id.rocket);

        Button enter;
        enter = findViewById(R.id.enter);

        song = MediaPlayer.create(MainActivity.this, R.raw.mars_madness_song); //song plays
        song.setLooping(true); //song loops
        song.start();

        enter.setOnClickListener(this);
    }

    //the only activity on this screen is going to the name screen when the enter button is clicked
    @Override
    public void onClick(View v) {
        rocketLaunch();
        MediaPlayer woosh = MediaPlayer.create(MainActivity.this, R.raw.jet_whoosh);
        woosh.start();
        launchNameScreen();
    }

    //this function goes to the screen where the user inputs their name
    private void launchNameScreen() {
        Intent name = new Intent(MainActivity.this, nameActivity.class);
        startActivity(name);
    }

    //this function launches the rocket when the button is clicked
    private void rocketLaunch() {
        AnimatorSet launch = new AnimatorSet();
        ObjectAnimator y = ObjectAnimator.ofFloat(rocket, "translationY", -1100);
        ObjectAnimator x = ObjectAnimator.ofFloat(rocket, "translationX", 1100);
        launch.playTogether(x,y);
        launch.setInterpolator(new LinearInterpolator());
        launch.setDuration(1200);
        launch.start();
    }


}
