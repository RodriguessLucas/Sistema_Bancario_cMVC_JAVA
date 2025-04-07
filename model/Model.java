package model;

import java.util.ArrayList;

public class Model {
    private final Banco banco = new Banco();
    private ArrayList<Observer> observers = new ArrayList<>();

    private Cliente clienteAtivo;

    public Model() {}


    public String getNomeBanco() {
        return banco.getNomeBanco();
    }

    public Cliente getClienteAtivo() {
        return clienteAtivo;
    }

    public String validarNome(String nome) {
        if(nome == null ||nome.isEmpty()){
            return "O nome não pode ser nulo! Tente novamente!";
        }
        if(nome.length()<4){
            return "Digite seu nome completo!";
        }
        if(nome.length()>100){
            return "Nome muito grande! Digite somente nome e sobrenome (Máx: 100 caracteres)";
        }
        if(nome.contains("[0-9]")){
            return "Digite seu nome sem números!";
        }
        return "OK";
    }

    public boolean validarCpf(String cpf) {
        return cpf.matches("[0-9]{11}");
    }

    public boolean validarSenha(String senha) {
        return senha.matches("[0-9]{6}");
    }

    public boolean validarCliente(String cpf, String senha) {
        Cliente aux = banco.getCliente(cpf,senha);
        return aux != null;
    }

    public String validarLogin(String cpf, String senha) {
        if(cpf.isEmpty()){
            return "CPF vazio! Tente novamente!";
        }
        if(senha.isEmpty()){
            return "Senha vazia! Tente novamente!";
        }

        if(!validarCpf(cpf)){
            return "CPF inválido! Tente novamente!";
        }

        if(!validarSenha(senha)){
            return "Senha inválida! Tente novamente!";
        }

        if(!validarCliente(cpf, senha)){
            return "Cliente não existe no banco!";
        }

        return "OK";
    }

    public void cadastrarCliente(String nome, String cpf, String senha) {
        Cliente novo = new Cliente(nome,senha, cpf);
        banco.adicionaCliente(novo);
        notifica();

    }
    public void cadastrarConta(String cpf, String senha){
        Cliente aux = banco.getCliente(cpf,senha);
        Conta nova = new Conta(aux,0,true);
        aux.setConta(nova);
        notifica();

    }

    public Cliente getCliente(String cpf, String senha) {
        return banco.getCliente(cpf,senha);
    }

    public void logarCliente(String cpf, String senha) {
        clienteAtivo = getCliente(cpf, senha);
    }

    public String getNomeClienteAtivo(){
        return clienteAtivo.getNome();
    }

    public double getSaldoClienteAtivo(){
        return clienteAtivo.getConta().getSaldo();
    }




    public void notifica(){
        for(Observer o : observers){
            o.update();
        }
    }

    public void attachObserver(Observer o){
        if(o!=null){
            observers.add(o);
        }
    }
    public void detachObserver(Observer o){
        if(o!=null){
            observers.remove(o);
        }
    }


}
