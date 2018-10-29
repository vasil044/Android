package com.example.vasilmilchov.aplicacion6android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
    String r1,r2;
    TextView textView,textView1,textView3;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView)findViewById(R.id.editText);
        textView1 = (TextView)findViewById(R.id.editText2);
        textView3 = (TextView)findViewById(R.id.textView6);
        id=getIntent().getIntExtra("id",0);
        if(id==R.id.button2) {
            textView3.setText("Modificar contacto, cambia el nombre y los apellidos");
            r1 = getIntent().getStringExtra("p1");
            r2 = getIntent().getStringExtra("p2");
            textView.setText(r1);
            textView1.setText(r2);
        }
    }
    public void respuesta(View v){

        Intent datos = new Intent();
        String nom,apellido;
        nom = textView.getText().toString();
        apellido = textView1.getText().toString();
        datos.putExtra("nom",nom);
        datos.putExtra("apellido",apellido);
        setResult(RESULT_OK,datos);
        finish();
    }
}
