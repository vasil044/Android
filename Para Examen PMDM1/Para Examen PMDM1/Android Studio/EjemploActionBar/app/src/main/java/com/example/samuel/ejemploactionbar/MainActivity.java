package com.example.samuel.ejemploactionbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Button b = (Button) findViewById(R.id.button);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //registerForContextMenu(b);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.ItemOpcionContextual1){
            Toast.makeText(getApplicationContext(),"Opción contextual 1.", Toast.LENGTH_SHORT);
        }
        if(id == R.id.ItemOpcionContextual1){
            Toast.makeText(getApplicationContext(),"Opción contextual 2.", Toast.LENGTH_SHORT);
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast toast1;
        switch (item.getItemId()){
            case R.id.ItemOpcion1:
                toast1 = Toast.makeText(getApplicationContext(),"Opción 1.", Toast.LENGTH_SHORT);
                toast1.show();
                break;
            case R.id.ItemOpcion2:
                toast1 = Toast.makeText(getApplicationContext(),"Opción 2.", Toast.LENGTH_SHORT);
                toast1.show();
                break;
            case R.id.ItemOpcionCruz:
                toast1 = Toast.makeText(getApplicationContext(),"Opción +.", Toast.LENGTH_SHORT);
                toast1.show();
                break;
            case R.id.ItemOpcionX:
                toast1 = Toast.makeText(getApplicationContext(),"Opción X.", Toast.LENGTH_SHORT);
                toast1.show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
