package com.example.mattheus.trabalho_01_dcc196.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mattheus.trabalho_01_dcc196.Adapters.ListarParticipantesAdapter;
import com.example.mattheus.trabalho_01_dcc196.R;

public class DetalhesEvento extends Activity {

    public static final String POSICAO_EVENTO = "Posiçao do Evento";
    private static final int REQUEST_ATUALIZAR_EVENTO = 1;

    private ListarParticipantesAdapter adapter;
    private TextView txtTitulo, txtData, txtHorario, txtFacilitador, txtDescricao;
    private int posicaoEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_evento);
        final Intent intent = getIntent();
        Bundle bundleResult = intent.getExtras();
        txtTitulo = findViewById(R.id.act_detalhes_evento_titulo);
        txtData = findViewById(R.id.act_detalhes_evento_data);
        txtDescricao = findViewById(R.id.act_detalhes_evento_Descricao);
        txtFacilitador = findViewById(R.id.act_detalhes_evento_Facilitador);
        txtHorario = findViewById(R.id.act_detalhes_evento_Hora);
        RecyclerView rvParticipantesEvento = findViewById(R.id.rcDetalhesEvento);
        Button btnEditarInfoEvento = findViewById(R.id.act_detalhes_evento_btnEdit);

        if (bundleResult != null) {
            posicaoEvento = bundleResult.getInt(ListarEventos.POSICAO_EVENTO);
            if (bundleResult.getBoolean(ListarEventosParaParticipante.ORIGEM_PARTICIPANTE)) {
                btnEditarInfoEvento.setEnabled(false);
            }
        }

        setInformacoes();

        adapter = new ListarParticipantesAdapter(Singleton.getInstance().getEventos().get(posicaoEvento).getParticipantes());
        rvParticipantesEvento.setLayoutManager(new LinearLayoutManager(this));
        rvParticipantesEvento.setAdapter(adapter);


        adapter.setOnParticipanteClickListener(new ListarParticipantesAdapter.OnParticipanteClickListener() {
            @Override
            public void onParticipanteClick(View view, int position) {
                int i = Singleton.getInstance().getParticipantes()
                        .indexOf(Singleton.getInstance().getEventos().get(posicaoEvento).getParticipantes().get(position));
                Intent intent = new Intent(DetalhesEvento.this, EditarParticipante.class);
                intent.putExtra(MainActivity.POSICAO_PARTICIPANTE, i);
                startActivity(intent);
            }

            @Override
            public void onLongParticipanteClick(View view, int position) {
                Singleton.getInstance().removeParticipanteDoEvento(
                        Singleton.getInstance().getEventos().get(posicaoEvento),
                        Singleton.getInstance().getEventos().get(posicaoEvento).getParticipantes().get(position));

                Singleton.getInstance().getEventos().get(posicaoEvento).getParticipantes().remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        btnEditarInfoEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalhesEvento.this, EditarEvento.class);
                intent.putExtra(DetalhesEvento.POSICAO_EVENTO, posicaoEvento);
                startActivityForResult(intent, REQUEST_ATUALIZAR_EVENTO);
            }
        });
    }

    private void setInformacoes() {
        txtTitulo.setText(Singleton.getInstance().getEventos().get(posicaoEvento).getTitulo());
        txtHorario.setText(Singleton.getInstance().getEventos().get(posicaoEvento).getHora());
        txtFacilitador.setText(Singleton.getInstance().getEventos().get(posicaoEvento).getFacilitador());
        txtDescricao.setText(Singleton.getInstance().getEventos().get(posicaoEvento).getDescricao());
        txtData.setText(Singleton.getInstance().getEventos().get(posicaoEvento).getData());
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == DetalhesEvento.REQUEST_ATUALIZAR_EVENTO && resultCode == Activity.RESULT_OK && data != null) {
            setInformacoes();
        }
    }
}
