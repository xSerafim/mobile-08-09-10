package com.example.ex09.model;

import java.time.LocalDate;

public class AtletaSenior extends Atleta {
    private boolean temProblemasCardiacos;

    public AtletaSenior(String nomeAtleta, LocalDate dataNascimentoAtleta, String enderecoAtleta, boolean temProblemasCardiacos) {
        super(nomeAtleta, dataNascimentoAtleta, enderecoAtleta);
        this.temProblemasCardiacos = temProblemasCardiacos;
    }

    public boolean isTemProblemasCardiacos() {
        return temProblemasCardiacos;
    }

    public void setTemProblemasCardiacos(boolean temProblemasCardiacos) {
        this.temProblemasCardiacos = temProblemasCardiacos;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Tem Problemas Cardíacos='" + temProblemasCardiacos + '\'';
    }
}
