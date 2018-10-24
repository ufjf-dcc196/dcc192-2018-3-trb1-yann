package com.example.ylhal.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String titulo, data, hora, desc;
    private List<Participante> participantes;

    public Evento(String titulo, String data, String hora, String desc) {
        this.titulo = titulo;
        this.data = data;
        this.hora = hora;
        this.desc = desc;
        participantes = new ArrayList();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List getParticipantes() {
        return participantes;
    }

    public Participante getParticipante(int index) {
        return participantes.get(index);
    }

    public void addParticipante(Participante p) {
        participantes.add(p);
    }
}
