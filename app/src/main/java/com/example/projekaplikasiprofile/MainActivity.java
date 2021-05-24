package com.example.projekaplikasiprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends NavDrawer {
    Button btnGaluh,btnNanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.activity_main,null,false);
        drawer.addView(v,0);

        btnGaluh=findViewById(R.id.buttonGaluh);
        btnNanda=findViewById(R.id.buttonNanda);

        btnGaluh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ProfileGaluh.class);
                startActivity(intent);
            }
        });
        btnNanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ProfileNanda.class);
                startActivity(intent);
            }
        });
    }
}