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

    private Button single;
    private Button multi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        single = (Button) findViewById(R.id.button);
        multi =  (Button) findViewById(R.id.button3);

        single.setOnClickListener(this);
        multi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button :
            {
                launchSingle();
                break;
            }
            case R.id.button3 :
            {
                launchMulti();
                break;
            }
        }
    }

    private void launchSingle() {
        Intent sing = new Intent(homeActivity.this, cardsMenu.class);
        startActivity(sing);
    }

    private void launchMulti() {
        Intent mult = new Intent(homeActivity.this, multiMenu.class);
        startActivity(mult);
    }
}
