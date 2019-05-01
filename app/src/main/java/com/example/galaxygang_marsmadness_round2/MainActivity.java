package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.media.MediaPlayer;

/***************************************************
 * implementation for launch.xml
 * this is the welcome screen to the app
 *main purpose is to look nice
 **************************************************/

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);

        Button enter;
        enter = findViewById(R.id.enter);

        enter.setOnClickListener(this);

        //MediaPlayer song = MediaPlayer.create(MainActivity.this, R.raw.mars_madness_song_hq);
        //song.start();
    }

    //the only activity on this screen is going to the name screen when the enter button is clicked
    @Override
    public void onClick(View v) {
        launchNameScreen();
    }

    private void launchNameScreen() {
        Intent name = new Intent(MainActivity.this, nameActivity.class);
        startActivity(name);
    }

}
