package com.example.p5;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class Estado extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado);
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
