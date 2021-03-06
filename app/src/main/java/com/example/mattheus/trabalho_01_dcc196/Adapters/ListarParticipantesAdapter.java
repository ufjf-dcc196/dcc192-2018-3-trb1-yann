package com.example.mattheus.trabalho_01_dcc196.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mattheus.trabalho_01_dcc196.Objetos.Participante;
import com.example.mattheus.trabalho_01_dcc196.R;

import java.util.ArrayList;

public class ListarParticipantesAdapter extends RecyclerView.Adapter<ListarParticipantesAdapter.ViewHolder> {
    private ArrayList<Participante> participantes;
    private OnParticipanteClickListener listener;

    public ListarParticipantesAdapter(ArrayList<Participante> participantes) {
        this.participantes = participantes;

    }

    public void setOnParticipanteClickListener(OnParticipanteClickListener listener) {
        this.listener = listener;
    }

    public interface OnParticipanteClickListener {
        void onParticipanteClick(View view, int position);

        void onLongParticipanteClick(View view, int position);
    }

    @NonNull
    @Override
    public ListarParticipantesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View lstParticipantesView = inflater.inflate(R.layout.recycle_view_listar_participantes, viewGroup, false);
        return new ViewHolder(lstParticipantesView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListarParticipantesAdapter.ViewHolder holder, int position) {
        holder.txtNomeParticpante.setText(participantes.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return participantes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView txtNomeParticpante;

        ViewHolder(View itemView) {
            super(itemView);

            txtNomeParticpante= itemView.findViewById(R.id.txt_lista_dos_participantes);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (listener!=null){
                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            listener.onLongParticipanteClick(view, position);
                        }
                    }
                    return false;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){
                    if (listener!=null){
                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            listener.onParticipanteClick(v, position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View view){
            if (listener!=null){
                int position = getAdapterPosition();
                if(position!= RecyclerView.NO_POSITION){
                    listener.onParticipanteClick(view, position);
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            if (listener!=null){
                int position = getAdapterPosition();
                if(position!= RecyclerView.NO_POSITION){
                    listener.onLongParticipanteClick(view, position);
                }
            }
            return true;
        }
    }
}

