package com.example.ozcanyureklioglu.oyun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText isim;
    Button btn;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isim= (EditText)findViewById(R.id.isim);
        btn=(Button)findViewById(R.id.basla);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(MainActivity.this,oyun.class);
                i.putExtra("isim",isim.getText().toString());
                startActivity(i);


            }
        });




    }
}
