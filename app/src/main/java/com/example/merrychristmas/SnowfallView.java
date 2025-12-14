package com.example.merrychristmas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnowfallView extends View {

    private List<Snowflake> snowflakes;
    private Paint paint;
    private Random random;
    private boolean isRunning = false;

    public SnowfallView(Context context) {
        super(context);
        init();
    }

    public SnowfallView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SnowfallView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        snowflakes = new ArrayList<>();
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        random = new Random();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        snowflakes.clear();
        for (int i = 0; i < 100; i++) {
            snowflakes.add(createSnowflake(w, h, true));
        }
        isRunning = true;
    }

    private Snowflake createSnowflake(int width, int height, boolean randomY) {
        Snowflake flake = new Snowflake();
        flake.x = random.nextInt(width);
        flake.y = randomY ? random.nextInt(height) : -random.nextInt(50);
        flake.radius = 2 + random.nextFloat() * 6;
        flake.speed = 1 + random.nextFloat() * 4;
        flake.alpha = 100 + random.nextInt(155);
        flake.drift = -1 + random.nextFloat() * 2;
        return flake;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (Snowflake flake : snowflakes) {
            paint.setAlpha(flake.alpha);
            canvas.drawCircle(flake.x, flake.y, flake.radius, paint);

            flake.y += flake.speed;
            flake.x += flake.drift;

            if (flake.y > getHeight()) {
                flake.y = -flake.radius;
                flake.x = random.nextInt(getWidth());
            }

            if (flake.x < 0) {
                flake.x = getWidth();
            } else if (flake.x > getWidth()) {
                flake.x = 0;
            }
        }

        if (isRunning) {
            postInvalidateDelayed(16);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        isRunning = false;
    }

    private static class Snowflake {
        float x, y;
        float radius;
        float speed;
        int alpha;
        float drift;
    }
}
