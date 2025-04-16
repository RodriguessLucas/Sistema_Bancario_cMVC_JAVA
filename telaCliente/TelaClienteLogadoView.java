package telaCliente;


import model.Entrada;
import model.Model;
import model.Observer;

public class TelaClienteLogadoView implements Observer {
    private Model model;
    private TelaClienteLogadoController telaClienteLogadoController;
    private boolean finalizar;

    public void initTelaClienteLogadoView(Model model) {
        this.model = model;
        model.attachObserver(this);
        telaClienteLogadoController = new TelaClienteLogadoController();
        telaClienteLogadoController.initTelaClienteLogadoViewController(model, this);

    }

    public void telaCliente(String msg){
        while(!finalizar){
            System.out.print(msg);
            String entrada = Entrada.lerString();
            telaClienteLogadoController.handleEvent(entrada);
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
        telaClienteLogadoController.carregarDadosCliente();
    }
}
