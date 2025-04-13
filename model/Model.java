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
    public Conta getContaClienteAtivo(){
        return clienteAtivo.getConta();
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

    public void deslogarCliente(){
        clienteAtivo = null;
    }

    public String imprimirExtrato(){
        ArrayList<Transacao> aux = clienteAtivo.getConta().getExtrato().getExtrato();
        if(aux.isEmpty()){
            return "-----------------------------\n"
                    +"Não houve movimentações!\n"
                    +"-----------------------------\n";
        }

        String resposta = "";
        resposta += "////////////////////////////////////////\n"
                + "Extrato:\n"
                + "-----------------------------\n";
        for(Transacao transacao : aux){
            if(transacao.getTipo().equals("SAQUE")){
                resposta+= "Operacao: SAQUE\n"
                        + "Valor : R$ " + transacao.getValor() + "\n"
                        +"-----------------------------\n";
            }
            else if(transacao.getTipo().equals("DEPOSITO")){
                resposta+= "Operacao: DEPOSITO\n"
                        + "Valor : R$ " + transacao.getValor() + "\n"
                        + "-----------------------------\n";
            }
            else if(transacao.getTipo().equals("TRANSFERENCIA")){
                resposta+= "Operacao: TRANSFERENCIA\n"
                        + "Valor : R$ " + transacao.getValor() + "\n"
                        +"Conta Fonte: " + transacao.getFonte().getCliente().getCpf() + "\n"
                        +"Conta Destino: "+ transacao.getDestino().getCliente().getCpf() + "\n"
                        + "-----------------------------\n";;
            }
        }
        return resposta;

    }

    public void adicionarExtrato(String operacao, double valor, Conta origem, Conta destino) {
        switch(operacao){
            case "SAQUE":
                break;

            case "DEPOSITO":
                clienteAtivo.getConta().getExtrato().registrarDeposito(valor, clienteAtivo.getConta());
                break;

            case "TRANSFERENCIA":
                break;

                default:
                    break;
        }

    }


    public String validarDeposito(double valor){
        if(valor <= 0){
            return "Erro: não pode depositar R$0 ou valores negativos!";
        }
        return "OK";
    }

    public void depositar(Double valor){
        double montante = clienteAtivo.getConta().getSaldo() + valor;
        clienteAtivo.getConta().setSaldo(montante);
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
