package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.content.Intent;

/***************************************************
 * Implementation for cards_menu.xml:
 *
 * In this code, 3 buttons in a radio group are displayed.
 * The buttons will bring the player either to an 8 card game, a 16 card game, or a 20 card game.
 * When one of the buttons is clicked by the user, the screen redirects to the
 * correct game screen depending on said card amount. The type of game (multiplayer), and the name of the user
 * is also passed through this script.
 * There is alos a button that redirects the user back to the home menu.
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

        //button selects the correct number of cards when clicked
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
        //this allows the radio buttons to be clicked
    }

    //this function launches the correct game activity
    //based on the inputs, a specific game type will be launched
    private void launchGame(int cards, String type, String name) {

        if (type.equals("single")) {
            if(cards == 16){
                Intent game = new Intent(cardsMenu.this, singleActivity16.class);
                Bundle b = new Bundle();
                b.putString("name", name);
                game.putExtras(b);
                startActivity(game);
            } else if (cards == 8){
                Intent game = new Intent(cardsMenu.this, singleActivity8.class);
                Bundle b = new Bundle();
                b.putString("name", name);
                game.putExtras(b);
                startActivity(game);
            } else if (cards == 20){
                Intent game = new Intent(cardsMenu.this, singleActivity20.class);
                Bundle b = new Bundle();
                b.putString("name", name);
                game.putExtras(b);
                startActivity(game);
            }

        } else if (type.equals("computer") || type.equals("local")) {
            if (cards == 8) {
                Intent game = new Intent(cardsMenu.this, multiActivity8.class);
                Bundle b = new Bundle();
                b.putString("type", type);
                b.putString("name", name);
                game.putExtras(b);
                startActivity(game);
            } else if (cards == 16) {
                Intent game = new Intent(cardsMenu.this, multiActivity16.class);
                Bundle b = new Bundle();
                b.putString("type", type);
                b.putString("name", name);
                game.putExtras(b);
                startActivity(game);
            } else if (cards == 20) {
                Intent game = new Intent(cardsMenu.this, multiActivity20.class);
                Bundle b = new Bundle();
                b.putString("type", type);
                b.putString("name", name);
                game.putExtras(b);
                startActivity(game);
            }


        }

    }
    //this function goes back to home menu
    private void goHome (String name) {
        Intent home = new Intent(cardsMenu.this, homeActivity.class);
        Bundle b = new Bundle();
        b.putString("name",name);
        home.putExtras(b);
        startActivity(home);
    }

}
