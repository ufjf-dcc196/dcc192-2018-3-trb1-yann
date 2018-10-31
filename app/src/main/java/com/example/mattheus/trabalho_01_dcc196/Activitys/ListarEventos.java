package com.example.mattheus.trabalho_01_dcc196.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mattheus.trabalho_01_dcc196.Adapters.ListarEventosAdapter;
import com.example.mattheus.trabalho_01_dcc196.R;

public class ListarEventos extends Activity {
    public static final String POSICAO_EVENTO = "Posição Evento";
    private RecyclerView rcListaEvento;
    private ListarEventosAdapter listaEventosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_eventos);


        rcListaEvento = findViewById(R.id.rclistaevento);

        rcListaEvento.setLayoutManager(new LinearLayoutManager(this));

        listaEventosAdapter = new ListarEventosAdapter(Singleton.getInstance().getEventos());

        rcListaEvento.setAdapter(listaEventosAdapter);

        listaEventosAdapter.setOnEventoClickListener(new ListarEventosAdapter.OnEventoClickListener() {
            @Override
            public void onEventoClick(View view, int position) {
                Intent intent = new Intent(ListarEventos.this, DetalhesEventoActivity.class);
                intent.putExtra(ListarEventos.POSICAO_EVENTO, position);
                intent.putExtra(ListarEventosParaParticipanteActivity.ORIGEM_PARTICIPANTE, false);
                startActivity(intent);
            }

            @Override
            public void onLongEventoClick(View view, int position) {
                Singleton.getInstance().removeAllParticipanteEvento(Singleton.getInstance().getEventos().get(position));
                Singleton.getInstance().getEventos().remove(position);
                listaEventosAdapter.notifyDataSetChanged();
            }
        });


    }
}
