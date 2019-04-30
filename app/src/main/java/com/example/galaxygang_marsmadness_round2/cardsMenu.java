package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.content.Intent;

/***************************************************
 * implementation for cards_menu.xml
 * ********************************************/

public class cardsMenu extends Activity {

    private RadioGroup cardGroup;

    private String game_type;

    private String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards_menu);

        cardGroup = findViewById(R.id.radioGroup);

        Bundle b = getIntent().getExtras();
        if (b != null){
            game_type = b.getString("key");     //get type of game
            playerName = b.getString("name");   //get player name
        }

        Button back = findViewById(R.id.back);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome(playerName);
            }
        });

        Button start = findViewById(R.id.start);
        start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedCards = cardGroup.getCheckedRadioButtonId();

                switch (selectedCards) {
                    case (R.id.cardsbutton_8) :
                        launchGame(8, game_type, playerName);
                        break;
                    case (R.id.cardsbutton_16) :
                        launchGame(16, game_type, playerName);
                        break;
                    case (R.id.cardsbutton_20) :
                        launchGame(20, game_type, playerName);
                }

            }

        });



    }

    public void onRadioButtonClicked(View v) {
        //wooohoeohfeohfe
    }

    //this function launches the game activity
    private void launchGame(int cards, String type, String name) {
        Intent game = new Intent(cardsMenu.this, gameActivity.class);
        Bundle b = new Bundle();
        b.putString("type",type);
        b.putInt("cards",cards);
        b.putString("name",name);
        game.putExtras(b);
        startActivity(game);

    }

    //this function goes back to home menu
    private void goHome(String name) {
        Intent goHome = new Intent(cardsMenu.this, homeActivity.class);
        Bundle b = new Bundle();
        b.putString("name",name);
        goHome.putExtras(b);
        startActivity(goHome);
    }

}

