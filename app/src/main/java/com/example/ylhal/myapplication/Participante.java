package com.example.ylhal.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Participante extends Activity {
    private Button cadastrar;
    private TextView nome, email, cpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participante);
        cadastrar = findViewById(R.id.btn_cadastrar);
        nome = findViewById(R.id.editNome);
        email = findViewById(R.id.editEmail);
        cpf = findViewById(R.id.editCPF);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
