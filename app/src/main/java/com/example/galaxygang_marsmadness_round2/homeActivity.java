package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.animation.ObjectAnimator;

/***************************************************
 * implementation for home.xml
 * this is the home screen, basically the main menu
 * welcomes player, asks for what type of multigame to play
 **************************************************/

public class homeActivity extends Activity implements OnClickListener{

    private String playerName;
    //private String State;

    private TextView nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button single =   findViewById(R.id.single);
        Button computer = findViewById(R.id.computer);
        Button local =    findViewById(R.id.local);
        //Button wifi =     findViewById(R.id.wifi);

        single.setOnClickListener(this);
        computer.setOnClickListener(this);
        local.setOnClickListener(this);
       // wifi.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            playerName = b.getString("name"); //gets the name inputted from the name screen
        }

        nameText = findViewById(R.id.nameText);
        nameText.setText(playerName); //puts the player's name on the screen
        //now the screen should say: welcome <name>


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.single :
            {
                //State = "single";
                launchSingle(playerName);
                break;
            }
            case R.id.computer:
            {
                //State = "computer";
                launchComp(playerName);
                break;
            }
            case R.id.local:
            {
               // State = "local";
                launchLocal(playerName);
                break;
            }
        }
    }

    //this function launches the cards menu for a single player multigame
    private void launchSingle(String name) {
        Intent sing = new Intent(homeActivity.this, cardsMenu.class);
        Bundle b = new Bundle();
        b.putString("key","single"); //pass along that this will be a single player multigame
        b.putString("name",name); //pass the player's name
        //b.putString("State", State); //pass along the game type
        sing.putExtras(b);
        startActivity(sing);
    }

    //this function launches the cards menu for a computer multigame
    private void launchComp(String name) {
        Intent comp = new Intent(homeActivity.this, cardsMenu.class);
        Bundle b = new Bundle();
        b.putString("key","computer"); //pass along that this will be a single player multigame
        b.putString("name",name); //pass the player's name
      //  b.putString("State", State); //pass along the game type
        comp.putExtras(b);
        startActivity(comp);
    }

    //this function launches the cards menu for a local multigame
    private void launchLocal(String name) {
        Intent loc = new Intent(homeActivity.this, cardsMenu.class);
        Bundle b = new Bundle();
        b.putString("key","local"); //pass along that this will be a single player multigame
        b.putString("name",name); //pass the player's name
      //  b.putString("State", State); //pass along the game type
        loc.putExtras(b);
        startActivity(loc);

    }

}
