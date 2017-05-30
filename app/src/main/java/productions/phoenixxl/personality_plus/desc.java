package productions.phoenixxl.personality_plus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by abhishek on 19/5/17.
 */

public class desc extends Activity{
    TextView thistext;
    ScrollView ll_desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desc);
        thistext = (TextView)findViewById(R.id.txtStatus);

        int id = getResources().getIdentifier(getIntent().getStringExtra("opt"), "string", getPackageName());
        thistext.setText(Html.fromHtml(getResources().getString(id)));
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
