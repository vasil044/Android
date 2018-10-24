package com.example.alumno.intentexplicitoapk6;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class ModificarContacto extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar_contacto_activity);
    }

    public void cerrar(View view) {
        finish();
    }
}
