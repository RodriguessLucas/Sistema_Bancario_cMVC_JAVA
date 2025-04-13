package telaSaque;

import model.Model;
import model.Observer;

public class TelaSaqueView implements Observer {
    private Model model;
    private TelaSaqueViewController telaSaqueViewController;

    public void initTelaSaqueview(Model model) {
        this.model = model;
        model.attachObserver(this);
        telaSaqueViewController = new TelaSaqueViewController();
        telaSaqueViewController.initTelaSaqueViewController(model, this);
    }



    @Override
    public void update() {

    }
}
