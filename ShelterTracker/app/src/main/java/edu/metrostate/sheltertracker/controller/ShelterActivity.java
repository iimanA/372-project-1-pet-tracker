package edu.metrostate.sheltertracker.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import edu.metrostate.sheltertracker.R;
import edu.metrostate.sheltertracker.domains.Shelter;
import edu.metrostate.sheltertracker.domains.ShelterAdapter;
import edu.metrostate.sheltertracker.domains.ShelterTrackerApplication;

public class ShelterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter);

        ListView lv = findViewById(R.id.shelter_list);

//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.i("itemClick", String.valueOf(i));
//                Shelter shelter = ((ShelterTrackerApplication) getApplication()).getAnimalList().get(i);
//                Intent intent = new Intent(AnimalListActivity.this, AnimalActivity.class);
//                intent.putExtra("animalId", tvAnimalId.getanimalId());
//                startActivity(intent);
//            });
        Bundle extras = getIntent().getExtras();
        String shelterId;
        TextView tvAnimalId = findViewById(R.id.tvShelterId);

        if (extras != null) {
            shelterId = extras.getString("shelterId");
            lv.setAdapter(new AnimalAdapter(ShelterActivity.this,
                        ((ShelterTrackerApplication)getApplication()).showAnimalsByShelter(shelterId)));
            tvAnimalId.setText("Shelter " + shelterId);
        } else {
            tvAnimalId.setText("Invalid Shelter");
        }
    }

    public void backShelterList (View view) {
        Intent intent = new Intent(this, ShelterListActivity.class);
        startActivity(intent);
    }

    public void backHome (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
