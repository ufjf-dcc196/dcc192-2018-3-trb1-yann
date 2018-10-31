package com.example.mattheus.trabalho_01_dcc196;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListarMeusEventosAdapter extends RecyclerView.Adapter<ListarMeusEventosAdapter.ViewHolder> {
    private ArrayList<Evento> eventos;
    private OnMeusEventosClickListener listener;

    public ListarMeusEventosAdapter(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public void setOnMeusEventosClickListener(OnMeusEventosClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ListarMeusEventosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View lstMeusEventosView = inflater.inflate(R.layout.rv_listar_meus_eventos, viewGroup, false);
        return new ViewHolder(lstMeusEventosView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListarMeusEventosAdapter.ViewHolder holder, int position) {
        holder.txtTituloEvento.setText(eventos.get(position).getTitulo());
        holder.txtDataEvento.setText(eventos.get(position).getData());
        holder.txtHoraEvento.setText(eventos.get(position).getHora());
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    public interface OnMeusEventosClickListener {
        void onMeusEventosClick(View view, int position);

        void onLongMeusEventosClick(View view, int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView txtTituloEvento;
        TextView txtDataEvento;
        TextView txtHoraEvento;

        ViewHolder(View itemView) {
            super(itemView);

            txtTituloEvento = itemView.findViewById(R.id.rv_lst_meus_eventos_Titulo);
            txtDataEvento = itemView.findViewById(R.id.rv_lst_meus_eventos_Data);
            txtHoraEvento = itemView.findViewById(R.id.rv_lst_meus_eventos_Hora);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onLongMeusEventosClick(view, position);
                        }
                    }
                    return false;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onMeusEventosClick(v, position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onMeusEventosClick(v, position);
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            if (listener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onLongMeusEventosClick(view, position);
                }
            }
            return true;
        }
    }
}