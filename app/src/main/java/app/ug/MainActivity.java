package app.ug;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.graphics.Typeface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.TextView;
import android.app.Activity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends Activity {

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
                startActivity(new Intent(MainActivity.this, InstructionsActivity.class));
            }
        });

        startTestButton = (LinearLayout) findViewById(R.id.startTestButton);
        startTestButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InterestsActivity.class));
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



        /*SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-06:00"));
        String temp = dateFormat.format(new Date().getTime());
        Timestamp aux = Timestamp.valueOf(temp);
        System.out.println(temp);
        System.out.println(aux);//*/

        /*Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);//*/

        String dateText = "02/12/2017 16:21:12";
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            Date date = dateFormat.parse(dateText);
            long timestamp = (long) date.getTime()/1000;
            System.out.println(timestamp);


            HttpPostAsyncTask task = new HttpPostAsyncTask(timestamp);
            task.execute("http://reina.southcentralus.cloudapp.azure.com/getListEvents.php?timestamp=");
        }
        catch (ParseException pe){

        }


    }

    public void setupBanners(String json){
        //Setup Banners
        ArrayList<Banner> banners = new ArrayList<>();
        /*banners.add(new Banner("Concierto UG", R.drawable.cartel, 0));
        banners.add(new Banner("Concierto UG", R.drawable.cartel, 0));
        banners.add(new Banner("Concierto UG", R.drawable.cartel, 0));
        banners.add(new Banner("Concierto UG", R.drawable.cartel, 0));
        banners.add(new Banner("Concierto UG", R.drawable.cartel, 0));
        banners.add(new Banner("Concierto UG", R.drawable.cartel, 0));//*/

        System.out.println(json);

        try {
            JSONParser parser = new JSONParser();
            JSONArray arr = (JSONArray) parser.parse(json);

            //Parse each JSON object
            for(int i = 0; i < arr.size(); i++) {
                JSONObject culturalOffer = (JSONObject) arr.get(i);
                final Banner banner = new Banner();

                String title = (String) culturalOffer.get("title");
                String tag = (String) culturalOffer.get("tags");
                String date = (String) culturalOffer.get("eventdate");
                String imageURL = (String) culturalOffer.get("url");

                System.out.println("Object:");
                System.out.println(title);
                System.out.println(tag);
                System.out.println(date);
                System.out.println(imageURL);
                System.out.println();

                //Load image from server
                Glide.with(MainActivity.this).load(imageURL).asBitmap().into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        banner.setImage(resource);
                        /*bitmap = resource;
                        saveBitmapToExternalStorage();//*/
                    }
                });//*/

                //Set banner data
                banner.setTitle(title);
                banner.setImageID(R.drawable.notimage);
                banner.setTag(Integer.parseInt(tag));

                //Add banner to array
                banners.add(banner);
            }
        }
        catch(org.json.simple.parser.ParseException pe){
            pe.printStackTrace();
        }

        bannersAdapter = new CustomBannerAdapter(this, banners);
        bannersManager = new LinearLayoutManager(this);
        bannersManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        bannersView = (RecyclerView) findViewById(R.id.bannersView);
        bannersView.setAdapter(bannersAdapter);
        bannersView.setLayoutManager(bannersManager);
    }

    public class HttpPostAsyncTask extends AsyncTask<String, Void, String> {

        Long timestamp;

        // This is a constructor that allows you to pass in the JSON body
        public HttpPostAsyncTask(Long timestamp) {
            this.timestamp = timestamp;
        }

        @Override
        protected void onPostExecute(String json){
            setupBanners(json);
        }

        // This is a function that we are overriding from AsyncTask. It takes Strings as parameters because that is what we defined for the parameters of our async task
        @Override
        protected String doInBackground(String... params) {

            try {
                // This is getting the url from the string we passed in
                URL url = new URL(params[0] + Long.toString(1508487720));

                System.out.println(params[0] + Long.toString(this.timestamp));

                // Create the urlConnection
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.setReadTimeout(15000);
                urlConnection.setConnectTimeout(15000);
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);
                urlConnection.setRequestMethod("POST");

            /*OutputStream os = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(Long.toString(1508487720));
            writer.flush();
            writer.close();
            os.close();//*/

            /*OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
            writer.write(1508487720);
            writer.flush();
            urlConnection.connect();//*/

                /*List<NameValuePair> params2 = new ArrayList<NameValuePair>();
                params2.add(new BasicNameValuePair("timestamp", Long.toString(1508487720)));

                OutputStream os = urlConnection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                writer.write(getQuery(params2));
                writer.flush();
                writer.close();
                os.close();
                urlConnection.connect();//*/

                int statusCode = urlConnection.getResponseCode();

                System.out.println(statusCode);

                if (statusCode ==  200) {

                    InputStream inputStream = urlConnection.getInputStream();

                    byte[] buffer = new byte[1024];

                    int num_bytes;
                    String json = "";
                    while ( ( num_bytes = inputStream.read(buffer)) != -1 ) {
                        byte[] temp = new byte[num_bytes];
                        for(int i = 0; i < num_bytes; i++)
                            temp[i] = buffer[i];
                        json +=  new String(temp, "UTF-8");
                    }
                    inputStream.close();

                    //System.out.println(json);
                    System.out.println("Chido");

                    return json;

                /*JSONParser parser = new JSONParser();
                JSONArray arr = (JSONArray) parser.parse(json);
                JSONObject offer = (JSONObject) arr.get(0);

                System.out.println((String) offer.get("title"));//*/

                    // From here you can convert the string to JSON with whatever JSON parser you like to use
                    // After converting the string to JSON, I call my custom callback. You can follow this process too, or you can implement the onPostExecute(Result) method
                } else {
                    // Status code is not 200
                    // Do something to handle the error
                    System.out.println("Error");
                }//*/

            } catch (Exception e) {
                //Log.d(TAG, e.getLocalizedMessage());
            }
            return null;
        }

        private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
            StringBuilder result = new StringBuilder();
            boolean first = true;

            for (NameValuePair pair : params)
            {
                if (first)
                    first = false;
                else
                    result.append("&");

                result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
            }

            return result.toString();
        }

    }

}
