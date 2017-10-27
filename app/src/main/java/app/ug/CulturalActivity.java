package app.ug;

import android.graphics.Typeface;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class CulturalActivity extends Activity {

    private TextView culturalTitle;
    private TextView descriptionTitle;
    private TextView descriptionText;
    private TextView locationTitle;
    private TextView locationText;
    private TextView dateTitle;
    private TextView dateText;
    private TextView timeTitle;
    private TextView timeText;
    private TextView durationTitle;
    private TextView durationText;
    private TextView coordinatorTitle;
    private TextView coordinatorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultural);

        culturalTitle = (TextView) findViewById(R.id.culturalTitle);
        descriptionTitle = (TextView) findViewById(R.id.descriptionTitle);
        descriptionText = (TextView) findViewById(R.id.descriptionText);
        locationTitle = (TextView) findViewById(R.id.locationTitle);
        locationText = (TextView) findViewById(R.id.locationText);
        dateTitle = (TextView) findViewById(R.id.dateTitle);
        dateText = (TextView) findViewById(R.id.dateText);
        timeTitle = (TextView) findViewById(R.id.timeTitle);
        timeText = (TextView) findViewById(R.id.timeText);
        durationTitle = (TextView) findViewById(R.id.durationTitle);
        durationText = (TextView) findViewById(R.id.durationText);
        //coordinatorTitle = (TextView) findViewById(R.id.coordinatorTitle);
        //coordinatorText = (TextView) findViewById(R.id.coordinatorText);

        culturalTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        descriptionTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        descriptionText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        locationTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        locationText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        dateTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        dateText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        timeTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        timeText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        durationTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        durationText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        //coordinatorTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        //coordinatorText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
    }
}
