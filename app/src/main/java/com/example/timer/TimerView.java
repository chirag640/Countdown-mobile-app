package com.example.timer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
public class TimerView extends View {
    private Paint backgroundPaint;
    private Paint elapsedTimePaint;
    private Paint textPaint;
    private Paint shadowPaint;
    private int elapsedTime; // in seconds
    private int totalTime; // in seconds

    private float animatedElapsedTime = 0;

    public TimerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        backgroundPaint = new Paint();
        backgroundPaint.setColor(Color.LTGRAY);
        backgroundPaint.setStyle(Paint.Style.FILL);

        elapsedTimePaint = new Paint();
        elapsedTimePaint.setColor(Color.RED);
        elapsedTimePaint.setStyle(Paint.Style.FILL);

        textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(30);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setAntiAlias(true);

        shadowPaint = new Paint();
        shadowPaint.setColor(Color.DKGRAY);
        shadowPaint.setStyle(Paint.Style.STROKE);
        shadowPaint.setStrokeWidth(10);
        shadowPaint.setAntiAlias(true);

        totalTime = 60; // Default to 60 seconds
        elapsedTime = 0;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
        invalidate();
    }

    public void setAnimatedElapsedTime(float animatedElapsedTime) {
        this.animatedElapsedTime = animatedElapsedTime;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int diameter = Math.min(width, height);

        // Draw the background circle with shadow
        canvas.drawCircle(width / 2, height / 2, diameter / 2-5, shadowPaint);
        canvas.drawCircle(width / 2, height / 2, diameter / 2 - 15, backgroundPaint);

        // Calculate the angle of the elapsed time
        float angle = 360.0f * animatedElapsedTime / totalTime;

        // Draw the red elapsed time segment
        canvas.drawArc(10, 10, width - 10, height - 10, -90, angle, true, elapsedTimePaint);

        // Draw the numbers around the circle
        drawNumbers(canvas, width / 2, height / 2, diameter / 2 - 50);
    }

    private void drawNumbers(Canvas canvas, int cx, int cy, int radius) {
        int maxNumbers = 30;
        int step = 1;

        // If totalTime exceeds maxNumbers, calculate the step to space out numbers
        if (totalTime > maxNumbers) {
            step = (int) Math.ceil((double) totalTime / maxNumbers);
        }

        // Calculate the angle between each number
        float angleStep = 360.0f / totalTime;

        for (int i = 0; i < totalTime; i += step) {
            // Calculate the angle for the current number
            double angle = Math.toRadians(90 - (i * angleStep));

            // Calculate the position of the number
            int x = (int) (cx + radius * Math.cos(angle));
            int y = (int) (cy - radius * Math.sin(angle));

            // Draw the number at the calculated position
            canvas.drawText(String.valueOf(i), x, y, textPaint);
        }
    }
}
