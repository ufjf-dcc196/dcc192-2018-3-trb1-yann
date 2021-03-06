package com.example.mattheus.trabalho_01_dcc196.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.mattheus.trabalho_01_dcc196.Adapters.ListarParticipantesAdapter;
import com.example.mattheus.trabalho_01_dcc196.Objetos.Participante;
import com.example.mattheus.trabalho_01_dcc196.R;

public class MainActivity extends Activity {

    public static final int REQUEST_CADASTRO_EVENTO = 1;
    public static final int REQUEST_CADASTRO_PARTICIPANTE = 2;
    public static final int REQUEST_DETALHES_PARTICIPANTE = 3;
    public static final String POSICAO_PARTICIPANTE = "POS";
    public static final String NOME_PARTICIPANTE = "NOME";
    public static final String EMAIL_PARTICIPANTE = "EMAIL";
    public static final String CPF_PARTICIPANTE = "CPF";
    public static final String TITULO_EVENTO = "TITULO";
    public static final String DESCRICAO_EVENTO = "DESCRICAO";
    public static final String FACILITADOR = "FACILITADOR";
    public static final String DATA = "DATA";
    public static final String HORA = "HORA";
    private ListarParticipantesAdapter participanteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvMain = findViewById(R.id.rcl_View_Participantes);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        participanteAdapter = new ListarParticipantesAdapter(Singleton.getInstance().getParticipantes());
        rvMain.setAdapter(participanteAdapter);

        participanteAdapter.setOnParticipanteClickListener(new ListarParticipantesAdapter.OnParticipanteClickListener() {
            @Override
            public void onParticipanteClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, EditarParticipante.class);
                intent.putExtra(MainActivity.POSICAO_PARTICIPANTE, position);
                startActivityForResult(intent, REQUEST_DETALHES_PARTICIPANTE);
            }

            @Override
            public void onLongParticipanteClick(View view, int position) {
                Singleton.getInstance().removeParticipanteEventos(Singleton.getInstance().getParticipantes().get(position));
                Singleton.getInstance().removeParticipante(Singleton.getInstance().getParticipantes().get(position));
                participanteAdapter.notifyItemRemoved(position);
            }
        });

        Button cadparticipante = findViewById(R.id.btn_Cadastrar_Participante);
        cadparticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CadastrarParticipanteActivity.class);
                startActivityForResult(intent, REQUEST_CADASTRO_PARTICIPANTE);

            }
        });

        Button cadevento = findViewById(R.id.btn_Cadastrar_Evento);
        cadevento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastrarEventoActivity.class);
                startActivityForResult(intent, REQUEST_CADASTRO_EVENTO);
            }
        });

        Button listeventos = findViewById(R.id.btn_View_Eventos);
        listeventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListarEventos.class);
                startActivity(intent);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MainActivity.REQUEST_CADASTRO_PARTICIPANTE && resultCode == Activity.RESULT_OK && data != null) {
            Bundle bundleResultado = data.getExtras();
            Participante p = new Participante(bundleResultado.getString(MainActivity.NOME_PARTICIPANTE), bundleResultado.getString(MainActivity.EMAIL_PARTICIPANTE), bundleResultado.getString(MainActivity.CPF_PARTICIPANTE));
            Singleton.getInstance().addParticipante(p);

            participanteAdapter.notifyDataSetChanged();

        }
    }
}
