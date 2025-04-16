package telaDeposito;

import model.Model;
import model.Observer;

public class TelaDepositoController implements Observer {
    private Model model;
    private TelaDepositoView telaDepositoView;

    public void initTelaDepositoView(Model model, TelaDepositoView telaDepositoView) {
        this.model = model;
        this.telaDepositoView = telaDepositoView;
        model.attachObserver(this);
    }


    public void handleEvent() {
        model.depositar(telaDepositoView.getValor());
        model.adicionarExtrato("DEPOSITO", telaDepositoView.getValor(), model.getContaClienteAtivo(),null);
        telaDepositoView.update();
        telaDepositoView.finalizar();
        finalizar();


    }

    public String verificarValorDeposito(Double valor) {
        String resultado = model.validarDeposito(valor);

        if(!resultado.equals("OK")){
            telaDepositoView.exibirMsg(resultado);
            return "Erro";
        }

        return resultado;
    }

    public void finalizar(){
        model.detachObserver(this);
    }

    @Override
    public void update() {

    }
}
