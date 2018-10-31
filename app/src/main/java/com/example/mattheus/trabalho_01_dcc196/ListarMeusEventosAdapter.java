package com.example.mattheus.trabalho_01_dcc196;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListaMeusEventoAdapter extends RecyclerView.Adapter<ListaMeusEventoAdapter.ViewHolder> {
    private ArrayList<Evento> eventos = new ArrayList<>();
    private OnMeusEventosClickListener listener;

    @NonNull
    @Override
    public ListaMeusEventoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ListaMeusEventoAdapter.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface OnMeusEventosClickListener {
        void onMeusEventosClick(View view, int position);

        void onLongMeusEventosClick(View view, int position);
    }
}
