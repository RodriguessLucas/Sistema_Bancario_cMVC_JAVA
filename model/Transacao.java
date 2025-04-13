package model;

public class Transacao {
    private String tipo;
    private Double valor;
    private Conta fonte;
    private Conta destino;

    public Transacao(){};

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public void setFonte(Conta fonte) {
        this.fonte = fonte;
    }
    public void setDestino(Conta destino) {
        this.destino = destino;
    }
    public String getTipo() {
        return tipo;
    }
    public Double getValor() {
        return valor;
    }
    public Conta getFonte() {
        return fonte;
    }
    public Conta getDestino() {
        return destino;
    }

    public void tansacaoSaque(String tipo, Double valor, Conta fonte){
        this.tipo = tipo;
        this.valor = valor;
        this.fonte = fonte;
    }

    public void transacaoDeposito(String tipo, Double valor, Conta fonte){
        this.tipo = tipo;
        this.valor = valor;
        this.fonte = fonte;
    }

    public void transacaoTransferencia(String tipo, Double valor, Conta fonte, Conta destino){
        this.tipo = tipo;
        this.valor = valor;
        this.fonte = fonte;
        this.destino = destino;
    }




}
