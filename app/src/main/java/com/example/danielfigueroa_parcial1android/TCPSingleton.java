package com.example.danielfigueroa_parcial1android;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;



public class TCPSingleton extends Thread {

    //Singleton
    private static  TCPSingleton unicaInstancia;

    public static TCPSingleton getInstance(){
            if (unicaInstancia == null){
                unicaInstancia = new TCPSingleton();
            }
            return unicaInstancia;
    }

    private TCPSingleton(){

    }
    //singleton


    //globales
    private Socket socket;
    private BufferedWriter writer;
   // private MainActivity mainActivity;

    /*public void setObserver(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }*/

    @Override
    public void run(){

        try {
            System.out.println("Enviando solicitud...");//todavia muy prematuro para pedir los datos

            socket = new Socket("10.0.2.2", 5000); //solicitud al server donde necesito que el server busque la ip y puerto
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



    public void enviarNombre(String message){
        new Thread(
                ()->{ //metodo run del runable sin parametro
                    try {

                        writer.write(message + "\n"); //enviar el mensaje igual
                        writer.flush(); //para que envie la info
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        ).start();
    }

}
