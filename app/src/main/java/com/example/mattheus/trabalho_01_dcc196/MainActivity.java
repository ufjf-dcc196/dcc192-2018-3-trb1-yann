package com.example.mattheus.trabalho_01_dcc196;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_cadastrar_evento, btn_listar_participante, btn_cadastrar_participante;
    public static final int REQUEST_CADASTRO_PARTICIPANTE = 1;
    public static final int REQUEST_CADASTRO_EVENTO = 1;
    public static final int REQUEST_LISTAR_EVENTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_cadastrar_evento = findViewById(R.id.btn_Cadastrar_Evento);
        btn_cadastrar_participante = findViewById(R.id.btn_Cadastrar_Participante);
        btn_listar_participante = findViewById(R.id.btn_View_Participantes);

        btn_cadastrar_participante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastrarParticipanteActivity.class);
                startActivityForResult(intent, MainActivity.REQUEST_CADASTRO_PARTICIPANTE);
            }
        });

        btn_cadastrar_evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastrarEventoActivity.class);
                startActivityForResult(intent, MainActivity.REQUEST_CADASTRO_EVENTO);
            }
        });

        btn_listar_participante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListarParticipantesActivity.class);
                startActivityForResult(intent, MainActivity.REQUEST_LISTAR_EVENTO);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

    }
}