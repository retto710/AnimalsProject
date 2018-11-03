package com.example.anthony.animalsx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.anthony.animalsx.Classes.Matriz;

public class SpeciesRatesActivity extends AppCompatActivity {

    Button btnSave;
    EditText edtRanges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species_rates);
        btnSave = findViewById(R.id.btnRangos);
        edtRanges = findViewById(R.id.edtRangos);

        //Matriz
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),RatesActivity.class);
                intent.putExtra("rango",String.valueOf(edtRanges.getText().toString()));
                startActivity(intent);
            }
        });


    }
}
