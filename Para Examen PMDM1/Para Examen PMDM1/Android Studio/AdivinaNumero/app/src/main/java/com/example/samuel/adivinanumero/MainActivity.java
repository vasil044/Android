package com.example.samuel.adivinanumero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private final static String STATE_NUM_VECES = "numVeces";
    int numVeces;
    private final static String STATE_NUM_A_ADIVINAR = "miNumero";
    int miNumero;
    private final static String STATE_TEXTO_SUP = "texto_sup";
    String texto_sup = "He pensado un número entre 1 y 100. \n ¡Adivina cual es!";


    @Override

    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnProbar = (Button) findViewById(R.id.probar);//Guardamos los datos de "probar".
        final TextView txtSuperior = (TextView) findViewById(R.id.etiquetaSuperior);//Guardamos los datos de "etiquetaSuperior".
        TextView txtIntentalo = (TextView) findViewById(R.id.intentalo);//Guardamos los datos de "intentalo".
        final EditText txtNumero = (EditText) findViewById(R.id.numero);//Guardamos los datos de "numero".
        numVeces=0;
        miNumero=devolverRandom();


        if(savedInstanceState != null)//Carga los valores al girar la pantalla.
        {
            numVeces= savedInstanceState.getInt(STATE_NUM_VECES);
            miNumero= savedInstanceState.getInt(STATE_NUM_A_ADIVINAR);
            texto_sup = savedInstanceState.getString(STATE_TEXTO_SUP);
            txtSuperior.setText(texto_sup);
        }

        btnProbar.setOnClickListener( new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                /*
                    -Si el número introducido está entre 1 y 100.
                    -Después de comprobar que está entre esos parámetros, se compara con el número a adivinar y se muestra si el número introducido es mayor, menor o igual a él.
                    -Se mostrará una excepción si no está entre los parámetros y si no se introduce un número.
                 */
                    try{
                        if(Integer.valueOf(txtNumero.getText().toString())>0 && Integer.valueOf(txtNumero.getText().toString())<101) {
                            numVeces++;//Añadimos 1 en el contador de veces.
                            if (Integer.valueOf(txtNumero.getText().toString()) < miNumero) {
                                txtSuperior.setText("¿" + Integer.valueOf(String.valueOf(txtNumero.getText())) + "?" + getResources().getString(R.string.mayorQueNum) + "\n" + getResources().getString(R.string.intentos) + numVeces);
                                texto_sup = "" + txtSuperior.getText();
                            } else {
                                if (Integer.valueOf(txtNumero.getText().toString()) > miNumero) {
                                    txtSuperior.setText("¿" + Integer.valueOf(String.valueOf(txtNumero.getText())) + "?" + getResources().getString(R.string.menorQueNum) + "\n" + getResources().getString(R.string.intentos) + numVeces);
                                    texto_sup = "" + txtSuperior.getText();
                                } else {
                                    if (Integer.valueOf(txtNumero.getText().toString()) == miNumero) {
                                        txtSuperior.setText(getResources().getString(R.string.acierto) + "\n" + getResources().getString(R.string.intentos) + numVeces);
                                        texto_sup = "" + txtSuperior.getText();
                                    }
                                }
                            }
                        }
                        else{
                            Toast toast2 =Toast.makeText(getApplicationContext(),getResources().getString(R.string.toast2), Toast.LENGTH_SHORT);//Configuramos el mensaje tipo "Toast".
                            toast2.show();//Mostramos mensaje.
                        }
                    }catch(Exception e)
                    {
                        Toast toast1 =Toast.makeText(getApplicationContext(),getResources().getString(R.string.toast1), Toast.LENGTH_SHORT);//Configuramos el mensaje tipo "Toast".
                        toast1.show();//Mostramos mensaje.
                    }
                }
        });

    }

    public static int devolverRandom(){//Devuelve número random entre 1 y 100.
        int num;
        Random r = new Random();
        num = r.nextInt(100)+1;
        return num;
    }

    public void onSaveInstanceState(Bundle outInstance)//Permite guardar valores para que cuando se gire la pantalla no se resetee.
    {

        super.onSaveInstanceState(outInstance);
        outInstance.putInt(STATE_NUM_VECES, numVeces);
        outInstance.putInt(STATE_NUM_A_ADIVINAR,miNumero);
        outInstance.putString(STATE_TEXTO_SUP,texto_sup);
    }
}
