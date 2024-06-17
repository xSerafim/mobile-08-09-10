package com.example.ex09.model;

import androidx.annotation.NonNull;

import java.time.LocalDate;

public abstract class Atleta {
    private String nomeAtleta;
    private LocalDate dataNascimentoAtleta;
    private String enderecoAtleta;

    public Atleta(String nomeAtleta, LocalDate dataNascimentoAtleta, String enderecoAtleta) {
        this.nomeAtleta = nomeAtleta;
        this.dataNascimentoAtleta = dataNascimentoAtleta;
        this.enderecoAtleta = enderecoAtleta;
    }

    public String getNomeAtleta() {
        return nomeAtleta;
    }

    public void setNomeAtleta(String nomeAtleta) {
        this.nomeAtleta = nomeAtleta;
    }

    public LocalDate getDataNascimentoAtleta() {
        return dataNascimentoAtleta;
    }

    public void setDataNascimentoAtleta(LocalDate dataNascimentoAtleta) {
        this.dataNascimentoAtleta = dataNascimentoAtleta;
    }

    public String getEnderecoAtleta() {
        return enderecoAtleta;
    }

    public void setEnderecoAtleta(String enderecoAtleta) {
        this.enderecoAtleta = enderecoAtleta;
    }

    @NonNull
    @Override
    public String toString() {
        return "Nome='" + nomeAtleta + '\'' +
                ", Data de Nascimento='" + dataNascimentoAtleta + '\'' +
                ", Endereço='" + enderecoAtleta + '\'';
    }
}
