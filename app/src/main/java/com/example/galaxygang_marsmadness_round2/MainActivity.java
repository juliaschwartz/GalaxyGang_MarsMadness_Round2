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
        enter = (Button) findViewById(R.id.enter);

        enter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        launchHome();
    }


    private void launchHome() {
        Intent home = new Intent(MainActivity.this, homeActivity.class);
        startActivity(home);
    }

}
