package com.example.userinterfacetoyapp;

import android.os.Bundle;

import com.example.userinterfacetoyapp.databinding.ActivityConstraintLayoutBinding;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class ConstraintLayoutActivity extends AppCompatActivity {

    private ActivityConstraintLayoutBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_constraint_layout);
    }
}
