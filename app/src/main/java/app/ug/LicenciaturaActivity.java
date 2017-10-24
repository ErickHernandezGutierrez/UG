package app.ug;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class LicenciaturaActivity extends Activity {
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
        setContentView(R.layout.activity_licenciatura);

        //Setup Title
        title = (TextView) findViewById(R.id.licenciatura_title);
        title.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));

        setupJSONMap();

        //Setup ListView
        listView = (ListView) findViewById(R.id.licenciatura_list);
        setListViewData();
        listAdapter = new CustomListAdapter(this, offersGuanajuato);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Offer selectedOffer = (Offer) listView.getItemAtPosition(position);
                String offerName = selectedOffer.getName();

                /*Intent intent = new Intent(LicenciaturaActivity.this, OfferActivity.class);
                intent.putExtra("jsonName", jsonNames.get(offerName));
                startActivity(intent);//*/
            }
        });

        //Setup Menu Button
        menuButton = (Button) findViewById(R.id.licenciaturaMenuButton);
        menuButton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu popupMenu = new PopupMenu(LicenciaturaActivity.this, menuButton);
                popupMenu.getMenuInflater().inflate(R.menu.menu_licenciatura, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item){
                        int optionOrder = item.getOrder();

                        Toast.makeText(LicenciaturaActivity.this, "Cargando...", Toast.LENGTH_SHORT).show();

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
        jsonNames.put("Arquitectura", "arquitectura");
        jsonNames.put("Artes Escénicas", "artes_escenicas");
        jsonNames.put("Artes Visuales", "artes_visuales");
        jsonNames.put("Diseño de Interiores", "diseno_de_interiores");
        jsonNames.put("Diseño Gráfico", "diseno_grafico");
        jsonNames.put("Música Cantante", "musica_cantante");
        jsonNames.put("Música Composición", "musica_composicion");
        jsonNames.put("Música Educación Musical", "musica_educacion_musical");
        jsonNames.put("Música Instrumentista", "musica_instrumentista");
        jsonNames.put("Administración de la Calidad y la Productividad", "administracion_de_la_calidad_y_la_productividad");
        jsonNames.put("Administración de Recursos Turísticos", "administracion_de_recursos_turisticos");
        jsonNames.put("Comercio Internacional", "comercio_internacional");
        jsonNames.put("Contador Público", "contador_publico");
        jsonNames.put("Economía", "economia");
        jsonNames.put("Relaciones Industriales", "relaciones_industriales");
        jsonNames.put("Sistemas de Información Administrativa", "sistemas_de_informacion_administrativa");
        jsonNames.put("Biología Experimental", "biologia_experimental");
        jsonNames.put("Computación", "computacion");
        jsonNames.put("Ingeniería Química", "ingenieria_quimica");
        jsonNames.put("Matemáticas", "matematicas");
        jsonNames.put("Química", "quimica");
        jsonNames.put("Químico Farmacéutico Biólogo", "quimico_farmaceutico_biologo");
        jsonNames.put("Educación", "educacion");
        jsonNames.put("Enseñanza del Español como Segunda Lengua", "ensenanza_del_espanol_como_segunda_lengua");
        jsonNames.put("Enseñanza del Inglés", "ensenanza_del_ingles");
        jsonNames.put("Filosofía", "filosofia");
        jsonNames.put("Historia", "historia");
        jsonNames.put("Letras Españolas", "letras_espanolas");
        jsonNames.put("Derecho", "derecho");
        jsonNames.put("Ciencia Política", "ciencia_politica");
        jsonNames.put("Administración Pública", "administracion_publica");
        jsonNames.put("Ingeniería Civil", "ingenieria_civil");
        jsonNames.put("Ingeniería Ambiental", "ingenieria_ambiental");
        jsonNames.put("Ingeniería Geomática", "ingenieria_geomatica");
        jsonNames.put("Ingeniería Hidráulica", "ingenieria_hidraulica");
        jsonNames.put("Ingeniería en Minas", "ingenieria_en_minas");
        jsonNames.put("Ingeniero Geólogo", "ingeniero_geologo");
        jsonNames.put("Ingeniería Metalúrgica", "ingenieria_metalurgica");
        jsonNames.put("Geografía", "geografia");
        //jsonNames.put("", "");
    }

    private void setListViewData(){
        //Setup Guanajuato Offers
        offersGuanajuato.add(new Offer("Administración de la Calidad y la Productividad", "Ciencias Económico Administrativas", "Guanajuato"));
        offersGuanajuato.add(new Offer("Administración de Recursos Turísticos", "Ciencias Económico Administrativas", "Guanajuato"));
        offersGuanajuato.add(new Offer("Administración Pública", "Derecho, Política y Gobierno", "Guanajuato"));
        offersGuanajuato.add(new Offer("Arquitectura", "Arquitectura, Arte y Diseño", "Guanajuato"));
        offersGuanajuato.add(new Offer("Artes Escénicas", "Arquitectura, Arte y Diseño", "Guanajuato"));
        offersGuanajuato.add(new Offer("Artes Visuales", "Arquitectura, Arte y Diseño", "Guanajuato"));
        offersGuanajuato.add(new Offer("Biología Experimental", "Ciencias Naturales y Exactas", "Guanajuato"));
        offersGuanajuato.add(new Offer("Ciencia Política", "Derecho, Política y Gobierno", "Guanajuato"));
        offersGuanajuato.add(new Offer("Comercio Internacional", "Ciencias Económico Administrativas", "Guanajuato"));
        offersGuanajuato.add(new Offer("Computación", "Ciencias Naturales y Exactas", "Guanajuato"));
        offersGuanajuato.add(new Offer("Contador Público", "Ciencias Económico Administrativas", "Guanajuato"));
        offersGuanajuato.add(new Offer("Derecho", "Derecho, Política y Gobierno", "Guanajuato"));
        offersGuanajuato.add(new Offer("Diseño de Interiores", "Arquitectura, Arte y Diseño", "Guanajuato"));
        offersGuanajuato.add(new Offer("Diseño Gráfico", "Arquitectura, Arte y Diseño", "Guanajuato"));
        offersGuanajuato.add(new Offer("Economía", "Ciencias Económico Administrativas", "Guanajuato"));
        offersGuanajuato.add(new Offer("Educación", "Ciencias Sociales y Humanidades", "Guanajuato"));
        offersGuanajuato.add(new Offer("Enseñanza del Español como Segunda Lengua", "Ciencias Sociales y Humanidades", "Guanajuato"));
        offersGuanajuato.add(new Offer("Enseñanza del Inglés", "Ciencias Sociales y Humanidades", "Guanajuato"));
        offersGuanajuato.add(new Offer("Filosofía", "Ciencias Sociales y Humanidades", "Guanajuato"));
        offersGuanajuato.add(new Offer("Geografía", "Ingenierías", "Guanajuato"));
        offersGuanajuato.add(new Offer("Historia", "Ciencias Sociales y Humanidades", "Guanajuato"));
        offersGuanajuato.add(new Offer("Ingeniería Ambiental", "Ingenierías", "Guanajuato"));
        offersGuanajuato.add(new Offer("Ingeniería Civil", "Ingenierías", "Guanajuato"));
        offersGuanajuato.add(new Offer("Ingeniería en Minas", "Ingenierías", "Guanajuato"));
        offersGuanajuato.add(new Offer("Ingeniero Geólogo", "Ingenierías", "Guanajuato"));
        offersGuanajuato.add(new Offer("Ingeniería Geomática", "Ingenierías", "Guanajuato"));
        offersGuanajuato.add(new Offer("Ingeniería Hidráulica", "Ingenierías", "Guanajuato"));
        offersGuanajuato.add(new Offer("Ingeniería Metalúrgica", "Ingenierías", "Guanajuato"));
        offersGuanajuato.add(new Offer("Ingeniería Química", "Ciencias Naturales y Exactas", "Guanajuato"));
        offersGuanajuato.add(new Offer("Letras Españolas", "Ciencias Sociales y Humanidades", "Guanajuato"));
        offersGuanajuato.add(new Offer("Matemáticas", "Ciencias Naturales y Exactas", "Guanajuato"));
        offersGuanajuato.add(new Offer("Música Cantante", "Arquitectura, Arte y Diseño", "Guanajuato"));
        offersGuanajuato.add(new Offer("Música Composición", "Arquitectura, Arte y Diseño", "Guanajuato"));
        offersGuanajuato.add(new Offer("Música Educación Musical", "Arquitectura, Arte y Diseño", "Guanajuato"));
        offersGuanajuato.add(new Offer("Música Instrumentista", "Arquitectura, Arte y Diseño", "Guanajuato"));
        offersGuanajuato.add(new Offer("Química", "Ciencias Naturales y Exactas", "Guanajuato"));
        offersGuanajuato.add(new Offer("Químico Farmacéutico Biólogo", "Ciencias Naturales y Exactas", "Guanajuato"));
        offersGuanajuato.add(new Offer("Relaciones Industriales", "Ciencias Económico Administrativas", "Guanajuato"));
        offersGuanajuato.add(new Offer("Sistemas de Información Administrativa", "Ciencias Económico Administrativas", "Guanajuato"));

        // Setup DAAD
        offersGuanajuatoDAAD.add(new Offer("Arquitectura", "Arquitectura, Arte y Diseño", "Guanajuato"));
        offersGuanajuatoDAAD.add(new Offer("Artes Escénicas", "Arquitectura, Arte y Diseño", "Guanajuato"));
        offersGuanajuatoDAAD.add(new Offer("Artes Visuales", "Arquitectura, Arte y Diseño", "Guanajuato"));
        offersGuanajuatoDAAD.add(new Offer("Diseño de Interiores", "Arquitectura, Arte y Diseño", "Guanajuato"));
        offersGuanajuatoDAAD.add(new Offer("Diseño Gráfico", "Arquitectura, Arte y Diseño", "Guanajuato"));
        offersGuanajuatoDAAD.add(new Offer("Música Cantante", "Arquitectura, Arte y Diseño", "Guanajuato"));
        offersGuanajuatoDAAD.add(new Offer("Música Composición", "Arquitectura, Arte y Diseño", "Guanajuato"));
        offersGuanajuatoDAAD.add(new Offer("Música Educación Musical", "Arquitectura, Arte y Diseño", "Guanajuato"));
        offersGuanajuatoDAAD.add(new Offer("Música Instrumentista", "Arquitectura, Arte y Diseño", "Guanajuato"));

        // Setup DCEA
        offersGuanajuatoDCEA.add(new Offer("Administración de la Calidad y la Productividad", "Ciencias Económico Administrativas", "Guanajuato"));
        offersGuanajuatoDCEA.add(new Offer("Administración de Recursos Turísticos", "Ciencias Económico Administrativas", "Guanajuato"));
        offersGuanajuatoDCEA.add(new Offer("Comercio Internacional", "Ciencias Económico Administrativas", "Guanajuato"));
        offersGuanajuatoDCEA.add(new Offer("Contador Público", "Ciencias Económico Administrativas", "Guanajuato"));
        offersGuanajuatoDCEA.add(new Offer("Economía", "Ciencias Económico Administrativas", "Guanajuato"));
        offersGuanajuatoDCEA.add(new Offer("Relaciones Industriales", "Ciencias Económico Administrativas", "Guanajuato"));
        offersGuanajuatoDCEA.add(new Offer("Sistemas de Información Administrativa", "Ciencias Económico Administrativas", "Guanajuato"));

        // Setup DCNE
        offersGuanajuatoDCNE.add(new Offer("Biología Experimental", "Ciencias Naturales y Exactas", "Guanajuato"));
        offersGuanajuatoDCNE.add(new Offer("Computación", "Ciencias Naturales y Exactas", "Guanajuato"));
        offersGuanajuatoDCNE.add(new Offer("Ingeniería Química", "Ciencias Naturales y Exactas", "Guanajuato"));
        offersGuanajuatoDCNE.add(new Offer("Matemáticas", "Ciencias Naturales y Exactas", "Guanajuato"));
        offersGuanajuatoDCNE.add(new Offer("Química", "Ciencias Naturales y Exactas", "Guanajuato"));
        offersGuanajuatoDCNE.add(new Offer("Químico Farmacéutico Biólogo", "Ciencias Naturales y Exactas", "Guanajuato"));

        // Setup DCSH
        offersGuanajuatoDCSH.add(new Offer("Educación", "Ciencias Sociales y Humanidades", "Guanajuato"));
        offersGuanajuatoDCSH.add(new Offer("Enseñanza del Español como Segunda Lengua", "Ciencias Sociales y Humanidades", "Guanajuato"));
        offersGuanajuatoDCSH.add(new Offer("Enseñanza del Inglés", "Ciencias Sociales y Humanidades", "Guanajuato"));
        offersGuanajuatoDCSH.add(new Offer("Filosofía", "Ciencias Sociales y Humanidades", "Guanajuato"));
        offersGuanajuatoDCSH.add(new Offer("Historia", "Ciencias Sociales y Humanidades", "Guanajuato"));
        offersGuanajuatoDCSH.add(new Offer("Letras Españolas", "Ciencias Sociales y Humanidades", "Guanajuato"));

        // Setup DDPG
        offersGuanajuatoDDPG.add(new Offer("Administración Pública", "Derecho, Política y Gobierno", "Guanajuato"));
        offersGuanajuatoDDPG.add(new Offer("Ciencia Política", "Derecho, Política y Gobierno", "Guanajuato"));
        offersGuanajuatoDDPG.add(new Offer("Derecho", "Derecho, Política y Gobierno", "Guanajuato"));

        // Setup DI
        offersGuanajuatoDI.add(new Offer("Geografía", "Ingenierías", "Guanajuato"));
        offersGuanajuatoDI.add(new Offer("Ingeniería Ambiental", "Ingenierías", "Guanajuato"));
        offersGuanajuatoDI.add(new Offer("Ingeniería Civil", "Ingenierías", "Guanajuato"));
        offersGuanajuatoDI.add(new Offer("Ingeniería en Minas", "Ingenierías", "Guanajuato"));
        offersGuanajuatoDI.add(new Offer("Ingeniero Geólogo", "Ingenierías", "Guanajuato"));
        offersGuanajuatoDI.add(new Offer("Ingeniería Geomática", "Ingenierías", "Guanajuato"));
        offersGuanajuatoDI.add(new Offer("Ingeniería Hidráulica", "Ingenierías", "Guanajuato"));
        offersGuanajuatoDI.add(new Offer("Ingeniería Metalúrgica", "Ingenierías", "Guanajuato"));

        /*//Setup Celaya-Salvatierra
        offersCelayaSalvatierra.add(new Offer("Administración", "", "Celaya-Salvatierra"));
        offersCelayaSalvatierra.add(new Offer("Administración de Negocios", "", "Celaya-Salvatierra"));
        offersCelayaSalvatierra.add(new Offer("Administración Financiera", "", "Celaya-Salvatierra"));
        offersCelayaSalvatierra.add(new Offer("Agronegocios", "", "Celaya-Salvatierra"));
        offersCelayaSalvatierra.add(new Offer("Contador Público", "", "Celaya-Salvatierra"));
        offersCelayaSalvatierra.add(new Offer("Desarrollo Regional", "", "Celaya-Salvatierra"));
        offersCelayaSalvatierra.add(new Offer("Enfermería y Obstetricia", "", "Celaya-Salvatierra"));
        offersCelayaSalvatierra.add(new Offer("Ingeniería Agroindustrial", "", "Celaya-Salvatierra"));
        offersCelayaSalvatierra.add(new Offer("Ingeniería Civil", "", "Celaya-Salvatierra"));
        offersCelayaSalvatierra.add(new Offer("Ingeniería en Biotecnología", "", "Celaya-Salvatierra"));
        offersCelayaSalvatierra.add(new Offer("Mercadotecnia", "", "Celaya-Salvatierra"));
        offersCelayaSalvatierra.add(new Offer("Nutrición", "", "Celaya-Salvatierra"));
        offersCelayaSalvatierra.add(new Offer("Psicología Clínica", "", "Celaya-Salvatierra"));
        offersCelayaSalvatierra.add(new Offer("Terapia Física y Rehabilitación", "", "Celaya-Salvatierra"));

        //Setup Irapuato-Salamanca
        offersIrapuatoSalamanca.add(new Offer("Agronegocios", "", "Irapuato-Salamanca"));
        offersIrapuatoSalamanca.add(new Offer("Artes Digitales", "", "Irapuato-Salamanca"));
        offersIrapuatoSalamanca.add(new Offer("Enfermería y Obstetricia", "", "Irapuato-Salamanca"));
        offersIrapuatoSalamanca.add(new Offer("Enseñanza del Inglés", "", "Irapuato-Salamanca"));
        offersIrapuatoSalamanca.add(new Offer("Gestión Empresarial", "", "Irapuato-Salamanca"));
        offersIrapuatoSalamanca.add(new Offer("Ingeniería Ambiental", "", "Irapuato-Salamanca"));
        offersIrapuatoSalamanca.add(new Offer("Ingeniería Eléctrica", "", "Irapuato-Salamanca"));
        offersIrapuatoSalamanca.add(new Offer("Ingeniería en Agronomía", "", "Irapuato-Salamanca"));
        offersIrapuatoSalamanca.add(new Offer("Ingeniería en Alimentos", "", "Irapuato-Salamanca"));
        offersIrapuatoSalamanca.add(new Offer("Ingeniería en Comunicaciones y Electrónica", "", "Irapuato-Salamanca"));
        offersIrapuatoSalamanca.add(new Offer("Ingeniería en Energías Renovables", "", "Irapuato-Salamanca"));
        offersIrapuatoSalamanca.add(new Offer("Ingeniería en Sistemas Computacionales", "", "Irapuato-Salamanca"));
        offersIrapuatoSalamanca.add(new Offer("Ingeniería Mecánica", "", "Irapuato-Salamanca"));
        offersIrapuatoSalamanca.add(new Offer("Ingeniería Mecánica Agrícola", "", "Irapuato-Salamanca"));
        offersIrapuatoSalamanca.add(new Offer("Ingeniería Mecatrónica", "", "Irapuato-Salamanca"));
        offersIrapuatoSalamanca.add(new Offer("Medicina Veterinaria y Zootecnia", "", "Irapuato-Salamanca"));

        //Setup Leon
        offers.add(new Offer("Administración", "", ""));
        offers.add(new Offer("Administración de la Calidad y la Productividad", "Ciencias Económico - Administrativas", "Guanajuato"));
        offers.add(new Offer("Administración de Negocios", "", ""));
        offers.add(new Offer("Administración Financiera", "", ""));
        offers.add(new Offer("Administración Pública", "", ""));
        offers.add(new Offer("Administración de Recursos Turísticos", "", ""));
        offers.add(new Offer("Agronegocios", "", ""));
        offers.add(new Offer("Antropología Social", "", ""));
        offers.add(new Offer("Arquitectura", "", ""));
        offers.add(new Offer("Artes Digitales", "", ""));
        offers.add(new Offer("Artes Escénicas", "", ""));
        offers.add(new Offer("Artes Visuales", "", ""));
        offers.add(new Offer("Biología Experimental", "", ""));
        offers.add(new Offer("Ciencia Política", "", ""));
        offers.add(new Offer("Ciencia Política y Administración Pública", "", ""));
        offers.add(new Offer("Ciencias de la Actividad Física y Salud", "", ""));
        offers.add(new Offer("Comercio Internacional", "", ""));
        offers.add(new Offer("Computación", "", ""));
        offers.add(new Offer("Contador Público", "", ""));
        offers.add(new Offer("Contador Público", "", ""));
        offers.add(new Offer("Cultura y Arte", "", ""));
        offers.add(new Offer("Derecho", "", ""));
        offers.add(new Offer("Desarrollo Regional", "", ""));
        offers.add(new Offer("Desarrollo y Gestión de Territorio", "", ""));
        offers.add(new Offer("Diseño de Interiores", "", ""));
        offers.add(new Offer("Diseño Gráfico", "", ""));
        offers.add(new Offer("Economía", "", ""));
        offers.add(new Offer("Educación", "", ""));
        offers.add(new Offer("Enfermería y Obstetricia", "", ""));
        offers.add(new Offer("Enfermería y Obstetricia", "", ""));
        offers.add(new Offer("Enfermería y Obstetricia", "", ""));
        offers.add(new Offer("Enfermería y Obstetricia", "", ""));
        offers.add(new Offer("Enfermería y Obstetricia", "", ""));
        offers.add(new Offer("Enfermería y Obstetricia", "", ""));
        offers.add(new Offer("Enseñanza del Español como Segunda Lengua", "", ""));
        offers.add(new Offer("Enseñanza del Inglés", "", ""));
        offers.add(new Offer("Enseñanza del Inglés", "", ""));
        offers.add(new Offer("Filosofía", "", ""));
        offers.add(new Offer("Física", "", ""));
        offers.add(new Offer("Gestión Empresarial", "", ""));
        offers.add(new Offer("Gestión Empresarial", "", ""));
        offers.add(new Offer("Historia", "", ""));
        offers.add(new Offer("Ingeniería Agroindustrial", "", ""));
        offers.add(new Offer("Ingeniería Ambiental", "", ""));
        offers.add(new Offer("Ingeniería Ambiental", "", ""));
        offers.add(new Offer("Ingeniería Ambiental", "", ""));
        offers.add(new Offer("Ingeniería Biomédica", "", ""));
        offers.add(new Offer("Ingeniería Civil", "", ""));
        offers.add(new Offer("Ingeniería Civil", "", ""));
        offers.add(new Offer("Ingeniería Eléctrica", "", ""));
        offers.add(new Offer("Ingeniería Eléctrica", "", ""));//*/
    }
}