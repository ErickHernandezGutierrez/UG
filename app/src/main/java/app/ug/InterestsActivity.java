package app.ug;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ProgressBar;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by vanessa on 5/7/17. */

public class InterestsActivity extends Activity  {
    static int NUM_QUESTIONS = 6; static int NUM_AREAS = 10; static float MAX_POINT = 24 ;

    RadioGroup radioGroupI ; // RadioGroup para las respuestas
    Button btnSig, btnPrev, btnPrevResults, btnSigResults ;
    //ProgressBar variables
    ProgressBar question_progress = null ; int progressStatus = 0;
    // TextView para pregunta y vars auxiliares
    TextView question ; int checkedOption = -1 ;
    // Matrices de preguntas y respuestas, dimensiones
    int[] resultados = new int[NUM_AREAS] ;
    Integer[] sortedPair = {0,1,2,3,4,5,6,7,8,9};
    public String[][] preguntas = new String[NUM_QUESTIONS][NUM_AREAS] ;
    public int[][] respuestas = new int[NUM_QUESTIONS][NUM_AREAS] ;
    int questionIndex = 0; int areaIndex = 0;
    // TextView para resultados y RatingBar
    String[] areas = new String[NUM_AREAS] ;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);

        // Inicializar Matriz de preguntas
        preguntas[0][0] = "Atender y cuidar enfermos";  preguntas[0][1] = "Intervenir activamente en las discusiones de clase";
        preguntas[0][2] = "Escribir cuentos, crónicas o artículos";     preguntas[0][3] = "Dibujar o pintar";
        preguntas[0][4] = "Cantar en un coro estudiantil" ;     preguntas[0][5] = "Llevar en orden tus libros y cuadernos" ;
        preguntas[0][6] = "Conocer y estudiar la estructura de las plantas y de los animales" ;      preguntas[0][7] = "Resolver mecanizaciones numéricas" ;
        preguntas[0][8] = "Armar o desarmar objetos mecánicos" ;     preguntas[0][9] = "Salir de excursión";  preguntas[1][0] = "Proteger a los muchachos menores del grupo";
        preguntas[1][1] = "Ser jefe de un grupo" ;   preguntas[1][2] = "Leer obras literarias" ; preguntas[1][3] = "Moldear el barro, la plastilina o cualquier otro material" ;
        preguntas[1][4] = "Escuchar música clásica" ;  preguntas[1][5] = "Ordenar y clasificar libros de una biblioteca" ;
        preguntas[1][6] = "Hacer experimentos en un laboratorio" ;   preguntas[1][7] = "Resolver problemas de aritmética" ;
        preguntas[1][8] = "Manejar herramientas y maquinaria" ;   preguntas[1][9] = "Pertenecer a un club de exploradores" ;
        preguntas[2][0] = "Ser miembro de una sociedad de ayuda y asistencia" ;  preguntas[2][1] = "Dirigir la campaña política para un candidato estudiantil";
        preguntas[2][2] = "Hacer versos para una publicación";   preguntas[2][3] = "Encargarte del decorado del lugar para un festival";
        preguntas[2][4] = "Aprender a tocar un instrumento musical";   preguntas[2][5] = "Aprender a escribir a máquina y en taquigrafía";
        preguntas[2][6] = "Investigar el origen de las costumbres de los pueblos";  preguntas[2][7] = "Llevar las cuentas de una institución";
        preguntas[2][8] = "Construir objetos o muebles";    preguntas[2][9] = "Trabajar al aire libre, fuera de la ciudad";
        preguntas[3][0] = "Enseñar a leer a los analfabetos";     preguntas[3][1] = "Hacer propaganda para la difusión de una idea";
        preguntas[3][2] = "Representar un papel en una obra de teatro";  preguntas[3][3] = "Idear y diseñar el escudo de un club o sociedad";
        preguntas[3][4] = "Ser miembro de una asociación musical";    preguntas[3][5] = "Ayudar a calificar pruebas";
        preguntas[3][6] = "Estudiar y entender las causas de los movimientos sociales";   preguntas[3][7] = "Explicar a otros como resolver problemas de matemáticas";
        preguntas[3][8] = "Reparar las instalaciones eléctricas, de gas o de plomería en tu casa";
        preguntas[3][9] = "Sembrar y plantar en una granja durante las vacaciones";
        preguntas[4][0] = "Ayudar a tus compañeros en sus dificultades y preocupaciones";  preguntas[4][1] = "Leer biografías de políticos eminentes";
        preguntas[4][2] = "Participar en un concurso de oratoria";  preguntas[4][3] = "Diseñar el vestuario para una función teatral";
        preguntas[4][4] = "Leer biografías de músicos eminentes"; preguntas[4][5] = "Encargarte del archivo y los documentos de una sociedad";
        preguntas[4][6] = "Leer revistas y libros científicos"; preguntas[4][7] = "Participar en concursos de matemáticas";
        preguntas[4][8] = "Proyectar y dirigir alguna construcción";    preguntas[4][9] = "Atender animales en un rancho durante las vacaciones";
        preguntas[5][0] = "Trabajar como funcionario al servicio de las clases humildes";
        preguntas[5][1] = "Trabajar como experto en relaciones sociales de una gran empresa";
        preguntas[5][2] = "Trabajar como escritor en un periódico o empresa editorial";   preguntas[5][3] = "Trabajar como dibujante profesional en una empresa";
        preguntas[5][4] = "Trabajar como concertista en una sinfónica";  preguntas[5][5] = "Trabajar como técnico organizador de oficinas";
        preguntas[5][6] = "Investigar en un laboratorio"; preguntas[5][7] = "Trabajar como experto calculista en una institución";
        preguntas[5][8] = "Trabajar como perito mecánico en un taller"; preguntas[5][9] = "Trabajar como técnico, cuyas actividades se desempeñan fuera de la ciudad";

        // Inicializar matriz de respuestas
        for (int k=0; k<NUM_QUESTIONS; k++){
            for (int j=0; j<NUM_AREAS; j++)
                respuestas[k][j] = -1 ;
        }
        //Inicializar arreglo de areas
        areas[0] = "Servicio Social"; areas[1] = "Ejecutivo Persuasivo"; areas[2] = "Verbal"; areas[3] = "Artístico Plástico"; areas[4] = "Musical";
        areas[5] = "Organización"; areas[6] = "Científico";areas[7] = "Cálculo"; areas[8] = "Mecánico Constructivo"; areas[9] = "Trabajo al aire libre";

        //Cambiar font a titulo y pregunta
        TextView title = (TextView) findViewById(R.id.questionI_title); title.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView question = (TextView) findViewById(R.id.questions);question.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        //Cambiar font a respuestas
        TextView ans1 = (TextView) findViewById(R.id.ansI1); ans1.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView ans2 = (TextView) findViewById(R.id.ansI2); ans2.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView ans3 = (TextView) findViewById(R.id.ansI3); ans3.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView ans4 = (TextView) findViewById(R.id.ansI4); ans4.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView ans5 = (TextView) findViewById(R.id.ansI5); ans5.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));

        // Barra de progreso
        question_progress = (ProgressBar)findViewById(R.id.progress_questions) ;
        question_progress.setMax(NUM_AREAS * NUM_QUESTIONS);
        question_progress.getProgressDrawable().setColorFilter(Color.rgb(255,204,51), android.graphics.PorterDuff.Mode.SRC_IN);
        // Actividades
        questionsAndAnswers();
    }

    private void updateProgressBar(int progressStatus) {
        // Barra de progreso
        question_progress.setProgress(progressStatus + 1);
        Log.d("bar", " " + progressStatus + 1);
    }

    private void loadQuestion(int areaIndex, int questionIndex) {
        Log.d("Pregunta", " "+preguntas[questionIndex][areaIndex]) ;
        // Modificar la pregunta
        TextView question = (TextView) findViewById(R.id.questions); question.setText(preguntas[questionIndex][areaIndex]);
        //ProgressBar
        updateProgressBar(questionIndex * NUM_AREAS + areaIndex);
    }

    private void loadNextQuestion() {
        areaIndex ++;
        if (areaIndex >= NUM_AREAS) {
            areaIndex = 0;
            questionIndex ++;
            if (questionIndex >= NUM_QUESTIONS) {
                computeResults();
                loadResults();
                return ;
            }
        }
        loadQuestion(areaIndex, questionIndex);
    }

    private void loadPrevQuestion() {
        if (areaIndex == 0 && questionIndex == 0) {
            Toast.makeText(getApplicationContext(), "Estás en la primer pregunta", Toast.LENGTH_SHORT).show();
            return;
        }
        areaIndex --;
        if (areaIndex < 0) {
            areaIndex = NUM_AREAS - 1;
            questionIndex --;
        }
        loadQuestion(areaIndex, questionIndex);
    }

    private void saveAnswer() {
        if (checkedOption >= 0 && checkedOption <= 4) {
            respuestas[questionIndex][areaIndex] = 4 - checkedOption;
        }
        Log.d("saveAnswer().respuestas", ""+ Arrays.deepToString(respuestas));
    }

    private boolean hasAnswer() {
        return respuestas[questionIndex][areaIndex] != -1;
    }

    private void loadAnswer() {
        Log.d("loadAnswer().respuestas", ""+ Arrays.deepToString(respuestas));
        clearListenerOnRadioButton();
        RadioButton radioButton = null;
        switch(respuestas[questionIndex][areaIndex]) {
            case 4:
                radioButton = (RadioButton) findViewById(R.id.ansI1);
                break;
            case 3:
                radioButton = (RadioButton) findViewById(R.id.ansI2);
                break;
            case 2:
                radioButton = (RadioButton) findViewById(R.id.ansI3);
                break;
            case 1:
                radioButton = (RadioButton) findViewById(R.id.ansI4);
                break;
            case 0:
                radioButton = (RadioButton) findViewById(R.id.ansI5);
                break;
            case -1:
                radioGroupI.clearCheck();
                break;
            default:
                throw new RuntimeException();
        }
        if (radioButton != null) {
            radioButton.setChecked(true);
        }
        addListenerOnRadioButton();
    }

    public void questionsAndAnswers() {
        loadQuestion(areaIndex, questionIndex);
        addListenerOnRadioButton();
        //Esperar al Boton Siguiente
        addListenerOnButton();
    }

    public void clearListenerOnRadioButton() {
        radioGroupI = (RadioGroup) findViewById(R.id.answers_intereses);
        radioGroupI.setOnCheckedChangeListener(null);
    }

    public void addListenerOnRadioButton() {
        radioGroupI = (RadioGroup) findViewById(R.id.answers_intereses);
        radioGroupI.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroupI.findViewById(checkedId);
                int index = radioGroupI.indexOfChild(radioButton);
                checkedOption = index;
                Log.d("checkOption: ", "" + checkedOption);
                saveAnswer();
            }
        });
    }

    public void addListenerOnButton() {
        btnSig = (Button) findViewById(R.id.btnSig);
        btnPrev = (Button) findViewById(R.id.btnPrev);
        // Realizar accion al presionar siguiente
        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("hasAnswer(): ", "" + hasAnswer());
                if (!hasAnswer())
                    Toast.makeText(getApplicationContext(), "Elige una opción para seguir", Toast.LENGTH_SHORT).show();
                else {
                    loadNextQuestion();
                    if (questionIndex < NUM_QUESTIONS) {
                        loadAnswer();
                    }
                }
            }
        });
        // Actividad anterior
        btnPrev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d("btnPrev.onClick(): ", "" + areaIndex + " " + questionIndex);
                loadPrevQuestion();
                loadAnswer();
                //onBackPressed();
            }
        });
    }

    private void computeResults() {
        for ( int l = 0; l < NUM_AREAS; l++ ) {
            int sum = 0;
            for ( int k = 0; k < NUM_QUESTIONS; k++ )
                sum = sum + respuestas[k] [l];
            resultados[l] = sum ;
            Log.d("puntaje", ""+resultados[l]);
        }
        Arrays.sort(sortedPair, new Comparator<Integer>() {
            @Override public int compare(final Integer o1, final Integer o2) {
                return resultados[o2] - resultados[o1];
            }
        });
        Log.d("sort", ""+ Arrays.toString(sortedPair));
    }

    public void addListenerOnButtonResults() {
        btnSigResults = (Button) findViewById(R.id.btnSigResults);
        // Realizar accion al presionar siguiente
        btnSigResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InterestsActivity.this, WelcomeAptitudesActivity.class);
                i.putExtra("max1", Integer.valueOf(sortedPair[0]));
                i.putExtra("max2", Integer.valueOf(sortedPair[1]));
                i.putExtra("max3", Integer.valueOf(sortedPair[2]));
                Log.d("indice enviado", ""+resultados[sortedPair[0]]);
                startActivity(i);
            }
        });
    }

    public void loadResults() {
        String intereses = "Resultados: Intereses" ;
        //ir al layout de respuestas
        setContentView(R.layout.slide_results);
        //cambiar font a resultados
        TextView titulo_resultados = (TextView) findViewById(R.id.results_title); titulo_resultados.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView area1 = (TextView) findViewById(R.id.area1); area1.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView area2 = (TextView) findViewById(R.id.area2); area2.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView area3 = (TextView) findViewById(R.id.area3); area3.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView area4 = (TextView) findViewById(R.id.area4); area4.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView area5 = (TextView) findViewById(R.id.area5); area5.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView area6 = (TextView) findViewById(R.id.area6); area6.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView area7 = (TextView) findViewById(R.id.area7); area7.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView area8 = (TextView) findViewById(R.id.area8); area8.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView area9 = (TextView) findViewById(R.id.area9); area9.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView area10 = (TextView) findViewById(R.id.area10); area10.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        // Configurar los nombres
        titulo_resultados.setText(intereses);
        area1.setText(areas[0]); area2.setText(areas[1]); area3.setText(areas[2]); area4.setText(areas[3]); area5.setText(areas[4]);
        area6.setText(areas[5]); area7.setText(areas[6]); area8.setText(areas[7]); area9.setText(areas[8]); area10.setText(areas[9]);
        //Ratingbars, configurar su relleno
        RatingBar rating1 = (RatingBar) findViewById(R.id.rating1); rating1.setRating((resultados[0]*rating1.getNumStars())/MAX_POINT);
        RatingBar rating2 = (RatingBar) findViewById(R.id.rating2); rating2.setRating((resultados[1]*rating2.getNumStars())/MAX_POINT);
        RatingBar rating3 = (RatingBar) findViewById(R.id.rating3); rating3.setRating((resultados[2]*rating3.getNumStars())/MAX_POINT);
        RatingBar rating4 = (RatingBar) findViewById(R.id.rating4); rating4.setRating((resultados[3]*rating4.getNumStars())/MAX_POINT);
        RatingBar rating5 = (RatingBar) findViewById(R.id.rating5); rating5.setRating((resultados[4]*rating5.getNumStars())/MAX_POINT);
        RatingBar rating6 = (RatingBar) findViewById(R.id.rating6); rating6.setRating((resultados[5]*rating6.getNumStars())/MAX_POINT);
        RatingBar rating7 = (RatingBar) findViewById(R.id.rating7); rating7.setRating((resultados[6]*rating7.getNumStars())/MAX_POINT);
        RatingBar rating8 = (RatingBar) findViewById(R.id.rating8); rating8.setRating((resultados[7]*rating8.getNumStars())/MAX_POINT);
        RatingBar rating9 = (RatingBar) findViewById(R.id.rating9); rating9.setRating((resultados[8]*rating9.getNumStars())/MAX_POINT);
        RatingBar rating10 = (RatingBar) findViewById(R.id.rating10);  rating10.setRating((resultados[9]*rating10.getNumStars())/MAX_POINT);
        Log.d("num stars", ""+rating1.getNumStars());
        //add listener to new buttons
        addListenerOnButtonResults();
    }
}