package com.example.profileappdevelopment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class GalNavDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolBar;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer);


        drawerLayout = findViewById(R.id.drawer);
        toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, 0, 0);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    Intent intent = new Intent();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            startActivity(new Intent(GalNavDrawer.this, MainActivity.class));
        } else if (id == R.id.credit) {
            startActivity(new Intent(GalNavDrawer.this, CreditActivity.class));
        } else if (id == R.id.exit) {
            AlertDialog.Builder builder = new AlertDialog.Builder(GalNavDrawer.this);
            builder.setMessage("Do you want to logout?");
            builder.setCancelable(true);
            builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        } else if (id == R.id.email) {
            Toast.makeText(GalNavDrawer.this, "Open Gmail", Toast.LENGTH_SHORT).show();
            intent = new Intent(Intent.ACTION_VIEW);
            startActivity(intent.setData(Uri.parse("mailto:galuharya005@gmail.com")));
        } else if (id == R.id.whatsapp) {
            Toast.makeText(GalNavDrawer.this, "Open WhatsApp", Toast.LENGTH_SHORT).show();
            intent = new Intent(Intent.ACTION_VIEW);
            startActivity(intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=" + "+62 81586424731")));
        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}