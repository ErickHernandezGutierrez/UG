package app.ug;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by vanessa on 1/16/18.
 */

public class MainTestActivity extends Activity{

    LinearLayout btnStart;
    LinearLayout btnInstruction;
    TextView instructionsText;
    TextView startTestText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintest);

        //Cambiar font
        TextView title = (TextView) findViewById(R.id.testMainTitle);
        title.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        TextView mainText = (TextView) findViewById(R.id.testMainText);
        mainText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));

        instructionsText = (TextView) findViewById(R.id.startText);
        instructionsText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        startTestText = (TextView) findViewById(R.id.goInstructionsText);
        startTestText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));

        btnInstruction = (LinearLayout) findViewById(R.id.goInstructionsButton);
        btnInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), InstructionsActivity.class));
            }
        });

        btnStart = (LinearLayout) findViewById(R.id.startButton);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WelcomeInteresesActivity.class));
            }
        });
    }
}
