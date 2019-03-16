package com.example.userinterfacetoyapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.userinterfacetoyapp.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class SecondActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getSupportActionBar().setTitle(SecondActivity.class.getSimpleName());

        initUiWithStartingIntent(getIntent());
        initSendButton();
    }

    private void initUiWithStartingIntent(Intent intent) {
        if (intent.hasExtra(getIntentExtraKey())) {
            binding.tvReceiving.setText(
                    intent.getStringExtra(getIntentExtraKey())
            );
        }
    }

    private void initSendButton() {
        binding.buttonSend.setOnClickListener(view -> {
            Intent returnIntent = new Intent();
            returnIntent.putExtra(getIntentExtraKey(), binding.editTextSending.getText().toString());
            setResult(RESULT_OK, returnIntent);
            finish();
        });
    }


    private String getIntentExtraKey() {
        return getString(R.string.intent_extra_key);
    }
}
