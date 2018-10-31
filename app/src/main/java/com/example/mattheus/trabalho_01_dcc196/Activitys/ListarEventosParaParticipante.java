package com.example.mattheus.trabalho_01_dcc196.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mattheus.trabalho_01_dcc196.Adapters.ListaEventoParaParticipanteAdapter;
import com.example.mattheus.trabalho_01_dcc196.Objetos.Evento;
import com.example.mattheus.trabalho_01_dcc196.R;

import java.util.ArrayList;

public class ListarEventosParaParticipante extends Activity {
    public static final String ORIGEM_PARTICIPANTE = "Origem de onde foi chamada a activity";
    private ArrayList<Evento> eventos = new ArrayList<>();
    private RecyclerView rvEventosParaParticipante;
    private int posicaoParticipante;
    private ListaEventoParaParticipanteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_eventos_para_participante);
        final Intent intent = getIntent();
        Bundle bundleResult = intent.getExtras();
        posicaoParticipante = bundleResult.getInt(EditarParticipante.POSICAO_PARTICIPANTE);
        instanciaEventos(posicaoParticipante);
        rvEventosParaParticipante = findViewById(R.id.rv_listar_eventos_para_participante);
        rvEventosParaParticipante.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListaEventoParaParticipanteAdapter(eventos);
        rvEventosParaParticipante.setAdapter(adapter);
        adapter.setOnEventoParaParticipanteClickListener(new ListaEventoParaParticipanteAdapter.OnEventoParaParticipanteClickListener() {
            @Override
            public void onEventoParaParticipanteClick(View view, int position) {
                Intent attPart = new Intent();
                int i = Singleton.getInstance().getEventos().indexOf(eventos.get(position));
                Singleton.getInstance().getParticipantes().
                        get(posicaoParticipante).
                        addEvento(eventos.get(position));

                Singleton.getInstance().getEventos().get(i).addParticipante(Singleton.getInstance().getParticipantes().
                        get(posicaoParticipante));
                setResult(Activity.RESULT_OK, attPart);
                finish();
            }

            @Override
            public void onLongEventoParaParticipanteClick(View view, int position) {
                Intent attPart = new Intent(ListarEventosParaParticipante.this, DetalhesEvento.class);
                int i = Singleton.getInstance().getEventos().indexOf(eventos.get(position));
                attPart.putExtra(ListarEventos.POSICAO_EVENTO, i);
                attPart.putExtra(ListarEventosParaParticipante.ORIGEM_PARTICIPANTE, true);
                startActivity(attPart);
            }
        });
    }

    private void instanciaEventos(int posicaoParticipante) {
        for (Evento e : Singleton.getInstance().getEventos()) {
            if (!Singleton.getInstance().getParticipantes().get(posicaoParticipante).getEventos().contains(e)) {
                eventos.add(e);
            }
        }
    }
}
