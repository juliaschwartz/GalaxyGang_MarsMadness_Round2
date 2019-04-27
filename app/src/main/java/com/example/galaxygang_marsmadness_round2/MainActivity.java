package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;

/***************************************************
 * implementation for launch.xml
 **************************************************/

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);

        Button enter;
        enter = findViewById(R.id.enter);

        enter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        launchNameScreen();
    }


    private void launchNameScreen() {
        Intent name = new Intent(MainActivity.this, nameActivity.class);
        startActivity(name);
    }

}
