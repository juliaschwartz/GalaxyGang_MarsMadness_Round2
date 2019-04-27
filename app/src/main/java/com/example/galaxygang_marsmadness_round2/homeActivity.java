package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

/***************************************************
 * implementation for home.xml
 **************************************************/

public class homeActivity extends Activity implements OnClickListener{

    String playerName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button single = findViewById(R.id.single);
        Button multi =  findViewById(R.id.multi);

        single.setOnClickListener(this);
        multi.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            playerName = b.getString("name");
        }

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.single :
            {
                launchCards(playerName);
                break;
            }
            case R.id.multi :
            {
                launchMulti(playerName);
                break;
            }
        }
    }

    private void launchCards(String name) {
        Intent Cards = new Intent(homeActivity.this, cardsMenu.class);
        Bundle b = new Bundle();
        b.putString("key","single");
        b.putString("name",name);
        Cards.putExtras(b);
        startActivity(Cards);
    }

    private void launchMulti(String name) {
        Intent mult = new Intent(homeActivity.this, multiMenu.class);
        Bundle b = new Bundle();
        b.putString("name",name);
        mult.putExtras(b);
        startActivity(mult);
    }
}
