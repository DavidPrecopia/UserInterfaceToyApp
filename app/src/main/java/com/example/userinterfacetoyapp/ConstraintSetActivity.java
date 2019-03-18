package com.example.userinterfacetoyapp;

import android.os.Bundle;
import android.transition.TransitionManager;

import com.example.userinterfacetoyapp.databinding.ActivityConstraintSetBinding;
import com.example.userinterfacetoyapp.databinding.ConstraintSetDetailBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.databinding.DataBindingUtil;

public class ConstraintSetActivity extends AppCompatActivity {

    private ActivityConstraintSetBinding bindingNormal;
    private ConstraintSetDetailBinding bindingDetail;

    private ConstraintSet constraintSetNormal;
    private ConstraintSet constraintSetDetail;

    private boolean normalLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initLayouts();
        initConstraintSets();
        initClickListeners();
    }

    private void initLayouts() {
        bindingNormal = DataBindingUtil.setContentView(this, R.layout.activity_constraint_set);
        bindingDetail = DataBindingUtil.inflate(getLayoutInflater(), R.layout.constraint_set_detail, null, false);
    }

    private void initConstraintSets() {
        constraintSetNormal = new ConstraintSet();
        constraintSetDetail = new ConstraintSet();

        constraintSetNormal.clone(bindingNormal.constraintLayoutRootNormal);
        // This has been inflated in the method above.
        // If it wasn't inflated, you would have to use: constraintSetDetail.clone(getApplicationContext(), R.layout.constraint_set_detail);
        constraintSetDetail.clone(bindingDetail.constraintLayoutRootAlt);
    }

    private void initClickListeners() {
        bindingNormal.constraintLayoutRootNormal.setOnClickListener(v -> transitionLayout());
        bindingDetail.constraintLayoutRootAlt.setOnClickListener(v -> transitionLayout());
    }


    // I apply the constraints I want to this Activity's root layout
    private void transitionLayout() {
        TransitionManager.beginDelayedTransition(bindingNormal.constraintLayoutRootNormal);
        if (normalLayout) {
            constraintSetDetail.applyTo(bindingNormal.constraintLayoutRootNormal);
            normalLayout = false;
        } else if (!normalLayout) {
            constraintSetNormal.applyTo(bindingNormal.constraintLayoutRootNormal);
            normalLayout = true;
        }
    }
}
