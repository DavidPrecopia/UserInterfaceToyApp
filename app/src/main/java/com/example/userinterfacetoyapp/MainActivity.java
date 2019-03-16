package com.example.userinterfacetoyapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.userinterfacetoyapp.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getSupportActionBar().setTitle(MainActivity.class.getSimpleName());

        initSendButton();
    }


    private void initSendButton() {
        binding.buttonSend.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(getIntentExtraKey(), binding.editTextSending.getText().toString());
            startActivityForResult(intent, getRequestCode());
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == getRequestCode() && resultCode == RESULT_OK) {
            binding.tvReceiving.setText(data.getStringExtra(getIntentExtraKey()));
        } else {
            Snackbar.make(binding.rootLayout, "FAILED", Snackbar.LENGTH_LONG).show();
        }
    }

    private int getRequestCode() {
        return getResources().getInteger(R.integer.get_text_request);
    }

    private String getIntentExtraKey() {
        return getString(R.string.intent_extra_key);
    }
}
