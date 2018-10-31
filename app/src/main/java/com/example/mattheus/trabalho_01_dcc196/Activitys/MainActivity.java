package com.example.mattheus.trabalho_01_dcc196.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.mattheus.trabalho_01_dcc196.Adapters.ListarEventosAdapter;
import com.example.mattheus.trabalho_01_dcc196.R;

public class MainActivity extends Activity {

    public static final int REQUEST_CADASTRO_PARTICIPANTE = 1;
    public static final int REQUEST_CADASTRO_EVENTO = 2;
    public static final int REQUEST_LISTAR_EVENTO = 3;
    public static final String POSICAO_PARTICIPANTE = "POS";

    public static final String NOME_PARTICPANTE = "NOME";
    public static final String EMAIL_PARTICPANTE = "EMAIL";
    public static final String CPF_PARTICPANTE = "CPF";
    public static final String MATRICULA_PARTICPANTE = "MATRICULA";

    public static final String TITULO_EVENTO = "TITULO";
    public static final String DESCRICAO_EVENTO = "DESCRICAO";
    public static final String FACILITADOR = "FACILITADOR";
    public static final String DATA = "DATA";
    public static final String HORA = "HORA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_cadastrar_evento = findViewById(R.id.btn_Cadastrar_Evento);
        Button btn_cadastrar_participante = findViewById(R.id.btn_Cadastrar_Participante);
        Button btn_listar_participante = findViewById(R.id.btn_View_Participantes);

        RecyclerView recyclerView = findViewById(R.id.rcl_View_Eventos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListarEventosAdapter adapter = new ListarEventosAdapter(Singleton.getInstance().getEventos());
        recyclerView.setAdapter(adapter);



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

}
