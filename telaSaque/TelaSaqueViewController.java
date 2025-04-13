package telaSaque;

import model.Model;
import model.Observer;

public class TelaSaqueViewController implements Observer {
    private Model model;
    private TelaSaqueView telaSaqueView;

    public void initTelaSaqueViewController(Model model, TelaSaqueView telaSaqueView) {
        this.model = model;
        this.telaSaqueView = telaSaqueView;
        model.attachObserver(this);
    }


    @Override
    public void update() {

    }
}
