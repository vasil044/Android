package es.mentor.unidad3.eje8.ventanasdialogo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DialogoPersonalizado extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder ventana =
                new AlertDialog.Builder(getActivity());

        // Primero preparamos el interior de la ventana de diálogo inflando su fichero XML
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li =(LayoutInflater)getActivity().getSystemService(infService);
        // Inflamos el componente compuesto definido en el XML
        View inflador = li.inflate(R.layout.dialogo_entrada_texto, null);
        // Buscamos los componentes dentro del Diálogo
        final TextView nombreEdit = (TextView) inflador.findViewById(R.id.nombre_edit);
        final TextView passwordEdit = (TextView) inflador.findViewById(R.id.password_edit);

        ventana = new AlertDialog.Builder(getActivity());
        ventana.setTitle("Indica usuario y contraseña");
        // Asignamos el contenido dentro del diálogo (el que hemos inflado previamente)
        ventana.setView(inflador);
        // ¡¡ No se puede incluir un mensaje dentro de este tipo de diálogo!!!
        ventana.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int boton) {
                Toast.makeText(getActivity(), "Has escrito el nombre '" +
                        nombreEdit.getText().toString() + "', la contraseña '" +
                        passwordEdit.getText().toString() + "' y has pulsado el botón 'Aceptar'", Toast.LENGTH_SHORT).show();
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