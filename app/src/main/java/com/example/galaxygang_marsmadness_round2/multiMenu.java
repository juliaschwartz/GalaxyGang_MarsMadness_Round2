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

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.back :
                goHome();
                break;
            case R.id.findplayer :
                findPlayer();
                break;
            case R.id.computer :
                launchComp();
                break;
        }
    }

    private void goHome() {
        Intent home = new Intent(multiMenu.this, homeActivity.class);
        startActivity(home);
    }

    private void findPlayer() {
        Intent wifi = new Intent(multiMenu.this, WiFisearch.class);
        startActivity(wifi);
    }

    private void launchComp() {
        Intent comp = new Intent(multiMenu.this, cardsMenu.class);
        Bundle b = new Bundle();
        b.putString("key", "computer");
        comp.putExtras(b);
        startActivity(comp);
    }

}

