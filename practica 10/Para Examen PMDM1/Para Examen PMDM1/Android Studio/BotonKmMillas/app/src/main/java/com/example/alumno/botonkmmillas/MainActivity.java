package com.example.alumno.botonkmmillas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            Guardamos en variables del tipo de nuestros elementos visuales de la aplicación los datos de éstos,
            para poder modificar ciertos datos en diferentes situaciones.
         */
        Button calcular = (Button) findViewById(R.id.botonCalcular);//Guardamos los valores de "botonCalcular".
        final EditText cajaTexto = (EditText) findViewById(R.id.texto);//Guardamos los valores "texto" .
        final RadioButton aKm = (RadioButton) findViewById(R.id.rbAKm);//Guardamos los valores de "rbAKm".
        final RadioButton aMillas = (RadioButton) findViewById(R.id.rbAMillas);//Guardamos los valores de "rbAMillas".
        final EditText textoGenerado = (EditText) findViewById(R.id.editText);//Guardamos los valores de "editText".
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = String.valueOf(cajaTexto.getText());//Guardamos la cadena de nuestra caja de texto en una variable de tipo "String".

                try{
                    float num = Float.valueOf(txt);//Transformamos el número guardado como String de nuestra caja de texto en un float.
                    if(aKm.isChecked())//Si el radioButton "aKm" se ha seleccionado, se transformará de millas a km.
                    {
                        num = num / 0.621f;
                        textoGenerado.setText("millas son "+String.format("%.2f",num)+"Km");//Asignamos un mensaje adicional por estética.
                    }
                    if(aMillas.isChecked())//Si el radioButton "aMillas" se ha seleccionado, se transformará de km a millas.
                    {
                        num = num * 0.621f;
                        textoGenerado.setText("km son "+String.format("%.2f",num)+" millas");//Asignamos un mensaje adicional por estética.
                    }
                }catch(Exception e){
                    /*
                        Saltara una excepción porque el texto esté vacío o porque se hayan introducido caracteres,
                        en lugar de números. Si ocurre, saltará un cuadro de texto con un mensaje.
                     */
                    Toast toast1 =Toast.makeText(getApplicationContext(),"Por favor, introduce un número.", Toast.LENGTH_SHORT);//Configuramos el mensaje tipo "Toast".
                    toast1.show();//Mostramos mensaje.
                    cajaTexto.setText("");//Reiciamos el valor en el cuadro de texto.
                }
            }
        });

    }
}
