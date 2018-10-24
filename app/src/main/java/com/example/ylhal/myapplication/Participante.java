package com.example.ylhal.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Participante extends Activity {
    private Button cadastrar;
    private TextView nome, email, CPF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participante);
        cadastrar = findViewById(R.id.btn_cadastrar);
        nome = findViewById(R.id.editNome);
        email = findViewById(R.id.editEmail);
        CPF = findViewById(R.id.editCPF);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                String name = nome.getText().toString(), Email = email.getText().toString(), cpf = CPF.getText().toString();
                result.putExtra("nome", name);
                result.putExtra("email", Email);
                result.putExtra("CPF", cpf);
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}