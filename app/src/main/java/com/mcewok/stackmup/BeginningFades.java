package com.mcewok.stackmup;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Joshua on 5/6/2017.
 */
class BeginningFades extends Animation {
    private Animation animationAL = null;
    private ImageView _logoIS;
    private TextView _wsmuTV;
    private MainActivity _ctx;
    private String aDone = "";

    BeginningFades(MainActivity ctx) {
        this._ctx = ctx;
    }
}