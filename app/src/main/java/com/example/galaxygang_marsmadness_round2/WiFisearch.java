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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifi);

        Button back = findViewById(R.id.back);
        Button next = findViewById(R.id.next);

        back.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.back : {
                goBack();
                break;
            }
            case R.id.next : {
                launchCards();
                break;
            }

        }
    }

    private void launchCards() {
        Intent Cards = new Intent(WiFisearch.this, cardsMenu.class);
        Bundle b = new Bundle();
        b.putString("key","wifi");
        Cards.putExtras(b);
        startActivity(Cards);
    }

    private void goBack() {
        Intent back = new Intent(WiFisearch.this, multiMenu.class);
        startActivity(back);
    }

}
