package com.example.ex09.model;

import java.time.LocalDate;

public class AtletaJuvenil extends Atleta {
    private int anosPraticando;

    public AtletaJuvenil(String nomeAtleta, LocalDate dataNascimentoAtleta, String enderecoAtleta, int anosPraticando) {
        super(nomeAtleta, dataNascimentoAtleta, enderecoAtleta);
        this.anosPraticando = anosPraticando;
    }

    public int getAnosPraticando() {
        return anosPraticando;
    }

    public void setAnosPraticando(int anosPraticando) {
        this.anosPraticando = anosPraticando;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Anos Praticando='" + anosPraticando + '\'';
    }
}