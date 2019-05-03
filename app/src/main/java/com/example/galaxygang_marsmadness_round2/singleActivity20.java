package com.example.galaxygang_marsmadness_round2;

/*********************************
 * Implementation for singleActivity8:
 * This java class is dedicated to single player activity of an twenty card game.
 * Because it is an twenty card game, the layout of the xml is determined, and 20 cards of 10 different
 * styles are used. These cards are put into arrays, where when the image is clicked by the user,
 * the image flips over into the card stored within the array. If two of the same photo are clicked,
 * then the images disappear from the screen. The score is calculated by how many turns the user takes,
 * with a goal of achieving the smallest score possible.
 *
 * At the end, a pop up is employed that displays a single users score for that
 * round, and an option to go back to the main menu.
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

public class singleActivity20 extends AppCompatActivity {

    TextView tv_p1;

    ImageView iv_11, iv_12, iv_13, iv_14, iv_15,
            iv_21, iv_22, iv_23, iv_24, iv_25,
            iv_31, iv_32, iv_33, iv_34, iv_35,
            iv_41, iv_42, iv_43, iv_44, iv_45;

    //array for the cards16
    Integer[] cardsArray = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110,
            201, 202, 203, 204, 205, 206, 207, 208, 209, 210};

    //actual cards16
    int image101, image102, image103, image104, image105, image106, image107, image108, image109, image110,
            image201, image202, image203, image204, image205, image206, image207, image208, image209, image210;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    int turn = 1;
    int playerPoints = 0;

    String p1_name = "P1";

    MediaPlayer beep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singlegame);

        beep = MediaPlayer.create(singleActivity20.this, R.raw.match_beep);

        Bundle b = getIntent().getExtras();
        if (b != null){
            p1_name = b.getString("name");

        }


        View deck20 = findViewById(R.id.deck20);
        deck20.setVisibility(View.VISIBLE);

        tv_p1 = findViewById(R.id.tv_p1);

        tv_p1.setText(p1_name+": "+ playerPoints);

        iv_11 = findViewById(R.id.iv_20_11);
        iv_12 = findViewById(R.id.iv_20_12);
        iv_13 = findViewById(R.id.iv_20_13);
        iv_14 = findViewById(R.id.iv_20_14);
        iv_15 = findViewById(R.id.iv_20_15);
        iv_21 = findViewById(R.id.iv_20_21);
        iv_22 = findViewById(R.id.iv_20_22);
        iv_23 = findViewById(R.id.iv_20_23);
        iv_24 = findViewById(R.id.iv_20_24);
        iv_25 = findViewById(R.id.iv_20_25);
        iv_31 = findViewById(R.id.iv_20_31);
        iv_32 = findViewById(R.id.iv_20_32);
        iv_33 = findViewById(R.id.iv_20_33);
        iv_34 = findViewById(R.id.iv_20_34);
        iv_35 = findViewById(R.id.iv_20_35);
        iv_41 = findViewById(R.id.iv_20_41);
        iv_42 = findViewById(R.id.iv_20_42);
        iv_43 = findViewById(R.id.iv_20_43);
        iv_44 = findViewById(R.id.iv_20_44);
        iv_45 = findViewById(R.id.iv_20_45);

        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_14.setTag("3");
        iv_15.setTag("4");
        iv_21.setTag("5");
        iv_22.setTag("6");
        iv_23.setTag("7");
        iv_24.setTag("8");
        iv_25.setTag("9");
        iv_31.setTag("10");
        iv_32.setTag("11");
        iv_33.setTag("12");
        iv_34.setTag("13");
        iv_35.setTag("14");
        iv_41.setTag("15");
        iv_42.setTag("16");
        iv_43.setTag("17");
        iv_44.setTag("18");
        iv_45.setTag("19");

        //load the card cards16
        frontOfCardResources();

        //shuffle the cards16
        Collections.shuffle(Arrays.asList(cardsArray));

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

        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_13, theCard);
            }

        });

        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_14, theCard);
            }

        });

        iv_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_15, theCard);
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

        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_23, theCard);
            }

        });

        iv_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_24, theCard);
            }

        });

        iv_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_25, theCard);
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

        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_33, theCard);
            }

        });

        iv_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_34, theCard);
            }

        });

        iv_35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_35, theCard);
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

        iv_43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_43, theCard);
            }

        });

        iv_44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_44, theCard);
            }

        });

        iv_45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_45, theCard);
            }

        });
    }

    private void doStuff(ImageView iv, int card) {
        //set the correct image to imageview
        if (cardsArray[card] == 101) {
            iv.setImageResource(image101);
        } else if (cardsArray[card] == 102) {
            iv.setImageResource(image102);
        } else if (cardsArray[card] == 103) {
            iv.setImageResource(image103);
        } else if (cardsArray[card] == 104) {
            iv.setImageResource(image104);
        } else if (cardsArray[card] == 105) {
            iv.setImageResource(image105);
        } else if (cardsArray[card] == 106) {
            iv.setImageResource(image106);
        } else if (cardsArray[card] == 107) {
            iv.setImageResource(image107);
        } else if (cardsArray[card] == 108) {
            iv.setImageResource(image108);
        } else if (cardsArray[card] == 109) {
            iv.setImageResource(image109);
        } else if (cardsArray[card] == 110) {
            iv.setImageResource(image110);
        } else if (cardsArray[card] == 201) {
            iv.setImageResource(image201);
        } else if (cardsArray[card] == 202) {
            iv.setImageResource(image202);
        } else if (cardsArray[card] == 203) {
            iv.setImageResource(image203);
        } else if (cardsArray[card] == 204) {
            iv.setImageResource(image204);
        } else if (cardsArray[card] == 205) {
            iv.setImageResource(image205);
        } else if (cardsArray[card] == 206) {
            iv.setImageResource(image206);
        } else if (cardsArray[card] == 207) {
            iv.setImageResource(image207);
        } else if (cardsArray[card] == 208) {
            iv.setImageResource(image208);
        } else if (cardsArray[card] == 209) {
            iv.setImageResource(image209);
        } else if (cardsArray[card] == 210) {
            iv.setImageResource(image210);
        }

        //check which image is selected and save it to the temporary variable
        if (cardNumber == 1) {
            firstCard = cardsArray[card];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        } else if (cardNumber == 2) {
            secondCard = cardsArray[card];
            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);
            iv_15.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_24.setEnabled(false);
            iv_25.setEnabled(false);
            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_33.setEnabled(false);
            iv_34.setEnabled(false);
            iv_35.setEnabled(false);
            iv_41.setEnabled(false);
            iv_42.setEnabled(false);
            iv_43.setEnabled(false);
            iv_44.setEnabled(false);
            iv_45.setEnabled(false);

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

            //beep.start();


            if (clickedFirst == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv_15.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                iv_25.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 12) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 13) {
                iv_34.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 14) {
                iv_35.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 15) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 16) {
                iv_42.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 17) {
                iv_43.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 18) {
                iv_44.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 19) {
                iv_45.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv_15.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {
                iv_25.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 10) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 11) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 12) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 13) {
                iv_34.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 14) {
                iv_35.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 15) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 16) {
                iv_42.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 17) {
                iv_43.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 18) {
                iv_44.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 19) {
                iv_45.setVisibility(View.INVISIBLE);
            }

            //add points to the correct player

            if (turn ==1){
                playerPoints++;
                tv_p1.setText(p1_name+": "+ playerPoints);
            }
        } else {
            playerPoints++;
            tv_p1.setText(p1_name+": "+ playerPoints);

            iv_11.setImageResource(R.drawable.ic_back);
            iv_12.setImageResource(R.drawable.ic_back);
            iv_13.setImageResource(R.drawable.ic_back);
            iv_14.setImageResource(R.drawable.ic_back);
            iv_15.setImageResource(R.drawable.ic_back);
            iv_21.setImageResource(R.drawable.ic_back);
            iv_22.setImageResource(R.drawable.ic_back);
            iv_23.setImageResource(R.drawable.ic_back);
            iv_24.setImageResource(R.drawable.ic_back);
            iv_25.setImageResource(R.drawable.ic_back);
            iv_31.setImageResource(R.drawable.ic_back);
            iv_32.setImageResource(R.drawable.ic_back);
            iv_33.setImageResource(R.drawable.ic_back);
            iv_34.setImageResource(R.drawable.ic_back);
            iv_35.setImageResource(R.drawable.ic_back);
            iv_41.setImageResource(R.drawable.ic_back);
            iv_42.setImageResource(R.drawable.ic_back);
            iv_43.setImageResource(R.drawable.ic_back);
            iv_44.setImageResource(R.drawable.ic_back);
            iv_45.setImageResource(R.drawable.ic_back);


        }

        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);
        iv_15.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_24.setEnabled(true);
        iv_25.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_34.setEnabled(true);
        iv_35.setEnabled(true);
        iv_41.setEnabled(true);
        iv_42.setEnabled(true);
        iv_43.setEnabled(true);
        iv_44.setEnabled(true);
        iv_45.setEnabled(true);

        //check if the game is over
        checkEnd();
    }
    private void checkEnd() {
        if (iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&
                iv_13.getVisibility() == View.INVISIBLE &&
                iv_14.getVisibility() == View.INVISIBLE &&
                iv_15.getVisibility() == View.INVISIBLE &&
                iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE &&
                iv_23.getVisibility() == View.INVISIBLE &&
                iv_24.getVisibility() == View.INVISIBLE &&
                iv_25.getVisibility() == View.INVISIBLE &&
                iv_31.getVisibility() == View.INVISIBLE &&
                iv_32.getVisibility() == View.INVISIBLE &&
                iv_33.getVisibility() == View.INVISIBLE &&
                iv_34.getVisibility() == View.INVISIBLE &&
                iv_35.getVisibility() == View.INVISIBLE &&
                iv_41.getVisibility() == View.INVISIBLE &&
                iv_42.getVisibility() == View.INVISIBLE &&
                iv_43.getVisibility() == View.INVISIBLE &&
                iv_44.getVisibility() == View.INVISIBLE &&
                iv_45.getVisibility() == View.INVISIBLE){

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(singleActivity20.this);
            alertDialogBuilder
                    .setMessage("GAME OVER!\n"+p1_name+" took " + playerPoints + " turns!"+"\n")
                    .setCancelable(false)
                    .setNegativeButton("MENU", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent exit = new Intent(singleActivity20.this, homeActivity.class);
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
        image105 = R.drawable.ic_image105;
        image106 = R.drawable.ic_image106;
        image107 = R.drawable.ic_image107;
        image108 = R.drawable.ic_image108;
        image109 = R.drawable.ic_image109;
        image110 = R.drawable.ic_image110;
        image201 = R.drawable.ic_image201;
        image202 = R.drawable.ic_image202;
        image203 = R.drawable.ic_image203;
        image204 = R.drawable.ic_image204;
        image205 = R.drawable.ic_image205;
        image206 = R.drawable.ic_image206;
        image207 = R.drawable.ic_image207;
        image208 = R.drawable.ic_image208;
        image209 = R.drawable.ic_image209;
        image210 = R.drawable.ic_image210;
    }
}
