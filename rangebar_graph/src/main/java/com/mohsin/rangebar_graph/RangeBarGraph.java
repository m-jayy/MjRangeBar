package com.mohsin.rangebar_graph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class RangeBarGraph extends View {


    private boolean initialisedSlider;
    private double startKnobValueTmp, endKnobValueTmp;//the position on the X axis
    private double sliderWidth, sliderHeight;//real size of the view that holds the slider
    private Paint paintSelected, paintNotSelected, paintText,paintCircle,PaintLabResultValue,PaintOutOfBound;
    RectF rectangleSelected,rectangleNotSelected;
    double ItemValue;
    double ItemValueTemp;
    double LK,RK;
    double left_boundStart , right_boundEnd;
    double RangebarYAxisiStart,RangebarYAxisiend;
    double Circleradius;

    double val_max;
    double val_min;

    int rangeBarBackgroundColor = Color.parseColor("#00ffffff");
    int RangeBarSelectedColor = Color.parseColor("#eaeaea");
    int RangeBarStrokeColor = Color.parseColor("#eaeaea");
    int RangeBarMinMaxTextColor = Color.parseColor("#333333");
    int RangeBarValueTextColor = Color.parseColor("#333333");
    int valueCircleColor = Color.parseColor("#333333");
    int outOfBoundColor = Color.parseColor("#FF0000");



    public RangeBarGraph(Context context) {

        super(context);
        setFocusable(true);
    }

    public RangeBarGraph(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        initialisedSlider = false;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawColor(rangeBarBackgroundColor);       //background for slider

        if(!initialisedSlider) {
            initialisedSlider = true;
            sliderWidth = getMeasuredWidth();
            sliderHeight = getMeasuredHeight();

            ///set start height of range bar
            RangebarYAxisiStart =60.0;
            RangebarYAxisiend=100.0;

            // left and right bound of slider and the difference
            left_boundStart = (Double) (40.0);
            right_boundEnd = (Double) (sliderWidth-40.0);

            Circleradius = 20.0;

            double delta_bound = right_boundEnd - left_boundStart;

            // start and end value from the slider and the difference

            double delta_val = val_max-val_min;

            double ratio = (double)delta_bound/delta_val;


            LK = (Double) ( startKnobValueTmp*ratio+right_boundEnd-(val_max*ratio)); //value in widht

            RK = (Double) ( endKnobValueTmp*ratio+right_boundEnd-(val_max*ratio));

            ItemValueTemp = (Double) ( ItemValue*ratio+right_boundEnd-(val_max*ratio)); //labresult value in width for black circle


            //////////////////////////////////////////////////////////////////////
            paintSelected = new Paint();//the paint between knobs
            paintSelected.setColor(RangeBarSelectedColor);

            paintNotSelected = new Paint();//the paint outside knobs
            paintNotSelected.setStyle(Paint.Style.STROKE);
            paintNotSelected.setStrokeWidth(3);
            paintNotSelected.setColor(RangeBarStrokeColor);

            paintText = new Paint();//the paint for the slider data(the values)
            paintText.setTextSize(24);
            paintText.setColor(RangeBarMinMaxTextColor);

            paintCircle = new Paint();
            paintCircle.setColor(valueCircleColor);

            PaintLabResultValue = new Paint();
            if(ItemValue>startKnobValueTmp && ItemValue<endKnobValueTmp) {
                PaintLabResultValue.setColor(RangeBarValueTextColor);
            }
            else {
                PaintLabResultValue.setColor(RangeBarValueTextColor);
            }

            PaintLabResultValue.setTextSize(24);

            PaintOutOfBound = new Paint();
            PaintOutOfBound.setColor(outOfBoundColor);
            PaintOutOfBound.setTextSize(20);

            //rectangles that define the line between and outside of knob
            rectangleSelected = new RectF();
            rectangleNotSelected = new RectF();

        }


        rectangleSelected.set((float) LK,(float)RangebarYAxisiStart ,(float) RK ,(float)RangebarYAxisiend);

        rectangleNotSelected.set((float) left_boundStart, (float) RangebarYAxisiStart, (float) right_boundEnd,(float) RangebarYAxisiend );

        canvas.drawText(Double.toString(startKnobValueTmp),(float) LK, (float) RangebarYAxisiend+40, paintText); //10
        canvas.drawText(Double.toString(endKnobValueTmp),(float) RK, (float) RangebarYAxisiend+40, paintText); //90



        canvas.drawRoundRect(rectangleSelected, 20,20,paintSelected);
        canvas.drawRoundRect(rectangleNotSelected, 20,20,paintNotSelected);


        if(ItemValue<startKnobValueTmp)
        {
            canvas.drawText(Double.toString(ItemValue), (float) left_boundStart+20, (float) RangebarYAxisiStart - 20, PaintLabResultValue); //50
            canvas.drawText("OUT OF RANGE", (float) left_boundStart+20, (float) RangebarYAxisiend -14, PaintOutOfBound); //50
        }
        else if(ItemValue>endKnobValueTmp)
        {
            canvas.drawText(Double.toString(ItemValue), (float) right_boundEnd-60, (float) RangebarYAxisiStart - 20, PaintLabResultValue); //50
            canvas.drawText("OUT OF RANGE", (float) right_boundEnd-140, (float) RangebarYAxisiend -14, PaintOutOfBound); //50
            //Toast.makeText(getContext(), Integer.toString(canvas.getWidth()), Toast.LENGTH_SHORT).show();
        }
        else
        {
            canvas.drawCircle((float) ItemValueTemp, (float) RangebarYAxisiStart + (float) Circleradius, (float) Circleradius, paintCircle);
            canvas.drawText(Double.toString(ItemValue), (float)ItemValueTemp -(float) (Circleradius / 2)-8, (float) RangebarYAxisiStart - 20, PaintLabResultValue); //50
        }

    }


    public void setRangeBarBackgroundColor(String colorCode)
    {

        rangeBarBackgroundColor=Color.parseColor(colorCode);
    }

    public void setRangeBarSelectedColor(String colorCode)
    {
        RangeBarSelectedColor=Color.parseColor(colorCode);
    }
    public void setRangeBarStrokeColor(String colorCode)
    {
        RangeBarStrokeColor=Color.parseColor(colorCode);
    }
    public void setRangeBarMinMaxTextColor(String colorCode)
    {
        RangeBarMinMaxTextColor=Color.parseColor(colorCode);
    }
    public void setRangeBarValueTextColor(String colorCode)
    {
        RangeBarValueTextColor=Color.parseColor(colorCode);
    }
    public void setvalueCircleColor(String colorCode)
    {
        valueCircleColor=Color.parseColor(colorCode);
    }
    public void setoutOfBoundColor(String colorCode)
    {
        outOfBoundColor=Color.parseColor(colorCode);
    }

    public void setValues(double RangeBarMinValue,double RangeBarMaxValue, double startRange, double EndRange, double ItemValue)
    {
        startKnobValueTmp = startRange;
        endKnobValueTmp = EndRange;

        this.ItemValue = ItemValue;

        val_max = RangeBarMaxValue;
        val_min = RangeBarMinValue;
    }

    public RangeBarGraph(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RangeBarGraph(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
