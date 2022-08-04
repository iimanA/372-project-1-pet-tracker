package edu.metrostate.sheltertracker.controller;
import edu.metrostate.sheltertracker.R;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AnimalListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);
    }
    public void addAnimal (View view) {
        Intent intent = new Intent(this, AddAnimalActivity.class);
        startActivity(intent);
    }
}