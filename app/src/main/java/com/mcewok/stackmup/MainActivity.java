package com.mcewok.stackmup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public ImageView _logoIS;
    public TextView _wsmuTV;
    public TextView _cbTV;
    public TextView _esTV;
    public TextView _playerOneTV;
    public TextView _disPlayerOne;
    public TextView _disPlayerTwo;
    public EditText _playerOneET;
    public TextView _playerTwoTV;
    public EditText _playerTwoET;
    public RelativeLayout _logoRL;
    public RelativeLayout _createdByL;
    public RelativeLayout _amtPlayersRL;
    public RelativeLayout _playerTwoRL;
    public RelativeLayout _showPlayers;
    public GridLayout _boardGL;
    public Button _continueBt;
    public Button _twoContinueBt;
    public SetPlayers _setPlayers;
    public ImageView[] redCounters = new ImageView[42];
    public ImageView[] yellowCounters = new ImageView[42];
    public String player;
    public String[] apostleNames = {"President Russell M. Nelson","President Dallin H. Oaks","President Henry B. Eying","Elder M. Russell Ballard",
                                    "Elder Jeffrey R. Holland","Elder Dieter F. Uchtdorf","Elder David A. Bednar","Elder Quentin L. Cook",
                                    "Elder D. Todd Christofferson","Elder Neil L. Andersen","Elder Ronald A. Rasband","Elder Gary E. Stevenson",
                                    "Elder Dale G. Renlund","Elder Gerrit W. Gong","Elder Ulisses Soares"};

    public int [] randomMatirix = new int[15];
    public int [] boardArray = new int[42];

    Random rand = new Random();
    BeginningFades _beginningFade;

    public void boardVisible(View view) {
        _playerTwoRL.setVisibility(View.GONE);
        _setPlayers.setPlayer2(_playerTwoET.getText().toString());
        _disPlayerOne.setText(_setPlayers.getPlayer1());
        _disPlayerTwo.setText(_setPlayers.getplayer2());
        _showPlayers.setVisibility(View.VISIBLE);
        _boardGL.setVisibility(View.VISIBLE);
    }

    public void seedBoard(View view){
        int _rand;
        boolean completed = false;
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = 33;
        params.topMargin = 23;
        _createdByL.setVisibility(View.GONE);
        for(int x = 0; x < 14; x++){
            randomMatirix[x] = 0;
        }

        for(int x = 0; x < 41; x++){

            do {
                _rand = rand.nextInt(15);
                if (randomMatirix[_rand] != 2) {
                    randomMatirix[_rand]++;
                    boardArray[x] = _rand;
                    completed = true;
                } else {
                    completed = false;
                }
            } while (completed = false);
        }

        for(int x = 0; x < redCounters.length; x++){
            redCounters[x] = new ImageView(this);
            redCounters[x].setImageResource(R.drawable.reddot);
            redCounters[x].setVisibility(View.VISIBLE);
            redCounters[x].setLayoutParams(params);
            _boardGL.addView(redCounters[x]);
        }

        for(int x = 0; x < yellowCounters.length; x++){
            yellowCounters[x] = new ImageView(this);
            yellowCounters[x].setImageResource(R.drawable.yellowdot);
            yellowCounters[x].setVisibility(View.GONE);
            _boardGL.addView(yellowCounters[x]);
        }
        _setPlayers.setPlayer1(_playerOneET.getText().toString());
        _amtPlayersRL.setVisibility(View.GONE);
        _playerTwoRL.setVisibility(View.VISIBLE);
    }

    public void logoOnClick (View view) {
        _logoIS.animate().alpha(0).setDuration(1000);
        _wsmuTV.animate().alpha(0).setDuration(1000);
        _cbTV.animate().alpha(1).setDuration(2000);
        _esTV.animate().alpha(1).setDuration(2000);
        Toast.makeText(getApplicationContext(),"SetUp",Toast.LENGTH_LONG);
        _createdByL.setVisibility(View.VISIBLE);
    }

    public void createdByOnClick (View view) {
        _logoRL.setVisibility(View.GONE);
        _cbTV.animate().alpha(0).setDuration(1000);
        _esTV.animate().alpha(0).setDuration(1000);
        _playerOneTV.animate().alpha(1).setDuration(2000);
        _playerOneET.animate().alpha(1).setDuration(2000);
        _continueBt.animate().alpha(1).setDuration(2000);
        _amtPlayersRL.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _cbTV = (TextView) findViewById(R.id.cbTV);
        _esTV = (TextView) findViewById(R.id.esTV);
        _disPlayerOne = (TextView) findViewById(R.id.disPlayerOne);
        _disPlayerTwo = (TextView) findViewById(R.id.disPlayerTwo);
        _playerOneTV = (TextView) findViewById(R.id.playerOneTV);
        _playerOneET = (EditText) findViewById(R.id.playerOneET);
        _playerTwoTV = (TextView) findViewById(R.id.playerTwoTV);
        _playerTwoET = (EditText) findViewById(R.id.playerTwoET);
        _logoIS = (ImageView) findViewById(R.id.logoIS);
        _wsmuTV = (TextView) findViewById(R.id.wsmuTV);
        _createdByL = (RelativeLayout) findViewById(R.id.createdByL);
        _amtPlayersRL = (RelativeLayout) findViewById(R.id.amtPlayersRL);
        _playerTwoRL = (RelativeLayout) findViewById(R.id.playerTwoRL);
        _logoRL = (RelativeLayout) findViewById(R.id.logoRL);
        _showPlayers = (RelativeLayout) findViewById(R.id.showPlayers);
        _continueBt = (Button) findViewById(R.id.continueBt);
        _twoContinueBt = (Button) findViewById(R.id.twoContinueBt);
        _boardGL = (GridLayout) findViewById(R.id.boardGL);

        _setPlayers = new SetPlayers();
        _beginningFade = new BeginningFades(this);
    }
}


