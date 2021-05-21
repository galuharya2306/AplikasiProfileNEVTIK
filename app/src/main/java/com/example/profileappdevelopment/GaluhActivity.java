package com.example.profileappdevelopment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class GaluhActivity extends GalNavDrawer implements View.OnClickListener {
    Button alamatGaluh, sekolahGaluh;
    ImageButton btFB, btIG, btgGithub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.activity_galuh, null, false);
        drawerLayout.addView(v, 0);

        alamatGaluh = findViewById(R.id.alamatGaluh);
        alamatGaluh.setOnClickListener(this);
        sekolahGaluh = findViewById(R.id.sekolahGaluh);
        sekolahGaluh.setOnClickListener(this);
        btFB = findViewById(R.id.btFB);
        btFB.setOnClickListener(this);
        btIG = findViewById(R.id.btIG);
        btIG.setOnClickListener(this);
        btgGithub = findViewById(R.id.btGithub);
        btgGithub.setOnClickListener(this);

    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.alamatGaluh:
                intent = new Intent(Intent.ACTION_VIEW);
                startActivity(intent.setData(Uri.parse("https://goo.gl/maps/mmRyJVEV5oSSRkeJ6")));
                break;
            case R.id.sekolahGaluh:
                intent = new Intent(Intent.ACTION_VIEW);
                startActivity(intent.setData(Uri.parse("https://maps.app.goo.gl/Mh2ni5hz74UBP4uo9")));
                break;
            case R.id.btFB:
                Toast.makeText(GaluhActivity.this, "Open Facebook", Toast.LENGTH_SHORT).show();
                intent = new Intent(Intent.ACTION_VIEW);
                startActivity(intent.setData(Uri.parse("mailto:galuharya005@gmail.com")));
                break;
            case R.id.btIG:
                Toast.makeText(GaluhActivity.this, "Open Instagram", Toast.LENGTH_SHORT).show();
                intent = new Intent(Intent.ACTION_VIEW);
                startActivity(intent.setData(Uri.parse("https://www.instagram.com/galxskuy")));
                break;
            case R.id.btGithub:
                Toast.makeText(GaluhActivity.this, "Open Github", Toast.LENGTH_SHORT).show();
                intent = new Intent(Intent.ACTION_VIEW);
                startActivity(intent.setData(Uri.parse("https://github.com/galuhxarya")));
                break;
        }
    }
}