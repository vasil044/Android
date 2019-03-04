package es.mentor.unidad3.eje8.ventanasdialogo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class DialogoRadioButton extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder ventana =
                new AlertDialog.Builder(getActivity());

        ventana.setIcon(android.R.drawable.ic_dialog_info);
        ventana.setTitle("Selecciona un modelo de teléfono");
        // ¡¡ No se puede incluir un mensaje dentro de este tipo de diálogo!!!
        final CharSequence[] telefonos = {"iPhone", "Nokia", "Android"};
        ventana.setSingleChoiceItems(telefonos, 0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int opcion) {
                // Evento que ocurre cuando el usuario selecciona una opción
                Toast.makeText(getActivity(), "Has seleccionado " + telefonos[opcion], Toast.LENGTH_SHORT).show();
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