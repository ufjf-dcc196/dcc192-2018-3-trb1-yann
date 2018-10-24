package com.example.ylhal.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
        cadastrarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra("Titulo", titulo.getText().toString());
                result.putExtra("Data", hora.getText().toString());
                result.putExtra("Hora", data.getText().toString());
                result.putExtra("Descrição", descricao.getText().toString());
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}
