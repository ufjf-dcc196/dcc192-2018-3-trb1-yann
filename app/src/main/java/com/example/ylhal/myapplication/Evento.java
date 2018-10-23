package com.example.ylhal.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Evento extends Activity {
    private Button cadastrar;
    private TextView titulo, hora, data, descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        cadastrar = findViewById(R.id.btn_Cadastrar);
        titulo = findViewById(R.id.editTitulo);
        hora = findViewById(R.id.editHora);
        data = findViewById(R.id.editData);
        descricao = findViewById(R.id.editDesc);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
