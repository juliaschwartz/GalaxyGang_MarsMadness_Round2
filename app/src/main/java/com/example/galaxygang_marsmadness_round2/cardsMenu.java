package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.content.Intent;

/***************************************************
 * implementation for cards_menu.xml
 * ********************************************/

public class cardsMenu extends Activity {

    private RadioGroup cardGroup;

    private String game_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards_menu);

        cardGroup = findViewById(R.id.radioGroup);

        Bundle b = getIntent().getExtras();
        if (b != null){
            game_type = b.getString("key");
        }

        Button back = findViewById(R.id.back);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });

        Button start = findViewById(R.id.start);
        start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedCards = cardGroup.getCheckedRadioButtonId();

                switch (selectedCards) {
                    case (R.id.cardsbutton_8) :
                        launchGame(8, game_type);
                        break;
                    case (R.id.cardsbutton_16) :
                        launchGame(16, game_type);
                        break;
                    case (R.id.cardsbutton_24) :
                        launchGame(24, game_type);
                }

            }

        });



    }

    public void onRadioButtonClicked(View v) {
        //wooohoeohfeohfe
    }

    private void launchGame(int cards, String type) {
        Intent game = new Intent(cardsMenu.this, gameActivity.class);
        Bundle b = new Bundle();
        b.putString("type",type);
        b.putInt("cards",cards);
        game.putExtras(b);
        startActivity(game);

    }

    private void goHome() {
        Intent goHome = new Intent(cardsMenu.this, homeActivity.class);
        startActivity(goHome);
    }

}

