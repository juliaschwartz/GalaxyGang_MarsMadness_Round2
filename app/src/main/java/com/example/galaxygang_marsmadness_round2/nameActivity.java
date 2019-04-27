package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

/***************************************************
 * implementation for namescreen.xml
 **************************************************/

public class nameActivity extends Activity implements OnClickListener {

    private String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.namescreen);

        Button next;
        next = findViewById(R.id.next);
        next.setOnClickListener(this);

        EditText inputName = findViewById(R.id.name_input);
        playerName = inputName.getText().toString();

    }

    @Override
    public void onClick(View v) {
        launchHome(playerName);
    }


    private void launchHome(String name) {
        Intent home = new Intent(nameActivity.this, homeActivity.class);
        Bundle b = new Bundle();
        b.putString("name",name);
        home.putExtras(b);
        startActivity(home);
    }

}