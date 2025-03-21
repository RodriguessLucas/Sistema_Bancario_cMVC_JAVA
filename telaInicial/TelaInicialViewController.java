package telaInicial;

import model.Model;
import model.Observer;

import java.util.Observable;

public class TelaInicialViewController implements Observer {
    private Model model;
    private TelaInicialView view;

    public void initTelaInicialViewController(Model model, TelaInicialView view) {
        this.model = model;
        this.view = view;
    }

    public void handleEvent(String event) {
        switch (event) {
            case "1":
                if(model.get)
        }
    }



    public void update() {}
}
