package com.example.galaxygang_marsmadness_round2;

/*********************************
 * Implementation for multiActivity8:
 * This java class is dedicated to multiplayer activity of an eight card game.
 * Because it is an eight card game, the layout of the xml is determined, and 8 cards of four different
 * styles are used. These cards are put into arrays, where when the image is clicked by the user,
 * the image flips over into the card stored within the array. If two of the same photo are clicked,
 * then the images disappear from the screen.
 *
 * At the end, a pop up is employed to display who won the game depending on how many matches they had.
 * Furthermore, an option to go back to the main menu is displayed.
 *
*********************************/


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import android.os.Handler;
import java.util.Arrays;
import java.util.Collections;

public class multiActivity8 extends AppCompatActivity {

    TextView tv_p1, tv_p2;

    ImageView iv_8_11, iv_8_12, iv_8_21, iv_8_22,  iv_8_31, iv_8_32,  iv_8_41, iv_8_42;

    //array for the cards16
    Integer[] cardsArray = {101, 102, 103, 104, 201, 202, 203, 204};

    //actual cards16
    int image101, image102, image103, image104,
            image201, image202, image203, image204;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    int turn = 1;
    int playerPoints = 0, cpuPoints = 0;

    String p1_name = "P1";
    String p2_name = "Friend";
    String type = "local";

