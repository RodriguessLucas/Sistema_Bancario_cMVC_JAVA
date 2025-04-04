package telaLogin;

import model.Model;
import model.Observer;

public class TelaLoginViewController implements Observer {
    private Model model;
    private TelaLoginView telaLoginView;

    public void initTelaLoginViewController(Model model, TelaLoginView telaLoginView) {
        this.model = model;
        this.telaLoginView = telaLoginView;
        model.attachObserver(this);
    }

    public boolean validarLogin() {
        String resultado = model.validarLogin(telaLoginView.getCpf(), telaLoginView.getSenha());

        if (!resultado.equals("OK")) {
            telaLoginView.ebixirMsg(resultado);
            return false;
        }
        return true;
    }

    public void handleEvent() {
        System.out.println("Chegou no handleEvent na TelaClienteLogadoViewController poha!");
        //continuar aqui
        // é o handle event para fazer o login na conta bancária
    }



    @Override
    public void update() {

    }
}
