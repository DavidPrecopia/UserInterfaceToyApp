package com.example.userinterfacetoyapp;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.animation.OvershootInterpolator;

import com.example.userinterfacetoyapp.databinding.ActivityConstraintSetBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.databinding.DataBindingUtil;

public class ConstraintSetActivity extends AppCompatActivity {

    private ActivityConstraintSetBinding bindingNormal;

    private ConstraintSet constraintSetNormal;
    private ConstraintSet constraintSetDetail;

    private boolean normalLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingNormal = DataBindingUtil.setContentView(this, R.layout.activity_constraint_set);
        initConstraintSets();

        // You only need to set a click listener on this Activity's root layout
        bindingNormal.constraintLayoutRootNormal.setOnClickListener(v -> transitionLayout());
    }

    private void initConstraintSets() {
        constraintSetNormal = new ConstraintSet();
        constraintSetDetail = new ConstraintSet();

        // This copies the constraints from the passed-in layouts
        constraintSetNormal.clone(bindingNormal.constraintLayoutRootNormal);
        // Inflating this layout is overkill because ConstraintSet only clones the constraints of the passed-in layout
        constraintSetDetail.clone(getApplicationContext(), R.layout.constraint_set_detail);
    }


    // I apply the constraints I want to this Activity's root layout
    private void transitionLayout() {
        // This will add a "rubber-band" effect when the Views reach the end position
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setInterpolator(new OvershootInterpolator());

        TransitionManager.beginDelayedTransition(bindingNormal.constraintLayoutRootNormal, changeBounds);

        if (normalLayout) {
            constraintSetDetail.applyTo(bindingNormal.constraintLayoutRootNormal);
            normalLayout = false;
        } else if (!normalLayout) {
            constraintSetNormal.applyTo(bindingNormal.constraintLayoutRootNormal);
            normalLayout = true;
        }
    }
}
