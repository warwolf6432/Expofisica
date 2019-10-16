package com.example.p5;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import java.io.IOException;

public class DatosCasa extends AppCompatActivity
{
    private BluetoothSocket btSocket = null;
    TextView txtTemp, txtHumedad;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_casa);

        txtTemp=(TextView) findViewById(R.id.txtTemp);
        txtHumedad=(TextView) findViewById(R.id.txtHumedad);

        //Aquí llega la información
        bluetoothIn = new Handler()
        {
            public void handleMessage(android.os.Message msg)
            {
                if (msg.what == handlerState)
                {
                    String readMessage = (String) msg.obj;
                    DataStringIN.append(readMessage);

                    int endOfLineIndex = DataStringIN.indexOf("#");

                    if (endOfLineIndex > 0)
                    {
                        //Variable que recibe los datos
                        String dataInPrint = DataStringIN.substring(0, endOfLineIndex);
                        txtTemp.setText("Temperatura: " + dataInPrint);//<-<- PARTE A MODIFICAR >->->
                        DataStringIN.delete(0, DataStringIN.length());
                    }
                }
            }
        };


        public void run()
    {
        byte[] buffer = new byte[256];
        int bytes;

        // Se mantiene en modo escucha para determinar el ingreso de datos
        while (true) {
            try {
                bytes = mmInStream.read(buffer);
                String readMessage = new String(buffer, 0, bytes);
                // Envia los datos obtenidos hacia el evento via handler
                bluetoothIn.obtainMessage(handlerState, bytes, -1, readMessage).sendToTarget();
            } catch (IOException e) {
                break;
            }
        }
    }
    }













    //MENÚ
    //Método para arrastras y ocultar el menú
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //El R es porque está en la carpeta Res
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    //Método para asignar las opciones correspondientes al menú
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        if (id==R.id.itemDesconectar)
        {
            if (btSocket != null)
            {
                try
                {
                    //VERIFICAR ESTO
                    btSocket.close();
                } catch (IOException e)
                {
                    Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_SHORT).show();
                    ;
                }
            }
            finish();

        }else if (id==R.id.itemInicio)
        {
            Intent siguiente= new Intent(this, Bienvenida.class);
            startActivity(siguiente);
        }else if (id== R.id.itemEstado)
        {
            Intent siguiente= new Intent(this, Estado.class);
            startActivity(siguiente);
        }
        else if (id==R.id.itemd)
        {
            Intent siguiente= new Intent(this, DatosCasa.class);
            startActivity(siguiente);
        }
        return super.onOptionsItemSelected(item);
    }
    //MENÚ





















}
