package com.example.anthony.animalsx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.anthony.animalsx.Classes.Matriz;

public class RatesActivity extends AppCompatActivity {
    Matriz matriz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rates);
        matriz.setnColumnas(3);

    }
}
