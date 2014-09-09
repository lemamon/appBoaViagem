package com.sadseacode.boaviagem;

import com.sadseacode.boaviagem.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
//import android.text.style.BulletSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText usuario;
	private EditText senha;
	private Button entrarButton;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		usuario = (EditText)findViewById(R.id.usuario);
		senha = (EditText)findViewById(R.id.senha);
		
		entrarButton = (Button)findViewById(R.id.entrarButton);
		entrarButton.setOnClickListener(entrarButtonListener);
	}
	
	
	private OnClickListener entrarButtonListener = new OnClickListener() {
		@Override
		public void onClick(View view) {
			String usuarioInformado = usuario.getText().toString();
			String senhaInformada = senha.getText().toString();
			
			if("leitor".equals(usuarioInformado)&&"123".equals(senhaInformada)){
				Intent intent = new Intent(view.getContext(), DashboardActivity.class);		
				startActivity(intent);
			
			}else{	
				Builder builder = new Builder(view.getContext());
				builder.setMessage(R.string.erro_autenticacao);
				builder.setPositiveButton("Ok", null);
				
				AlertDialog alert = builder.create();
				alert.show();
				senha.setText("");
				/*
				String msgErro = getString(R.string.erro_autenticacao);
				Toast toast = Toast.makeText(view.getContext(), msgErro, Toast.LENGTH_SHORT);
				toast.show();*/
			}
		}
	};

	
}
