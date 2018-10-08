package com.example.alumno.adivinanumero;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int random;
    int numIntroducido;
    int contador=0;

    TextView texto;
    TextView intentalo;

    EditText valor;

    boolean correcto=false;

    String inferior="¡Uy! El número que he pensado es menor";
    String superior="¡Uy! El número que he pensado es mayor";
    String acierto="Congratulation, has acertado el numero";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = (int) (Math.random() * 10) + 1;
        texto = (TextView)findViewById(R.id.etiquetaSuperior);
        intentalo = (TextView)findViewById(R.id.intentalo);
        valor = (EditText) findViewById(R.id.numero);
    }

    public void adivinar(View v){

        //numIntroducido = Integer.parseInt(valor.getText().toString());

        texto.setText(random);

        /*while (correcto==false){
            if (numIntroducido<random){
                texto.setText(superior);
            }else if (numIntroducido>random){
                texto.setText(inferior);
            }else{
                texto.setText(acierto);
                correcto=true;
                contador=0;
            }
        }*/
    }
}
