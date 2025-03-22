package telaInicial;

import model.Model;
import model.Observer;

import java.util.Scanner;

public class TelaInicialView implements Observer {
    private Model model;
    private TelaInicialViewController telaIncialController;
    private boolean finalizar = false;

    public void initMainView(Model model) {
        this.model = model;
        telaIncialController = new TelaInicialViewController();
        telaIncialController.initTelaInicialViewController(model, this);
        model.attachObserver (this);
        menuPrincipal();
    }

    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
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
            String entrada = scanner.nextLine();
            telaIncialController.handleEvent(entrada);
        }
        while (!finalizar);
        scanner.close();
    }

    public void finalizar() {
        finalizar = true;
    }

    public void ebixirMsg(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }


    public void update() {
        System.out.println("Quantidade observadores: "+ model.countObservers());
    }

}
