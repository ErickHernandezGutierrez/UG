package app.ug;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vanessa on 3/20/18.
 */

public class PhdActivity extends Activity {
    private TextView title;
    private ListView listView;
    private Button menuButton;
    private CustomListAdapter listAdapter;
    private HashMap<String, String> jsonNames;
    private List<Offer> offersGuanajuato     = new ArrayList<>();
    private List<Offer> offersGuanajuatoDAAD = new ArrayList<>();
    private List<Offer> offersGuanajuatoDCEA = new ArrayList<>();
    private List<Offer> offersGuanajuatoDCNE = new ArrayList<>();
    private List<Offer> offersGuanajuatoDCSH = new ArrayList<>();
    private List<Offer> offersGuanajuatoDDPG = new ArrayList<>();
    private List<Offer> offersGuanajuatoDI   = new ArrayList<>();
    /*private List<Offer> offersLeon = new ArrayList<>();
    private List<Offer> offersIrapuatoSalamanca = new ArrayList<>();
    private List<Offer> offersCelayaSalvatierra = new ArrayList<>();
    private List<Offer> offers = new ArrayList<>();//*/

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phd);

        //Setup Title
        title = (TextView) findViewById(R.id.phd_title);
        title.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));

        setupJSONMap();

        //Setup ListView
        listView = (ListView) findViewById(R.id.phd_list);
        setListViewData();
        listAdapter = new CustomListAdapter(this, offersGuanajuato);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Offer selectedOffer = (Offer) listView.getItemAtPosition(position);
                String offerName = selectedOffer.getName();

                Intent intent = new Intent(PhdActivity.this, OfferActivityPhd.class);
                intent.putExtra("jsonName", jsonNames.get(offerName));
                startActivity(intent);
            }
        });

        //Setup Menu Button
        menuButton = (Button) findViewById(R.id.phdMenuButton);
        menuButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu popupMenu = new PopupMenu(PhdActivity.this, menuButton);
                popupMenu.getMenuInflater().inflate(R.menu.menu_licenciatura, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item){
                        int optionOrder = item.getOrder();

                        Toast.makeText(PhdActivity.this, "Cargando...", Toast.LENGTH_SHORT).show();

                        if(optionOrder == 100)
                            listAdapter.setList(offersGuanajuato);
                        else if(optionOrder == 101)
                            listAdapter.setList(offersGuanajuatoDAAD);
                        else if(optionOrder == 102)
                            listAdapter.setList(offersGuanajuatoDCEA);
                        else if(optionOrder == 103)
                            listAdapter.setList(offersGuanajuatoDCNE);
                        else if(optionOrder == 104)
                            listAdapter.setList(offersGuanajuatoDCSH);
                        else if(optionOrder == 105)
                            listAdapter.setList(offersGuanajuatoDDPG);
                        else if(optionOrder == 106)
                            listAdapter.setList(offersGuanajuatoDI);

                        listAdapter.notifyDataSetChanged();

                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    private void setupJSONMap(){
        jsonNames = new HashMap<String, String>();

        //Campus Guanajuato
        //jsonNames.put("Arquitectura", "h");
        //jsonNames.put("Artes", "h");
        //jsonNames.put("Ciencia y Tecnología del Agua", "h");
        jsonNames.put("Filosofía", "filosofia");
        jsonNames.put("Historia", "historia");
        jsonNames.put("Interinstitucional en Derecho", "interinstitucional_derecho");
        jsonNames.put("Interinstitucional en Derechos Humanos", "interinstitucional_derechos_humanos") ;
        //jsonNames.put("", "");
    }

    private void setListViewData(){
        //Setup Guanajuato Offers
        //offersGuanajuato.add(new Offer("Arquitectura", "Arquitectura, Arte y Diseño", "Guanajuato"));
        //offersGuanajuato.add(new Offer("Artes", "Arquitectura, Arte y Diseño", "Guanajuato"));
        //offersGuanajuato.add(new Offer("Ciencia y Tecnología del Agua", "Ingenierías", "Guanajuato"));
        offersGuanajuato.add(new Offer("Filosofía", "Ciencias Sociales y Humanidades", "Guanajuato"));
        offersGuanajuato.add(new Offer("Historia", "Ciencias Sociales y Humanidades", "Guanajuato"));
        offersGuanajuato.add(new Offer("Interinstitucional en Derecho", "Derecho, Política y Gobierno", "Guanajuato"));
        offersGuanajuato.add(new Offer("Interinstitucional en Derechos Humanos", "Derecho, Política y Gobierno", "Guanajuato"));

        // Setup DAAD
        //offersGuanajuatoDAAD.add(new Offer("Arquitectura", "Arquitectura, Arte y Diseño", "Guanajuato"));
        //offersGuanajuatoDAAD.add(new Offer("Artes", "Arquitectura, Arte y Diseño", "Guanajuato"));

        // Setup DCEA
        //offersGuanajuatoDCEA.add(new Offer("Administración de la Calidad y la Productividad", "Ciencias Económico Administrativas", "Guanajuato"));

        // Setup DCNE
        //offersGuanajuatoDCNE.add(new Offer("Biología Experimental", "Ciencias Naturales y Exactas", "Guanajuato"));

        // Setup DCSH
        offersGuanajuatoDCSH.add(new Offer("Filosofía", "Ciencias Sociales y Humanidades", "Guanajuato"));
        offersGuanajuatoDCSH.add(new Offer("Historia", "Ciencias Sociales y Humanidades", "Guanajuato"));

        // Setup DDPG
        offersGuanajuatoDDPG.add(new Offer("Interinstitucional en Derecho", "Derecho, Política y Gobierno", "Guanajuato"));
        offersGuanajuatoDDPG.add(new Offer("Interinstitucional en Derechos Humanos", "Derecho, Política y Gobierno", "Guanajuato"));

        // Setup DI
        //offersGuanajuatoDI.add(new Offer("Ciencia y Tecnología del Agua", "Ingenierías", "Guanajuato"));

        /* *** //Setup Celaya-Salvatierra
        offersCelayaSalvatierra.add(new Offer("Administración", "", "Celaya-Salvatierra"));

        //Setup Irapuato-Salamanca
        offersIrapuatoSalamanca.add(new Offer("Agronegocios", "", "Irapuato-Salamanca"));

        //Setup Leon
        offers.add(new Offer("Administración", "", ""));*/

    }
}
