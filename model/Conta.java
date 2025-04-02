package model;

import java.util.ArrayList;

public class Conta {
    private Cliente cliente;
    private double saldo;
    private boolean ativa;
    private Extrato extrato;

    public Conta(Cliente cliente, double saldo, boolean ativa) {
        this.cliente = cliente;
        this.saldo = saldo;
        this.ativa = ativa;
        this.extrato = new Extrato();
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isAtiva() {
        return ativa;
    }
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    public void AdicionarExtrato(Extrato extrato) {
        this.extrato.add(extrato);
    }
    public ArrayList<Extrato> getExtrato() {
        return extrato;
    }

    public void transferir(double valor, Conta destino) {
        this.saldo -= valor;
        destino.depositar(valor);
    }



}
