package telaDeposito;


import model.Entrada;
import model.Model;
import model.Observer;

public class TelaDepositoView implements Observer {
    private Model model;
    private TelaDepositoController telaDepositoController;
    private double valor;

    public double getValor(){return valor;}

    public void initTelaDepositoView(Model model) {
        this.model = model;
        telaDepositoController = new TelaDepositoController();
        telaDepositoController.initTelaDepositoView(model, this);
        model.attachObserver(this);
        iniciarDeposito();
    }

    public void iniciarDeposito() {
        String resposta = "";
        do{
            System.out.println("/////////////////////////////");
            System.out.println("Digite um valor para deposito");
            System.out.print("R$ ");
            valor = Entrada.lerDouble();
            resposta = telaDepositoController.verificarValorDeposito(valor);

        }while(!resposta.equals("OK"));

        telaDepositoController.handleEvent();

    }


    public void exibirMsg(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }

    public void finalizar() {
        model.detachObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Deposito realizado com sucesso!");
        System.out.println("Novo saldo: R$ " + model.getSaldoClienteAtivo());
        System.out.println("Retornando a tela do cliente...\n");
    }
}
