package app.ug;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by vanessa on 1/18/18 .
 */

public class WelcomeAptitudesActivity extends Activity {
    LinearLayout btnStart;
    TextView instructionsText;
    TextView startTestText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomeaptitudes);

        //Cambiar font
        TextView title = (TextView) findViewById(R.id.aptitudesMainTitle);
        title.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        TextView mainText = (TextView) findViewById(R.id.aptitudesMainText);
        mainText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));

        startTestText = (TextView) findViewById(R.id.startTextAptitudes);
        startTestText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));

        btnStart = (LinearLayout) findViewById(R.id.startButtonAptitudes);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AptitudesActivity.class));
            }
        });
    }
}
