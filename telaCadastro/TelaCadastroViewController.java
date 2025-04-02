package telaCadastro;

import model.Model;
import model.Observer;


public class TelaCadastroViewController implements Observer {
    private Model model;
    private TelaCadastroView telaCadastroView;

    public void initTelaCadastroViewController(Model model, TelaCadastroView telaCadastroView) {
        this.model = model;
        this.telaCadastroView = telaCadastroView;
        model.attachObserver(this);
    }


    public void handleEvent() {
        System.out.println("Conta criada com sucesso");
        System.out.println("TelaCadastroViewController handleEvent");
        model.detachObserver(this);
        System.out.println("TelaCadastroViewController handleEvent voltando para tela inicial!");

    }
    public boolean validarNome() {
        String resultado = model.validarNome(telaCadastroView.getNome());
        if(!resultado.equals("OK")){
            telaCadastroView.ebixirMsg(resultado);
            return false;
        }
        return true;
    }

    public boolean validarCadastro(){
        String resultado = model.validarLogin(telaCadastroView.getCpf(), telaCadastroView.getSenha());

        if(!resultado.equals("OK") && !resultado.equals("Cliente não existe no banco!")){
            telaCadastroView.ebixirMsg(resultado);
            return false;
        }
        if(model.validarCliente(telaCadastroView.getCpf(), telaCadastroView.getSenha())){
           telaCadastroView.ebixirMsg("Não é possível cadastrar cliente pois já existe no banco!");
           telaCadastroView.finalizar();
           return false;
        }

        telaCadastroView.finalizar();
        return true;
    }

    @Override
    public void update() {

    }
}

