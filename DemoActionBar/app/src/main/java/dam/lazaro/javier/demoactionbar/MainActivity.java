package dam.lazaro.javier.demoactionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private TextView labelResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        labelResultado = (TextView) findViewById(R.id.labelResultado);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.MenuOp1:
                labelResultado.setText("Has pulsado la opcion 1");
                return true;
            case R.id.MenuOp2:
                labelResultado.setText("Has pulsado la opcion 2");
                return true;
            case R.id.MenuOp3:
                labelResultado.setText("Has pulsado la opcion 3");
                return true;
            case R.id.SubMenuOp1:
                labelResultado.setText("Has pulsado la opcion 3.1");
                return true;
            case R.id.SubMenuOp2:
                labelResultado.setText("Has pulsado la opcion 3.2");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
