package com.example.ylhal.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends Activity {
    public static ArrayList<Evento> eventos;
    private static ArrayList<Participante> participantes;
    private Button evento, participante;
    private RecyclerView rv;
    public static int EVENTO_CODE = 1, PART_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        participante = findViewById(R.id.btn_participante);
        evento = findViewById(R.id.btn_evento);
        rv = findViewById(R.id.Listas);
        eventos = new ArrayList<>();
        participantes = new ArrayList<>();

        evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cad_Evento.class);
                startActivityForResult(intent, EVENTO_CODE);

            }
        });

        participante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cad_Participante.class);
                startActivityForResult(intent, PART_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MainActivity.EVENTO_CODE && resultCode == Activity.RESULT_OK && data != null) {
            String titulo = data.getStringExtra("Titulo");
            String dia = data.getStringExtra("Data");
            String hora = data.getStringExtra("Hora");
            String facilitador = data.getStringExtra("Facilitador");
            String desc = data.getStringExtra("Descrição");
            if (data.getIntExtra("CAD", 1) == 2)
                eventos.remove(data.getIntExtra("Index", -1));
            eventos.add(new Evento(titulo, dia, hora, facilitador, desc));

        } else if (requestCode == MainActivity.PART_CODE && resultCode == Activity.RESULT_OK && data != null) {
            String nome = data.getStringExtra("nome");
            String Email = data.getStringExtra("email");
            String CPF = data.getStringExtra("CPF");
            if (data.getIntExtra("CAD", 1) == 2)
                participantes.remove(data.getIntExtra("Index", -1));
            participantes.add(new Participante(nome, Email, CPF));
        }
    }

}
