package telaCliente;


import model.Entrada;
import model.Model;
import model.Observer;

public class TelaClienteLogadoView implements Observer {
    private Model model;
    private TelaClienteLogadoViewController telaClienteLogadoViewController;
    private boolean finalizar;

    public void initTelaCadastroView(Model model) {
        this.model = model;
        telaClienteLogadoViewController = new TelaClienteLogadoViewController();
        telaClienteLogadoViewController.initTelaClienteLogadoViewController(model, this);
        model.attachObserver(this);

    }

    public void telaCliente(String msg){
        while(!finalizar){
            System.out.print(msg);
            String entrada = Entrada.lerString();
            telaClienteLogadoViewController.handleEvent(entrada);
        }
    }

    public void exibirMsg(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }

    public void finalizar() {
        finalizar = true;
        model.detachObserver(this);
    }


    @Override
    public void update() {

    }
}
