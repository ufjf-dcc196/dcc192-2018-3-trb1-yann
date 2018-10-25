package com.example.ylhal.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cad_Participante extends Activity {
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
        Bundle extras = getIntent().getExtras();
        final Intent result = new Intent();
        if (extras != null && extras.getInt("CAD") > 1) {
            nome.setText(extras.getString("Nome"));
            email.setText(extras.getString("Email"));
            CPF.setText(extras.getString("CPF"));
            cadastrar.setText("Salvar");
            result.putExtra("Index", extras.getInt("Index"));
            setResult(RESULT_OK, result);
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
                result.putExtra("nome", nome.getText().toString());
                result.putExtra("email", email.getText().toString());
                result.putExtra("CPF", CPF.getText().toString());
                finish();
            }
        });
    }
}