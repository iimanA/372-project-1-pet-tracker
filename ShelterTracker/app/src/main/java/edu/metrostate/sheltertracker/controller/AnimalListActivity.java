package edu.metrostate.sheltertracker.controller;
import edu.metrostate.sheltertracker.R;
import edu.metrostate.sheltertracker.domains.Animal;
import edu.metrostate.sheltertracker.domains.Shelter;
import edu.metrostate.sheltertracker.domains.ShelterTrackerApplication;
import edu.metrostate.sheltertracker.domains.AnimalAdapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class AnimalListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);

        ListView animallv = findViewById(R.id.animal_list);
        animallv.setAdapter(new AnimalAdapter(this,
                ((ShelterTrackerApplication)getApplication()).getAnimalList()));
        animallv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("itemClick", String.valueOf(i));
                Animal animal = ((ShelterTrackerApplication)getApplication()).getAnimalList().get(i);
                Intent intent = new Intent(AnimalListActivity.this, AnimalActivity.class);
                intent.putExtra("animalId", animal.getAnimalId());
                startActivity(intent);
            }
        });


    }
    public void addAnimal (View view) {
        Intent intent = new Intent(this, AddAnimalActivity.class);
        startActivity(intent);
    }
}