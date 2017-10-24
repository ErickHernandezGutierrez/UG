package app.ug;

import java.util.ArrayList;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.graphics.Typeface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView culturalOffersTitle;
    private TextView offersTitle;
    private TextView licenciaturaText;
    private TextView especialidadText;
    private TextView maestriaText;
    private TextView doctoradoText;
    private TextView testTitle;
    private TextView instructionsText;
    private TextView startTestText;
    //private TextView storeTitle;
    //private TextView storeText;
    //private TextView paymentsText;
    private TextView socialNetworksTitle;
    private TextView facebookText;
    private TextView twitterText;
    private TextView instagramText;
    private TextView youtubeText;
    private LinearLayout licenciaturaButton;
    //private LinearLayout especialidadButton;
    //private LinearLayout maestriaButton;
    //private LinearLayout doctoradoButton;
    private LinearLayout instructionsButton;
    private LinearLayout startTestButton;
    //private ImageButton storeButton;
    //private ImageButton paymentsButton;
    private LinearLayout facebookButton;
    private LinearLayout twitterButton;
    private LinearLayout instagramButton;
    private LinearLayout youtubeButton;
    private RecyclerView bannersView;
    private CustomBannerAdapter bannersAdapter;
    private LinearLayoutManager bannersManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set font for all TextViews
        culturalOffersTitle = (TextView) findViewById(R.id.culturalOffersTitle);
        culturalOffersTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        offersTitle = (TextView) findViewById(R.id.offersTitle);
        offersTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        licenciaturaText = (TextView) findViewById(R.id.licenciaturaText);
        licenciaturaText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        especialidadText = (TextView) findViewById(R.id.especialidadText);
        especialidadText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        maestriaText = (TextView) findViewById(R.id.maestriaText);
        maestriaText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        doctoradoText = (TextView) findViewById(R.id.doctoradoText);
        doctoradoText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));//*/

        /*// Setup Store
        storeTitle = (TextView) findViewById(R.id.storeTitle);
        storeTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        storeText = (TextView) findViewById(R.id.storeText);
        storeText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        paymentsText = (TextView) findViewById(R.id.paymentsText);
        paymentsText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        storeButton = (ImageButton) findViewById(R.id.storeButton);
        storeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StoreActivity.class));
            }
        });
        paymentsButton = (ImageButton) findViewById(R.id.paymentsButton);
        paymentsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "No disponible", Toast.LENGTH_SHORT).show();
            }
        });//*/

        testTitle = (TextView) findViewById(R.id.testTitle);
        testTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        instructionsText = (TextView) findViewById(R.id.instructionsText);
        instructionsText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        startTestText = (TextView) findViewById(R.id.startTestText);
        startTestText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));

        socialNetworksTitle = (TextView) findViewById(R.id.socialNetworksTitle);
        socialNetworksTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        facebookText = (TextView) findViewById(R.id.facebookText);
        facebookText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        twitterText = (TextView) findViewById(R.id.twitterText);
        twitterText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        instagramText = (TextView) findViewById(R.id.instagramText);
        instagramText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        youtubeText = (TextView) findViewById(R.id.youtubeText);
        youtubeText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));

        //Setup all Buttons

        licenciaturaButton = (LinearLayout) findViewById(R.id.licenciaturaButton);
        licenciaturaButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LicenciaturaActivity.class));
            }
        });

        /*especialidadButton = (ImageButton) findViewById(R.id.especialidadButton);
        especialidadButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "No disponible", Toast.LENGTH_SHORT).show();
            }
        });//*/

        /*maestriaButton = (ImageButton) findViewById(R.id.maestriaButton);
        maestriaButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "No disponible", Toast.LENGTH_SHORT).show();
            }
        });//*/

        /*doctoradoButton = (ImageButton) findViewById(R.id.doctoradoButton);
        doctoradoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "No disponible", Toast.LENGTH_SHORT).show();
            }
        });//*/

        instructionsButton = (LinearLayout) findViewById(R.id.instructionsButton);
        instructionsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, InstructionsExam.class));
            }
        });

        startTestButton = (LinearLayout) findViewById(R.id.startTestButton);
        startTestButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, WelcomeExam.class));
            }
        });

        facebookButton = (LinearLayout) findViewById(R.id.facebookButton);
        facebookButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Abriendo...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/univdeguanajuato")));
            }
        });

        twitterButton = (LinearLayout) findViewById(R.id.twitterButton);
        twitterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Abriendo...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/UdeGuanajuato")));
            }
        });

        instagramButton = (LinearLayout) findViewById(R.id.instagramButton);
        instagramButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Abriendo...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/udeguanajuato/")));
            }
        });

        youtubeButton = (LinearLayout) findViewById(R.id.youtubeButton);
        youtubeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Abriendo...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/televisionug")));
            }
        });

        //Setup Banners
        ArrayList<Banner> banners = new ArrayList<>();
        banners.add(new Banner("Banner1", R.drawable.desfile_ugto));
        banners.add(new Banner("Banner2", R.drawable.brigadas_ugto));
        banners.add(new Banner("Banner3", R.drawable.convocatoria_ugto));

        bannersAdapter = new CustomBannerAdapter(this, banners);
        bannersManager = new LinearLayoutManager(this);
        bannersManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        bannersView = (RecyclerView) findViewById(R.id.bannersView);
        bannersView.setAdapter(bannersAdapter);
        bannersView.setLayoutManager(bannersManager);
    }
}
