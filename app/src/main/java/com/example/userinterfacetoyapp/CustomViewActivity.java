package com.example.userinterfacetoyapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.userinterfacetoyapp.databinding.ActivityCustomViewBinding;

public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCustomViewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_custom_view);
    }
}
