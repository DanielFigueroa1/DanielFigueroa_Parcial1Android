package com.example.danielfigueroa_parcial1android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.danielfigueroa_parcial1android.model.Usuario;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private EditText NombreUsuario;
    private Button OkBoton;
    private TCPSingleton tcp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NombreUsuario = findViewById(R.id.NombreUsuario);
        OkBoton = findViewById(R.id.OkBoton);

        tcp = TCPSingleton.getInstance();
        tcp.start();

        OkBoton.setOnClickListener( //metodo onclick con parametro

                (v) -> {

                    Gson gson = new Gson(); //crea json


                    String nombre = NombreUsuario.getText().toString();//datos ingresados


                    Usuario obj= new Usuario(nombre, 200, 200, 0, 255, 0); //creo un objeto cordenada que serializo

                    String json = gson.toJson(obj);
                    //Log.e(">>>","funciono"+json);

                    //singleton envio
                    tcp.enviarNombre();

                    Intent i = new Intent(this, ControlActivity.class);
                    startActivity(i);
                }
        );

        TCPSingleton tcp = TCPSingleton.getInstance();
    }
}