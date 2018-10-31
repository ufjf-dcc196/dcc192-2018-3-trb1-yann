package com.example.mattheus.trabalho_01_dcc196.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mattheus.trabalho_01_dcc196.Adapters.ListarParticipantesAdapter;
import com.example.mattheus.trabalho_01_dcc196.R;

public class Inscritos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_participantes);
        final Intent intent = getIntent();
        Bundle bundleResult = intent.getExtras();
        RecyclerView rvParticipantesEvento = findViewById(R.id.rclv_listar_participantes);
        int posicaoEvento = -1;
        int posicaoParticipante = -1;
        if (bundleResult != null) {
            posicaoEvento = bundleResult.getInt(EditarParticipante.POSICAO_EVENTO);
            posicaoParticipante = bundleResult.getInt(EditarParticipante.POSICAO_PARTICIPANTE);
        }
        ListarParticipantesAdapter adapter = new ListarParticipantesAdapter(Singleton.getInstance().getParticipantes().get(posicaoParticipante).getEventos().get(posicaoEvento).getParticipantes());

        rvParticipantesEvento.setLayoutManager(new LinearLayoutManager(this));
        rvParticipantesEvento.setAdapter(adapter);
    }
}
