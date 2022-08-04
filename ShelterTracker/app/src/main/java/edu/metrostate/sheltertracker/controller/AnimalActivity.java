package edu.metrostate.sheltertracker.controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Date;


import edu.metrostate.sheltertracker.R;
import edu.metrostate.sheltertracker.domains.Animal;
import edu.metrostate.sheltertracker.domains.Shelter;
import edu.metrostate.sheltertracker.domains.ShelterTrackerApplication;

public class AnimalActivity extends AppCompatActivity {
    public String animalId;
    TextView tvAnimalId;
    TextView tvAnimalInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        Bundle extras = getIntent().getExtras();

        this.tvAnimalId = findViewById(R.id.tvAnimalId);
        this.tvAnimalInfo = findViewById(R.id.tvAnimalInfo);

        if (extras != null) {
            animalId = extras.getString("animalId");
            Animal animal = ((ShelterTrackerApplication)getApplication()).getAnimalInfo(animalId);

            if (animal == null) {
                tvAnimalId.setText("Invalid Animal");
            } else {
                Shelter shelter = ((ShelterTrackerApplication)getApplication()).getShelterInfo(animal.getShelterId());
                tvAnimalId.setText("Animal " + animalId);
                String shelterName;
                if (shelter == null) {
                    shelterName = "N/A";
                } else {
                    shelterName = shelter.getShelterName();
                }
                String animalInfo = getAnimalInfo(animal, shelterName);
                tvAnimalInfo.setText(animalInfo);
            }
        } else {
            tvAnimalId.setText("Invalid Animal");
        }
    }

    public String getAnimalInfo (Animal animal, String shelterName) {
        String animalInfo = String.format("Animal name: %s \nShelter id: %s  Shelter name: %s\n",
                animal.getName(), animal.getShelterId(), shelterName);
        Date releaseDate = animal.getReleaseDate();
        String releaseString = "";
        if (releaseDate.equals(new Date(0))) {
            releaseString = "N/A";
        } else releaseString = releaseDate.toString();
        animalInfo += String.format("Type: %s   Weight:%.2f   Receipt Date: %s\n Release Date: %s\n",
                animal.getAnimalType(), animal.getWeight(), animal.getReceiptDate(), releaseString);
        return animalInfo;
    }

    public void releaseAnimal (View view) {
        int result = ((ShelterTrackerApplication)getApplication()).removeAnimal(animalId);
        String message = "";
        if (result == -1) {
            message = "Animal has already left the shelter!";
        } else {
            message = "Release success!";
        }
        Animal animal = ((ShelterTrackerApplication)getApplication()).getAnimalInfo(animalId);
        Shelter shelter = ((ShelterTrackerApplication)getApplication()).getShelterInfo(animal.getShelterId());
        String animalInfo = getAnimalInfo(animal, shelter.getShelterName());
        tvAnimalInfo.setText(animalInfo);

        Dialog dialog = new AlertDialog.Builder(this).setTitle("Release Animal").setCancelable(false)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                }).create();

        dialog.show();
    }

    public void backHome (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}