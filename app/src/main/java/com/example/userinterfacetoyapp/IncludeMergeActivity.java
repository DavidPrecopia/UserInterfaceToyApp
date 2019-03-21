package com.example.userinterfacetoyapp;

import android.os.Bundle;

import com.example.userinterfacetoyapp.databinding.ActivityIncludeMergeBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class IncludeMergeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityIncludeMergeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_include_merge);
    }
}
