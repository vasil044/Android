package es.mentor.unidad3.eje8.ventanasdialogo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class DialogoAlerta extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder ventana =
                new AlertDialog.Builder(getActivity());

        ventana.setTitle("Atención");
        ventana.setMessage("Tienes un mensaje nuevo. Pulsa el botón Atrás para volver a la pantalla principal.");
        ventana.setIcon(android.R.drawable.ic_dialog_email);
        return ventana.create();
    }
}