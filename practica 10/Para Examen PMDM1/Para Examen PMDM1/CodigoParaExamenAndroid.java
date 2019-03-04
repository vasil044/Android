Código para examen:

//ÍNDICE//
#1 FindViewBy
#2 Button
#3 Spinner
#4 Uso de imágenes
#5 ListView
#6 Menú Action Bar
#7 Menú Contextual
#8 Varias actividades
#9 Ficheros en raw
#10 SQLite
#11 Girar Dispositivo
#12 Dialog Fragment
#13 Barra de Progreso
#14 Tablets
#15 Acceso a memoria
#16 Errores comunes
//Utilidades:
cadena = cadena.substring(posiciónEmpieza, posiciónTermina);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Cualquier ejercicio.
#1
FinViewBy:

-Ejemplos:
-> ListView list = (ListView) findViewById(R.id.listViewPrincipal);
-> Spinner s = (Spinner) findViewById(R.id.spinner);
-> Button b = (Button) findViewById(R.id.buttonAceptar);
-> EditText desc = (EditText) findViewById(R.id.editText);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Cualquier ejercicio.
#2
Button:

-Ejemplo de uso si se pulsa:
	b.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View view) {
		}
	});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//FaunaMarina,SQLiteNotas.
#3
Spinner:
	-Inicializar un Spinner(Código):
		public void cargarSpinner(Spinner s){
        String [] array = {"Cena","Comida","Reunion","Juegos","Deporte"};
        s.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array));
		}
	
	-Trabajar con lo seleccionado del Spinner:
		-> Se utiliza el siguiente método:
			spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
					if(position==0){
						adaptador = new AdapterFMarina(a,peces);
						lista.setAdapter(adaptador);
					}
					else
					{
						adaptador = new AdapterFMarina(a,alginvert);
						lista.setAdapter(adaptador);
					}
				}
				@Override
				//Si no se selecciona nada en el Spinner, no se hará nada.
				public void onNothingSelected(AdapterView<?> parentView) {
				}
			});
			
	-Sacar la posición del Spinner:
		s.getSelectedItemPosition() -> Devuelve un entero.
		-> Método para sacar nombre del Spinner:
			public String devolverNombreSpinner(Spinner s){
				switch (s.getSelectedItemPosition()){
					case 0:
						return "Cena";
					case 1:
						return "Comida";
					case 2:
						return "Reunion";
					case 3:
						return "Juegos";
					case 4:
						return "Deporte";
					default:
						return "";
				}
			}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//EjercicioListView, FaunaMarina.
#4
Para uso de imágenes:

-Tienen que estar guardadas en la carpeta drawable:

-Código para trabajar con las imágenes guardadas en drawable:
	->Guardar valor de una imagen para operar con ella:
		int atletismo = R.drawable.atletismo;
		return R.drawable.anemona;
		
	->Cómo igualar el contenido de un ImageView con un entero:
		ImageView im = (ImageView)findViewById(R.id.imageView2);
        im.setImageResource(R.drawable.anemona);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//FaunaMarina, EjercicioListView, SQLiteNotas, ListaCompra.
