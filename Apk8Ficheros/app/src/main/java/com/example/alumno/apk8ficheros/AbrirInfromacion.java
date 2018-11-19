package com.example.alumno.apk8ficheros;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AbrirInfromacion extends Activity {
    ImageView imagen;
    TextView nombre;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_marisco);

        imagen=(ImageView)findViewById(R.id.imageViewMarisco);
        nombre=(TextView)findViewById(R.id.textViewNombre);
    }
}
