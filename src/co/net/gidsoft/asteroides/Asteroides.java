package co.net.gidsoft.asteroides;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
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

	// Configuraciones del Juego
	private boolean sys_music;
	private String sys_type_gra;
	private String sys_frag;
	private MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
		mp = MediaPlayer.create(this, R.raw.audio);
		mp.start();
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
		startActivityForResult(i, 1234);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.i("Esta ", "o no dentra? " + requestCode);
		Log.i("resultCode ", "resultCode " + resultCode);
		Log.i("resultCode ", "RESULT_OK  " + RESULT_OK);

		if (requestCode == 6969 && resultCode == RESULT_OK) {
			String res = data.getExtras().getString("result");
			Log.i("INFORMACION", res);
		}

		// A la fecha funciona con el 0 (RESULT_CANCELED) la accion que
		// desencadena el evento de cierre en Preferencias.java es
		// "onBackPressed"
		if (requestCode == 1234 && resultCode == RESULT_OK) {
			Log.i("Esta ", "o no dentra? " + requestCode);
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

	private void configGame(Intent data) {

		sys_music = data.getExtras().getBoolean("musica");
		sys_type_gra = data.getExtras().getString("t_graficos");
		sys_frag = data.getExtras().getString("fragmentos");

		Log.i("musica", "Aplicacion con musica? " + sys_music);
		Log.i("Graficos Txt", "Tipo Graficos " + sys_type_gra);
		Log.i("Fragmentos", "Cantidad de Fragmentos " + sys_frag);

		Toast.makeText(this, "Configuraciones de Usuario Aplicadas",
				Toast.LENGTH_LONG).show();

	}

	// Prueba Ciclo de Vida Aplicacion
	@Override
	protected void onStart() {
		super.onStart();
		Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
		if (mp!= null){
			mp.start();
		}
	}

	@Override
	protected void onPause() {
		Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
		super.onPause();
		
		if (mp != null){
			mp.pause();
		}
		
	}

	@Override
	protected void onStop() {
		Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
		super.onStop();
		
		if (mp != null){
			mp.pause();
		}
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
		if (mp == null){
			mp = MediaPlayer.create(this, R.raw.audio);
		}
		mp.start();
	}

	@Override
	protected void onDestroy() {
		Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
		super.onDestroy();
		if (mp != null){
			mp.stop();
		}
	}
	
	
	//Guardar el estado de las Variables
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if( mp!= null){
			outState.putInt("pos", mp.getCurrentPosition());
		}
	};
	
	
	//Recuperar el estado de las Variables
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		
		if(mp != null && savedInstanceState != null){
			mp.seekTo(savedInstanceState.getInt("pos"));
		}
		
	}

}
