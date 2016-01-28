package fys.com.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by I-Tang HIU  on 20/01/2016.
 */
public class CustomView extends LinearLayout {

    private boolean selected = false;
    protected View view;
    private Drawable leftPicture;
    private String centerLabel;
    private TextView mainLabel;
    private ImageView leftImageView;

    public CustomView(Context context, AttributeSet attrs) {

        super(context, attrs);
        inflate(getContext(), R.layout.custom_view, this);
        mainLabel = (TextView) findViewById(R.id.mainLabel);
        leftImageView = (ImageView) findViewById(R.id.leftImageView);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.custom_view_attributes, 0, 0);
        try {
            leftPicture = a.getDrawable(R.styleable.custom_view_attributes_leftPicture);
            centerLabel = a.getString(R.styleable.custom_view_attributes_label);
        }
        finally {
            a.recycle();
        }
        mainLabel.setText(centerLabel);
        leftImageView.setImageDrawable(leftPicture);
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        int viewWidth = this.getMeasuredWidth();
        int viewHeight = this.getMeasuredHeight();
        RectF rectangle = new RectF(0, 0, viewWidth , viewHeight);
        final Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.LTGRAY);
        paint.setAntiAlias(true);
        int radius = 20;
        canvas.drawRoundRect(rectangle, radius, radius, paint);
    }
}


