package com.example.profileappdevelopment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;


public class MainActivity extends MainNavDrawer {
    Button btGaluh, btNanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.activity_main, null, false);
        drawerLayout.addView(v, 0);

        btGaluh = findViewById(R.id.btGaluh);
        btNanda = findViewById(R.id.btNanda);

        btGaluh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GaluhActivity.class));
            }
        });

        btNanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NandaActivity.class));
            }
        });
    }
}
