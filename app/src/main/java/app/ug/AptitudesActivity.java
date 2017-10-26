package app.ug;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.LayerDrawable;
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

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * Created by vanessa on 5/7/17. */

public class AptitudesActivity extends Activity  {
    static int NUM_QUESTIONS = 6; static int NUM_AREAS = 10; static float MAX_POINT = 24;

    RadioGroup radioGroupA ;
    Button btnSig, btnPrev, btnPrevResults, btnSigResults ;
    //ProgressBar variables
    ProgressBar question_progress = null ;
    int progressStatus = 0;
    // TextView para pregunta y vars auxiliares
    TextView question ; int checkedOption = -1 ;
    // Matrices de preguntas y respuestas, dimensiones
    int[] resultados = new int[NUM_AREAS] ;
    Integer[] sortedPair = {0,1,2,3,4,5,6,7,8,9};
    public String[][] preguntas = new String[NUM_QUESTIONS][NUM_AREAS] ;
    public int[][] respuestas = new int[NUM_QUESTIONS][NUM_AREAS] ;
    int questionIndex = 0;  int areaIndex = 0;
    // TextView para resultados y RatingBar
    String[] areasA = new String[NUM_AREAS] ; String[] areasI = new String[NUM_AREAS] ;
    // Bundle para la segunda parte
    //Matriz para imprimir las principales areas
    public String[][]  recomendacion = new String[NUM_AREAS][NUM_AREAS] ;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aptitudes);

        // Inicializar Matriz de preguntas
        preguntas[0][0] = "Tratar y hablar con tacto y tino a las personas"; preguntas[0][1] = "Ser jefe competente de un grupo, equipo o sociedad";
        preguntas[0][2] = "Expresarte con facilidad en clase o al platicar con tus amigos"; preguntas[0][3] = "Dibujar casas, objetos, figuras humanas, etc.";
        preguntas[0][4] = "Cantar en un grupo";   preguntas[0][5] = "Llevar en forma correcta y ordenada los apuntes de clase";
        preguntas[0][6] = "Entender principios y experimentos de Biología"; preguntas[0][7] = "Ejecutar con rapidez y exactitud mecanizaciones aritméticas";
        preguntas[0][8] = "Armar y componer objetos mecánicos como chapas, timbres, etc."; preguntas[0][9] = "Actividades que requieren destreza manual";
        preguntas[1][0] = "Ser miembro activo y útil en un club o sociedad";
        preguntas[1][1] = "Organizar y dirigir festivales, encuentros deportivos, excursiones o campañas sociales";
        preguntas[1][2] = "Redactar composiciones o artículos periodísticos"; preguntas[1][3] = "Pintar paisajes";   preguntas[1][4] = "Tocar un instrumento musical";
        preguntas[1][5] = "Ordenar y clasificar debidamente documentos en una oficina";  preguntas[1][6] = "Entender principios y experimentos de Física";
        preguntas[1][7] = "Resolver problemas de aritmética";  preguntas[1][8] = "Desarmar, armar y componer objetos complicados";
        preguntas[1][9] = "Manejar con habilidad herramientas de carpintería";    preguntas[2][0] = "Colaborar con otros para el bien de la comunidad";
        preguntas[2][1] = "Convencer a otros para que hagan lo que crees que deben hacer";  preguntas[2][2] = "Componer versos serios o jocosos";
        preguntas[2][3] = "Decorar artísticamente un salón, corredor, escenario o patio para un festival";
        preguntas[2][4] = "Distinguir cuando alguien desentona en las canciones o piezas musicales";  preguntas[2][5] = "Contestar y redactar correctamente oficios y cartas";
        preguntas[2][6] = "Entender principios y experimentos de Química"; preguntas[2][7] = "Resolver rompecabezas numéricos";
        preguntas[2][8] = "Resolver rompecabezas de alambre o de madera"; preguntas[2][9] = "Manejar con facilidad herramientas mecánicas como pinzas, llaves de tuercas, desarmador, etc.";
        preguntas[3][0] = "Saber escuchar a los otros con paciencia y comprender su punto de vista"; preguntas[3][1] = "Dar órdenes a otros con paciencia y comprender su punto de vista";
        preguntas[3][2] = "Escribir cuentos, narraciones o historietas"; preguntas[3][3] = "Modelar con barro, plastilina o grabar madera";
        preguntas[3][4] = "Entonar correctamente las canciones de moda";  preguntas[3][5] = "Anotar y manejar con exactitud y rapidez los nombres, números y otros datos";
        preguntas[3][6] = "Entender principios y hechos económicos y sociales";    preguntas[3][7] = "Resolver problemas de álgebra";
        preguntas[3][8] = "Armar y componer muebles"; preguntas[3][9] = "Manejar con habilidad pequeñas piezas y herramientas como agujas, manecillas, joyas, piezas de relojería, etc.";
        preguntas[4][0]= "Conversar en las reuniones y fiestas con acierto y naturalidad"; preguntas[4][1]= "Dirigir un grupo o equipo en situaciones difíciles o peligrosas";
        preguntas[4][2]= "Distinguir y apreciar la buena literatura";  preguntas[4][3]= "Distinguir y apreciar la buena pintura";
        preguntas[4][4]= "Distinguir y apreciar la buena música"; preguntas[4][5]= "Encargarse de recibir, anotar y dar recados sin olvidar detalles importantes";
        preguntas[4][6]= "Entender las causas que determinan los acontecimientos históricos";     preguntas[4][7]= "Resolver problemas de geometría";
        preguntas[4][8]= "Aprender el funcionamiento de ciertos mecanismos complicados como motores, relojes, bombas, etc.";
        preguntas[4][9]= "Hacer con facilidad trazos geométricos con la ayuda de las escuadras, la regla T y el compás";
        preguntas[5][0] = "Actuar con desinterés y condolencia"; preguntas[5][1] = "Corregir a los demás sin ofenderlos";
        preguntas[5][2] = "Exponer juicios públicamente sin preocupación por la crítica";
        preguntas[5][3] = "Colaborar en la elaboración de un libro sobre el arte en la Arquitectura"; preguntas[5][4] = "Dirigir un conjunto musical";
        preguntas[5][5] = "Colaborar en el desarrollo de métodos más eficientes de trabajo";
        preguntas[5][6] = "Realizar investigaciones científicas teniendo como finalidad la búsqueda de la verdad";
        preguntas[5][7] = "Enseñar a resolver problemas de matemáticas"; preguntas[5][8] = "Inducir a las personas a obtener resultados prácticos";
        preguntas[5][9] = "Participar en un concurso de modelismo de coches, aviones, barcos, etc.";

        // Inicializar matriz de respuestas
        for (int k=0; k<NUM_QUESTIONS; k++){
            for (int j=0; j<NUM_AREAS; j++)
                respuestas[k][j] = -1 ;
        }
        //Inicializar arreglo de areas
        areasA[0] = "Servicio Social"; areasA[1] = "Ejecutivo Persuasiva"; areasA[2] = "Verbal"; areasA[3] = "Artístico Plástica"; areasA[4] = "Musical";
        areasA[5] = "Organización"; areasA[6] = "Científica"; areasA[7] = "Cálculo"; areasA[8] = "Mecánico Constructiva"; areasA[9] = "Destreza Manual";

        areasI[0] = "Servicio Social"; areasI[1] = "Ejecutivo Persuasivo"; areasI[2] = "Verbal"; areasI[3] = "Artístico Plástico"; areasI[4] = "Musical";
        areasI[5] = "Organización"; areasI[6] = "Científico";areasI[7] = "Cálculo"; areasI[8] = "Mecánico Constructivo"; areasI[9] = "Trabajo al aire libre";

        //Inicializar recomendacion
        recomendacion[0][0] = "Educación, Enseñanza del Español como Segunda Lengua, Enseñanza del Inglés y Enfermería.";
        recomendacion[0][1] = "Ciencias Políticas, Administración Pública, Relaciones Internacionales, Derecho, Enseñanza del Inglés y Enfermería.";
        recomendacion[0][2] = "Derecho, Letras Clásicas, Lenguas y Literatura Hispánicas y Enseñanza del Inglés.";
        recomendacion[0][3] = "Diseño Gráfico, Urbanismo y Arquitectura."; recomendacion[0][4] = "Composición, Instrumentación, Piano, Canto y Educación Musical.";
        recomendacion[0][5] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[0][6] = "QFB, Biología, Enfermería, Ciencias Políticas, Historia y Filosofía.";
        recomendacion[0][7] = "Economía, Arquitectura y Ingeniería Civil.";
        recomendacion[0][8] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[0][9] = "Sociología, Medicina Veterinaria y Zootecnia y Biología";
        recomendacion[1][0] = "Ciencias Políticas, Administración Pública, Relaciones Internacionales, Derecho, Enseñanza del Inglés y Enfermería.";
        recomendacion[1][1] = "Comercio Internacional, Derecho y Relaciones Industriales.";
        recomendacion[1][2] = "Relaciones Internacionales, Derecho, Letras, Enseñanza del Inglés y Ciencias Políticas.";
        recomendacion[1][3] = "Diseño Gráfico y Comunicación Gráfica."; recomendacion[1][4] = "Educación Musical y Etnomusicología.";
        recomendacion[1][5] = "Economía, Administración Pública, Relaciones Internacionales y Contaduría.";
        recomendacion[1][6] = "Medicina, Enfermería, Ciencias Políticas y Sociología."; recomendacion[1][7] = "Economía, Administración, Administración Pública y Contaduría.";
        recomendacion[1][8] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[1][9] = "Planificación para el desarrollo Agropecuario y Trabajo Social.";
        recomendacion[2][0] = "Derecho, Letras Clásicas, Lenguas y Literatura Hispánicas y Enseñanza del Inglés.";
        recomendacion[2][1] = "Relaciones Internacionales, Derecho, Letras, Enseñanza del Inglés y Ciencias Políticas.";
        recomendacion[2][2] = "Enseñanza del Español como Segunda Lengua, Enseñanza del Inglés y Letras Españolas.";  recomendacion[2][3] = "Artes Visuales y Literatura.";
        recomendacion[2][4] = "Composición y Educación Musical.";  recomendacion[2][5] = "Relaciones Internacionales";
        recomendacion[2][6] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[2][7] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[2][8] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[2][9] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[3][0] = "Diseño Gráfico, Urbanismo y Arquitectura."; recomendacion[3][1] = "Diseño Gráfico y Comunicación Gráfica.";
        recomendacion[3][2] = "Artes Visuales y Literatura."; recomendacion[3][3] = "Diseño de Interiores, Diseño Gráfico, Arquitectura, Artes Escénicas y Artes Visuales.";
        recomendacion[3][4] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[3][5] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[3][6] = "Urbanismo y Arquitectura.";  recomendacion[3][7] = "Arquitectura y Ingeniería Civil.";
        recomendacion[3][8] = "Arquitectura, Urbanismo."; recomendacion[3][9] = "Arquitectura y Urbanismo.";
        recomendacion[4][0] = "Composición, Instrumentación, Piano, Canto y Educación Musical.";
        recomendacion[4][1] = "Educación Musical y Etnomusicología."; recomendacion[4][2] = "Composición y Educación Musical.";
        recomendacion[4][3] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[4][4] = "Música Cantante, Música Composición, Educación Musical y Música Instrumentista.";
        recomendacion[4][5] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[4][6] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[4][7] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[4][8] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[4][9] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[5][0] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[5][1] = "Economía, Administración Pública, Relaciones Internacionales y Contaduría.";
        recomendacion[5][2] = "Relaciones Internacionales";
        recomendacion[5][3] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[5][4] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[5][5] = "Administración de la Calidad y la Productividad,Administración de Recursos Turísticos y Administración Pública.";
        recomendacion[5][6] = "Matemáticas, Computación, Biología, Ingeniería Química, Química, QFB, Medicina, Historia y Ingeniería Metalúrgica.";
        recomendacion[5][7] = "Computación, Matemáticas, Química, Ingeniería Química, QFB, Economía, Contaduría y Administración.";
        recomendacion[5][8] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[5][9] = "Ingeniería Agrícola, Medicina Veterinaria y Zootecnia.";
        recomendacion[6][0] = "QFB, Biología, Enfermería, Ciencias Políticas, Historia y Filosofía.";
        recomendacion[6][1] = "Medicina, Enfermería, Ciencias Políticas y Sociología."; recomendacion[6][2] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[6][3] = "Urbanismo y Arquitectura.";
        recomendacion[6][4] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[6][5] = "Matemáticas, Computación, Biología, Ingeniería Química, Química, QFB, Medicina, Historia y Ingeniería Metalúrgica.";
        recomendacion[6][6] = "Filosofía, Historia, Biología Experimental,  Ciencia Política, Computación, Matemáticas, Química y QFB.";
        recomendacion[6][7] = "Física, Computación, Ingeniería Geológica, Ingeniería de Minas, Matemáticas, Ingeniería Química, QFB, Química y Ingeniería Civil.";
        recomendacion[6][8] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[6][9] = "Ingeniería Agrícola, Medicina Veterinaria y Zootecnia, Biología e Ingeniería de Minas.";
        recomendacion[7][0] = "Economía, Arquitectura y Ingeniería Civil."; recomendacion[7][1] = "Economía, Administración, Administración Pública y Contaduría.";
        recomendacion[7][2] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[7][3] = "Arquitectura e Ingeniería Civil.";
        recomendacion[7][4] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[7][5] = "Computación, Matemáticas, Química, Ingeniería Química, QFB, Economía, Contaduría y Administración.";
        recomendacion[7][6] = "Física, Computación, Ingeniería Geológica, Ingeniería de Minas, Matemáticas, Ingeniería Química, QFB, Química y Ingeniería Civil.";
        recomendacion[7][7] = "Economía y Contador Público.";
        recomendacion[7][8] = "Arquitectura, Física, Ingeniería Civil, Ingeniería de Minas, Ingeniería Química e Ingeniería Mecánica.";
        recomendacion[7][9] = "Ingeniería Agrícola, Arquitectura, Ingeniería Civil, Ingeniería Mecánica e Ingeniería de Minas.";
        recomendacion[8][0] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[8][1] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[8][2] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[8][3] = "Arquitectura y Urbanismo.";
        recomendacion[8][4] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[8][5] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[8][6] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[8][7] = "Arquitectura, Física, Ingeniería Civil, Ingeniería de Minas, Ingeniería Química e Ingeniería Mecánica.";
        recomendacion[8][8] =  "Ingeniería Ambiental, Ingeniería Civil e Ingeniería en Minas.";
        recomendacion[8][9] = "Ingeniería Civil, Ingeniería Mecánica e Ingeniería de Minas."; recomendacion[9][0] = "Sociología, Medicina Veterinaria y Zootecnia y Biología";
        recomendacion[9][1] = "Planificación para el desarrollo Agropecuario y Trabajo Social.";
        recomendacion[9][2] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[9][3] = "Arquitectura y Urbanismo.";  recomendacion[9][4] = "Lo sentimos no tenemos una recomendación pues tu caso no está considerado en este examen.";
        recomendacion[9][5] = "Ingeniería Agrícola, Medicina Veterinaria y Zootecnia.";
        recomendacion[9][6] = "Ingeniería Agrícola, Medicina Veterinaria y Zootecnia, Biología, Ingeniería de Minas.";
        recomendacion[9][7] = "Ingeniería Agrícola, Arquitectura, Ingeniería Civil, Ingeniería Mecánica e Ingeniería de Minas.";
        recomendacion[9][8] = "Ingeniería Civil, Ingeniería Mecánica e Ingeniería de Minas.";  recomendacion[9][9] = "Geografía, Ingeniero Geólogo y Ingeniería Geomática.";

        //Cambiar font a titulo y pregunta
        TextView title = (TextView) findViewById(R.id.questionA_title); title.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView question = (TextView) findViewById(R.id.questions); question.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        //Cambiar font a respuestas
        TextView ans1 = (TextView) findViewById(R.id.ansA1); ans1.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView ans2 = (TextView) findViewById(R.id.ansA2); ans2.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView ans3 = (TextView) findViewById(R.id.ansA3); ans3.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView ans4 = (TextView) findViewById(R.id.ansA4); ans4.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView ans5 = (TextView) findViewById(R.id.ansA5); ans5.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));

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
        // clean radio button
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
                radioButton = (RadioButton) findViewById(R.id.ansA1);
                break;
            case 3:
                radioButton = (RadioButton) findViewById(R.id.ansA2);
                break;
            case 2:
                radioButton = (RadioButton) findViewById(R.id.ansA3);
                break;
            case 1:
                radioButton = (RadioButton) findViewById(R.id.ansA4);
                break;
            case 0:
                radioButton = (RadioButton) findViewById(R.id.ansA5);
                break;
            case -1:
                radioGroupA.clearCheck();
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
        radioGroupA = (RadioGroup) findViewById(R.id.answers_aptitudes);
        radioGroupA.setOnCheckedChangeListener(null);
    }

    public void addListenerOnRadioButton() {
        radioGroupA = (RadioGroup) findViewById(R.id.answers_aptitudes);
        radioGroupA.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroupA.findViewById(checkedId);
                int index = radioGroupA.indexOfChild(radioButton);
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

    private void handleResults(){
        //cargar maximos de ExamQuestionsI
        Intent mIntent = getIntent();
        Integer max1_interes = mIntent.getIntExtra("max1", 0);
        Log.d("max1 de interes", ""+max1_interes);
        Integer max2_interes = mIntent.getIntExtra("max2", 0);
        Integer max3_interes = mIntent.getIntExtra("max3", 0);
        //lanzar layout de conclusiones
        setContentView(R.layout.slide_conclusion);
        TextView titulo_conclusiones = (TextView) findViewById(R.id.conclusion_title); titulo_conclusiones.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView finaltext = (TextView) findViewById(R.id.finaltext); finaltext.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView mainarea = (TextView) findViewById(R.id.mainarea); mainarea.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));
        TextView finaltext2 = (TextView) findViewById(R.id.finaltext2); finaltext2.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifRegular.otf"));
        TextView mainlic = (TextView) findViewById(R.id.mainlic); mainlic.setTypeface(Typeface.createFromAsset(getAssets(), "GandhiSerifBold.otf"));

        // set areas principales
        if( max1_interes.equals(sortedPair[0])){
            mainarea.setText(areasA[sortedPair[0]]);
            mainlic.setText(recomendacion[max1_interes][sortedPair[0]]);
            Log.d("recomendacion", ""+recomendacion[max1_interes][sortedPair[0]]);
        }
        else if (max1_interes.equals(sortedPair[1])){
            mainarea.setText(areasA[sortedPair[1]]);
            mainlic.setText(recomendacion[max1_interes][sortedPair[1]]);
        }
        else if (max1_interes.equals(sortedPair[2])){
            mainarea.setText(areasA[sortedPair[2]]);
            mainlic.setText(recomendacion[max1_interes][sortedPair[2]]);
        }
        else if (max2_interes.equals(sortedPair[0])){
            mainarea.setText(areasA[sortedPair[0]]);
            mainlic.setText(recomendacion[max2_interes][sortedPair[0]]);
        }
        else if (max2_interes.equals(sortedPair[1])){
            mainarea.setText(areasA[sortedPair[1]]);
            mainlic.setText(recomendacion[max2_interes][sortedPair[1]]);
        }
        else if (max2_interes.equals(sortedPair[2])){
            mainarea.setText(areasA[sortedPair[2]]);
            mainlic.setText(recomendacion[max2_interes][sortedPair[2]]);
        }
        else if (max3_interes.equals(sortedPair[0])){
            mainarea.setText(areasA[sortedPair[0]]);
            mainlic.setText(recomendacion[max3_interes][sortedPair[0]]);
        }
        else if (max3_interes.equals(sortedPair[1])){
            mainarea.setText(areasA[sortedPair[1]]);
            mainlic.setText(recomendacion[max3_interes][sortedPair[1]]);
        }
        else if (max3_interes.equals(sortedPair[2])){
            mainarea.setText(areasA[sortedPair[2]]);
            mainlic.setText(recomendacion[max3_interes][sortedPair[2]]);
        }
        else {
            mainarea.setText(areasI[max1_interes] + " & " + areasA[sortedPair[0]]);
            mainlic.setText(recomendacion[max1_interes][sortedPair[0]]);
        }
        //Boton Finalizar
        Button finish ; finish = (Button) findViewById(R.id.finish);
        Button lic ; lic = (Button) findViewById(R.id.btnLic);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AptitudesActivity.this, MainActivity.class));
            }
        });

        lic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AptitudesActivity.this, LicenciaturaActivity.class));
            }
        });
    }

    public void addListenerOnButtonResults() {
        btnSigResults = (Button) findViewById(R.id.btnSigResults);
        // Realizar accion al presionar siguiente
        btnSigResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleResults() ;
            }
        });
    }

    public void loadResults() {
        String aptitudes = "Resultados: Aptitudes" ;
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
        titulo_resultados.setText(aptitudes); area1.setText(areasA[0]); area2.setText(areasA[1]);  area3.setText(areasA[2]);
        area4.setText(areasA[3]); area5.setText(areasA[4]); area6.setText(areasA[5]); area7.setText(areasA[6]);
        area8.setText(areasA[7]); area9.setText(areasA[8]);  area10.setText(areasA[9]);
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