package es.mentor.unidad3.eje8.ventanasdialogo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class VentanasDialogoActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final FragmentManager fragmentManager = getSupportFragmentManager();

		// Crea el Diálogo de tipo Mensaje
		((Button) findViewById(R.id.mensajeDiag)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				DialogoAlerta dialogo = new DialogoAlerta();
				dialogo.show(fragmentManager, "tagAlerta");
			}
		});

		// Crea el Diálogo con 2 botones
		((Button) findViewById(R.id.dos_botonesDiag)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				DialogoConfirmacion dialogo = new DialogoConfirmacion();
				dialogo.show(fragmentManager, "tagConfirmacion");
			}
		});

		// Crea el Diálogo con 3 botones
		((Button) findViewById(R.id.tres_botones_Diag)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				DialogoConfirmacionTresBotones dialogo = new DialogoConfirmacionTresBotones();
				dialogo.show(fragmentManager, "tagConfirmacionTresBotones");
			}
		});

		// Crea el Diálogo con una lista de selección
		((Button) findViewById(R.id.seleccionDiag)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				DialogoSeleccion dialogo = new DialogoSeleccion();
				dialogo.show(fragmentManager, "tagSeleccion");
			}
		});

		// Crea el Diálogo con una barra de progreso
		((Button) findViewById(R.id.barraProgresoDiag)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				DialogoProgreso dialogo = new DialogoProgreso();
				dialogo.show(fragmentManager, "tagProgreso");
			}
		});

		// Crea el Diálogo con una lista de selección de tipo Radio
		((Button) findViewById(R.id.radioButtonDiag)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				DialogoRadioButton dialogo = new DialogoRadioButton();
				dialogo.show(fragmentManager, "tagRadioButton");
			}
		});

		// Crea el Diálogo con un grupo de CheckBox
		((Button) findViewById(R.id.checkboxDiag)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				DialogoSeleccionCheckBox dialogo = new DialogoSeleccionCheckBox();
				dialogo.show(fragmentManager, "tagSeleccionCheckBox");
			}
		});

		// Crea el Diálogopersonalizado con TextBoxs
		((Button) findViewById(R.id.entradaTextoDiag)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				DialogoPersonalizado dialogo = new DialogoPersonalizado();
				dialogo.show(fragmentManager, "tagPersonalizado");
			}
		});


	}
}