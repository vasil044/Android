package com.example.samuel.faunamarina;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Samuel on 21/11/2017.
 */

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagengrande);
        //Se recoge el valor numérico que devuelve la actividad principal y se asigna la imagen correspondiente al valor en el objeto ImageView de la actividad.
        int num = getIntent().getIntExtra("ref",0);
        ImageView im = (ImageView)findViewById(R.id.imageView2);
        im.setImageResource(num);
    }
}
