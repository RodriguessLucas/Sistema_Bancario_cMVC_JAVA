package telaSaque;

import model.Model;
import model.Observer;

public class TelaSaqueController implements Observer {
    private Model model;
    private TelaSaqueView telaSaqueView;

    public void initTelaSaqueViewController(Model model, TelaSaqueView telaSaqueView) {
        this.model = model;
        this.telaSaqueView = telaSaqueView;
        model.attachObserver(this);
    }

    public String verificarValor() {
        String resultado = model.validarSaque(telaSaqueView.getValor());

        if(!resultado.equals("OK")){
            telaSaqueView.exibirMsg(resultado);
            return "Erro";
        }

        return resultado;
    }


    public void handleEvent() {
        model.sacar(telaSaqueView.getValor());
        model.adicionarExtrato("SAQUE", telaSaqueView.getValor(), model.getContaClienteAtivo(),null);
        telaSaqueView.update();
        telaSaqueView.finalizar();
        finalizar();

    }

    public void finalizar() {
        model.detachObserver(this);
    }

    @Override
    public void update() {
    }
}