    MediaPlayer beep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multigame);

        beep = MediaPlayer.create(multiActivity8.this, R.raw.match_beep);

        Bundle b = getIntent().getExtras();
        if (b != null){
            p1_name = b.getString("name");
            type = b.getString("type");
        }

        if (type.equals("computer")) {
            p2_name = "Computer";
        }

        View deck8 = findViewById(R.id.deck8);
        deck8.setVisibility(View.VISIBLE);


        tv_p1 = findViewById(R.id.tv_p1);
        tv_p2 = findViewById(R.id.tv_p2);

        tv_p1.setText(p1_name+": "+ playerPoints);
        tv_p2.setText(p2_name+": "+cpuPoints);

        iv_8_11 = findViewById(R.id.iv_8_11);
        iv_8_12 = findViewById(R.id.iv_8_12);

        iv_8_21 = findViewById(R.id.iv_8_21);
        iv_8_22 = findViewById(R.id.iv_8_22);

        iv_8_31 = findViewById(R.id.iv_8_31);
        iv_8_32 = findViewById(R.id.iv_8_32);

        iv_8_41 = findViewById(R.id.iv_8_41);
        iv_8_42 = findViewById(R.id.iv_8_42);


        iv_8_11.setTag("0");
        iv_8_12.setTag("1");

        iv_8_21.setTag("2");
        iv_8_22.setTag("3");

        iv_8_31.setTag("4");
        iv_8_32.setTag("5");

        iv_8_41.setTag("6");
        iv_8_42.setTag("7");


        //load the card cards16
        frontOfCardResources();

        //shuffle the cards16
        Collections.shuffle(Arrays.asList(cardsArray));

        //changing the color of the second player to show inactivity
        tv_p2.setTextColor(Color.GRAY);

        iv_8_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_8_11, theCard);
            }

        });

        iv_8_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_8_12, theCard);
            }

        });


        iv_8_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_8_21, theCard);

            }

        });

        iv_8_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_8_22, theCard);
            }

        });


        iv_8_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_8_31, theCard);
            }

        });

        iv_8_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_8_32, theCard);
            }

        });


        iv_8_41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_8_41, theCard);
            }

        });
        iv_8_42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_8_42, theCard);
            }

        });

    }

    private void doStuff(ImageView iv, int card){
        //set the correct image to imageview
        if (cardsArray[card] == 101){
            iv.setImageResource(image101);
        } else if (cardsArray[card] == 102){
            iv.setImageResource(image102);
        } else if (cardsArray[card] == 103){
            iv.setImageResource(image103);
        } else if (cardsArray[card] == 104){
            iv.setImageResource(image104);
        } else if (cardsArray[card] == 201){
            iv.setImageResource(image201);
        } else if (cardsArray[card] == 202){
            iv.setImageResource(image202);
        } else if (cardsArray[card] == 203){
            iv.setImageResource(image203);
        } else if (cardsArray[card] == 204){
            iv.setImageResource(image204);
        }


        //check which image is selected and save it to the temporary variable
        if (cardNumber ==1){
            firstCard = cardsArray[card];
            if (firstCard > 200){
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        } else if (cardNumber == 2){
            secondCard = cardsArray[card];
            if (secondCard > 200){
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            iv_8_11.setEnabled(false);
            iv_8_12.setEnabled(false);

            iv_8_21.setEnabled(false);
            iv_8_22.setEnabled(false);

            iv_8_31.setEnabled(false);
            iv_8_32.setEnabled(false);

            iv_8_41.setEnabled(false);
            iv_8_42.setEnabled(false);


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //check if the selected cards16 are equal
                    calculate();
                }
            }, 1000);
        }

    }
    private void calculate() {
        //if cards16 are equal, remove them and add point
        if (firstCard == secondCard){

            beep.start();

            if (clickedFirst == 0) {
                iv_8_11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv_8_12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                iv_8_21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                iv_8_22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv_8_31.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv_8_32.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                iv_8_41.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                iv_8_42.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                iv_8_11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv_8_12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                iv_8_21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                iv_8_22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv_8_31.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv_8_32.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                iv_8_41.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                iv_8_42.setVisibility(View.INVISIBLE);
            }

            //add points to the correct player

            if (turn ==1){
                playerPoints++;
                tv_p1.setText(p1_name+": "+ playerPoints);
            } else if (turn ==2) {
                cpuPoints++;
                tv_p2.setText(p2_name+": "+ cpuPoints);
            }
        } else {
            iv_8_11.setImageResource(R.drawable.ic_back);
            iv_8_12.setImageResource(R.drawable.ic_back);

            iv_8_21.setImageResource(R.drawable.ic_back);
            iv_8_22.setImageResource(R.drawable.ic_back);

            iv_8_31.setImageResource(R.drawable.ic_back);
            iv_8_32.setImageResource(R.drawable.ic_back);

            iv_8_41.setImageResource(R.drawable.ic_back);
            iv_8_42.setImageResource(R.drawable.ic_back);


            //change the player turn and corresponding text color
            if(turn == 1){
                turn = 2;
                tv_p1.setTextColor(Color.GRAY);
                tv_p2.setTextColor(Color.WHITE);
            } else if(turn == 2){
                turn = 1;
                tv_p1.setTextColor(Color.WHITE);
                tv_p2.setTextColor(Color.GRAY);
            }
        }

        iv_8_11.setEnabled(true);
        iv_8_12.setEnabled(true);

        iv_8_21.setEnabled(true);
        iv_8_22.setEnabled(true);

        iv_8_31.setEnabled(true);
        iv_8_32.setEnabled(true);

        iv_8_41.setEnabled(true);
        iv_8_42.setEnabled(true);


        //check if the multigame is over
        checkEnd();
    }
    private void checkEnd() {
        if (iv_8_11.getVisibility() == View.INVISIBLE &&
                iv_8_12.getVisibility() == View.INVISIBLE &&

                iv_8_21.getVisibility() == View.INVISIBLE &&
                iv_8_22.getVisibility() == View.INVISIBLE &&

                iv_8_31.getVisibility() == View.INVISIBLE &&
                iv_8_32.getVisibility() == View.INVISIBLE &&

                iv_8_41.getVisibility() == View.INVISIBLE &&
                iv_8_42.getVisibility() == View.INVISIBLE){

            String message;
            if(playerPoints>cpuPoints){
                message = "GAME OVER!\n"+p1_name + " wins!";
            } else if(cpuPoints>playerPoints) {
                message = "GAME OVER!\n"+p2_name + " wins!";
            } else {
                message = "GAME OVER!\n"+"It's a tie!";
            }

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(multiActivity8.this);
            alertDialogBuilder
                    .setMessage(message)
                    .setCancelable(false)
                    .setNegativeButton("MENU", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent exit = new Intent(multiActivity8.this, homeActivity.class);
                            Bundle exit_b = new Bundle();
                            exit_b.putString("name",p1_name);
                            exit.putExtras(exit_b);
                            startActivity(exit);
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }
    private void frontOfCardResources(){
        image101 = R.drawable.ic_image101;
        image102 = R.drawable.ic_image102;
        image103 = R.drawable.ic_image103;
        image104 = R.drawable.ic_image104;

        image201 = R.drawable.ic_image201;
        image202 = R.drawable.ic_image202;
        image203 = R.drawable.ic_image203;
        image204 = R.drawable.ic_image204;

    }
}
