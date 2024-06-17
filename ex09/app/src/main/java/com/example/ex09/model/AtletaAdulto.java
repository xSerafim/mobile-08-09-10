package com.example.ex09.model;

import java.time.LocalDate;

public class AtletaAdulto extends Atleta {
    private String academia;
    private int recordeSegundos;

    public AtletaAdulto(String nomeAtleta, LocalDate dataNascimentoAtleta, String enderecoAtleta, String academia, int recordeSegundos) {
        super(nomeAtleta, dataNascimentoAtleta, enderecoAtleta);
        this.academia = academia;
        this.recordeSegundos = recordeSegundos;
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public int getRecordeSegundos() {
        return recordeSegundos;
    }

    public void setRecordeSegundos(int recordeSegundos) {
        this.recordeSegundos = recordeSegundos;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Academia='" + academia + '\'' +
                ", Recorde em Segundos='" + recordeSegundos + '\'';
    }
}
