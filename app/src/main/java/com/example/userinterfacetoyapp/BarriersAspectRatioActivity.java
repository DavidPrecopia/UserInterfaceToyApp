package com.example.userinterfacetoyapp;

import android.os.Bundle;

import com.example.userinterfacetoyapp.databinding.ActivityBarriersAspectRatioBinding;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class BarriersAspectRatioActivity extends AppCompatActivity {

    private ActivityBarriersAspectRatioBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_barriers_aspect_ratio);
    }
}
