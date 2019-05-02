package com.example.galaxygang_marsmadness_round2;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
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

    ImageView iv_11, iv_12, iv_21, iv_22,  iv_31, iv_32,  iv_41, iv_42;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multigame);

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

        iv_11 = findViewById(R.id.iv_11);
        iv_12 = findViewById(R.id.iv_12);

        iv_21 = findViewById(R.id.iv_21);
        iv_22 = findViewById(R.id.iv_22);

        iv_31 = findViewById(R.id.iv_31);
        iv_32 = findViewById(R.id.iv_32);

        iv_41 = findViewById(R.id.iv_41);
        iv_42 = findViewById(R.id.iv_42);


        iv_11.setTag("0");
        iv_12.setTag("1");

        iv_21.setTag("4");
        iv_22.setTag("5");

        iv_31.setTag("8");
        iv_32.setTag("9");

        iv_41.setTag("12");
        iv_42.setTag("13");


        //load the card cards16
        frontOfCardResources();

        //shuffle the cards16
        Collections.shuffle(Arrays.asList(cardsArray));

        //changing the color of the second player to show inactivity
        tv_p2.setTextColor(Color.GRAY);

        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_11, theCard);
            }

        });

        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_12, theCard);
            }

        });


        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_21, theCard);

            }

        });

        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_22, theCard);
            }

        });


        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_31, theCard);
            }

        });

        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_32, theCard);
            }

        });


        iv_41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_41, theCard);
            }

        });
        iv_42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_42, theCard);
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

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);

            iv_21.setEnabled(false);
            iv_22.setEnabled(false);

            iv_31.setEnabled(false);
            iv_32.setEnabled(false);

            iv_41.setEnabled(false);
            iv_42.setEnabled(false);


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
            if (clickedFirst == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 12) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 13) {
                iv_42.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 12) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 13) {
                iv_42.setVisibility(View.INVISIBLE);
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
            iv_11.setImageResource(R.drawable.ic_back);
            iv_12.setImageResource(R.drawable.ic_back);

            iv_21.setImageResource(R.drawable.ic_back);
            iv_22.setImageResource(R.drawable.ic_back);

            iv_31.setImageResource(R.drawable.ic_back);
            iv_32.setImageResource(R.drawable.ic_back);

            iv_41.setImageResource(R.drawable.ic_back);
            iv_42.setImageResource(R.drawable.ic_back);


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

        iv_11.setEnabled(true);
        iv_12.setEnabled(true);

        iv_21.setEnabled(true);
        iv_22.setEnabled(true);

        iv_31.setEnabled(true);
        iv_32.setEnabled(true);

        iv_41.setEnabled(true);
        iv_42.setEnabled(true);


        //check if the multigame is over
        checkEnd();
    }
    private void checkEnd() {
        if (iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&

                iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE &&

                iv_31.getVisibility() == View.INVISIBLE &&
                iv_32.getVisibility() == View.INVISIBLE &&

                iv_41.getVisibility() == View.INVISIBLE &&
                iv_42.getVisibility() == View.INVISIBLE){

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(multiActivity8.this);
            alertDialogBuilder
                    .setMessage("GAME OVER!\n"+p1_name+": " + playerPoints + "\n"+p2_name+": "+ cpuPoints)
                    .setCancelable(false)
                    .setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent restart = new Intent(multiActivity8.this, cardsMenu.class);
                            Bundle new_b = new Bundle();
                            new_b.putString("name",p1_name);
                            restart.putExtras(new_b);
                            startActivity(restart);
                            finish();
                        }
                    })
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
