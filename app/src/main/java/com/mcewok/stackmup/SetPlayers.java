package com.mcewok.stackmup;

import android.widget.EditText;

import java.util.Set;

/**
 * Created by Joshu on 11/13/2017.
 */

public class SetPlayers {
    private String _player1;
    private String _player2;

    public void setPlayer1(String _sPlayerOne){
        _player1 = _sPlayerOne;
    }

    public void setPlayer2(String _sPlayerTwo){
        _player2 = _sPlayerTwo;
    }

    public String getPlayer1(){
        return(_player1);
    }

    public String getplayer2(){
        return(_player2);
    }
}
