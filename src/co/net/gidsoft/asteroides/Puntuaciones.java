package co.net.gidsoft.asteroides;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class Puntuaciones extends ListActivity {

	// Lista Generica con Strings
	// @Override
	// public void onCreate(Bundle savedInstanceState) {
	// super.onCreate(savedInstanceState);
	// setContentView(R.layout.puntuaciones);
	// setListAdapter(new ArrayAdapter<String>(this,
	// android.R.layout.simple_list_item_1,
	// Asteroides.almacen.listaPuntuaciones(10)));
	// }

	// Lista con Imagenes y View Personalizada
	// @Override
	// public void onCreate(Bundle savedInstanceState) {
	// super.onCreate(savedInstanceState);
	// setContentView(R.layout.puntuaciones);
	// setListAdapter(
	// new ArrayAdapter<String>(this,
	// R.layout.elemento_lista,
	// R.id.titulo,
	// Asteroides.almacen.listaPuntuaciones(10)));
	// }

	/**
	 * NOTA: En algunos casos el adaptador ha de trabajar con listas muy grandes
	 * o estas listas han de ser creadas desde un servidor. En estos casos es
	 * mejor ir solicitando la información a medida que se va representando. Un
	 * ejemplo se muestra en la aplicación ApiDemos descrita en el capítulo 1,
	 * en la actividad: com.example.android.apis.view.List13
	 */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.puntuaciones);
		setListAdapter(new MiAdaptador(this,
				Asteroides.almacen.listaPuntuaciones(10)));
	}

	@Override
	protected void onListItemClick(ListView listView, View view, int position,
			long id) {
		super.onListItemClick(listView, view, position, id);
		Object o = getListAdapter().getItem(position);
		Toast.makeText(
				this,
				"Selección: " + Integer.toString(position) + " - "
						+ o.toString(), Toast.LENGTH_LONG).show();
	}

}
