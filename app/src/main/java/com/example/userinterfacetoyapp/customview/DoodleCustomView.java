package com.example.userinterfacetoyapp.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.userinterfacetoyapp.R;

public class DoodleCustomView extends View {

    private Paint paint;
    private Path path;

    {
        paint = new Paint();
        paint.setStrokeWidth(10);
        path = new Path();
    }

    public DoodleCustomView(Context context) {
        super(context);
    }

    public DoodleCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw from the top-left corner, to the middle.
        paint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        canvas.drawLine(0.0F, 0.0F, getWidthHalf(), getHeightHalf(), paint);

        // Draw from the top-right corner, to the middle.
        paint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        canvas.drawLine(getWidth(), 0, getWidthHalf(), getHeightHalf(), paint);

        // This is what draws the lines the user creates with their finger.
        paint.setColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
        // This gives you lines.
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);
    }

    private float getWidthHalf() {
        return (float) getWidth() / 2;
    }

    private float getHeightHalf() {
        return (float) getHeight() / 2;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float X = event.getX();
        float Y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(X, Y);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(X, Y);
                break;
        }

        // See `this.performClick()` JavaDoc.
        this.performClick();

        // Invalidating the whole View every time a user draws is very inefficient (to say the least).
        // I am doing it because this is a toy app.
        invalidate();

        // If you return false, you are saying that you do not want any events past ACTION_DOWN.
        return true;
    }

    /**
     * Some accessibility readers invoke this method when touch occurs, thus it need to be
     * overridden and invoked from `onTouchEvent()`.
     * Because of that, I should call this method from onTouchEvent() and execute the
     * business logic here.
     * Because this is a toy app, I am ignoring it.
     */
    @Override
    public boolean performClick() {
        return super.performClick();
    }
}
