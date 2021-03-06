package app.ug;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class ChestActivity extends AppCompatActivity {

    private CustomMemoryAdapter memoriesAdapter;
    private LinearLayoutManager memoriesManager;
    private RecyclerView memoriesView;
    private TextView chestMainTitle;
    private TextView chestMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);
        getSupportActionBar().hide();

        chestMainTitle = (TextView) findViewById(R.id.chestMainTitle);
        chestMainTitle.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));

        //String serverURL = "http://reina.southcentralus.cloudapp.azure.com/getListMemories.php?timestamp=";
        String serverURL = "http://www.ofertaeducativayculturalcgto.ugto.mx/getListMemories.php?timestamp=";
        String lastTimestamp = "1508487720";

        HttpPostAsyncTask task = new HttpPostAsyncTask(this);
        task.execute(serverURL + lastTimestamp);
        chestMessage = (TextView) findViewById(R.id.chestMessage);
        chestMessage.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        chestMessage.setText("Cargando...");
    }

    public void setupChest(final ArrayList<Memory> memories){
        if(memories.size() == 0) {
            chestMessage.setText("No hay eventos disponibles. Revisa tu conexión a internet");
            return;
        }
        //Setup Chest
        chestMessage.setText("");
        memoriesAdapter = new CustomMemoryAdapter(this, memories);
        memoriesManager = new LinearLayoutManager(this);
        memoriesManager.setOrientation(LinearLayoutManager.VERTICAL);
        memoriesView = (RecyclerView) findViewById(R.id.memoriesView);
        memoriesView.setAdapter(memoriesAdapter);
        memoriesView.setLayoutManager(memoriesManager);
        memoriesView.addOnItemTouchListener(new CustomMemoryAdapter.RecyclerTouchListener(getApplicationContext(), memoriesView, new CustomMemoryAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("images", memories.get(position).getImages());
                bundle.putInt("position", position);

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ChestDialogFragment newFragment = ChestDialogFragment.newInstance();
                newFragment.setArguments(bundle);
                newFragment.show(ft, "slideshow");
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));//*/
    }

    public class HttpPostAsyncTask extends AsyncTask<String, Void, ArrayList<Memory>> {

        private Context context;

        // This is a constructor that allows you to pass in the JSON body
        public HttpPostAsyncTask(Context context) {
            this.context = context;
        }

        // This is a function that we are overriding from AsyncTask. It takes Strings as parameters because that is what we defined for the parameters of our async task
        @Override
        protected ArrayList<Memory> doInBackground(String... params) {

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

                //Get status code
                int statusCode = urlConnection.getResponseCode();

                if (statusCode ==  200) {
                    System.out.println("Chidote");
                    //Load content of JSON file
                    InputStream inputStream = urlConnection.getInputStream();
                    byte[] buffer = new byte[1024];
                    int num_bytes;
                    String jsonText = "";
                    while ( ( num_bytes = inputStream.read(buffer)) != -1 ) {
                        byte[] temp = new byte[num_bytes];
                        for(int i = 0; i < num_bytes; i++)
                            temp[i] = buffer[i];
                        jsonText +=  new String(temp, "UTF-8");
                    }
                    inputStream.close();

                    System.out.println(jsonText);

                    ArrayList<Memory> memories = new ArrayList<>();

                    //Add new banners
                    try {
                        JSONParser parser = new JSONParser();
                        JSONArray arr = (JSONArray) parser.parse(jsonText);

                        //Parse each JSON object
                        for(int i = 0; i < arr.size(); i++) {

                            JSONObject jsonMemory = (JSONObject) arr.get(i);
                            Memory memory = new Memory();

                            String date = (String) jsonMemory.get("creationdate");
                            String title = (String) jsonMemory.get("title");
                            String description = (String) jsonMemory.get("description");
                            //Long num_links = (Long) jsonMemory.get("urlcount");
                            //JSONArray jsonLinks = (JSONArray) jsonMemory.get("urls");

                            memory.setDate(date);
                            memory.setCampus("Guanajuato");
                            memory.setTitle(title);
                            memory.setDescription(description);

                            ArrayList<String> links = new ArrayList();
                            ArrayList<Bitmap> images = new ArrayList<>();
                            System.out.println("Links:");
                            for(int j = 1; j <= 4; j++){
                                String link = (String) jsonMemory.get("url" + Integer.toString(j));
                                System.out.println(link);
                                if(link == null) continue;
                                links.add(link);
                                images.add(Glide.with(context).load(link).asBitmap().into(500, 500).get());
                            }
                            memory.setLinks(links);
                            memory.setImages(images);

                            memories.add(memory);
                        }
                    }
                    catch(org.json.simple.parser.ParseException pe){
                        pe.printStackTrace();
                    }

                    return memories;
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }

            return new ArrayList<>();
        }

        @Override
        protected void onPostExecute(ArrayList<Memory> memories){
            setupChest(memories);
        }

    }
}
