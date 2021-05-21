package com.example.profileappdevelopment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainNavDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static String PACKAGE_NAME;
    DrawerLayout drawerLayout;
    Toolbar toolBar;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_nav_drawer);

        PACKAGE_NAME = getApplicationContext().getPackageName();

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
    public void onBackPressed () {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    Intent intent = new Intent();
    @Override
    public boolean onNavigationItemSelected (@NonNull MenuItem item){
        int id = item.getItemId();

        if (id == R.id.home) {
            startActivity(new Intent(MainNavDrawer.this, MainActivity.class));
        } else if (id == R.id.credit) {
            startActivity(new Intent(MainNavDrawer.this, CreditActivity.class));
        } else if (id == R.id.share) {
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=" + PACKAGE_NAME);
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, "Share via"));
        } else if (id == R.id.exit) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainNavDrawer.this);
            builder.setMessage("Do you want to logout?");
            builder.setCancelable(true);
            builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish(); }
            });
            builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel(); }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}