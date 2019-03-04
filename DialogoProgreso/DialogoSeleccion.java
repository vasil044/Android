package es.mentor.unidad3.eje8.ventanasdialogo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class DialogoSeleccion extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder ventana =
                new AlertDialog.Builder(getActivity());
        ventana.setIcon(android.R.drawable.ic_dialog_alert);
        ventana.setTitle("Selecciona una opción");
        ventana.setItems(R.array.elementos_dialog_seleccion, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int opcion) {
                // El usuario selecciona una de las opciones del listado
                String[] opciones = getResources().getStringArray(R.array.elementos_dialog_seleccion);
                Toast.makeText(getActivity(), "Has selecciondo la '" + opciones[opcion] + "'", Toast.LENGTH_SHORT).show();
            }
        });
        return ventana.create();
    }
}