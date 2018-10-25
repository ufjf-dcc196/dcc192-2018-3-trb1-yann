package com.example.ylhal.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cad_Evento extends Activity {
    private Button cadastrarEvento;
    private TextView titulo, hora, data, facilitador, descricao, aviso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        cadastrarEvento = findViewById(R.id.btn_Cadastrar);
        titulo = findViewById(R.id.editTitulo);
        hora = findViewById(R.id.editHora);
        data = findViewById(R.id.editData);
        facilitador = findViewById(R.id.editFacilitador);
        descricao = findViewById(R.id.editDesc);
        aviso = findViewById(R.id.aviso);
        Bundle extras = getIntent().getExtras();
        final Intent result = new Intent();
        if (extras != null && extras.getInt("CAD") > 1) {
            titulo.setText(extras.getString("Titulo"));
            hora.setText(extras.getString("Hora"));
            data.setText(extras.getString("Data"));
            facilitador.setText(extras.getString("Facilitador"));
            descricao.setText(extras.getString("Desc"));
            cadastrarEvento.setText("Salvar");
            result.putExtra("Index", extras.getInt("Index"));
            if (extras.getInt("CAD") == 3) {
                titulo.setEnabled(false);
                hora.setEnabled(false);
                data.setEnabled(false);
                descricao.setEnabled(false);
                cadastrarEvento.setText("Voltar");
                setResult(RESULT_CANCELED, result);
                finish();
            }
        }
        cadastrarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titulo.getText() != null && hora.getText() != null && data.getText() != null && facilitador.getText() != null && descricao.getText() != null) {
                    result.putExtra("Titulo", titulo.getText().toString());
                    result.putExtra("Data", hora.getText().toString());
                    result.putExtra("Hora", data.getText().toString());
                    result.putExtra("Facilitador", facilitador.getText().toString());
                    result.putExtra("Descrição", descricao.getText().toString());
                    setResult(RESULT_OK, result);
                    finish();
                } else {
                    aviso.setText("Todos os campos devem ser preenchidos");
                    aviso.setTextColor(Color.RED);
                }
            }
        });
    }

}
