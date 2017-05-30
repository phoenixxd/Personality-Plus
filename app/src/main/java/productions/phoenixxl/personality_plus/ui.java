package productions.phoenixxl.personality_plus;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class  ui extends Activity {

    static TextView head;
    static eTextView labels[] = new eTextView[4];
    static LinearLayout llsyn[] = new LinearLayout[4];

    //if the value of state is 1, this means the first screen is visible and it has not yet been pressed
    //if teh value of state is 0, this means the Start screen is visible
    static int  state;
    private String DEBUG_TAG = "playareaview";
    static private List<Pair<Integer, Integer>> res_list = new ArrayList<>();

    static int result[];
    static data Data;

    @Override
    public void onBackPressed() {
        if(state == 0){
            super.onBackPressed();
        }
        else if(state == 1){    //nothing pressed yet
            for(int i = 0; i < 4; i++)
                labels[i].setText("Start");
            state = 0;
        }
        else {

            Pair<Integer, Integer> temp = res_list.get(state-2);

            //result has been updated
            result[temp.first] -= temp.second;
            res_list.remove(state-2);

            state--;
            if(state < 20 ){
                setLabels(20-state);
            }
            else if(state == 20 || state == 40){
                setLabels(0);
                updateHead();
            }
            else if(state < 40){
                setLabels(40-state);
            }
            else super.onBackPressed();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.ui);


        head = (TextView)findViewById(R.id.head);
        labels[0] = (eTextView)findViewById(R.id.one);
        labels[1] = (eTextView)findViewById(R.id.two);
        labels[2] = (eTextView)findViewById(R.id.three);
        labels[3] = (eTextView)findViewById(R.id.four);

        llsyn[0] = (LinearLayout) findViewById(R.id.onesl);
        llsyn[1] = (LinearLayout)findViewById(R.id.twosl);
        llsyn[2] = (LinearLayout)findViewById(R.id.threesl);
        llsyn[3] = (LinearLayout)findViewById(R.id.foursl);

        final GestureDetector gest[] = new GestureDetector[4];

        gest[0] = new GestureDetector(llsyn[0].getContext(), new GestureListener(llsyn[0], ui.this));
        llsyn[0].setOnTouchListener(new LinearLayout.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gest[0].onTouchEvent(event);
            }
        });
        gest[1] = new GestureDetector(llsyn[01].getContext(), new GestureListener(llsyn[1], ui.this));
        llsyn[1].setOnTouchListener(new LinearLayout.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gest[1].onTouchEvent(event);
            }
        });
        gest[2] = new GestureDetector(llsyn[2].getContext(), new GestureListener(llsyn[2], ui.this));
        llsyn[2].setOnTouchListener(new LinearLayout.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gest[2].onTouchEvent(event);
            }
        });
        gest[3] = new GestureDetector(llsyn[3].getContext(), new GestureListener(llsyn[3], ui.this));
        llsyn[3].setOnTouchListener(new LinearLayout.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gest[3].onTouchEvent(event);
            }
        });


        state = 0; //on start page
        result = new int[4];
        Data = new data();


    }

    protected static LinearLayout getLayout(eTextView view){
        if(view == labels[0]) return llsyn[0];
        else if(view == labels[1]) return llsyn[1];
        else if(view == labels[2]) return llsyn[2];
        else if(view == labels[3]) return llsyn[3];
        return null;
    }

    protected static void updateResult(View v){
        CharSequence text;

        int e = (state <= 20) ? 0 : 4;

        if(v != null) {
            text = ((TextView)v).getText();

            if(text != null && !text.equals("Start")){

                int ind = Data.smap.get(text) % 4;
                if (e == 4){
                    result[ind]--;
                    res_list.add(new Pair<>(ind, -1));
                    Log.d("RESULT", ind + " -1");
                }
                else{
                    result[ind]++;
                    res_list.add(new Pair<>(ind, +1));
                    Log.d("RESULT", ind + " +1");
                }
            }
        }
    }

    protected static void updateHead(){
        //set the head variable
        if(state == 41){
            //print the result
            int ans = 0;
            if(result[1] > result[ans]) ans = 1;
            if(result[2] > result[ans]) ans = 2;
            if(result[3] > result[ans]) ans = 3;

            String pr = "";
            String name[] = {"Sanguine", "Melancholy", "Choleric", "Phlegmatic"};
            pr = name[ans];

            head.setText(Html.fromHtml("Your personality has maximum <font color='black'>" + pr + "</font> trait."));
            for(int i = 0; i < 4 ; i++){
                labels[i].setText(name[i] + " : " + String.valueOf(result[i]));
                if(labels[i].getX() > 1) labels[i].gest_listner.left_swipe();
            }
            return;
        }
        else if(state == 21 || state == 40) {
            head.setText("Opt your way : Weakness");
        }
        else if(state == 1 || state == 20){
            head.setText("Opt your way : Strengths");
        }
    }

    protected static void setLabels(int randomno){

        int e = (state <= 20) ? 0 : 4, arr_pos;

        List<ArrayList<String>> mapcopy = Data.mymap; //data
        String key;

        List<Integer> entered = new ArrayList<>();   //randomise the buttons
        entered.add(0); entered.add(1); entered.add(2); entered.add(3);
        Random rand = new Random();

        for(int i = 0; i < 4; i++){
            key = mapcopy.get(i+e).get(randomno);

            arr_pos = rand.nextInt(4-i);

            labels[entered.get(arr_pos)].setText(key);
            if(labels[i].getX() > 1) labels[i].gest_listner.left_swipe();

            entered.remove(arr_pos);

            Integer exc = getLastKey();
            Log.d("BACK", "exchange with " + exc);
            String last = mapcopy.get(i+e).get(exc);

            //swap this element to the last
            mapcopy.get(i+e).set(randomno, last);   //remove(key)
            mapcopy.get(i+e).set(exc, key);
        }

    }

    protected static int getLastKey() {
        if(state <= 20)return 20-state;
        else return 40-state;
    }

    protected static eTextView getLayout(LinearLayout view){
        if(view == llsyn[0]) return labels[0];
        else if(view == llsyn[1]) return labels[1];
        else if(view == llsyn[2]) return labels[2];
        else if(view == llsyn[3]) return labels[3];
        return null;
    }
}
