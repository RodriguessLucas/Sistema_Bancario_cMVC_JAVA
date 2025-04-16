package telaInicial;

import model.Model;
import model.Observer;
import telaCadastro.TelaCadastroView;
import telaLogin.TelaLoginView;


public class TelaInicialController implements Observer {
    private Model model;
    private TelaInicialView telaInicialView;

    public void initTelaInicialViewController(Model model, TelaInicialView view) {
        this.model = model;
        this.telaInicialView = view;
        model.attachObserver(this);
    }

    public void handleEvent(String event) {
        switch (event) {
            case "1":
                TelaLoginView loginView = new TelaLoginView();
                loginView.initTelaLoginView(model);


                break;
            case "2":
                TelaCadastroView telaCadastroView = new TelaCadastroView();
                telaCadastroView.initTelaCadastroView(model);
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
