package lib.kalu.camerax.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * description: 拍照按钮
 * created by kalu on 2021-03-03
 */
public final class TakeView extends View {

    private boolean isPress = false;
    private final Paint mPaint = new Paint();

    public TakeView(Context context) {
        super(context);
    }

    public TakeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TakeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TakeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        float center = Math.min(width, height) * 0.5f;

        mPaint.setAntiAlias(true);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(isPress ? Color.RED : Color.WHITE);
        canvas.drawCircle(center, center, center, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
            isPress = true;
            invalidate();
        } else {
            isPress = false;
            invalidate();
        }

        return true;
    }
}
