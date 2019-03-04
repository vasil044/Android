package com.example.samuel.faunamarina;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Samuel on 21/11/2017.
 */

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_TEXTO =
            "imagen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagengrande);

        FragmentDetalles detalle =
                (FragmentDetalles)getSupportFragmentManager()
                        .findFragmentById(R.id.FrgDetalle);

        detalle.mostrarDetalle(getIntent().getStringExtra(EXTRA_TEXTO));
    }
}
