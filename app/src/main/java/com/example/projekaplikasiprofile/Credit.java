package com.example.projekaplikasiprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class Credit extends NavDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.activity_credit,null,false);
        drawer.addView(v,1);
    }
}