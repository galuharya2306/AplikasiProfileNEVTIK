package com.example.projekaplikasiprofile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class NavDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    public static String PACKAGE_NAME;
DrawerLayout drawer;
Toolbar toolbar;
ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);

        PACKAGE_NAME=getApplicationContext().getPackageName();

        drawer=findViewById(R.id.drawer);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toggle=new ActionBarDrawerToggle(this,drawer,toolbar,0,0);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        NavigationView navigationView=(NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.isDrawerOpen(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.home){
            startActivity(new Intent(NavDrawer.this,MainActivity.class));
        } else if (id==R.id.credit){
            startActivity(new Intent(NavDrawer.this,Credit.class));
        } else if (id==R.id.exit){
            AlertDialog.Builder builder=new AlertDialog.Builder(NavDrawer.this);
            builder.setMessage("Do you want to out?");
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
            AlertDialog alertDialog=builder.create();
            alertDialog.show();
        }
        DrawerLayout drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}