package com.example.anthony.animalsx;

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
    Button btnNext;
    EditText edtRanges;
    //Rangos invisibles
    EditText edtAgeRange1;
    EditText edtAgeRange2;
    EditText edtAgeRange3;
    EditText edtAgeRange4;
    EditText edtAgeRange5;
    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    TextView txt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species_rates);
        btnSave = findViewById(R.id.btnRangos);
        edtRanges = findViewById(R.id.edtRangos);
        btnNext=findViewById(R.id.btnNext);
        edtAgeRange1=findViewById(R.id.edtAgeRange1);
        edtAgeRange2=findViewById(R.id.edtAgeRange2);
        edtAgeRange3=findViewById(R.id.edtAgeRange3);
        edtAgeRange4=findViewById(R.id.edtAgeRange4);
        edtAgeRange5=findViewById(R.id.edtAgeRange5);
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        txt3=findViewById(R.id.txt3);
        txt4=findViewById(R.id.txt4);
        txt5=findViewById(R.id.txt5);

        edtRanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtRanges.setText("1");
            }
        });
        //Matriz
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double[][] d = { { 80, 40, 60 }, { 0.28, 1.2, 0.5 }, { 0.51, 0.81, 0} };
                Matriz D = new Matriz(d);
                //Crea la segunda matriz con la cantidad de muestras
                Matriz C=D.transpose();
                //Genera la matriz Leslie
                D=D.LeslieMatriz(D);
                //Multiplica las matrices
                Matriz E = D.Multiplicacion(C);
                E.show();
            }
        });
        //Rangos
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer numberRanges = Integer.parseInt(edtRanges.getText().toString());
                Log.d("s",numberRanges.toString());
                Log.d("s",edtRanges.getText().toString());
                //Poner todos invisibles
                edtAgeRange1.setVisibility(View.INVISIBLE);
                edtAgeRange2.setVisibility(View.INVISIBLE);
                edtAgeRange3.setVisibility(View.INVISIBLE);
                edtAgeRange4.setVisibility(View.INVISIBLE);
                edtAgeRange5.setVisibility(View.INVISIBLE);
                txt1.setVisibility(View.INVISIBLE);
                txt2.setVisibility(View.INVISIBLE);
                txt3.setVisibility(View.INVISIBLE);
                txt4.setVisibility(View.INVISIBLE);
                txt5.setVisibility(View.INVISIBLE);
                btnNext.setVisibility(View.INVISIBLE);
                for (int i=0;i<=numberRanges;i++){
                    if (i == 1) {
                        edtAgeRange1.setVisibility(View.VISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        btnNext.setVisibility(View.VISIBLE);
                    }
                    if (i == 2) {
                        edtAgeRange2.setVisibility(View.VISIBLE);
                        txt2.setVisibility(View.VISIBLE);
                    }
                    if (i == 3) {
                        edtAgeRange3.setVisibility(View.VISIBLE);
                        txt3.setVisibility(View.VISIBLE);
                    }
                    if (i == 4) {
                        edtAgeRange4.setVisibility(View.VISIBLE);
                        txt4.setVisibility(View.VISIBLE);
                    }
                    if (i == 5) {
                        edtAgeRange5.setVisibility(View.VISIBLE);
                        txt5.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }
}
