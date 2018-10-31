package com.example.mattheus.trabalho_01_dcc196.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mattheus.trabalho_01_dcc196.Objetos.Evento;
import com.example.mattheus.trabalho_01_dcc196.R;

public class EditarEvento extends Activity {
    private EditText nomeEvento;
    private EditText dataEvento;
    private EditText horarioEvento;
    private EditText facilitadorEvento;
    private EditText descricaoEvento;
    private Button btnOk;
    private int posicaoEvento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_evento);
        final Intent intent = getIntent();
        Bundle bundleResult = intent.getExtras();
        posicaoEvento = bundleResult.getInt(DetalhesEvento.POSICAO_EVENTO, -1);
        nomeEvento = findViewById(R.id.act_att_Evento_Nome);
        dataEvento = findViewById(R.id.act_att_evento_Data);
        horarioEvento = findViewById(R.id.act_att_evento_Horario);
        facilitadorEvento = findViewById(R.id.act_att_evento_Facilitador);
        descricaoEvento = findViewById(R.id.act_att_evento_Descricao);
        btnOk = findViewById(R.id.act_att_evento_btnOk);
        setInformacoes();
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Evento e = Singleton.getInstance().getEventos().get(posicaoEvento);
                e.setDescricao(descricaoEvento.getText().toString());
                e.setData(dataEvento.getText().toString());
                e.setFacilitador(facilitadorEvento.getText().toString());
                e.setHora(horarioEvento.getText().toString());
                e.setTitulo(nomeEvento.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

    private void setInformacoes() {
        nomeEvento.setText(Singleton.getInstance().getEventos().get(posicaoEvento).getTitulo());
        horarioEvento.setText(Singleton.getInstance().getEventos().get(posicaoEvento).getHora());
        facilitadorEvento.setText(Singleton.getInstance().getEventos().get(posicaoEvento).getFacilitador());
        descricaoEvento.setText(Singleton.getInstance().getEventos().get(posicaoEvento).getDescricao());
        dataEvento.setText(Singleton.getInstance().getEventos().get(posicaoEvento).getData());
    }
}
