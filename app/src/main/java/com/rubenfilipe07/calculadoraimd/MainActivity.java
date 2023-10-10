package com.rubenfilipe07.calculadoraimd;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Calculadora fragmentCalculadora;
    private Notas fragmentNotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentCalculadora = new Calculadora();
        fragmentNotas = new Notas();
        irCalculadora(null);
    }

    public void irCalculadora(View view){
        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.frameLayout, fragmentCalculadora);
        fm.commit();
    }

    public void irNotas(View view){
        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.frameLayout, fragmentNotas);
        fm.commit();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }
    

}