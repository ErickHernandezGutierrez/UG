package app.ug;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ChestActivity extends Activity {

    private CustomMemoryAdapter memoriesAdapter;
    private LinearLayoutManager memoriesManager;
    private RecyclerView memoriesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        ArrayList<Memory> memories = new ArrayList<>();
        memories.add(new Memory("12/01/2017", "Guanajuato", "Título", "Descripción muy básica del evento."));
        memories.add(new Memory("24/09/2017", "Guanajuato", "Título", "Descripción muy básica del evento."));

        memoriesAdapter = new CustomMemoryAdapter(this, memories);
        memoriesManager = new LinearLayoutManager(this);
        memoriesManager.setOrientation(LinearLayoutManager.VERTICAL);
        memoriesView = (RecyclerView) findViewById(R.id.memoriesView);
        memoriesView.setAdapter(memoriesAdapter);
        memoriesView.setLayoutManager(memoriesManager);
    }
}
