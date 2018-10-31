package com.example.mattheus.trabalho_01_dcc196.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mattheus.trabalho_01_dcc196.Adapters.ListarParticipantesAdapter;
import com.example.mattheus.trabalho_01_dcc196.R;

public class ListarParticipantesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_participantes);

        RecyclerView recyclerView = findViewById(R.id.rclv_listar_participantes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListarParticipantesAdapter adapter = new ListarParticipantesAdapter(Singleton.getInstance().getParticipantes());
        recyclerView.setAdapter(adapter);
    }
}
