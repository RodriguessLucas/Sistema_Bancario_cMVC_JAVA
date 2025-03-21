package model;

public class Conta {
    private Cliente cliente;
    private double saldo;
    private boolean ativa;

    public Conta(Cliente cliente, double saldo, boolean ativa) {
        this.cliente = cliente;
        this.saldo = saldo;
        this.ativa = ativa;
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

    public void transferir(double valor, Conta destino) {
        this.saldo -= valor;
        destino.depositar(valor);
    }



}
