package telaInicial;

import model.Model;
import model.Observer;
import telaLogin.TelaLoginView;


public class TelaInicialViewController implements Observer {
    private Model model;
    private TelaInicialView telaInicialView;

    public void initTelaInicialViewController(Model model, TelaInicialView view) {
        this.model = model;
        this.telaInicialView = view;
    }

    public void handleEvent(String event) {
        switch (event) {
            case "1":
                TelaLoginView loginView = new TelaLoginView();
                loginView.initTelaLoginView(model);


                break;
            case "2":
                break;

            case "3":
                telaInicialView.finalizar();
                break;

            default:
                telaInicialView.ebixirMsg("Opção inválida! Tente novamente.");
                break;
        }
    }

    public void update() {}
}
