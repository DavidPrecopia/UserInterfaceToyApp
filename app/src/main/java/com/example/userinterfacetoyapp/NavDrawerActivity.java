package com.example.userinterfacetoyapp;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.userinterfacetoyapp.databinding.ActivityNavDrawerBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;

public class NavDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityNavDrawerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nav_drawer);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle(NavDrawerActivity.class.getSimpleName());

        // This will rotate the "hamburger" icon when the drawer is open / closed.
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close
        );
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // Its click listener
        binding.navigationView.setNavigationItemSelectedListener(this);


        // If this Activity is brand new, set its default state.
        // In a real app I would load the InboxFragment here - checking to see
        // if the Activity is new so I do not force the GUI back
        // to the InboxFragment because the user rotated their device.
        if (savedInstanceState == null) {
            binding.navigationView.setCheckedItem(R.id.menu_item_inbox);
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_inbox:
                displaySnackbar("Inbox");
                break;
            case R.id.menu_item_trash:
                displaySnackbar("Trash");
                break;
            case R.id.menu_item_profile:
                displaySnackbar("Profile");
                break;
            case R.id.menu_item_share:
                displaySnackbar("Share");
                break;
            case R.id.menu_item_send:
                displaySnackbar("Send");
                break;
        }

        // Close the drawer once the user has selected an item
        binding.drawerLayout.closeDrawer(GravityCompat.START);

        // Returning true means the item the user selected will be highlighted.
        return true;
    }

    private void displaySnackbar(String message) {
        Snackbar.make(binding.drawerLayout, message, Snackbar.LENGTH_SHORT).show();
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
