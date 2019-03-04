package es.mentor.unidad3.eje8.ventanasdialogo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.widget.Toast;


public class DialogoConfirmacion extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder ventana =
                new AlertDialog.Builder(getActivity());

        ventana.setIcon(android.R.drawable.ic_dialog_info);
        ventana.setTitle("Encuesta");
        ventana.setMessage("¿Te gusta el fúbol?");
        ventana.setCancelable(false);
        ventana.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int boton) {
                /* Sentencias si el usuario pulsa Sí */
                Toast.makeText(getActivity(), "Has pulsado el botón 'Sí'", Toast.LENGTH_SHORT).show();
            }
        });
        ventana.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int boton) {
                /* Sentencias si el usuario pulsa No */
                Toast.makeText(getActivity(), "Has pulsado el botón 'No'", Toast.LENGTH_SHORT).show();
            }
        });
        return ventana.create();
    }
}