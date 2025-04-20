package TelaExtrato;

import model.Entrada;
import model.Model;
import model.Observer;

public class TelaExtratoView implements Observer {
    private Model model;
    private TelaExtratoController telaExtratoController;
    private String entrada;
    private boolean finalizar;

    public void initTelaExtratoView(Model model){
        this.model = model;
        model.attachObserver(this);
        telaExtratoController = new TelaExtratoController();
        telaExtratoController.initTelaExtratoController(model, this);
        telaExtrato();
    }

    public void telaExtrato(){

        while(!finalizar){
            System.out.println("////////////////////////");
            System.out.println("Gostaria do EXTRADO sob quais filtros:");
            System.out.println("[1] Todas as movimentações\n"
                    + "[2] Historico de SAQUES\n"
                    + "[3] Historico de DEPOSITOS\n"
                    + "[4] Historico de TRANSFERENCIAS\n"
                    + "[0] Voltar"
            );
            entrada = Entrada.lerString();
            telaExtratoController.handleEvent(entrada);
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
        System.out.println();
        System.out.println("Saindo de EXTRADO...");
        System.out.println();

    }
}
