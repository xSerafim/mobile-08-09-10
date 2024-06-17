package com.example.ex08.model;

public class TicketVIP extends Ticket {

    private String cargo;

    public TicketVIP(String codigo, float valor, String cargo) {
        super(codigo, valor);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public float valorFinal(float taxaConveniencia) {
        return super.valorFinal(taxaConveniencia) * 1.18f; // Acrescenta 18%
    }
}
