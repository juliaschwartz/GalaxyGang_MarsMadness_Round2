package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.content.Intent;

/***************************************************
 * implementation for multi_menu*
 * back button always there on bottom
 *
 * radio button checkbox - computer / local
 * onClick for local selected - pop up: searching for local opponents
 *      -will search WiFi/wifi network for other phones
 *      -choose opponent from menu of other phones - opponent accepts on their phone - pop up closes
 *      -on screen: opponent's name is shown in text box
 *      -radio button appears: size - small/medium/large
 *      -start button appears:
 *          -if nobody found after 5s, pop up says: no local opponents found - pop up closes
 *          -button appears: try again?
 *
 * on Click for computer selected
 *      -radio button appears: difficulty - easy/hard
 *      -start button: initiate game with easy/hard computer
 **************************************************/

public class multiMenu extends Activity implements OnClickListener{

    private RadioButton human;
    private RadioButton computer;

    private RadioButton easy;
    private RadioButton hard;

    private RadioButton cards8;
    private RadioButton cards16;
    private RadioButton cards24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_menu);

        human = (RadioButton) findViewById(R.id.findplayer);
        computer = (RadioButton) findViewById(R.id.computer);
        easy = (RadioButton) findViewById(R.id.easy);
        hard = (RadioButton) findViewById(R.id.hard);
        cards8 = (RadioButton) findViewById(R.id.cards8);
        cards16 = (RadioButton) findViewById(R.id.cards16);
        cards24 = (RadioButton) findViewById(R.id.cards24);

        human.setOnClickListener(this);
        computer.setOnClickListener(this);
        easy.setOnClickListener(this);
        hard.setOnClickListener(this);
        cards24.setOnClickListener(this);
        cards8.setOnClickListener(this);
        cards16.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        switch(v.getId()) {
            case R.id.computer : //when computer is selected, easy/hard appear
                if (checked) {
                    easy.setVisibility(v.VISIBLE);
                    hard.setVisibility(v.VISIBLE);
                }
                break;

            case (R.id.easy) : //when one of these is selected card choices should appear
            case (R.id.hard) :
                if(checked) {
                    if (computer.isChecked()) {
                        cards24.setVisibility(v.VISIBLE);
                        cards16.setVisibility(v.VISIBLE);
                        cards8.setVisibility(v.VISIBLE);
                    }
                }
                break;

            case (R.id.findplayer) : //when find player selected, go to WiFi screen
                if (checked) {
                    findPlayer();
                }
                break;

            case (R.id.cards8) : //decide which 8 card game to play
                if (checked) {
                    if (computer.isChecked()) {
                        if (easy.isChecked()) {
                            launchComp(8,0);
                        } else {
                            launchComp(8,1);
                        }
                    } else {
                        launchLocal(8);
                    }
                }

            case (R.id.cards16) : //decide which 16 card game to play
                if (checked) {
                    if (computer.isChecked()) {
                        if (easy.isChecked()) {
                            launchComp(16,0);
                        } else {
                            launchComp(16,1);
                        }
                    } else {
                            launchLocal(16);
                    }
                }

            case (R.id.cards24) : //decide which 24 card game to play
                if (checked) {
                    if (computer.isChecked()) {
                        if (easy.isChecked()) {
                            launchComp(24,0);
                        } else {
                            launchComp(24,1);
                        }
                    } else {
                        launchLocal(24);
                    }
                }
            }
        }

    private void findPlayer() {
        Intent bluetooth = new Intent(multiMenu.this, WiFisearch.class);
        startActivity(bluetooth);

    }

    private void launchComp(int cards, int difficulty) {
        //launch computer game : 0=easy, 1=hard
    }

    private void launchLocal(int cards) {
        //launch local game
    }

    }

