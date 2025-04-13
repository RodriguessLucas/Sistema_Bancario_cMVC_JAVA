package telaCadastro;

import model.Entrada;
import model.Model;
import model.Observer;

public class TelaCadastroView implements Observer {
    private Model model;
    private TelaCadastroViewController telaCadastroViewController;
    private boolean finalizar;
    private boolean contaCriada;
    private boolean criarConta;
    private String nome,cpf,senha;

    public void initTelaCadastroView(Model model) {
        this.model = model;
        telaCadastroViewController = new TelaCadastroViewController();
        telaCadastroViewController.initTelaCadastroViewController(model,this);
        model.attachObserver(this);
        iniciarCadastro();
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getSenha() {
        return senha;
    }
    public boolean getCriarConta() { return criarConta;}



    public void iniciarCadastro(){

        while(!finalizar){
            apresentarCadastro();

            do{
                receberNome();
            }
            while(!telaCadastroViewController.validarNome());

            do{
                receberCPFeSenha();
            }
            while(!telaCadastroViewController.validarCadastro());


        }

        if(!contaCriada){
            criarConta = criarConta();
            telaCadastroViewController.handleEvent();
            update();
            // exibir as informações novamente
        }

        model.detachObserver(this);
        System.out.println("Voltando para tela inicial....");

    }

    public void apresentarCadastro(){
        System.out.println("======================");
        System.out.println("TELA DE CADASTRO");
        System.out.println("======================");
    }


    public void receberNome(){
        System.out.print("Digite seu NOME COMPLETO: \nExemplo: Lucas Rodrigues \nNome: ");
        nome = Entrada.lerString();
    }

    public void receberCPFeSenha(){
        System.out.print("Digite seu CPF COMPLETO: \nExemplo: 11122233344455 \nCPF: ");
        cpf = Entrada.lerString();
        System.out.print("Digite sua SENHA: \nExemplo: 123456 \nSenha: ");
        senha = Entrada.lerString();
    }

    public boolean criarConta(){
        String entrada;
        while(true){
            System.out.println("Gostaria de criar a conta corrente? [S/N]");
            entrada = Entrada.lerString();
            if(entrada.equals("s") || entrada.equals("S")){
                return true;
            }
            else if(entrada.equals("n") || entrada.equals("N")){
                return false;
            }
            else{
                System.out.println("Digite SOMENTE [S/N]");
            }
        }
    }

    public void finalizar(){
        finalizar = true;
    }

    public void ebixirMsg(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }

    @Override
    public void update() {
        System.out.println("Cadastrando no banco!");
        System.out.println("Conta criada com sucesso");
        System.out.println("Dados de Login: \nCPF: "+ cpf+" \nSenha: "+ senha);
        System.out.println("Finalizando cadastro...");
        System.out.println("Voltando para tela inicial.");

    }
}
