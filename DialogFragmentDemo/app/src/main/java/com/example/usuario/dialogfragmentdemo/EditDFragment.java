package com.example.usuario.dialogfragmentdemo;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView.OnEditorActionListener;


public class EditDFragment extends DialogFragment  {

    public interface EditNameDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog, String name, String password);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    //private EditText nombreEditText;
    private EditText passEditText;
    private EditText nombreEditText;

    private AlertDialog.Builder ventana;

    public EditDFragment() {
        // Empty constructor required for DialogFragment
    }

    EditNameDialogListener mListener;
    //private Handler mResponseHandler;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = ( EditNameDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement ShareDialogListener");
        }
    }
    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        final View v = inflater.inflate(R.layout.editdialogfragment,null);
        final TextView nombreEdit = (TextView) v.findViewById(R.id.nombre_edit);
        final TextView passwordEdit = (TextView) v.findViewById(R.id.password_edit);
        return new AlertDialog.Builder(getActivity())
                // Set Dialog Icon
                .setIcon(R.drawable.ic_adb_24px)
                // Set Dialog Title
                .setTitle("Edit DialogFragment")
                //Set XML file
                .setView(v)
                // Set Dialog Message
                .setMessage("Edit DialogFragment Tutorial")

                // Positive button
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Toast.makeText(getActivity(), "Has escrito el nombre '"+nombreEdit.getText().toString() +"', el password '"+passwordEdit.getText().toString() +"' y has pulsado el boton 'Aceptar'", Toast.LENGTH_SHORT).show();
                        String name=nombreEdit.getText().toString();
                        String pass=passwordEdit.getText().toString();
                        mListener.onDialogPositiveClick(EditDFragment.this,name,pass);
                    }
                })

                // Negative Button
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,    int which) {
                        // Do something else
                        Toast.makeText(getActivity(), " Has pulsado el boton 'Cancelar'", Toast.LENGTH_SHORT).show();
                    }
                }).create();
    }


}