package telaDeposito;


import model.Model;
import model.Observer;

public class TelaDepositoView implements Observer {
    private Model model;
    private TelaDepositoViewController telaDepositoViewController;

    public void initTelaDepositoView(Model model) {
        this.model = model;
        telaDepositoViewController = new TelaDepositoViewController();
        telaDepositoViewController.initTelaDepositoView(model, this);
        model.attachObserver(this);
        iniciarDeposito();
    }

    public void iniciarDeposito() {

    }







    @Override
    public void update() {

    }
}
