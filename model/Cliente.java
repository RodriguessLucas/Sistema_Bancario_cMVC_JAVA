package model;

public class Cliente {
    private String nome;
    private String senha;
    private String cpf;
    private Conta conta;

    public Cliente() {}

    public Cliente(String nome, String senha, String cpf) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
    }

    public Cliente (String nome, String senha, String cpf, Conta conta) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Conta getConta() {
        return conta;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }

}
