package com.example.mattheus.trabalho_01_dcc196.Activitys;

import com.example.mattheus.trabalho_01_dcc196.Objetos.Evento;
import com.example.mattheus.trabalho_01_dcc196.Objetos.Participante;

import java.util.ArrayList;

public class Singleton {

    private static Singleton instance = new Singleton();
    private ArrayList<Evento> eventos;
    private ArrayList<Participante> participantes;


    private Singleton() {
        eventos = new ArrayList<>();
        Evento e1 = new Evento("Android", "22/08", "12:00", "José Maria", "curso de desenvolvimento android");
        Evento e2 = new Evento("Xadrez", "22/09", "22:00", "Nina ALmeida", "curso para iniciantes de xadrez");
        Evento e3 = new Evento("Java", "01/01", "08:00", "Mauro", "Curso para aprendizado de Java");

        participantes = new ArrayList<>();
        Participante p1 = new Participante("Matheus", "Matheus@ufjf.br", "12345678900");
        Participante p2 = new Participante("Lucas", "Lucass@ufjf.br", "12345678901");
        Participante p3 = new Participante("Rafael", "Rafael@ufjf.br", "12345678902");
        participantes.add(p1);
        participantes.add(p2);
        participantes.add(p3);
        e1.addParticipante(p1);
        e2.addParticipante(p2);
        e3.addParticipante(p3);
        eventos.add(e1);
        eventos.add(e2);
        eventos.add(e3);
        p1.addEvento(e1);
        p2.addEvento(e2);
        p3.addEvento(e3);
    }

    public static Singleton getInstance(){
        return instance;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    void addEvento(Evento e) {
        this.eventos.add(e);
    }

    public void removeEvento(Evento e) {
        this.eventos.remove(e);
    }

    public int getIndiceEvento(Evento e) {
        for (int i = 0; i < eventos.size(); i++) {
            if (eventos.get(i).equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public void removeParticipanteEventos(Participante p) {
        for (Evento e : Singleton.getInstance().getEventos()) {
            if (e.getParticipantes().contains(p)) {
                int i = Singleton.getInstance().getEventos().indexOf(e);
                Singleton.getInstance().getEventos().get(i).removeParticipante(p);
            }
        }
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    void addParticipante(Participante p) {
        participantes.add(p);
    }

    public void removeParticipante(Participante p) {
        participantes.remove(p);
    }

    public void removeAllParticipanteEvento(Evento e) {
        for (Participante p : Singleton.getInstance().getParticipantes()) {
            if (p.getEventos().contains(e)) {
                int i = Singleton.getInstance().getParticipantes().indexOf(p);
                Singleton.getInstance().getParticipantes().get(i).removeEvento(e);
            }
        }
    }

    public void removeParticipanteDoEvento(Evento e, Participante p) {
        int indice = Singleton.getInstance().getParticipantes().indexOf(p);
        Singleton.getInstance().getParticipantes().get(indice).removeEvento(e);
    }
}