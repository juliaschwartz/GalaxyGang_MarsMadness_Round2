package com.example.galaxygang_marsmadness_round2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;

/***************************************************
 * implementation for multiplayer_menu.xml
 *
 * back button always there on bottom
 *
 * radio button checkbox - computer / local
 * onClick for local selected - pop up: searching for local opponents
 *      -will search bluetooth/wifi network for other phones
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

    private Button back;

}
