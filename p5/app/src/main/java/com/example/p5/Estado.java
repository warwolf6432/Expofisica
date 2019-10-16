package com.example.p5;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class Estado extends AppCompatActivity
{

    private BluetoothSocket btSocket = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado);
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

    public void feliz(View view)
{
    MediaPlayer mp= MediaPlayer.create(this, R.raw.happy);
    mp.start();

}

    public void wara(View view)
    {
        MediaPlayer mp= MediaPlayer.create(this, R.raw.tt);
        mp.start();
    }
    public void enamorado(View view)
    {
        MediaPlayer mp= MediaPlayer.create(this, R.raw.minina);
        mp.start();
    }

    public void jeje(View view)
    {
        MediaPlayer mp= MediaPlayer.create(this, R.raw.bb);
        mp.start();
    }
    public void stop(View view)
    {
        MediaPlayer mp= MediaPlayer.create(this, R.raw.bb);
        MediaPlayer mp1= MediaPlayer.create(this, R.raw.minina);
        MediaPlayer mp2= MediaPlayer.create(this, R.raw.tt);
        MediaPlayer mp3= MediaPlayer.create(this, R.raw.happy);
mp.stop();
        mp2.stop();
        mp3.stop();
        mp1.stop();
    }
}
