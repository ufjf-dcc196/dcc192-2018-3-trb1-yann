package com.example.ylhal.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cad_Evento extends Activity {
    private Button cadastrarEvento;
    private TextView titulo, hora, data, descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        cadastrarEvento = findViewById(R.id.btn_Cadastrar);
        titulo = findViewById(R.id.editTitulo);
        hora = findViewById(R.id.editHora);
        data = findViewById(R.id.editData);
        descricao = findViewById(R.id.editDesc);
        final Intent result = new Intent();
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getInt("CAD") > 1) {
            titulo.setText(extras.getString("Titulo"));
            hora.setText(extras.getString("Hora"));
            data.setText(extras.getString("Data"));
            descricao.setText(extras.getString("Desc"));
            cadastrarEvento.setText("Salvar");
            result.putExtra("Index", extras.getInt("Index"));
            setResult(RESULT_OK, result);
            if (extras.getInt("CAD") == 3) {
                //titulo.setEnabled(false);
                titulo.setInputType(InputType.TYPE_NULL);
                hora.setEnabled(false);
                data.setEnabled(false);
                descricao.setEnabled(false);
                cadastrarEvento.setVisibility(View.INVISIBLE);
                setResult(RESULT_CANCELED, result);
            }
        }
        cadastrarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.putExtra("Titulo", titulo.getText().toString());
                result.putExtra("Data", hora.getText().toString());
                result.putExtra("Hora", data.getText().toString());
                result.putExtra("Descrição", descricao.getText().toString());
                finish();
            }
        });
    }

}
