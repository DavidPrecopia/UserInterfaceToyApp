package com.example.userinterfacetoyapp;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

import com.example.userinterfacetoyapp.databinding.ActivityPlaceholderAnimationsBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class PlaceholderAnimationsActivity extends AppCompatActivity {

    private ActivityPlaceholderAnimationsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_placeholder_animations);
    }

    // onClick set via XML for simplicity
    public void swapView(View view) {
        TransitionManager.beginDelayedTransition(binding.rootLayout);
        binding.placeholder.setContentId(view.getId());
    }
}
