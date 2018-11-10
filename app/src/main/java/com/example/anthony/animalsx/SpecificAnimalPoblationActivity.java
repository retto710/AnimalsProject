package com.example.anthony.animalsx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anthony.animalsx.Classes.Anim.Ardilla;
import com.example.anthony.animalsx.Classes.Anim.Example;
import com.example.anthony.animalsx.Classes.Anim.Oruga;
import com.example.anthony.animalsx.Classes.Anim.Perro;
import com.example.anthony.animalsx.Classes.Anim.Rata;
import com.example.anthony.animalsx.Classes.Matriz;

import org.w3c.dom.Text;

public class SpecificAnimalPoblationActivity extends AppCompatActivity {
    ImageView image;
    Button btn;
    TextView txtVariable;
    TextView txtAnswer;
    TextView textView1;
    EditText edtPoblation;
    Integer contador;
    Matriz matriz;
    Matriz matrizInicial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_animal_poblation);
        //Especifico el animal
        String animalName = getIntent().getStringExtra("name");
        Log.d("nombre animal",animalName);
        String imageName="";
        matriz= new Matriz();
        //Inicializo con los valores predeterminados
        switch (animalName){
            case "rata": {
                Rata rata= new Rata();
                imageName= rata.getSrcName();
                matriz=new Matriz(rata.getMaxAge());
                matriz.BirthRate(rata.getAnimalRate());
                matriz.MortalRate(rata.getAnimalRate());
            }break;
            case "example": {
                Example example= new Example();
                imageName= example.getSrcName();
                matriz=new Matriz(example.getMaxAge());
                matriz.BirthRate(example.getAnimalRate());
                matriz.MortalRate(example.getAnimalRate());
            }break;
            case "perro": {
                Perro perro= new Perro();
                imageName= perro.getSrcName();
                matriz=new Matriz(perro.getMaxAge());
                matriz.BirthRate(perro.getAnimalRate());
                matriz.MortalRate(perro.getAnimalRate());
            }break;
            case "oruga": {
                Oruga oruga= new Oruga();
                imageName= oruga.getSrcName();
                matriz=new Matriz(oruga.getMaxAge());
                matriz.BirthRate(oruga.getAnimalRate());
                matriz.MortalRate(oruga.getAnimalRate());
            }break;
            case "ardilla": {
                Ardilla ardilla= new Ardilla();
                imageName= ardilla.getSrcName();
                matriz=new Matriz(ardilla.getMaxAge());
                matriz.BirthRate(ardilla.getAnimalRate());
                matriz.MortalRate(ardilla.getAnimalRate());
            }break;
        }
        //Nombre de la imagen del animal
        int resID = getResources().getIdentifier(imageName, "mipmap", getPackageName());
        //Inicializo todos los views
        btn= findViewById(R.id.btn);
        edtPoblation= findViewById(R.id.edtPoblation);
        txtVariable = findViewById(R.id.txtVariable);
        txtAnswer=findViewById(R.id.txtRespuesta);
        image= findViewById(R.id.imgAnimal);
        textView1=findViewById(R.id.txt1);
        contador=0;
        Log.d("COlumnas de animal",String.valueOf(matriz.getnColumnas()));

        //Asigno la imagen del animal
        image.setImageResource(resID );
        //Relleno la poblacion
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contador<matriz.getnColumnas())
                {
                    Integer NumeroAnimales=Integer.parseInt(edtPoblation.getText().toString());
                    matriz.setData(0,contador,NumeroAnimales);
                    contador++;
                    //Limpio valores
                    edtPoblation.setText("");
                    txtVariable.setText(String.valueOf(contador+1));
                    Log.d("numeros",String.valueOf(matriz.getData(0,contador-1)));
                    if (contador==matriz.getnColumnas())
                    {
                        //matriz.show();
                        btn.setText("Calcular");
                        textView1.setText("Ingrese cantidad de interacciones");
                        int maxLength = 1;
                        edtPoblation.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});

                    }
                }
                else
                {
                    //Guarda la matriz inciial
                    matrizInicial= new Matriz(matriz.getData());
                    Matriz C= new Matriz(matriz.transpose().getData());
                    //Genera la matriz Leslie
                    matriz= new Matriz(matriz.LeslieMatriz(matriz).getData());
                    //Log.d("termina leslie","end");
                    //Multiplica las matrices
                    Matriz E = new Matriz(matriz.UltInteracciones(C,Integer.valueOf(edtPoblation.getText().toString())).getData());
                    Log.d("termina mult","end");
                    //txtAnswer.setText(E.toString());
                    matriz.Interacciones(C,Integer.parseInt(edtPoblation.getText().toString()));
                    Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                    intent.putExtra("respuesta",matriz.getnAnimales());
                    intent.putExtra("ultimo",E.toString2());
                    intent.putExtra("matrizinicial",matrizInicial);
                    startActivity(intent);
                    btn.setEnabled(false);
                }
            }
        });
    }
}
