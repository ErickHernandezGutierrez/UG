package app.ug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;
import java.io.FileReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

import android.app.Activity;
import android.graphics.Typeface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.net.Uri;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.Button;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;//*/

public class OfferActivity extends Activity {
    private TextView title;
    private TextView modality;
    private TextView titleModality;
    private TextView studyPeriod;
    private TextView titleStudyPeriod;
    private TextView entryPeriod;
    private TextView titleEntryPeriod;
    private TextView admission;
    private TextView entry;
    private TextView classes;
    private TextView location;
    private TextView campus;
    private TextView division;
    private TextView sede;
    private TextView address;
    private TextView phone;
    private TextView link;
    private TextView map;
    private CustomExpandableAdapter offerClassesMenuAdapter;
    private CustomExpandableAdapter offerEntryMenuAdapter;
    private ExpandableListView offerClassesMenuView;
    private ExpandableListView offerEntryMenuView;
    private LinearLayout mapButton;
    private Button admissionButton;
    List<String> headersClasses;
    List<String> headersEntry;
    HashMap<String, List<String>> childsClasses;
    HashMap<String, List<String>> childsEntry;
    Double offerLatitud;
    Double offerLongitud;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //overridePendingTransition(R.anim.left_in, R.anim.left_out);
        setContentView(R.layout.activity_offer);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);

        // Setup Title
        title = (TextView) findViewById(R.id.offerTitle);
        title.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));

        // Setup Modality
        titleModality = (TextView) findViewById(R.id.titleModality);
        titleModality.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        modality = (TextView) findViewById(R.id.offerModality);
        modality.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));

        // Setup Study Period
        titleStudyPeriod = (TextView) findViewById(R.id.titleStudyPeriod);
        titleStudyPeriod.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        studyPeriod = (TextView) findViewById(R.id.offerStudyPeriod);
        studyPeriod.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));

        // Setup Entry Period
        titleEntryPeriod = (TextView) findViewById(R.id.titleEntryPeriod);
        titleEntryPeriod.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        entryPeriod = (TextView) findViewById(R.id.offerEntryPeriod);
        entryPeriod.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));

        // Setup Admission Process
        /*admission = (TextView) findViewById(R.id.offerAdmission);
        admission.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        admissionButton = (Button) findViewById(R.id.offerAdmissionButton);
        admissionButton.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        admissionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(OfferActivity.this, AdmissionActivity.class));
            }
        });//*/

        // Setup Study Plan
        classes = (TextView) findViewById(R.id.offerClasses);
        classes.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));

        // Setup Admission Porfile
        entry = (TextView) findViewById(R.id.offerEntry);
        entry.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));

        // Setup Location
        location = (TextView) findViewById(R.id.offerLocation);
        location.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        campus = (TextView) findViewById(R.id.offerCampus);
        campus.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        division = (TextView) findViewById(R.id.offerDivision);
        division.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        sede = (TextView) findViewById(R.id.offerSede);
        sede.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        address = (TextView) findViewById(R.id.offerAddress);
        address.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        phone = (TextView) findViewById(R.id.offerPhone);
        phone.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        link = (TextView) findViewById(R.id.offerLink);
        link.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        map = (TextView) findViewById(R.id.offerMap);
        map.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));

        try {
            String jsonName = getIntent().getStringExtra("jsonName");

            InputStream is = getAssets().open(jsonName + ".json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");

            JSONParser parser = new JSONParser();
            JSONArray arr = (JSONArray) parser.parse(json);
            JSONObject offer = (JSONObject) arr.get(0);

            String offerTitle = (String) offer.get("titulo");
            String offerModality = (String) offer.get("modalidad");
            String offerStudyPeriod = (String) offer.get("periodoEstudio");
            String offerEntryPeriod = (String) offer.get("periodoIngreso");
            String offerKnowledge = (String) offer.get("conocimientos");
            String offerAbilities = (String) offer.get("habilidades");
            String offerAttitudes = (String) offer.get("actitudes");
            String offerValues = (String) offer.get("valores");
            Long offerTotalSemesters = (Long) offer.get("totalSemestres");
            JSONArray offerStudyPlan  = (JSONArray) offer.get("planEstudios");
            String offerCampus = (String) offer.get("campus");
            String offerDivision = (String) offer.get("division");
            String offerSede = (String) offer.get("sede");
            String offerAddress = (String) offer.get("domicilio");
            String offerPhone = (String) offer.get("telefono");
            offerLatitud = (Double) offer.get("latitud");
            offerLongitud = (Double) offer.get("longitud");

            title.setText(offerTitle);
            modality.setText(offerModality);
            studyPeriod.setText(offerStudyPeriod);
            entryPeriod.setText(offerEntryPeriod);
            campus.setText("Campus: " + offerCampus);
            division.setText("Division: " + offerDivision);
            sede.setText("Sede: " + offerSede);
            address.setText("Domicilio: " + offerAddress);
            phone.setText("Teléfono: " + offerPhone);

            //Setup ExpandableListView for admission
            offerEntryMenuView = (ExpandableListView) findViewById(R.id.offerEntryMenuView);
            setOfferAdmissionProfileMenuViewData(offerKnowledge, offerAbilities, offerAttitudes, offerValues);
            offerEntryMenuAdapter = new CustomExpandableAdapter(this, headersEntry, childsEntry);
            offerEntryMenuView.setAdapter(offerEntryMenuAdapter);
            offerEntryMenuView.setOnTouchListener(new OnTouchListener(){
                @Override
                public boolean onTouch(View v, MotionEvent event){
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
            });

            //Setup ExpandableListView for classes
            offerClassesMenuView = (ExpandableListView) findViewById(R.id.offerClassesMenuView);
            setOfferClassesMenuViewData(offerStudyPlan, offerTotalSemesters);
            offerClassesMenuAdapter = new CustomExpandableAdapter(this, headersClasses, childsClasses);
            offerClassesMenuView.setAdapter(offerClassesMenuAdapter);
            offerClassesMenuView.setOnTouchListener(new OnTouchListener(){
                @Override
                public boolean onTouch(View v, MotionEvent event){
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
            });
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ParseException e){
            e.printStackTrace();
        }

        //Setup Button for map
        mapButton = (LinearLayout) findViewById(R.id.offerMapButton);
        mapButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(OfferActivity.this, MapsActivity.class);
                intent.putExtra("latitud", offerLatitud);
                intent.putExtra("longitud", offerLongitud);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed(){
        //overridePendingTransition(R.anim.right_in, R.anim.right_out);
        super.onBackPressed();
    }

    private void setOfferAdmissionProfileMenuViewData(String offerKnowledge, String offerAbilities, String offerAttitudes, String offerValues){
        headersEntry = new ArrayList<String>();
        childsEntry = new HashMap<String, List<String>>();
        List<String> group0 = new ArrayList<String>();
        List<String> group1 = new ArrayList<String>();
        List<String> group2 = new ArrayList<String>();
        List<String> group3 = new ArrayList<String>();

        //Add header data
        headersEntry.add("Conocimientos");
        headersEntry.add("Habilidades");
        headersEntry.add("Actitudes");
        headersEntry.add("Valores");

        //Add child data
        group0.add(offerKnowledge);
        group1.add(offerAbilities);
        group2.add(offerAttitudes);
        group3.add(offerValues);

        childsEntry.put(headersEntry.get(0), group0);
        childsEntry.put(headersEntry.get(1), group1);
        childsEntry.put(headersEntry.get(2), group2);
        childsEntry.put(headersEntry.get(3), group3);
    }

    private void setOfferClassesMenuViewData(JSONArray offerStudyPlan, Long offerTotalSemesters){
        //Add header data
        headersClasses = new ArrayList<String>();
        for(int i = 1; i <= offerTotalSemesters; i++)
            headersClasses.add(Integer.toString(i) + "° inscripción");
        headersClasses.add("Optativas");

        childsClasses = new HashMap<String, List<String>>();
        JSONObject temp = (JSONObject) offerStudyPlan.get(0);
        for(int i = 1; i <= offerTotalSemesters; i++){
            String semester = (String) temp.get(Integer.toString(i));
            List<String> group = new ArrayList<String>();
            group.add(semester);
            childsClasses.put(headersClasses.get(i-1), group);
        }
        String optional = (String) temp.get("optativas");
        List<String> group = new ArrayList<String>();
        group.add(optional);
        childsClasses.put(headersClasses.get((int)(long)offerTotalSemesters), group);//*/
    }
}

