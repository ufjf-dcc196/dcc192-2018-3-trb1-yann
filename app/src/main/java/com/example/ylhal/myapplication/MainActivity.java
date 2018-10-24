package com.example.ylhal.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
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

        evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Evento.class);
                startActivityForResult(intent, EVENTO_CODE);

            }
        });

        participante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MainActivity.EVENTO_CODE &&
                resultCode == Activity.RESULT_OK && data != null) {
            String Titulo = data.getStringExtra("Titulo");
        } else if (requestCode == MainActivity.PART_CODE &&
                resultCode == Activity.RESULT_OK && data != null) {
            String nome = data.getStringExtra("nome");
            String Email = data.getStringExtra("email");
            String CPF = data.getStringExtra("CPF");
            // Salvar dados------------------------------------------
        }
    }

}
