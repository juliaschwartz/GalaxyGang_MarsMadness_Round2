package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;

/***************************************************
 * implementation for home.xml
 **************************************************/

public class homeActivity extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button single = findViewById(R.id.single);
        Button multi =  findViewById(R.id.multi);

        single.setOnClickListener(this);
        multi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.single :
            {
                launchCards();
                break;
            }
            case R.id.multi :
            {
                launchMulti();
                break;
            }
        }
    }

    private void launchCards() {
        Intent Cards = new Intent(homeActivity.this, cardsMenu.class);
        Bundle b = new Bundle();
        b.putString("key","single");
        Cards.putExtras(b);
        startActivity(Cards);
    }

    private void launchMulti() {
        Intent mult = new Intent(homeActivity.this, multiMenu.class);
        startActivity(mult);
    }
}
