package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.content.Intent;
import android.widget.TextView;

/***************************************************
 * implementation for game.xml
 *
 * this is a dummy implementation:
 * when you start the game, the screen should show the correct number of cards and type of game that will be played
 * for example:
 * 8            24
 * Single       Computer
 * joe          joe
 **************************************************/

public class gameActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        TextView dummy = findViewById(R.id.textView4);
        int cards = 0;
        String type = "type";
        String name = "player";

        Bundle b = getIntent().getExtras();
        if (b != null){
            cards = b.getInt("cards");
            type = b.getString("type");
            name = b.getString("name");
        }

        String cardString = Integer.toString(cards);
        String dummytext = cardString+"\n"+type+"\n"+name;

        dummy.setText(dummytext);

    }
}
