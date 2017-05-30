package productions.phoenixxl.personality_plus;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

import static productions.phoenixxl.personality_plus.ui.state;

/**
 * Created by abhishek on 19/5/17.
 */

public class GestureListener implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener
{
    final String DEBUG_TAG = "GestureListener"; eTextView tview; LinearLayout view; Context cxt;

    public GestureListener(eTextView view, Context cxt) {this.tview = view; this.cxt = cxt;}
    public GestureListener(LinearLayout view, Context cxt) {this.view = view; this.cxt = cxt;}

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if(state > 40 || state == 0) return false;
        if(velocityX > 0 && tview != null){

            LinearLayout synonym = ui.getLayout(tview);
            ViewGroup.LayoutParams Lay = synonym.getLayoutParams();
            Lay.width = tview.getWidth();
            synonym.setX(-tview.getWidth());

            TextView syntext = (TextView) synonym.getChildAt(0);
            synonym.setLayoutParams(Lay);
            syntext.setText(data.dict.get(tview.getText()));

            ObjectAnimator ani = ObjectAnimator.ofFloat(tview, "X", tview.getWidth());
            ani.setDuration(600);

            ObjectAnimator ani1 = ObjectAnimator.ofFloat(synonym, "X", 0);
            ani1.setDuration(600);

            AnimatorSet sw_right = new AnimatorSet();
            sw_right.play(ani).with(ani1);
            sw_right.start();

        }
        else if(velocityX < 0 && view != null){
            left_swipe();
        }
        return false;
    }

    protected  void left_swipe(){
        eTextView synonym;
        if(view==null)view = ui.getLayout(tview);
        synonym = ui.getLayout(view);

        ObjectAnimator ani = ObjectAnimator.ofFloat(view, "X", -view.getWidth());
        ani.setDuration(600);

        ObjectAnimator ani1 = ObjectAnimator.ofFloat(synonym, "X", 0);
        ani1.setDuration(600);

        AnimatorSet sw_left = new AnimatorSet();
        sw_left.play(ani).with(ani1);
        sw_left.start();
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.v(DEBUG_TAG, "onLongPress");
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.v(DEBUG_TAG, "onScroll, X = " + distanceX);
//            tview.setX(20);
//            view.onMove(-distanceX, -distanceY);
        return false;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e)
    {
        Log.v(DEBUG_TAG, "SingleTapUp");
        if(tview != null ){
            if(state < 40){
                ui.updateResult(tview);
                state++;
                if(state <= 20)ui.setLabels(new Random().nextInt(20 - state + 1));
                else ui.setLabels(new Random().nextInt(40 - state  + 1));
                ui.updateHead();
            }
            else if(state == 40) {    //this was the last screen
                ui.updateResult(tview);
                state++;
                ui.updateHead();    //this will also set the labels with the result
            }
            else if(state > 40){
                Intent in = new Intent(cxt, desc.class);
                String nam = (String)tview.getText();
                nam = nam.substring(0, nam.indexOf(" "));
                in.putExtra("opt", nam);
                cxt.startActivity(in);
            }

        }
        else{
            left_swipe();
        }
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.v(DEBUG_TAG, "ShowPress");
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.v(DEBUG_TAG, "onDoubleTap");
//            view.onResetLocation();
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.v(DEBUG_TAG, "Double tap");
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.v(DEBUG_TAG, "singletap confirmed");


        return false;
    }


}