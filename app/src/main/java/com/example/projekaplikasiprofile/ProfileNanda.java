package com.example.projekaplikasiprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ProfileNanda extends AppCompatActivity implements View.OnClickListener {
    ImageButton btIG,btFB,btGithub,btTele;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_galuh);

        btIG=findViewById(R.id.ig_button);
        btIG.setOnClickListener(this);
        btFB=findViewById(R.id.fb_button);
        btFB.setOnClickListener(this);
        btGithub=findViewById(R.id.github_button);
        btGithub.setOnClickListener(this);
        btTele=findViewById(R.id.tele_button);
        btTele.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.ig_button:
                Toast.makeText(ProfileNanda.this,"Open Instagram", Toast.LENGTH_SHORT).show();
                intent=new Intent(Intent.ACTION_VIEW);
                startActivity(intent.setData(Uri.parse("https://www.instagram.com/nanptrsr")));
                break;
            case R.id.fb_button:
                Toast.makeText(ProfileNanda.this,"Open Facebook", Toast.LENGTH_SHORT).show();
                intent=new Intent(Intent.ACTION_VIEW);
                startActivity(intent.setData(Uri.parse("https://www.facebook.com/profile.php?id=100058670751238")));
                break;
            case R.id.github_button:
                Toast.makeText(ProfileNanda.this,"Open Github", Toast.LENGTH_SHORT).show();
                intent=new Intent(Intent.ACTION_VIEW);
                startActivity(intent.setData(Uri.parse("https://github.com/nanptrsr")));
                break;
            case R.id.tele_button:
                Toast.makeText(ProfileNanda.this,"Open Telegram", Toast.LENGTH_SHORT).show();
                intent=new Intent(Intent.ACTION_VIEW);
                startActivity(intent.setData(Uri.parse("https://telegram.me/Aslnan")));
                break;
        }
    }
}