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
    private BufferedWriter writer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NombreUsuario = findViewById(R.id.NombreUsuario);
        OkBoton = findViewById(R.id.OkBoton);

        OkBoton.setOnClickListener( //metodo onclick con parametro

                (v) -> {

                    Gson gson = new Gson(); //crea json


                    String nombre = NombreUsuario.getText().toString();//datos ingresados


                    Usuario obj= new Usuario(nombre, 200, 200, 0, 255, 0); //creo un objeto cordenada que serializo

                    String json = gson.toJson(obj);
                    //Log.e(">>>","funciono"+json);

                    new Thread(
                            ()->{ //metodo run del runable sin parametro
                                try {

                                    writer.write(json + "\n"); //enviar el mensaje igual
                                    writer.flush(); //para que envie la info
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                    ).start();
                    Intent i = new Intent(this, ControlActivity.class);
                    startActivity(i);
                }
        );

        new Thread( //generacion de hilo usar un singleton aqui para poder hacerse en mas clases y eso obliga a hacer un clase singleton
                () -> {
                    try {
                        System.out.println("Enviando solicitud...");//todavia muy prematuro para pedir los datos

                        Socket socket = new Socket("10.0.2.2", 5000); //solicitud al server donde necesito que el server busque la ip y puerto
                        System.out.println("Conexion establecida");
                        //socket es como una puerta hacia el servidor
                        InputStream is = socket.getInputStream();
                        OutputStream out = socket.getOutputStream();

                        /*BufferedWriter gracias a que la declare anteriormente de forma global*/
                        //globalizarlo para que funcione, necesto declarar el writer
                        writer = new BufferedWriter(new OutputStreamWriter(out));
                        BufferedReader reader = new BufferedReader(new InputStreamReader(is)); //declarando el lector para que lea mensajes del servidor

                        while (true) { //bucle infinito de lectura
                            System.out.println("Esperando nombre...");
                            String line = reader.readLine(); //llegan los mensajes del servidor
                            System.out.println("Nombre recibido" + line);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
        ).start();
    }
}