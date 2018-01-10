package app.ug;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import java.util.concurrent.ExecutionException;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.graphics.Typeface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.net.Uri;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.TextView;
import android.app.Activity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Text;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private TextView culturalOffersTitle;
    private TextView offersTitle;
    private TextView chestTitle;
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
    private LinearLayout chestButton;
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
    private Button filterButton;
    private ArrayList<Banner> banners;
    private ArrayList<Banner> filteredBanners;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //writeStringToFile(this, "1508487720", "timestamp.txt");

        String serverURL = "http://reina.southcentralus.cloudapp.azure.com/getListEvents.php?timestamp=";
        String lastTimestamp = readStringFromFile(this, "timestamp.txt");
        String currentTimestamp = Long.toString(new Date().getTime()/1000);
        System.out.println(lastTimestamp);

        //Connect with server to download all new banners
        HttpPostAsyncTask task = new HttpPostAsyncTask(this);
        task.execute(serverURL + lastTimestamp);

        //Set font for all TextViews
        culturalOffersTitle = (TextView) findViewById(R.id.culturalOffersTitle);
        culturalOffersTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        offersTitle = (TextView) findViewById(R.id.offersTitle);
        offersTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        chestTitle = (TextView) findViewById(R.id.chestTitle);
        chestTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        licenciaturaText = (TextView) findViewById(R.id.licenciaturaText);
        licenciaturaText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        especialidadText = (TextView) findViewById(R.id.especialidadText);
        especialidadText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        maestriaText = (TextView) findViewById(R.id.maestriaText);
        maestriaText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        doctoradoText = (TextView) findViewById(R.id.doctoradoText);
        doctoradoText.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));//*/

        /*//Setup Store
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

        //Setup Test
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
        chestButton = (LinearLayout) findViewById(R.id.chestButton);
        chestButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ChestActivity.class));
            }
        });

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

        filterButton = (Button) findViewById(R.id.filterButton);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, filterButton);
                popupMenu.getMenuInflater().inflate(R.menu.menu_filter, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item){
                        int optionOrder = item.getOrder();

                        int mask = 0;
                        filteredBanners.clear();

                        if(optionOrder == 100) {
                            mask = ~(mask & 0);
                        }
                        else if(optionOrder == 101) {
                            mask = 1;
                        }
                        else if(optionOrder == 102) {
                            mask = 1<<1;
                        }
                        else if(optionOrder == 103) {
                            mask = 1<<2;
                        }
                        else if(optionOrder == 104) {
                            mask = 1<<3;
                        }
                        else if(optionOrder == 105) {
                            mask = 1<<4;
                        }
                        else if(optionOrder == 106) {
                            mask = 1<<5;
                        }

                        for(int i = 0; i < banners.size(); i++){
                            int tag = banners.get(i).getTag();
                            if((mask & tag) > 0)
                                filteredBanners.add(banners.get(i));
                        }
                        bannersAdapter.notifyDataSetChanged();

                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    private void writeBannersToFile(Context context, ArrayList<Banner> banners, String filename){
        try{
            FileOutputStream fileWriter = context.openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream objectWriter = new ObjectOutputStream(fileWriter);

            objectWriter.writeObject(banners);
            objectWriter.close();
            fileWriter.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private ArrayList<Banner> readBannersFromFile(Context context, String filename){
        ArrayList<Banner> output;

        try{
            FileInputStream fileReader = context.openFileInput(filename);
            ObjectInputStream objectReader = new ObjectInputStream(fileReader);

            output = (ArrayList<Banner>) objectReader.readObject();
            objectReader.close();
        }
        catch(FileNotFoundException fnfe){
            output = new ArrayList<>();
        }
        catch(IOException e){
            output = new ArrayList<>();
        }
        catch(ClassNotFoundException cnfe){
            output = new ArrayList<>();
        }

        for(int i = 0; i < output.size(); i++)
            output.get(i).setImage(readBitmapFromFile(context, output.get(i).getTitle()));

        return output;
    }

    private void writeStringToFile(Context context, String data, String filename) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(filename, Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {}
    }

    private String readStringFromFile(Context context, String filename) {
        String ret = "";

        try {
            InputStream inputStream = context.openFileInput(filename);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            ret = "1508487720";
        } catch (IOException e) {
            ret = "1508487720";
        }

        return ret;
    }

    private void writeBitmapToFile(Context context, Bitmap bitmapImage, String filename){
        ContextWrapper contextWrapper = new ContextWrapper(context);
        // path to /data/data/yourapp/app_data/imageDir
        File directory = contextWrapper.getDir("banners", Context.MODE_PRIVATE);
        File mypath=new File(directory, filename + ".jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            bitmapImage.compress(Bitmap.CompressFormat.JPEG, 100, fos);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                fos.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }

        //return directory.getAbsolutePath();
        System.out.println("pakito = " + directory.getAbsolutePath());
    }

    private Bitmap readBitmapFromFile(Context context, String filename) {
        try {
            ContextWrapper contextWrapper = new ContextWrapper(context);
            File directory = contextWrapper.getDir("banners", Context.MODE_PRIVATE);
            File file = new File(directory, filename + ".jpg");
            return BitmapFactory.decodeStream(new FileInputStream(file));
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void setupBanners(ArrayList<Banner> banners){
        //Save banners for future
        this.banners = banners;
        this.filteredBanners = (ArrayList<Banner>) banners.clone();
        writeBannersToFile(this, banners, "banners.ser");

        //Show banners
        bannersAdapter = new CustomBannerAdapter(this, filteredBanners);
        bannersManager = new LinearLayoutManager(this);
        bannersManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        bannersView = (RecyclerView) findViewById(R.id.bannersView);
        bannersView.setAdapter(bannersAdapter);
        bannersView.setLayoutManager(bannersManager);
        bannersView.addOnItemTouchListener(new CustomBannerAdapter.RecyclerTouchListener(getApplicationContext(), bannersView, new CustomBannerAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("banners", filteredBanners);
                bundle.putInt("position", position);

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                CustomDialogFragment newFragment = CustomDialogFragment.newInstance();
                newFragment.setArguments(bundle);
                newFragment.show(ft, "slideshow");
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        //Update timestamp
        writeStringToFile(this, Long.toString(new Date().getTime()/1000), "timestamp.txt");
    }

    public class HttpPostAsyncTask extends AsyncTask<String, Void, ArrayList<Banner>> {

        private Context context;

        // This is a constructor that allows you to pass in the JSON body
        public HttpPostAsyncTask(Context context) {
            this.context = context;
        }

        // This is a function that we are overriding from AsyncTask. It takes Strings as parameters because that is what we defined for the parameters of our async task
        @Override
        protected ArrayList<Banner> doInBackground(String... params) {

            try {
                // This is getting the url from the string we passed in
                URL url = new URL(params[0]);

                // Create the urlConnection
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                //Set connection parameters
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

                //Get status code
                int statusCode = urlConnection.getResponseCode();

                if (statusCode ==  200) {
                    //Load content of JSON file
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

                    System.out.println(json);

                    ArrayList<Banner> banners = new ArrayList<>();
                    ArrayList<Banner> temp = readBannersFromFile(context, "banners.ser");
                    System.out.println("Temp banners size = " + temp.size());

                    //Before add new banners we remove old banners
                    Date currentDate = new Date();
                    for(int i = 0; i < temp.size(); i++) {
                        Date bannerDate = temp.get(i).getDate();
                        System.out.println(currentDate + " versus " + bannerDate);
                        if(currentDate.compareTo(bannerDate) <= 0) {
                            System.out.println("Remove: " + i);
                            banners.add(temp.get(i));
                        }
                    }

                    //Add new banners
                    try {
                        JSONParser parser = new JSONParser();
                        JSONArray arr = (JSONArray) parser.parse(json);

                        //Parse each JSON object
                        for(int i = 0; i < arr.size(); i++) {
                            JSONObject culturalOffer = (JSONObject) arr.get(i);
                            Banner banner = new Banner();

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

                            //Set banner title
                            banner.setTitle(title);

                            //Set banner tag
                            banner.setTag(Integer.parseInt(tag));

                            //Set banner date
                            try {
                                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy,HH.mm");
                                banner.setDate(dateFormat.parse(date));
                            }
                            catch (ParseException pe){
                                pe.printStackTrace();
                            }

                            //Load image from server, set banner image and save image to internal storage
                            try {
                                banner.setImage(Glide.with(context).load(imageURL).asBitmap().into(500, 500).get());
                                writeBitmapToFile(context, banner.getImage(), banner.getTitle());
                            }
                            catch (InterruptedException ie){
                                ie.printStackTrace();
                            }
                            catch (ExecutionException ee){
                                ee.printStackTrace();
                            }

                            //Add banner to array
                            banners.add(banner);
                        }
                    }
                    catch(org.json.simple.parser.ParseException pe){
                        pe.printStackTrace();
                    }

                    return banners;

                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Banner> banners){
            setupBanners(banners);
        }

    }

}
