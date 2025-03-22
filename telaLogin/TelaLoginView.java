package telaLogin;

import model.Model;
import model.Observer;

import java.util.Scanner;

public class TelaLoginView implements Observer {
    private Model model;
    private TelaLoginViewController telaLoginController;
    private String cpf;
    private String senha;


    public void initTelaLoginView(Model model) {
        this.model = model;
        telaLoginController = new TelaLoginViewController();
        // controller
        model.attachObserver(this);
        logarUsuario();

    }

    public String getCpf() {
        return cpf;
    }
    public String getSenha() {
        return senha;
    }

    public void logarUsuario() {
        Scanner sc = new Scanner(System.in);
        boolean valido = false;
        do{
            System.out.println("======================");
            System.out.println("TELA DE LOGIN");
            System.out.println("======================");
            System.out.print("CPF: ");
            cpf = sc.nextLine();
            System.out.print("Senha: ");
            senha = sc.nextLine();
            telaLoginController.handleEvent();

        }while(!valido);

        //handleEvent
        //remove a tela de login view do observadores
        sc.close();

    }

    public void ebixirMsg(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }


    @Override
    public void update() {}
}