#5
ListView compuestos por objetos complejos:
	-Al ListView hay que meterle un adaptador o adapter:
		->Adaptador, todos siguen un esquema similar:
			public class AdapterDeportes extends ArrayAdapter<Opcion> {

				Activity contexto;

				AdapterDeportes(Activity contexto, Opcion[] datos) {
					//Se llama al constructor de la clase padre y le pasamos el xml que genera la fila, el layout que queremos utilizar y el array.
					super(contexto, R.layout.layoutdeportes, datos);
					this.contexto = contexto;
				}

				//Genera cada elemento del array.
				public View getView(int position, View convertView, ViewGroup parent)
				{

					LayoutInflater inflater = contexto.getLayoutInflater();
					View item = inflater.inflate(R.layout.layoutdeportes, null);

					//Cargamos cada uno de los objetos del array
					Opcion mielemento=getItem(position);

					ImageView imagen=(ImageView)item.findViewById(R.id.Imagen);
					TextView deporte = (TextView)item.findViewById(R.id.Deporte);
					CheckBox checkBox = (CheckBox)item.findViewById(R.id.checkbox);


					imagen.setImageResource(mielemento.getRef_icono());
					deporte.setText(mielemento.getNombre());
					checkBox.setChecked(mielemento.check);

					// Devolvemos la vista que dibuja la opción.
					return(item);
				}
			}
			
	-Elegimos el adaptador que meteremos al ListView.
		AdapterDeportes adaptador = new AdapterDeportes(this,opciones);
		list.setAdapter(adaptador);
		-> El ListView podrá ver sobrescrito continuamente su adaptador, de modo que si queremos eliminar uno de los objetos, lo podemos borrar del ArrayList, crear un nuevo adaptador y metérselo al ListView.
			
	-Para trabajar con los elementos del ListView Compuesto:
		-> Se utilizará el método siguiente:
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int indice, long l) {
            }
        });
	-Debemos crear un layout en la carpeta layout para el ListView:
		<?xml version="1.0" encoding="utf-8"?>
		<AbsoluteLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:app="http://schemas.android.com/apk/res-auto"
			android:layout_width="match_parent" android:layout_height="match_parent">
			<TextView
				android:id="@+id/textViewList1"
				android:layout_width="170dp"
				android:layout_height="42dp"
				android:layout_x="105dp"
				android:layout_y="-1dp"
				android:textSize="18sp" />
			<TextView
				android:id="@+id/textViewList2"
				android:layout_width="127dp"
				android:layout_height="35dp"
				android:layout_x="108dp"
				android:layout_y="41dp" />
			<ImageView
				android:id="@+id/imageView"
				android:layout_width="102dp"
				android:layout_height="86dp"
				android:layout_x="0dp"
				android:layout_y="0dp"
				app:srcCompat="@drawable/exclamacion" />
		</AbsoluteLayout>
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//SQLiteNotas, ListaCompra.
#6
Menú ActionBar:
	-Primero se debe de crear una carpeta menu:
		-> CLICK DERECHO EN RES -> ANDROID RESOURCE DIRECTORY -> SELECCIONAR MENU EN RESOURCE TYPE.
	- Y crear allí un layout del menú:
		-> Layout:
			<?xml version="1.0" encoding="utf-8"?>
			<menu xmlns:android="http://schemas.android.com/apk/res/android"
				xmlns:app="http://schemas.android.com/apk/res-auto"
				xmlns:tools="http://schemas.android.com/tools" tools:context=".MainActivity">
				<item
					android:id="@+id/ItemOpcionCruz"
					android:icon="@android:drawable/ic_input_add"
					android:orderInCategory="102"
					android:title="NUEVO ARTÍCULO"
					app:showAsAction="ifRoom|withText" />
				<item
					android:id="@+id/ItemOpcionCruz"
					android:icon="@drawable/cruz"
					android:orderInCategory="102"
					android:title="NUEVO ARTÍCULO"
					app:showAsAction="ifRoom|withText" />
			</menu>
			-Ya dentro definiremos los objetos, imágenes, etc...que queramos que tenga.
			
	-Después en el main decidiremos cuál es nuestro layout del menú:
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			getMenuInflater().inflate(R.menu.menu_main, menu);
			return true;
		}
		
	-Para elegir la acción que sucede si pulsamos un elemento del menú:
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			int id = item.getItemId();
			if (id == R.id.ItemOpcionCruz) {
				Intent i = new Intent(NotasActivity.this,GestionarNota.class);
				i.putExtra("accion","alta");
				startActivityForResult(i,SECONDARY_ACTIVITY_TAG);
				return true;
			}
			return super.onOptionsItemSelected(item);
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//SQLiteNotas, ListaCompra.
#7
Menú contextual:
	-Primero se debe de crear una carpeta menu.
		-> CLICK DERECHO EN RES -> ANDROID RESOURCE DIRECTORY -> SELECCIONAR MENU EN RESOURCE TYPE.
	-Y crear allí un layout del menú:
		<?xml version="1.0" encoding="utf-8"?>
		<menu xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:android="http://schemas.android.com/apk/res/android">
			<item
				android:id="@+id/itemBorrar"
				android:title="Borrar nota" />
		</menu>
	-Definimos su esquema en el main:
		@Override
		public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
			super.onCreateContextMenu(menu, v, menuInfo);
			MenuInflater inflater = getMenuInflater();
			if(v.getId() == R.id.listViewPrincipal)//Lo asigna al ListView.
			{
				// Inflamos el menú contextual
				inflater.inflate(R.menu.menu_contextual, menu);//Define el esquema xml que sigue el menú contextual.
			}
		}
	-Después se decide para qué elemento de la app funciona.
		registerForContextMenu(list);
	-Finalmente se decide qué va a hacer el menú:
		@Override
		public boolean onContextItemSelected(MenuItem item) {
			//Objeto que ayuda a conseguir información de la opción escogida.
			AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
			switch (item.getItemId()) {
				//Si se selecciona la opción de borrar:
				case R.id.itemBorrar:
					//Borra el producto del ArrayList, reinicia el adaptador y vuelve a asignar al ListView el adaptador reiniciado.
					int pos = info.position;
					int id = adaptador.getItem(pos).getId();
					manager = new NotasBDManager(this);
					manager.eliminar(id);
					adaptador = new NotasBDAdapter(this,manager.volcarDatosAL());
					list.setAdapter(adaptador);
					return true;
				default:
					return super.onContextItemSelected(item);
			}
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//DosActividadesContactos, FaunaMarina, SQLiteNotas.
#8
Varias Actividades:
	->Código imprescindible en el main:
		@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			//Si se cancela la operación de la actividad secundaria.
			if (resultCode == RESULT_CANCELED){
			}
			//Si se ha salido de forma que no se haya cancelado la operación, se hará lo siguiente:
			else {
			}
			}
		}
		private static final int SECONDARY_ACTIVITY_TAG = 1;
		
	-Llamar a la 2a actividad:
		->Llamar a la 2a actividad desde la primera:
			Intent i = new Intent(NotasActivity.this,GestionarNota.class);//Intent(MainActivity.this,ActividadSecundaria.class).
            startActivityForResult(i,SECONDARY_ACTIVITY_TAG);
		->Enviar datos desde la 1a a la 2a:
			Intent i = new Intent(NotasActivity.this,GestionarNota.class);
            i.putExtra("accion",String);//Así se enviarían diferentes datos.
            startActivityForResult(i,SECONDARY_ACTIVITY_TAG);
			
	-En 2a actividad:
		->La 2a tiene que ser igual a la 1a en cuanto a estructura es decir:
			public class GestionarNota extends AppCompatActivity {
			protected void onCreate(Bundle savedInstanceState) {
			}
		->Recibir datos desde la 2a:
			getIntent().getStringExtra("accion");//Devolvería el String cuya etiqueta corresponda a lo que hay entre paréntesis.
		->Enviar datos a la 1a desde la 2a:
			Intent i = new Intent();
			i.putExtra("id", ""+n.getId());
			i.putExtra("categoria", devolverNombreSpinner(s));
			i.putExtra("titulo",""+tit.getText());
			i.putExtra("descripcion",""+desc.getText());
			i.putExtra("accion","mod");
			//Damos por correcto el resultado y finalizamos la 2a actividad.
			setResult(RESULT_OK, i);
			finish();
			
	-Recibir de la 2a en la 1a actividad:
		-> Todo esto iría en la parte de "else" del código imprescindible de más arriba.
		-> data.getStringExtra("accion");
		
	-El manifest tiene que ser algo así:
		<?xml version="1.0" encoding="utf-8"?>
		<manifest xmlns:android="http://schemas.android.com/apk/res/android"
			package="com.example.samuel.sqlitenotas">
			<application
				android:allowBackup="true"
				android:icon="@mipmap/ic_launcher"
				android:label="@string/app_name"
				android:roundIcon="@mipmap/ic_launcher_round"
				android:supportsRtl="true"
				android:theme="@style/AppTheme">
				<activity
					android:name=".NotasActivity">
					<intent-filter>
						<action android:name="android.intent.action.MAIN" />

						<category android:name="android.intent.category.LAUNCHER" />
					</intent-filter>
				</activity>
				//La segunda actividad se declara así:
				<activity
					android:name=".GestionarNota"
					android:parentActivityName=".NotasActivity"
					android:theme="@style/AppTheme.NoActionBar">
					<meta-data
						android:name="android.support.PARENT_ACTIVITY"
						android:value="com.example.samuel.sqlitenotas.NotasActivity" />
				</activity>
			</application>
		</manifest>
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//FaunaMarina.
#9
Ficheros en raw:
	-Lo primero es crearse una carpeta raw donde estén los ficheros.
		-> CLICK DERECHO EN RES -> ANDROID RESOURCE DIRECTORY -> SELECCIONAR RAW EN RESOURCE TYPE.
		
	-En esa carpeta guardaremos los ficheros con los que queramos trabajar.
	-Para llamar y utilizar su contenido aquí hay un ejemplo de código:
		public void rellenarPeces(){
        String linea="ERROR.";
        try
        {
            InputStream fraw =
                    getResources().openRawResource(R.raw.peces);

            BufferedReader brin =
                    new BufferedReader(new InputStreamReader(fraw));
            linea=brin.readLine();
            while (linea!=null){
                String [] splitter= linea.split(",");
                peces.add(new FMarina(asignarImagen(splitter[0]),splitter[1],splitter[2],splitter[3],splitter[4]));

                linea = brin.readLine();
            }
            brin.close();
            fraw.close();
        }
        catch (Exception ex)
        {
            Toast.makeText(this, linea, Toast.LENGTH_SHORT).show();
        }
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//SQLiteNotas.
#10
Usar SQLite:
	-CONECTAR-
	-> cd C:\Users\Samuel\AppData\Local\Android\sdk\platform-tools\ **Buscar esta carpeta**
	-> adb devices  **Nos va a mostrar los emuladores abiertos**
	-> adb -s emulator-5554 shell  **emulator-5554 es el nombre del emulador**
	-> su  **Si no se ejecuta, no nos va a dejar hacer nada**
	-> sqlite3 /data/data/com.example.samuel.pruebaexam/databases/pruebaexam  **/data/data/paqueteApp/databases/nombreBBDD**
	-> **Luego ya podemos usar sqlite3**
	
	-Creamos clase DBHelper que contenga lo siguiente
		public class NotasBDHelper extends SQLiteOpenHelper{

		//Declaramos el nombre de la base de datos y la versión del esquema que se va a usar.
		private static final String DB_NAME = "practica11";
		private static final int DB_SCHEME_VERSION = 1;

		//Constructor.
		public NotasBDHelper(Context contexto){
			super(contexto, DB_NAME, null, DB_SCHEME_VERSION);
		}

		//Cuando se crea este objeto, se crea la base de datos.
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(NotasBDManager.CREATE_TABLE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int i, int i1) {
			db.execSQL("DROP TABLE IF EXISTS notas");
			db.execSQL(NotasBDManager.CREATE_TABLE);
		}
	}
	
	-Creamos clase DBManager que contenga las siguientes operaciones:
	
	//***************Atributos***************.
	private NotasBDHelper helper;
    public SQLiteDatabase db;
    public static final String CREATE_TABLE = "create table notas (\n" +
            "_id integer primary key,\n" +
            "categoria text NOT NULL,\n" +
            "titulo text NOT NULL,\n" +
            "descripcion text NOT NULL)";
    //***************CONSTRUCTORES***************.
    public NotasBDManager(Context context){
        helper = new NotasBDHelper(context);
        db = helper.getWritableDatabase();
    }
	//***************Métodos***************.
    public void insertar2(int _id,String categoria, String titulo, String descripcion){
        String cadena = "INSERT INTO notas values("+_id+",'"+categoria+"','"+titulo+"','"+descripcion+"')";
        db.execSQL(cadena);
    }
    public void eliminar(Context contexto,String campo, String donde){
        String cadena;
        switch(campo){
            case "_id":
                cadena="delete from notas where _id="+donde;
                db.execSQL(cadena);
                break;
            case "categoria":
                cadena="delete from notas where categoria='"+donde+"'";
                db.execSQL(cadena);
                break;
            case "titulo":
                cadena="delete from notas where titulo='"+donde+"'";
                db.execSQL(cadena);
                break;
            case "descripcion":
                cadena="delete from notas where descripcion='"+donde+"'";
                db.execSQL(cadena);
                break;
            default:
                Toast.makeText(contexto, "ERROR AL BORRAR.", Toast.LENGTH_SHORT).show();
        }
    }
    public void close(){
        db.close();
    }
    public void conectado(Context contexto){
        if(db != null)
        {
            Toast.makeText(contexto, "Conectado correctamente a la BBDD.", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(contexto, "No conectado.", Toast.LENGTH_SHORT).show();
        }
    }
    public void mostrarValorEn(Context contexto, String campo, int id){
        switch(campo){
            case "categoria":
                Cursor c = db.rawQuery("SELECT categoria FROM notas WHERE _id="+id, null);
                if (c.moveToFirst()) {
                    String codigo = c.getString(0);
                    Toast.makeText(contexto, codigo, Toast.LENGTH_SHORT).show();
                }
            case "titulo":
                c = db.rawQuery("SELECT titulo FROM notas WHERE _id="+id, null);
                if (c.moveToFirst()) {
                    String codigo = c.getString(0);
                    Toast.makeText(contexto, codigo, Toast.LENGTH_SHORT).show();
                }
                break;
            case "descripcion":
                c = db.rawQuery("SELECT descripcion FROM notas WHERE _id="+id, null);
                if (c.moveToFirst()) {
                    String codigo = c.getString(0);
                    Toast.makeText(contexto, codigo, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Toast.makeText(contexto, "ERROR AL MOSTRAR.", Toast.LENGTH_SHORT).show();
        }
    }
    public ArrayList<Nota> volcarDatosAL(){
        ArrayList<Nota> notas = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM notas", null);
        if (c.moveToFirst()) {
            do {
                String id= c.getString(0);
                String categoria = c.getString(1);
                String titulo = c.getString(2);
                String descripcion = c.getString(3);
                notas.add(new Nota(Integer.valueOf(id),categoria,titulo,descripcion));
            } while(c.moveToNext());
        }
        return notas;
    }
    public void actualizar(int id,String categoria,String titulo,String descripcion){
        String cadena = "update notas set categoria='"+categoria+"',titulo='"+titulo+"',descripcion='"+descripcion+"' where _id="+id;
        db.execSQL(cadena);
    }
    public void eliminar(int id){
        String cadena = "delete from notas where _id="+id;
        db.execSQL(cadena);
    }
    public int devolverIdValido(int num){
        Cursor c = db.rawQuery("SELECT _id FROM notas", null);
        if (c.moveToFirst()) {
            do {
                String id= c.getString(0);
                if(Integer.valueOf(id)==num){
                    num++;
                }
                else{
                    return num;
                }
            } while(c.moveToNext());
        }
        return num++;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#11
//ListCompra.
Girar dispositivo y que todo esté bien.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#12
//ListaCompra.
Dialog Fragment.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#13
//AccesoImagenes_BarraProgreso
Dialog Fragment Barra Progreso.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#14
//FaunaMarinaTablet.
Tablets.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#15
//AccesoImagenes_BarraProgreso
Acceso a memoria.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#16
-Los métodos que reciben un String no pueden recibir enteros y otros datos. El entorno no los muestra como errores pera la app se crashea.
La mejor opción es "convertirlo" a String -> ""+entero.