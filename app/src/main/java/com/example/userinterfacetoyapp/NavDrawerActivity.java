package com.example.userinterfacetoyapp;

import android.os.Bundle;

import com.example.userinterfacetoyapp.databinding.ActivityNavDrawerBinding;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;

public class NavDrawerActivity extends AppCompatActivity {

    private ActivityNavDrawerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nav_drawer);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle(NavDrawerActivity.class.getSimpleName());

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close
        );
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    // In case the user presses the back button on the nav bar while the drawer is open
    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
