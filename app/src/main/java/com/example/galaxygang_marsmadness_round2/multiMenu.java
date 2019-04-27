package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;

/***************************************************
 * implementation for multi_menu*
 **************************************************/

public class multiMenu extends Activity implements OnClickListener{

    private String player_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_menu);

        Button human = findViewById(R.id.findplayer);
        Button computer = findViewById(R.id.computer);
        Button back = findViewById(R.id.back);


        human.setOnClickListener(this);
        computer.setOnClickListener(this);
        back.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        if (b != null){
            player_name = b.getString("name");
        }

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.back :
                goHome(player_name);
                break;
            case R.id.findplayer :
                findPlayer(player_name);
                break;
            case R.id.computer :
                launchComp(player_name);
                break;
        }
    }

    private void goHome(String name) {
        Intent home = new Intent(multiMenu.this, homeActivity.class);
        Bundle b = new Bundle();
        b.putString("name",name);
        home.putExtras(b);
        startActivity(home);
    }

    private void findPlayer(String name) {
        Intent wifi = new Intent(multiMenu.this, WiFisearch.class);
        Bundle b = new Bundle();
        b.putString("name",name);
        startActivity(wifi);
    }

    private void launchComp(String name) {
        Intent comp = new Intent(multiMenu.this, cardsMenu.class);
        Bundle b = new Bundle();
        b.putString("key", "computer");
        b.putString("name",name);
        comp.putExtras(b);
        startActivity(comp);
    }

}

