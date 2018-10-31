package com.example.mattheus.trabalho_01_dcc196.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mattheus.trabalho_01_dcc196.Objetos.Evento;
import com.example.mattheus.trabalho_01_dcc196.R;

public class CadastrarEventoActivity extends Activity {
    private EditText txt_titulo, txt_dia, txt_hora, txt_facilitador, txt_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_evento);

        txt_titulo = findViewById(R.id.txt_titulo_evento);
        txt_dia = findViewById(R.id.txt_dia_evento);
        txt_hora = findViewById(R.id.txt_hora_evento);
        txt_facilitador = findViewById(R.id.txt_facilitador_evento);
        txt_desc = findViewById(R.id.txt_descrição_evento);
        Button btn_salvar_evento = findViewById(R.id.btn_salvar_evento);

        btn_salvar_evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultado = new Intent();

                Evento e = new Evento(txt_titulo.getText().toString(), txt_dia.getText().toString(),txt_hora.getText().toString(), txt_facilitador.getText().toString(),txt_desc.getText().toString());
                Singleton.getInstance().addEvento(e);

                setResult(Activity.RESULT_OK, resultado);
                finish();
            }
        });
    }
}
