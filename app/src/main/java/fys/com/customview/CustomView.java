package fys.com.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
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

    public CustomView(Context context) {

        super(context);
        init();
    }

    public CustomView(Context context, AttributeSet attrs) {

        super(context, attrs);
        init();
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.custom_view, 0, 0);
        try {
            leftPicture = a.getDrawable(R.styleable.custom_view_leftPicture);
            centerLabel = a.getString(R.styleable.custom_view_label);
        }
        finally {
            a.recycle();
        }
        mainLabel.setText(centerLabel);
        leftImageView.setImageDrawable(leftPicture);
    }

    private void init() {

        view = LayoutInflater.from(getContext()).inflate(R.layout.custom_view, this, true);
        mainLabel = (TextView) findViewById(R.id.mainLabel);
        leftImageView = (ImageView) findViewById(R.id.leftImageView);
    }
}


