package es.mentor.unidad3.eje8.ventanasdialogo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class DialogoSeleccionCheckBox extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder ventana =
                new AlertDialog.Builder(getActivity());

        ventana.setIcon(android.R.drawable.ic_dialog_info);
        ventana.setTitle("Selecciona un modelo de teléfono");
        Resources res = getResources();
        final String[] matriz = res.getStringArray(R.array.elementos_dialog_seleccion2);
        // ¡¡ No se puede incluir un mensaje dentro de este tipo de diálogo!!!
        ventana.setMultiChoiceItems(matriz,
                new boolean[]{false, true, false, true, false, false, false},
                new DialogInterface.OnMultiChoiceClickListener() {
                    public void onClick(DialogInterface dialog, int opcion,
                                        boolean isChecked) {
                        // Evento que ocurre cuando el usuario selecciona una opción
                        if (isChecked)
                            Toast.makeText(getActivity(), "Has seleccionado " + matriz[opcion], Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getActivity(), "Has deseleccionado " + matriz[opcion], Toast.LENGTH_SHORT).show();
                    }
                });
        ventana.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int boton) {
                Toast.makeText(getActivity(), "Has pulsado el botón 'Aceptar'", Toast.LENGTH_SHORT).show();
            }
        });
        ventana.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int boton) {
                Toast.makeText(getActivity(), "Has pulsado el botón 'Cancelar'", Toast.LENGTH_SHORT).show();
            }
        });
        return ventana.create();
    }
}