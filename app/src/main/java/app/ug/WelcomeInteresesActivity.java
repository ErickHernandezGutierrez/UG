package app.ug;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by vanessa on 1/17/18.
 */

public class WelcomeInteresesActivity extends Activity {
    LinearLayout btnStart;
    TextView instructionsText;
    TextView startTestText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomeintereses);

        //Cambiar font
        TextView title = (TextView) findViewById(R.id.interesesMainText);
        title.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        TextView mainText = (TextView) findViewById(R.id.interesesMainText);
        mainText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));

        startTestText = (TextView) findViewById(R.id.startTextIntereses);
        startTestText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));

        btnStart = (LinearLayout) findViewById(R.id.startButtonIntereses);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), InterestsActivity.class));
            }
        });
    }
}
