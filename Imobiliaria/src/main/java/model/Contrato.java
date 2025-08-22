package model;

import java.time.LocalDate;

public class Contrato {
    private int contratoId;
    private int clienteId;
    private int imovelId;
    private double valorMensal;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Contrato() {}

    public Contrato(int clienteId, int imovelId, double valorMensal, LocalDate dataInicio, LocalDate dataFim) {
        this.clienteId = clienteId;
        this.imovelId = imovelId;
        this.valorMensal = valorMensal;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Getters e Setters
    public int getContratoId() { return contratoId; }
    public void setContratoId(int contratoId) { this.contratoId = contratoId; }
    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }
    public int getImovelId() { return imovelId; }
    public void setImovelId(int imovelId) { this.imovelId = imovelId; }
    public double getValorMensal() { return valorMensal; }
    public void setValorMensal(double valorMensal) { this.valorMensal = valorMensal; }
    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }
}
