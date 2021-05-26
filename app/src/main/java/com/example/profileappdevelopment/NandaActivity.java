package com.example.profileappdevelopment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class NandaActivity extends NanNavDrawer implements View.OnClickListener {
    Button alamatNanda, sekolahNanda;
    ImageButton btIG, btFB, btgGithub, btTele;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.activity_nanda, null, false);
        drawerLayout.addView(v, 0);

        btFB = findViewById(R.id.btFB);
        btFB.setOnClickListener(this);
        btIG = findViewById(R.id.btIG);
        btIG.setOnClickListener(this);
        btgGithub = findViewById(R.id.btGithub);
        btgGithub.setOnClickListener(this);
        btTele = findViewById(R.id.btTele);
        btTele.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btFB:
                Toast.makeText(NandaActivity.this, "Open Facebook", Toast.LENGTH_SHORT).show();
                intent = new Intent(Intent.ACTION_VIEW);
                startActivity(intent.setData(Uri.parse("https://www.facebook.com/profile.php?id=100058670751238")));
                break;
            case R.id.btIG:
                Toast.makeText(NandaActivity.this, "Open Instagram", Toast.LENGTH_SHORT).show();
                intent = new Intent(Intent.ACTION_VIEW);
                startActivity(intent.setData(Uri.parse("https://www.instagram.com/nanptrsr")));
                break;
            case R.id.btGithub:
                Toast.makeText(NandaActivity.this, "Open Github", Toast.LENGTH_SHORT).show();
                intent = new Intent(Intent.ACTION_VIEW);
                startActivity(intent.setData(Uri.parse("https://github.com/nanptrsr")));
                break;
            case R.id.btTele:
                Toast.makeText(NandaActivity.this, "Open Telegram", Toast.LENGTH_SHORT).show();
                intent = new Intent(Intent.ACTION_VIEW);
                startActivity(intent.setData(Uri.parse("https://telegram.me/Aslnan")));
        }
    }
}