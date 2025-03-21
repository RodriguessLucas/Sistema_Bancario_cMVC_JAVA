package telaInicial;

import model.Model;
import model.Observer;

import java.util.Scanner;

public class TelaInicialView implements Observer {
    private Model model;
    private TelaInicialViewController controller;
    private boolean finalizar = false;

    public void initMainView(Model model) {
        this.model = model;
        controller = new TelaInicialViewController();
        // controller.initiMainViewController(model, this);
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
            // linha do controller
            //
        }
        while (!finalizar);
        scanner.close();




    }

    public void finalizar() {
        finalizar = true;
    }


    public void update() {
        System.out.println("Quantidade observadores: "+ model.countObservers());
    }

}
