package com.example.ozcanyureklioglu.oyun;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;

import com.example.ozcanyureklioglu.oyun.R;
@SuppressLint("RestrictedApi")
public class kart extends Button {
    boolean acikMi=false;
    boolean cevrilirMi=true;
    int resimId;
    int arkaPlanId;
    int onPlanId;
    Drawable arka;
    Drawable on;
    public kart(Context context,int Id) {
        super(context);

        arkaPlanId= R.drawable.x;
        onPlanId=0;

        setId(Id);
        if(Id%8==1){onPlanId=R.drawable.bir;}
        if(Id%8==2) onPlanId=R.drawable.iki;
        if(Id%8==3) onPlanId=R.drawable.uc;
        if(Id%8==4) onPlanId=R.drawable.dort;
        if(Id%8==5) onPlanId=R.drawable.bes;
        if(Id%8==6) onPlanId=R.drawable.alti;
        if(Id%8==7) onPlanId=R.drawable.yedi;
        if(Id%8==0) onPlanId=R.drawable.sekiz;

        arka= AppCompatDrawableManager.get().getDrawable(context,arkaPlanId);
        on= AppCompatDrawableManager.get().getDrawable(context,onPlanId);
        setBackground(arka);

    }

    public void degistir(){
        if(cevrilirMi) {
            if (!acikMi) {
                setBackground(on);
                acikMi = true;
            } else {
                setBackground(arka);
                acikMi = false;

            }

        }

    }


}
