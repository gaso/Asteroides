package co.net.gidsoft.asteroides;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AcercaDe extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bundle extraInfo = getIntent().getExtras();
		String jugador = extraInfo.getString("jugador");
		Log.i("El Nombre del Jugador es ", jugador);
		
				
		setContentView(R.layout.acercade);
		
		Intent intent = new Intent();
		intent.putExtra("result", "El usuario leyó el texto de Acerca de ");
		setResult(RESULT_OK, intent);
		
	}

}
