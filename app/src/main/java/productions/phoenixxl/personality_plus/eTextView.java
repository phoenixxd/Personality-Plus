package productions.phoenixxl.personality_plus;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class eTextView extends TextView {
    public GestureDetector gestures;
    public GestureListener gest_listner;
    final String DEBUG_TAG = "eTextView";

    public eTextView(Context context, AttributeSet attr) {
        super(context, attr);
        gest_listner = new GestureListener(this, context);
        gestures = new GestureDetector(context, gest_listner);

        this.setOnTouchListener(new TextView.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestures.onTouchEvent(event);
            }
        });
    }


    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);
    }

}