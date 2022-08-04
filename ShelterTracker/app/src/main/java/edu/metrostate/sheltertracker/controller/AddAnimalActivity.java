package edu.metrostate.sheltertracker.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.simple.parser.ParseException;

import java.io.IOException;

import edu.metrostate.sheltertracker.R;
import edu.metrostate.sheltertracker.domains.ShelterTrackerApplication;

public class AddAnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);
    }

    public void importAnimal (View view) {

    }
}