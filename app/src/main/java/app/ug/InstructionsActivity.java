package app.ug;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;

/**
 * Created by vanessa on 5/7/17. */

public class InstructionsActivity extends Activity {

    LinearLayout startTestButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        TextView testInstructionsTitle = (TextView) findViewById(R.id.testInstructionsTitle);
        TextView testTargetTitle = (TextView) findViewById(R.id.testTargetTitle);
        TextView testTargetText  = (TextView) findViewById(R.id.testTargetText);
        TextView testStructureTitle = (TextView) findViewById(R.id.testStructureTitle);
        TextView testStructureText  = (TextView) findViewById(R.id.testStructureText);
        TextView testInterestsTitle = (TextView) findViewById(R.id.testInterestsTitle);
        TextView testInterestsText  = (TextView) findViewById(R.id.testInterestsText);
        TextView testInterestsOption1 = (TextView) findViewById(R.id.testInterestsOption1);
        TextView testInterestsOption2 = (TextView) findViewById(R.id.testInterestsOption2);
        TextView testInterestsOption3 = (TextView) findViewById(R.id.testInterestsOption3);
        TextView testInterestsOption4 = (TextView) findViewById(R.id.testInterestsOption4);
        TextView testInterestsOption5 = (TextView) findViewById(R.id.testInterestsOption5);
        TextView testAptitudesTitle = (TextView) findViewById(R.id.testAptitudesTitle);
        TextView testAptitudesText  = (TextView) findViewById(R.id.testAptitudesText);
        TextView testAptitudesOption1 = (TextView) findViewById(R.id.testAptitudesOption1);
        TextView testAptitudesOption2 = (TextView) findViewById(R.id.testAptitudesOption2);
        TextView testAptitudesOption3 = (TextView) findViewById(R.id.testAptitudesOption3);
        TextView testAptitudesOption4 = (TextView) findViewById(R.id.testAptitudesOption4);
        TextView testAptitudesOption5 = (TextView) findViewById(R.id.testAptitudesOption5);
        TextView testResultsTitle = (TextView) findViewById(R.id.testResultsTitle);
        TextView testResultsText  = (TextView) findViewById(R.id.testResultsText);
        TextView startTestText = (TextView) findViewById(R.id.startTestText);

        testInstructionsTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        testTargetTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        testTargetText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        testStructureTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        testStructureText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        testInterestsTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        testInterestsText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        testInterestsOption1.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        testInterestsOption2.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        testInterestsOption3.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        testInterestsOption4.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        testInterestsOption5.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        testAptitudesTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        testAptitudesText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        testAptitudesOption1.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        testAptitudesOption2.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        testAptitudesOption3.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        testAptitudesOption4.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        testAptitudesOption5.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        testResultsTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        testResultsText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        startTestText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));

        startTestButton = (LinearLayout) findViewById(R.id.startTestButton);
        startTestButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InstructionsActivity.this, InterestsActivity.class));
            }
        });
    }

}
