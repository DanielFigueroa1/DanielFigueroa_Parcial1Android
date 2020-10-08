package com.example.danielfigueroa_parcial1android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ControlActivity extends AppCompatActivity {

    private Button ArribaBoton;
    private Button AbajoBoton;
    private Button IzquierdaBoton;
    private Button DerechaBoton;
    private Button ColorBoton;
    private TCPSingleton tcp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        ArribaBoton = findViewById(R.id.ArribaBoton);
        AbajoBoton = findViewById(R.id.AbajoBoton);
        IzquierdaBoton = findViewById(R.id.IzquierdaBoton);
        DerechaBoton = findViewById(R.id.DerechaBoton);
        ColorBoton = findViewById(R.id.ColorBoton);
        tcp = TCPSingleton.getInstance();
    }
}