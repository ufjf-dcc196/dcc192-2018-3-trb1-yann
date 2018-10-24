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
                result.putExtra("nome", nome.getText().toString());
                result.putExtra("email", email.getText().toString());
                result.putExtra("CPF", CPF.getText().toString());
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}