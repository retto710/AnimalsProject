package com.example.anthony.animalsx;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout my_layout;
    AnimationDrawable animationDrawable;
    CircleImageView imgMouse;
    CircleImageView imgAny;
    CircleImageView imgDog;
    CircleImageView imgCaterpillar;
    CircleImageView imgChipmunk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializar variables
        my_layout=findViewById(R.id.my_layout);
        imgMouse=findViewById(R.id.mouse);
        imgAny= findViewById(R.id.any);
        imgDog=findViewById(R.id.dog);
        imgCaterpillar=findViewById(R.id.caterpillar);
        imgChipmunk= findViewById(R.id.chipmunk);
        //Animacion de cambio de color
        animationDrawable=(AnimationDrawable) my_layout.getBackground() ;
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        //Inicio con cambio de colot
        animationDrawable.start();
        //Al hacer clic se cambia de pantalla
        imgMouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SpecificAnimalPoblationActivity.class);
                intent.putExtra("name","rata");
                startActivity(intent);
            }
        });
        imgAny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SpeciesRatesActivity.class);
                startActivity(intent);
            }
        });
        imgDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SpecificAnimalPoblationActivity.class);
                intent.putExtra("name","perro");
                startActivity(intent);
            }
        });
        imgCaterpillar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SpecificAnimalPoblationActivity.class);
                intent.putExtra("name","oruga");
                startActivity(intent);
            }
        });
        imgChipmunk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SpecificAnimalPoblationActivity.class);
                intent.putExtra("name","ardilla");
                startActivity(intent);
            }
        });
    }
}
