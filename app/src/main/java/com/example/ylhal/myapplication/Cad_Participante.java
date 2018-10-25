package com.example.ylhal.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cad_Participante extends Activity {
    private TextView nome, email, CPF, aviso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participante);
        Button cadastrar = findViewById(R.id.btn_cadastrar);
        nome = findViewById(R.id.editNome);
        email = findViewById(R.id.editEmail);
        CPF = findViewById(R.id.editCPF);
        aviso = findViewById(R.id.aviso2);
        Bundle extras = getIntent().getExtras();
        final Intent result = new Intent();
        if (extras != null && extras.getInt("CAD") > 1) {
            nome.setText(extras.getString("Nome"));
            email.setText(extras.getString("Email"));
            CPF.setText(extras.getString("CPF"));
            cadastrar.setText("Salvar");
            result.putExtra("Index", extras.getInt("Index"));
            if (extras.getInt("CAD") == 3) {
                nome.setEnabled(false);
                email.setEnabled(false);
                CPF.setEnabled(false);
                cadastrar.setText("Voltar");
                cadastrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setResult(RESULT_CANCELED, result);
                        finish();
                    }
                });
            }
        }
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nome.getText() != null && email.getText() != null && CPF.getText() != null) {
                    result.putExtra("nome", nome.getText().toString());
                    result.putExtra("email", email.getText().toString());
                    result.putExtra("CPF", CPF.getText().toString());
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