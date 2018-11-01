package com.example.anthony.animalsx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anthony.animalsx.Classes.Anim.Example;
import com.example.anthony.animalsx.Classes.Anim.Rata;
import com.example.anthony.animalsx.Classes.Matriz;

import org.w3c.dom.Text;

public class SpecificAnimalPoblationActivity extends AppCompatActivity {
    ImageView image;
    Button btn;
    TextView txtVariable;
    TextView txtAnswer;
    EditText edtPoblation;
    Integer contador;
    Matriz matriz;
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
        }
        //Nombre de la imagen del animal
        int resID = getResources().getIdentifier(imageName, "mipmap", getPackageName());
        //Inicializo todos los views
        btn= findViewById(R.id.btn);
        edtPoblation= findViewById(R.id.edtPoblation);
        txtVariable = findViewById(R.id.txtVariable);
        txtAnswer=findViewById(R.id.txtRespuesta);
        image= findViewById(R.id.imgAnimal);
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
                        edtPoblation.setEnabled(false);
                    }
                }
                else
                {
                    Matriz C= new Matriz(matriz.transpose().getData());
                    //Genera la matriz Leslie
                    matriz= new Matriz(matriz.LeslieMatriz(matriz).getData());
                    //Log.d("termina leslie","end");
                    //Multiplica las matrices
                    Matriz E = new Matriz(matriz.Multiplicacion(C).getData());
                    Log.d("termina mult","end");
                    txtAnswer.setText(E.toString());
                    //Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                    //intent.putExtra("respuesta",E.toString());
                    //startActivity(intent);
                    btn.setEnabled(false);
                }
            }
        });
    }
}
