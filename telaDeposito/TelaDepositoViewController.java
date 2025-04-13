package telaDeposito;

import model.Model;
import model.Observer;

public class TelaDepositoViewController implements Observer {
    private Model model;
    private TelaDepositoView telaDepositoView;

    public void initTelaDepositoView(Model model, TelaDepositoView telaDepositoView) {
        this.model = model;
        this.telaDepositoView = telaDepositoView;
        model.attachObserver(this);
    }


    public void handleEvent() {

    }



    @Override
    public void update() {

    }
}
