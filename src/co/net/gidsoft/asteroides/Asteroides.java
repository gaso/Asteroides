package co.net.gidsoft.asteroides;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Asteroides extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Log.i("iniciando", "Aplicion Iniciada");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	       super.onCreateOptionsMenu(menu);
	       MenuInflater inflater = getMenuInflater();
	       inflater.inflate(R.menu.mi_menu, menu);
	       return true; /** true -> el menú ya está visible */
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
         return true; /** true -> consumimos el item, no se propaga*/
}
	
	

	public void lanzarAcerceDe(View view){
		//Instanciar Actividad de "Acerca de"
		Intent i = new Intent(this, AcercaDe.class );
		i.putExtra("jugador", "Pepe");
		//Lanzar Intencion
		startActivityForResult(i, 6969);
			
	}
	
	public void lanzarPreferencias(View view){
		Intent i = new Intent(this, Preferencias.class);
		startActivity(i);
	}

	@Override
	protected void onActivityResult (int requestCode,int resultCode, Intent data){
				if (requestCode==6969 && resultCode==RESULT_OK) {
					String res = data.getExtras().getString("result");
					Log.i("INFORMACION", res);
		}
}

	public void salir(View view) {
		// Cerrar Aplicacion
		finish();
	}
}
