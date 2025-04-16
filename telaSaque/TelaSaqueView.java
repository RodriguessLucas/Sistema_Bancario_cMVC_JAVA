package telaSaque;

import model.Entrada;
import model.Model;
import model.Observer;

public class TelaSaqueView implements Observer {
    private Model model;
    private TelaSaqueController telaSaqueController;
    private double valor;

    public double getValor() {return valor;}

    public void initTelaSaqueview(Model model) {
        this.model = model;
        model.attachObserver(this);
        telaSaqueController = new TelaSaqueController();
        telaSaqueController.initTelaSaqueViewController(model, this);
        iniciarSaque();
    }

    public void iniciarSaque() {
        String resposta ="";
        do{
            System.out.println("/////////////////////////////");
            System.out.println("Digite um valor para deposito");
            System.out.print("R$ ");
            valor = Entrada.lerDouble();
            resposta = telaSaqueController.verificarValor();

        }while(!resposta.equals("OK"));

        telaSaqueController.handleEvent();
    }

    public void finalizar() {
        model.detachObserver(this);
    }

    public void exibirMsg(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }


    @Override
    public void update() {
        System.out.println("Saque realizado com sucesso!");
        System.out.println("Novo saldo: R$ " + model.getSaldoClienteAtivo());
        System.out.println("Retornando a tela do cliente...\n");
    }
}
