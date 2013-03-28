package co.net.gidsoft.asteroides;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

public class Preferencias extends PreferenceActivity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferencias);
		
		
	}
	
	@Override //Codigo de Resultado CANCEL
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		//configUser();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Configuraciones del Usuario Escogidas
	 */
	private void configUser(){
		
		SharedPreferences preferencesUser =PreferenceManager.getDefaultSharedPreferences(this);
			
		Intent intent = new Intent();		
		intent.putExtra("musica", preferencesUser.getBoolean("musica", true));
		intent.putExtra("t_graficos", preferencesUser.getString("graficos", "1"));
		intent.putExtra("fragmentos", preferencesUser.getString("fragmentos", "3"));
		
		//RESULT_OK => Deberia de ser el Correcto
		setResult(RESULT_OK, intent);
		setResult(RESULT_CANCELED, intent);
		finish();
	}
	
}
