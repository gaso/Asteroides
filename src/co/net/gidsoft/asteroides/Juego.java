package co.net.gidsoft.asteroides;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Juego extends Activity {

	private VistaJuego vistaJuego;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.juego);

		vistaJuego = (VistaJuego) findViewById(R.id.VistaJuego);
	}

	@Override
	protected void onPause() {
		super.onPause();
		vistaJuego.getThread().pausar();
	}

	@Override
	protected void onResume() {
		super.onResume();
		vistaJuego.getThread().reanudar();
	}

	@Override
	protected void onDestroy() {
		vistaJuego.getThread().detener();
		super.onDestroy();
	}
	
	
	
	/**
	 * Cuando Aplicacion pase a segundo Plano Desactivar Sensores
	 */
	@Override
	protected void onStop(){
		super.onStop();
		vistaJuego.disableSensors();
		Log.i("onStop", "Sensores en Stop");
	}
	
	/**
	 * Cuando Aplicacion retome el foco , activar de nuevo sensores
	 */
	@Override
	protected void onRestart(){
		super.onRestart();
		vistaJuego.enableSensors();
		Log.i("onRestart", "Sensores Activados");
	}
}
