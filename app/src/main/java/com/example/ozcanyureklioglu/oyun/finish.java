package com.example.ozcanyureklioglu.oyun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class finish extends AppCompatActivity {
    Intent i;
    int skor,hata;
    TextView sTxt,hTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        sTxt=(TextView)findViewById(R.id.skor);
        hTxt=(TextView)findViewById(R.id.hata);
        i=getIntent();
        skor=i.getIntExtra("skor",0);
        hata=i.getIntExtra("hata",0);
        sTxt.setText("Skorunuz: "+skor);
        hTxt.setText("Hatanız: "+hata);

    }
}
