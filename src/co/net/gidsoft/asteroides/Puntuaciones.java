package co.net.gidsoft.asteroides;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Puntuaciones extends ListActivity {

// Lista Generica con Strings
//	@Override 
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.puntuaciones);
//		setListAdapter(new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1,
//				Asteroides.almacen.listaPuntuaciones(10)));
//	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.puntuaciones);
		 setListAdapter(
                 new ArrayAdapter<String>(this,
                       R.layout.elemento_lista,
                 R.id.titulo,
                       Asteroides.almacen.listaPuntuaciones(10)));
	}

}
