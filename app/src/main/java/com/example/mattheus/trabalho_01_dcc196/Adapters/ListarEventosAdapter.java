package com.example.mattheus.trabalho_01_dcc196.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mattheus.trabalho_01_dcc196.Objetos.Evento;
import com.example.mattheus.trabalho_01_dcc196.R;

import java.util.ArrayList;

public class ListarEventosAdapter extends RecyclerView.Adapter<ListarEventosAdapter.ViewHolder>{

    private ArrayList<Evento> eventos;
    private OnEventoClickListener listener;

    public interface OnEventoClickListener {
        void onEventoClick(View view, int position);
        void onLongEventoClick(View view, int position);
    }

    public void setOnEventoClickListener(OnEventoClickListener listener){
        this.listener = listener;
    }

    public ListarEventosAdapter(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }


    @NonNull
    @Override
    public ListarEventosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View lstEventoView;
        lstEventoView = inflater.inflate(R.layout.recycle_view_listar_eventos, viewGroup, false);
        return new ViewHolder(lstEventoView);
    }


    @Override
    public void onBindViewHolder(@NonNull ListarEventosAdapter.ViewHolder holder, int position) {
        holder.txtTituloEvento.setText(eventos.get(position).getTitulo());
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        TextView txtTituloEvento;

        ViewHolder(View itemView) {
            super(itemView);

            txtTituloEvento = itemView.findViewById(R.id.txt_lista_dos_eventos);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (listener!=null){
                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            listener.onLongEventoClick(view, position);
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
                            listener.onEventoClick(v, position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View v){
            if (listener!=null){
                int position = getAdapterPosition();
                if(position!= RecyclerView.NO_POSITION){
                    listener.onEventoClick(v, position);
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            if (listener!=null){
                int position = getAdapterPosition();
                if(position!= RecyclerView.NO_POSITION){
                    listener.onLongEventoClick(view, position);
                }
            }
            return true;
        }

    }

}
