package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.content.Intent;

/***************************************************
 * implementation for cards_menu.xml********************************************/

public class cardsMenu extends Activity implements OnClickListener{

    private Button back;

    private RadioButton cards8;
    private RadioButton cards16;
    private RadioButton cards24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards_menu);

        back = (Button) findViewById(R.id.button4);
        back.setOnClickListener(this);

        cards8 = (RadioButton) findViewById(R.id.cardsbutton_8);
        cards16 = (RadioButton) findViewById(R.id.cardsbutton_16);
        cards24 = (RadioButton) findViewById(R.id.cardsbutton_24);

        cards8.setOnClickListener(this);
        cards16.setOnClickListener(this);
        cards24.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        switch(v.getId()) {
            case R.id.button4 :
                goHome();
                break;

            case R.id.cardsbutton_8 :
                if (checked) {
                    singleGame(8);
                }
                break;


            case R.id.cardsbutton_16 :
                if (checked) {
                    singleGame(16);
                }
                break;

            case R.id.cardsbutton_24 :
                if (checked) {
                    singleGame(24);
                }
                break;
        }
    }

    private void singleGame(int cards) {
        Intent sing8 = new Intent(cardsMenu.this, singleGame8.class);
        Intent sing16= new Intent(cardsMenu.this, singleGame16.class);
        Intent sing24= new Intent(cardsMenu.this, singleGame24.class);

        switch(cards) {
            case 8: {
                startActivity(sing8);
            }
            case 16: {
                startActivity(sing16);
            }
            case 24: {
                startActivity(sing24);
            }
        }
    }

    private void goHome() {
        Intent goHome = new Intent(cardsMenu.this, homeActivity.class);
        startActivity(goHome);
    }

}

