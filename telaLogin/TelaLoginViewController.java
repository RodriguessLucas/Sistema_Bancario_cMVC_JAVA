package telaLogin;

import model.Model;
import model.Observer;
import telaCliente.TelaClienteLogadoView;

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
        telaLoginView.ebixirMsg("Carregando cliente!.....");
        model.logarCliente(telaLoginView.getCpf(), telaLoginView.getSenha());
        TelaClienteLogadoView telaClienteLogadoView = new TelaClienteLogadoView();
        telaClienteLogadoView.initTelaClienteLogadoView(model);
        model.detachObserver(this);

    }

    @Override
    public void update() {}
}
