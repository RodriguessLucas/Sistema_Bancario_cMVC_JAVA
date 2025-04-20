package model;


import java.util.ArrayList;

public class Extrato {
    private final ArrayList<Transacao> extrato = new ArrayList<>();

    public Extrato() {}

    public ArrayList<Transacao> getExtrato() {
        return extrato;
    }

    public void adicionarTransacao(Transacao transacao) {
        this.extrato.add(transacao);
    }

    public void registrarSaque(Double valor, Conta conta) {
        Transacao transacao = new Transacao();
        transacao.tansacaoSaque("SAQUE", valor, conta);
        this.extrato.add(transacao);
    }

    public void registrarDeposito(Double valor, Conta conta) {
        Transacao transacao = new Transacao();
        transacao.transacaoDeposito("DEPOSITO", valor, conta);
        this.extrato.add(transacao);
    }

    public void registrarTransferencia(Double valor, Conta conta, Conta destino) {
        Transacao transacao = new Transacao();
        transacao.transacaoTransferencia("TRANSFERENCIA", valor, conta, destino);
        this.extrato.add(transacao);
    }



}
