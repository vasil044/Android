package com.example.usuario.dialogfragmentdemo;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements EditDFragment.EditNameDialogListener {
    Button dfragbutton;
    Button alertdfragbutton;
    Button editdfragbutton;
    TextView notatext;
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Locate the button in activity_main.xml
        dfragbutton = (Button) findViewById(R.id.dfragbutton);
        alertdfragbutton = (Button) findViewById(R.id.alertdfragbutton);
        editdfragbutton = (Button) findViewById(R.id.editfragbutton);
        // Capture button clicks
        dfragbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                DFragment dFragment = new DFragment();
                // Show DialogFragment
                dFragment.show(fm, "Dialog Fragment");
            }
        });

        // Capture button clicks
        alertdfragbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                AlertDFragment alertdFragment = new AlertDFragment();
                // Show Alert DialogFragment
                alertdFragment.show(fm, "Alert Dialog Fragment");
            }
        });


        // Capture button clicks
        editdfragbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                EditDFragment editdFragment = new EditDFragment();
                // Show Alert DialogFragment
                editdFragment.show(fm, "Edit Dialog Fragment");
            }
        });
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String name, String password) {
        notatext=(TextView) findViewById(R.id.textsalida);
        notatext.setText("Has tecleado:"+name+" y de password:"+password);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
}
