package com.example.userinterfacetoyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.userinterfacetoyapp.databinding.ActivityGoneChainGuidelinesBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class GoneChainGuidelinesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGoneChainGuidelinesBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_gone_chain_guidelines);

        binding.button2.setOnClickListener(v -> {
            Button button1 = binding.button1;
            Button button2 = binding.button2;

            switch (button1.getVisibility()) {
                case View.VISIBLE:
                    button1.setVisibility(View.GONE);
                    button2.setText(getString(R.string.show_button1));
                    break;
                case View.GONE:
                    button1.setVisibility(View.VISIBLE);
                    button2.setText(getString(R.string.hide_button1));
                    break;
                case View.INVISIBLE:
                    button1.setVisibility(View.VISIBLE);
                    button2.setText(getString(R.string.hide_button1));
                    break;
            }
        });
    }
}
