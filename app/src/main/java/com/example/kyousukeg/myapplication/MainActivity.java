package com.example.kyousukeg.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new homepageFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_homepage);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_homepage:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new homepageFragment()).commit();
                break;
            case R.id.nav_userAccount:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new useraccountFragment()).commit();
                break;
            case R.id.nav_favoriteProducts:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new favoriteproductsFragment()).commit();
                break;
            case R.id.nav_shoppingCart:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new shoppingCartFragment()).commit();
                break;
            case R.id.nav_signIn:
                Intent intentSignIn = new Intent(this, loginActivity.class);
                this.startActivity(intentSignIn);
                break;
            case R.id.nav_signUp:
                Intent intentSignUp = new Intent(this, registerActivity.class);
                this.startActivity(intentSignUp);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
