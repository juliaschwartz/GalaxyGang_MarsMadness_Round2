package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.content.Intent;
import android.widget.TextView;

public class WiFisearch extends Activity implements OnClickListener{

    private String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifi);

        Button back = findViewById(R.id.back);
        Button next = findViewById(R.id.next);

        back.setOnClickListener(this);
        next.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        if (b != null){
            playerName = b.getString("name");
        }

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.back : {
                goBack(playerName);
                break;
            }
            case R.id.next : {
                launchCards(playerName);
                break;
            }

        }
    }

    private void launchCards(String name) {
        Intent Cards = new Intent(WiFisearch.this, cardsMenu.class);
        Bundle b = new Bundle();
        b.putString("key","wifi");
        b.putString("name",name);
        Cards.putExtras(b);
        startActivity(Cards);
    }

    private void goBack(String name) {
        Intent back = new Intent(WiFisearch.this, multiMenu.class);
        Bundle b = new Bundle();
        b.putString("name",name);
        back.putExtras(b);
        startActivity(back);
    }

}
