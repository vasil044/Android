package com.example.usuario.dialogfragmentdemo;

/**
 * Created by usuario on 13/10/2016.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class AlertDFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                // Set Dialog Icon
                .setIcon(R.drawable.ic_adb_24px)
                // Set Dialog Title
                .setTitle("Alert DialogFragment")
                // Set Dialog Message
                .setMessage("Alert DialogFragment Tutorial")

                // Positive button
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), " Has pulsado el boton 'OK'", Toast.LENGTH_SHORT).show();

                    }
                })

                // Negative Button
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,    int which) {
                        Toast.makeText(getActivity(), " Has pulsado el boton 'Cancel'", Toast.LENGTH_SHORT).show();
                    }
                }).create();
    }
}
