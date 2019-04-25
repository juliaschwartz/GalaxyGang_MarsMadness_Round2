package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.content.Intent;

/***************************************************
 * implementation for cards_menu.xml
 * ********************************************/

public class cardsMenu extends Activity implements OnClickListener {

    private RadioButton cards8;
    private RadioButton cards16;
    private RadioButton cards24;

    private String game_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards_menu);

        Button back = findViewById(R.id.back);
        back.setOnClickListener(this);

        Button start = findViewById(R.id.start);
        start.setOnClickListener(this);

        cards8  = findViewById(R.id.cardsbutton_8);
        cards16 = findViewById(R.id.cardsbutton_16);
        cards24 = findViewById(R.id.cardsbutton_24);

        Bundle b = getIntent().getExtras();
        if (b != null){
            game_type = b.getString("key");
        }

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.back :
                goHome();
                break;
            case R.id.start :
                if (cards8.isChecked()) {
                    launchGame(8, game_type);
                } else if (cards16.isChecked()) {
                    launchGame(16, game_type);
                } else if (cards24.isChecked()) {
                    launchGame(24, game_type);
                }
        }
    }

    private void launchGame(int cards, String type) {
        Intent game = new Intent(cardsMenu.this, game.class);
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

