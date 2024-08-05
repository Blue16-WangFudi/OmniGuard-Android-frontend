package com.example.omniguardai;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class TipView extends View {
    private String mExampleString; // TODO: use a default from R.string...
    private int mExampleColor = Color.RED; // TODO: use a default from R.color...
    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
    private Drawable mExampleDrawable;

    private TextPaint mTextPaint;
    private float mTextWidth;
    private float mTextHeight;

    public TipView(Context context) {
        super(context);
        init(null, 0);
    }

    public TipView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public TipView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.MsgView, defStyle, 0);

        mExampleString = a.getString(
                R.styleable.MsgView_exampleString);
//        mExampleColor = a.getColor(
//                R.styleable.MsgView_exampleColor,
//                mExampleColor);
//        mExampleString = "通话拦截";
        mExampleColor = Color.BLACK;
        // Use getDimensionPixelSize or getDimensionPixelOffset when dealing with
        // values that should fall on pixel boundaries.
//        mExampleDimension = a.getDimension(
//                R.styleable.MsgView_exampleDimension,
//                mExampleDimension);
        mExampleDimension = 60;

        if (a.hasValue(R.styleable.MsgView_exampleDrawable)) {
            mExampleDrawable = a.getDrawable(
                    R.styleable.MsgView_exampleDrawable);
            mExampleDrawable.setCallback(this);
        }

        a.recycle();

        // Set up a default TextPaint object
        mTextPaint = new TextPaint();
        mTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextAlign(Paint.Align.LEFT);

        // Update TextPaint and text measurements from attributes
        invalidateTextPaintAndMeasurements();
    }

    private void invalidateTextPaintAndMeasurements() {
        mTextPaint.setTextSize(mExampleDimension);
        mTextPaint.setColor(mExampleColor);
        mTextWidth = mTextPaint.measureText(mExampleString);

        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        mTextHeight = fontMetrics.bottom;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // TODO: consider storing these as member variables to reduce
        // allocations per draw cycle.
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

        // Draw the text.
        mTextPaint.setTextSize(40);
        mTextPaint.setColor(Color.GRAY);
        mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);

        float currentX = (float) (getWidth() * .1);
        float currentY = (float) (getHeight() * .3);
//        String text = "[冒充知名物流公司]  诈骗分子常常冒充知\n名的物流公司，利用人们对于包裹送达的\n期待心理。";
        String text = getExampleString();
        if (text.contains("疑似诈骗") || text.contains("骚扰电话"))
            currentX = (float) (getWidth() * .07);
        if (!text.contains("]"))
            currentY = (float) (getHeight() * .1);
        String[] strings = text.split("\n");
        Paint.FontMetrics fm = mTextPaint.getFontMetrics();
        float offsetY = fm.descent - fm.ascent;
        for (String s : strings) {
            canvas.drawText(s, currentX, currentY, mTextPaint);
            currentY += offsetY * 1.2;
        }
        if (text.contains("疑似诈骗") || text.contains("骚扰电话")) {
            text = text.substring(text.indexOf("["), text.indexOf("]") + 1);
            mTextPaint.setColor(Color.RED);
            currentX *= 1.15;
            currentY = (float) (getHeight() * .3 + offsetY * 1.2);
            canvas.drawText(text, currentX, currentY, mTextPaint);
        } else {
            text = text.substring(0, text.indexOf("]") + 1);
            mTextPaint.setColor(Color.RED);
            currentX = (float) (getWidth() * .1);
            currentY = (float) (getHeight() * .3);
            canvas.drawText(text, currentX, currentY, mTextPaint);
        }
    }

    /**
     * Gets the example string attribute value.
     *
     * @return The example string attribute value.
     */
    public String getExampleString() {
        return mExampleString;
    }

    /**
     * Sets the view"s example string attribute value. In the example view, this string
     * is the text to draw.
     *
     * @param exampleString The example string attribute value to use.
     */
    public void setExampleString(String exampleString) {
        mExampleString = exampleString;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * Gets the example color attribute value.
     *
     * @return The example color attribute value.
     */
    public int getExampleColor() {
        return mExampleColor;
    }

    /**
     * Sets the view"s example color attribute value. In the example view, this color
     * is the font color.
     *
     * @param exampleColor The example color attribute value to use.
     */
    public void setExampleColor(int exampleColor) {
        mExampleColor = exampleColor;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * Gets the example dimension attribute value.
     *
     * @return The example dimension attribute value.
     */
    public float getExampleDimension() {
        return mExampleDimension;
    }

    /**
     * Sets the view"s example dimension attribute value. In the example view, this dimension
     * is the font size.
     *
     * @param exampleDimension The example dimension attribute value to use.
     */
    public void setExampleDimension(float exampleDimension) {
        mExampleDimension = exampleDimension;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * Gets the example drawable attribute value.
     *
     * @return The example drawable attribute value.
     */
    public Drawable getExampleDrawable() {
        return mExampleDrawable;
    }

    /**
     * Sets the view"s example drawable attribute value. In the example view, this drawable is
     * drawn above the text.
     *
     * @param exampleDrawable The example drawable attribute value to use.
     */
    public void setExampleDrawable(Drawable exampleDrawable) {
        mExampleDrawable = exampleDrawable;
    }
}