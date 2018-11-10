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

public class RatesActivity extends AppCompatActivity {
    Matriz matriz;
    EditText editNumAnim;
    EditText editMorRate;
    EditText editNatRate;
    TextView txtActRange;
    EditText editText;
    TextView txtAnswer;
    Button btnSave;
    Button btnGuardar;
    Integer nRangos;
    Matriz matrizInicial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rates);
        nRangos= Integer.parseInt(getIntent().getStringExtra("rango"));
        matriz=new Matriz(nRangos);
        matriz.show();
        btnSave=findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtActRange=findViewById(R.id.txtRangoActual);
                editMorRate=findViewById(R.id.edtMortRate);
                editNatRate=findViewById(R.id.edtNatRate);
                editNumAnim=findViewById(R.id.edtNuAni);
                editText= findViewById(R.id.edtIt);
                //Integer numberRanges = Integer.parseInt(edtRanges.getText().toString());
                Integer rangoActual=Integer.parseInt(txtActRange.getText().toString());
                Integer NumeroAnimales=Integer.parseInt(editNumAnim.getText().toString());
                Double MortalRate= Double.parseDouble(editMorRate.getText().toString());
                Double NatRate= Double.parseDouble(editNatRate.getText().toString());
                matriz.setData(0,rangoActual-1,NumeroAnimales);
                matriz.setData(1,rangoActual-1,NatRate);
                matriz.setData(2,rangoActual-1,MortalRate);
                Integer nuevorango= rangoActual+1;
                txtActRange.setText(nuevorango.toString());
                editNatRate.setText("");
                editNumAnim.setText("");
                editMorRate.setText("");
                matriz.show();
                if (nuevorango==nRangos)
                {

                    editText.setEnabled(true);
                }
                if (nuevorango>nRangos)
                {
                    //Guarda la matriz inciial
                    matrizInicial= new Matriz(matriz.getData());
                    Matriz C= new Matriz(matriz.transpose().getData());
                    //Genera la matriz Leslie
                    matriz= new Matriz(matriz.LeslieMatriz(matriz).getData());
                    //Log.d("termina leslie","end");
                    //Multiplica las matrices
                    Matriz E = new Matriz(matriz.UltInteracciones(C,Integer.valueOf(editText.getText().toString())).getData());
                    Log.d("termina mult","end");
                    //txtAnswer.setText(E.toString());
                    matriz.Interacciones(C,Integer.parseInt(editText.getText().toString()));
                    Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                    intent.putExtra("respuesta",matriz.getnAnimales());
                    intent.putExtra("ultimo",E.toString2());
                    intent.putExtra("matrizinicial",matrizInicial);
                    startActivity(intent);
            }
            }
        });

    }
}
