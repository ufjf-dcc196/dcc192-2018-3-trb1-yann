package com.example.mattheus.trabalho_01_dcc196.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mattheus.trabalho_01_dcc196.Adapters.ListarMeusEventosAdapter;
import com.example.mattheus.trabalho_01_dcc196.Objetos.Participante;
import com.example.mattheus.trabalho_01_dcc196.R;

public class EditarParticipante extends Activity {

    public static final String POSICAO_PARTICIPANTE = "Posição Participante";
    public static final String POSICAO_EVENTO = "Posição Evento";
    private static final int REQUEST_CADASTRAR_EVENTO_PARTICIPANTE = 1;
    private RecyclerView rvMeusEventos;
    private EditText nome;
    private EditText email;
    private EditText cpf;
    private Button btnSalvar;
    private Button btnNovoEvento;
    private Button btnCancelar;
    private ListarMeusEventosAdapter adapter;
    private int posicaoParticipante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_participante);
        final Intent intent = getIntent();
        Bundle bundleResult = intent.getExtras();
        posicaoParticipante = bundleResult.getInt(MainActivity.POSICAO_PARTICIPANTE);


        rvMeusEventos = findViewById(R.id.rv_meus_eventos);
        rvMeusEventos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListarMeusEventosAdapter(Singleton.getInstance().getParticipantes().get(posicaoParticipante).getEventos());
        rvMeusEventos.setAdapter(adapter);

        nome = findViewById(R.id.act_Att_participante_nome);
        email = findViewById(R.id.act_Att_participante_email);
        cpf = findViewById(R.id.act_Att_participante_cpf);
        btnSalvar = findViewById(R.id.act_Att_participante_btnSalvar);
        btnNovoEvento = findViewById(R.id.act_Att_participante_btnNovoEvento);
        btnCancelar = findViewById(R.id.act_Att_participante_btnCancelar);

        nome.setText(Singleton.getInstance().getParticipantes().get(posicaoParticipante).getNome());
        email.setText(Singleton.getInstance().getParticipantes().get(posicaoParticipante).getEmail());
        cpf.setText(Singleton.getInstance().getParticipantes().get(posicaoParticipante).getCPF());

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent attPart = new Intent();
                Participante p = Singleton.getInstance().getParticipantes().get(posicaoParticipante);
                p.setNome(nome.getText().toString());
                p.setEmail(email.getText().toString());
                p.setCPF(cpf.getText().toString());

                setResult(Activity.RESULT_OK, attPart);
                finish();
            }
        });

        btnNovoEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent attPart = new Intent(EditarParticipante.this, ListarEventosParaParticipante.class);
                attPart.putExtra(EditarParticipante.POSICAO_PARTICIPANTE, posicaoParticipante);
                startActivityForResult(attPart, REQUEST_CADASTRAR_EVENTO_PARTICIPANTE);
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent attPart = new Intent();
                setResult(Activity.RESULT_OK, attPart);
                finish();
            }
        });
        adapter.setOnMeusEventosClickListener(new ListarMeusEventosAdapter.OnMeusEventosClickListener() {
            @Override
            public void onMeusEventosClick(View view, int position) {
                Intent intent = new Intent(EditarParticipante.this, Inscritos.class);
                intent.putExtra(EditarParticipante.POSICAO_EVENTO, position);
                intent.putExtra(EditarParticipante.POSICAO_PARTICIPANTE, posicaoParticipante);
                startActivity(intent);
            }

            @Override
            public void onLongMeusEventosClick(View view, int position) {
                int indiceEvento = Singleton.getInstance().getIndiceEvento(Singleton.getInstance().getParticipantes().get(posicaoParticipante).getEventos().get(position));
                Singleton.getInstance().getParticipantes().get(posicaoParticipante).getEventos().remove(position);
                Singleton.getInstance().getEventos().get(indiceEvento).removeParticipante(Singleton.getInstance().getParticipantes().get(posicaoParticipante));
                adapter.notifyDataSetChanged();
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EditarParticipante.REQUEST_CADASTRAR_EVENTO_PARTICIPANTE && resultCode == Activity.RESULT_OK && data != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
