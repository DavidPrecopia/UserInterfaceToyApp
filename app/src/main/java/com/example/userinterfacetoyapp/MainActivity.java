package com.example.userinterfacetoyapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.userinterfacetoyapp.databinding.ActivityMainSharedBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity {

    private ActivityMainSharedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_shared);
        getSupportActionBar().setTitle(MainActivity.class.getSimpleName());

        initSendButton();
        initStartButtons();
    }


    private void initStartButtons() {
        binding.buttonStartBarriersAspectRatioActivity.setOnClickListener(v ->
                startActivity(new Intent(this, BarriersAspectRatioActivity.class))
        );

        binding.buttonStartGoneChainGuidelinesActivity.setOnClickListener(v ->
                startActivity(new Intent(this, GoneChainGuidelinesActivity.class))
        );

        binding.buttonStartPlaceholderAnimationsActivity.setOnClickListener(v ->
                startActivity(new Intent(this, PlaceholderAnimationsActivity.class))
        );

        binding.buttonStartPlaceholderTemplateActivity.setOnClickListener(v ->
                startActivity(new Intent(this, PlaceholderTemplateActivity.class))
        );

        binding.buttonStartConstraintSetActivity.setOnClickListener(v ->
                startActivity(new Intent(this, ConstraintSetActivity.class))
        );

        binding.buttonStartIncludeMergeActivity.setOnClickListener(v ->
                startActivity(new Intent(this, IncludeMergeActivity.class))
        );
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
