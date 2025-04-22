package telaInicial;

import model.Entrada;
import model.Model;
import model.Observer;

public class TelaInicialView implements Observer {
    private Model model;
    private TelaInicialController telaIncialController;
    private boolean finalizar = false;

    public void initMainView(Model model) {
        this.model = model;
        telaIncialController = new TelaInicialController();
        telaIncialController.initTelaInicialViewController(model, this);
        model.attachObserver (this);
        menuPrincipal();
    }

    public void menuPrincipal() {
        String opcoes[] = {"[1] - FAZER LOGIN", "[2] - FAZER CADASTRO", "[3] - SAIR"};

        do{
            System.out.println("Bem vindo ao " + model.getNomeBanco());
            System.out.println("=============================");
            System.out.println("MENU PRINCIPAL:");
            System.out.println();
            for (String opcao : opcoes) {
                System.out.println(opcao);
            }
            System.out.println("Digite a opção desejada:");
            String entrada = Entrada.lerString();
            telaIncialController.handleEvent(entrada);
        }
        while (!finalizar);
    }

    public void finalizar() {
        finalizar = true;
        model.detachObserver(this);
    }


    public void ebixirMsg(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }


    public void update() {
    }

}
