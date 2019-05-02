package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

/***************************************************
 * implementation for home.xml
 * this is the home screen, basically the main menu
 * welcomes player, asks for what type of game to play
 **************************************************/

public class homeActivity extends Activity implements OnClickListener{

    private String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button single =   findViewById(R.id.single);
        Button computer = findViewById(R.id.computer);
        Button local =    findViewById(R.id.local);
        Button wifi =     findViewById(R.id.wifi);

        single.setOnClickListener(this);
        computer.setOnClickListener(this);
        local.setOnClickListener(this);
        wifi.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            playerName = b.getString("name"); //gets the name inputted from the name screen
        }

        TextView nameText = findViewById(R.id.nameText);
        nameText.setText(playerName); //puts the player's name on the screen
        //now the screen should say: welcome <name>

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.single :
            {
                launchSingle(playerName);
                break;
            }
            case R.id.computer:
            {
                launchComp(playerName);
                break;
            }
            case R.id.local:
            {
                launchLocal(playerName);
                break;
            }
        }
    }

    //this function launches the cards menu for a single player game
    private void launchSingle(String name) {
        Intent sing = new Intent(homeActivity.this, cardsMenu.class);
        Bundle b = new Bundle();
        b.putString("key","single"); //pass along that this will be a single player game
        b.putString("name",name); //pass the player's name
        sing.putExtras(b);
        startActivity(sing);
    }

    //this function launches the cards menu for a computer game
    private void launchComp(String name) {
        Intent comp = new Intent(homeActivity.this, cardsMenu.class);
        Bundle b = new Bundle();
        b.putString("key","computer"); //pass along that this will be a single player game
        b.putString("name",name); //pass the player's name
        comp.putExtras(b);
        startActivity(comp);
    }

    //this function launches the cards men for a local game
    private void launchLocal(String name) {
        Intent loc = new Intent(homeActivity.this, cardsMenu.class);
        Bundle b = new Bundle();
        b.putString("key","local"); //pass along that this will be a single player game
        b.putString("name",name); //pass the player's name
        loc.putExtras(b);
        startActivity(loc);

    }
}
