package com.example.ozcanyureklioglu.oyun;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class oyun extends AppCompatActivity {
        Intent i,finish;
        TextView txt,skorText,hataText;
        GridLayout grd;
        kart kartlar[];
        int sonkart=0;
        int skor=0,hata=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun);
        i=getIntent();
        txt=(TextView)findViewById(R.id.hosgeldiniz);
        skorText=(TextView)findViewById(R.id.skor);
        hataText=(TextView)findViewById(R.id.hata);
        String s=i.getStringExtra("isim");
        txt.setText("Hoşgeldiniz: "+s);

        grd=(GridLayout)findViewById(R.id.grid);
        kartlar=new kart[16];
        for(int a=1;a<=16;a++){//array kart add
            kartlar[a-1]=new kart(this,a);
            kartlar[a-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   final kart k =(kart)v;
                    k.degistir();
                    if(sonkart>0){
                       final kart sKart=(kart)findViewById(sonkart);

                        if(sKart.onPlanId ==k.onPlanId && sKart.getId()!=k.getId()){//Eslestiler
                           sKart.cevrilirMi=false;
                           k.cevrilirMi=false;
                           skor++;
                           sonkart=0;
                           if(skor==8){//oyun bitti
                                finish=new Intent(oyun.this,finish.class);
                                finish.putExtra("hata",hata);
                                finish.putExtra("skor",skor);
                                startActivity(finish);
                           }
                           skorText.setText(""+skor);

                        }
                        else{//Eslesmediler
                            Handler h=new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    k.degistir();
                                    sKart.degistir();
                                }
                            },1000);
                            sonkart=0;
                            hata++;
                            hataText.setText(""+hata);

                        }



                    }
                    else{
                        sonkart=k.getId();
                    }



                }
            });
          }
        for(int a=0;a<16;a++){//mixer
            int rg=(int)(Math.random()*16);
            kart yedek=kartlar[rg];
            kartlar[rg]=kartlar[a];
            kartlar[a]=yedek;

        }
        for(int a=0;a<16;a++){// gridView add
            grd.addView(kartlar[a]);
        }



    }
}
