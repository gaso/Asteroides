package co.net.gidsoft.asteroides;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Asteroides extends Activity {

	// Almacenar Puntuaciones
	public static AlmacenPuntuaciones almacen = new AlmacenPuntuacionesArray();
	
	
	//Configuraciones del Juego
	private boolean sys_music;
	private String sys_type_gra;
	private String sys_frag;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Log.i("Activity", "Actividad Inicial en Pantalla");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mi_menu, menu);
		return true;
		/** true -> el menú ya está visible */
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.acercaDeMenu:
			lanzarAcerceDe(null);
			break;
		case R.id.configMenu:
			lanzarPreferencias(null);
			break;
		}
		return true;
		/** true -> consumimos el item, no se propaga */
	}

	public void lanzarAcerceDe(View view) {
		// Instanciar Actividad de "Acerca de"
		Intent i = new Intent(this, AcercaDe.class);
		i.putExtra("jugador", "Pepe");
		// Lanzar Intencion
		startActivityForResult(i, 6969);

	}

	public void lanzarPreferencias(View view) {
		Intent i = new Intent(this, Preferencias.class);
		startActivityForResult(i , 1234);
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.i("Esta " , "o no dentra? " + requestCode);
		Log.i("resultCode " , "resultCode " + resultCode);
		Log.i("resultCode " , "RESULT_OK  " + RESULT_OK);
		
		if (requestCode == 6969 && resultCode == RESULT_OK) {
			String res = data.getExtras().getString("result");
			Log.i("INFORMACION", res);
		}
		
		// A la fecha funciona con el 0 (RESULT_CANCELED) la accion que 
		//desencadena el evento de cierre en Preferencias.java es "onBackPressed"
		if (requestCode == 1234 && resultCode == RESULT_OK) {
			Log.i("Esta " , "o no dentra? " + requestCode);
			configGame(data);
		}
	}

	public void lanzarPuntuaciones(View view) {
		Intent i = new Intent(this, Puntuaciones.class);
		startActivity(i);
	}
	
	public void lanzarJuego(View view) {
		Intent i = new Intent(this, Juego.class);
		startActivity(i);
	}
	
	
	private void configGame(Intent data){
				
		sys_music = data.getExtras().getBoolean("musica");
		sys_type_gra = data.getExtras().getString("t_graficos");
		sys_frag = data.getExtras().getString("fragmentos");
		
		Log.i("musica" , "Aplicacion con musica? "+ sys_music);
		Log.i("Graficos Txt" , "Tipo Graficos "+ sys_type_gra);
		Log.i("Fragmentos" , "Cantidad de Fragmentos "+sys_frag);
		
		Toast.makeText(
				this,
				"Configuraciones de Usuario Aplicadas", Toast.LENGTH_LONG).show();
		
	}
	
}
