package model;

import java.util.ArrayList;

public class Model {
    private final Banco banco = new Banco();
    private final ArrayList<Observer> observers = new ArrayList<>();

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
        //notifica();

    }
    public void cadastrarConta(String cpf, String senha){
        Cliente aux = banco.getCliente(cpf,senha);
        Conta nova = new Conta(aux,0,true);
        aux.setConta(nova);
        //notifica();

    }

    public boolean existeCliente(String cpf){
        return  banco.existeCliente(cpf);
    }

    public Cliente getCliente(String cpf, String senha) {
        return banco.getCliente(cpf,senha);
    }

    public Cliente getCliente(String cpf) {return banco.getCliente(cpf);};

    public boolean existeContaCliente(String cpf){ return banco.getCliente(cpf).getConta() != null;}


    public void logarCliente(String cpf, String senha) {
        clienteAtivo = getCliente(cpf, senha);
    }

    public void deslogarCliente(){
        clienteAtivo = null;
    }

    public String getNomeClienteAtivo(){
        return clienteAtivo.getNome();
    }

    public double getSaldoClienteAtivo(){
        return clienteAtivo.getConta().getSaldo();
    }


    public void adicionarExtrato(String operacao, double valor, Conta origem, Cliente destino) {
        switch(operacao){
            case "SAQUE":
                clienteAtivo.getConta().getExtrato().registrarSaque(valor, clienteAtivo.getConta());
                break;

            case "DEPOSITO":
                clienteAtivo.getConta().getExtrato().registrarDeposito(valor, clienteAtivo.getConta());
                break;

            case "TRANSFERENCIA":
                clienteAtivo.getConta().getExtrato().registrarTransferencia(valor,origem,destino.getConta());
                destino.getConta().getExtrato().registrarTransferencia(valor,origem,destino.getConta());
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

    public String validarSaque(double valor){
        if(valor <= 0){
            return "Erro: não pode sacar R$0 ou valores negativos!";
        }
        if(clienteAtivo.getConta().getSaldo() < valor){
            return "Erro: saldo insuficiente para saque!";
        }
        return "OK";
    }

    public void sacar(double valor){
        double montante = clienteAtivo.getConta().getSaldo() - valor;
        clienteAtivo.getConta().setSaldo(montante);
    }

    public void transferir(double valor, Cliente origem, Cliente destino){
        origem.getConta().transferir(valor, destino.getConta());
    }

    public String carregarExtrato(String operacao){
        ArrayList<Transacao> aux = clienteAtivo.getConta().getExtratoLista();
        String resposta = "";

        if(aux.isEmpty()){
            return "-----------------------------\n"
                    +"Não houve movimentações!\n"
                    +"-----------------------------\n";
        }

        if(operacao.equals("TODOS")){
            for(Transacao transacao : aux){
                resposta += transacao.toString();
            }
        }

        if(!operacao.equals("TODOS")) {
            for (Transacao transacao : aux) {
                if (transacao.getTipo().equals(operacao)) {
                    resposta += transacao.toString();
                }
            }
        }

        if(resposta.isEmpty()){
            return "-----------------------------\n"
                    +"Não houve movimentações!\n"
                    +"-----------------------------\n";
        }

        return resposta;
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

    public void exibirObservacoes(){
        System.out.println("/////////////////////////////////");
        System.out.println("Apresentando os observacoes ativos");
        for(Observer o : observers){
            System.out.println(o.getClass().getName());
        }
        System.out.println("/////////////////////////////////");
    }

}
