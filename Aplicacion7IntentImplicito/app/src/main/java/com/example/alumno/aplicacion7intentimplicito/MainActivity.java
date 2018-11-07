package com.example.alumno.aplicacion7intentimplicito;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    Intent i;
    Spinner persona;
    String[] elementos;
    ImageView imagen;
    Button progresDialog;
    EditText texto;
    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spiner tipo de persona
        persona = (Spinner) findViewById(R.id.spinner);
        elementos = getResources().getStringArray(R.array.tipo_personas);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, elementos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        persona.setAdapter(adapter);

        //Texto
        texto = (EditText) findViewById(R.id.editTextDescripcion);

        //Imagen
        imagen = (ImageView) findViewById(R.id.imageViewImagen);

        //Progres Dialog
        //progresDialog = (Button) findViewById(R.id.buttonEnviar);
        // progresDialog.setOnClickListener(new View.OnClickListener() {

        //Permisos
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            }
        }
    }

    public void cargar(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Progreso");
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setMessage("Cargando informacion");
        progressDialog.setMax(100);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(false);
        progressDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                progressDialog.dismiss();
                Toast toast = Toast.makeText(getApplicationContext(), "Cancelado", Toast.LENGTH_SHORT);
                toast.show();

            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (progressDialog.getProgress() <= progressDialog.getMax()) {
                        Thread.sleep(200);
                        progressDialog.incrementProgressBy(10);
                        if (progressDialog.getProgress() == progressDialog.getMax()) {
                            progressDialog.dismiss();
                            /*
                            Toast toast1 = Toast.makeText(getApplicationContext(), "Enviado", Toast.LENGTH_SHORT);
                            toast1.show();
                            */
                        }
                    }
                } catch (Exception e) {

                }
            }
        }).start();
        progressDialog.show();
    }

    public void cargarImagen(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent.createChooser(intent, "Selecciona la aplicacion"), 10);
    }

    /*
    public void formularioInicial() {
        texto.setText("");
        persona.setSelection(0);
    }
    */
}
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Uri path = data.getData();
            imagen.setImageURI(path);
        }
    }
    */
    /*
    private int miProgreso;
    private Handler miProgresoHandler;
    private static final int PROGRESO_MAX = 100;
    private ProgressDialog miProgresoDialog;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        miProgresoDialog = new ProgressDialog(MainActivity.this);
        miProgreso = 0;
        miProgresoDialog.setProgress(0);

        miProgresoDialog.setIcon(android.R.drawable.ic_dialog_info);
        miProgresoDialog.setTitle("Descargando...");
        miProgresoDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        miProgresoDialog.setMax(PROGRESO_MAX);
        miProgresoDialog.setButton(DialogInterface.BUTTON_POSITIVE,"Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int boton) {
                Toast.makeText(getApplicationContext(), "Has pulsado el botón 'Aceptar'", Toast.LENGTH_SHORT).show();
            }
        });
        miProgresoDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int boton) {
                Toast.makeText(getApplicationContext(), "Has pulsado el botón 'Cancelar'", Toast.LENGTH_SHORT).show();
            }
        });
        // Controlador (hilo) que simula un cambio en el progreso.
        // Es como un temporizador que usamos para dibujar la barra de progreso
        // en una ventana de diálogo.
        miProgresoHandler = new Handler() {
            @Override
            public void handleMessage(Message msj) {
                super.handleMessage(msj);
                if (miProgreso >= PROGRESO_MAX) {
                    miProgresoDialog.dismiss();
                } else {
                    miProgreso++;
                    miProgresoDialog.incrementProgressBy(1);
                    miProgresoHandler.sendEmptyMessageDelayed(0, 100);
                }
            }
        };
        miProgresoHandler.sendEmptyMessage(0);
        return miProgresoDialog;
    }

    // Cuando desaparece la ventana de Diálogo paramos el Controlador (hilo) que simula el progreso
    @Override
    public void onStop() {
        super.onStop();
        miProgresoHandler.removeCallbacksAndMessages(null);
    }
}
*/
/*
    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void verifyPermission()
    {
        //WRITE_EXTERNAL_STORAGE tiene implícito READ_EXTERNAL_STORAGE
        //porque pertenecen al mismo grupo de permisos
        int writePermission = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (writePermission != PackageManager.PERMISSION_GRANTED){
            requestPermission();
        }
        else {
            saveComments();
        }
    }

    private void requestPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            showSnackBar();
        }else
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_WRITE_EXTERNAL_STORAGE);
    }

    private void showSnackBar() {
        Snackbar.make(mLayout,R.string.permission_write_storage,Snackbar.LENGTH_LONG)
                .setAction(R.string.settings, new View.OnClickListener() {
                    @Override public void onClick(View view){
                        openSettings();
                    }}).show();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_WRITE_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                saveComments();
            }else {
                showSnackBar();
            }
        }
    }
    */
