package com.example.anthony.animalsx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    TextView txtAnswer;
    Button btnSave;
    Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rates);
        double[][] d = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0} };
        matriz=new Matriz(d);
        matriz.show();
        btnSave=findViewById(R.id.btnSave);
        btnGuardar=findViewById(R.id.btnNext);
        txtAnswer=findViewById(R.id.txtRespuesta);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtActRange=findViewById(R.id.txtRangoActual);
                editMorRate=findViewById(R.id.edtMortRate);
                editNatRate=findViewById(R.id.edtNatRate);
                editNumAnim=findViewById(R.id.edtNuAni);
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
                //POR AHORA ESTA VALIDADO A 3 X 3
                if (nuevorango>3)
                {
                    Matriz C=matriz.transpose();
                    //Genera la matriz Leslie
                    matriz=matriz.LeslieMatriz(matriz);
                    //Multiplica las matrices
                    Matriz E = matriz.Multiplicacion(C);
                    E.show();
                    txtAnswer.setText(E.toString());
            }
            }
        });

    }
}
