package com.example.userinterfacetoyapp.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.userinterfacetoyapp.R;

public class DetailCompoundView extends LinearLayout {
    public DetailCompoundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.detail_compound_view, this);

        ImageView imageView = findViewById(R.id.image);
        TextView textView = findViewById(R.id.text);

        // Retrieve the attributes
        // This is using the Styleable we created in attrs.xml (res/values)
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.DetailCompoundView);

        // `R.styleable` provides the index of your custom attributes.
        imageView.setImageDrawable(
                attributes.getDrawable(R.styleable.DetailCompoundView_image)
        );
        textView.setText(
                attributes.getString(R.styleable.DetailCompoundView_text)
        );

        // ACHTUNG!
        // Recycles this TypeArray so it can be reused by a later call.
        attributes.recycle();
    }
}
