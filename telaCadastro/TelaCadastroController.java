package telaCadastro;

import model.Model;
import model.Observer;


public class TelaCadastroController implements Observer {
    private Model model;
    private TelaCadastroView telaCadastroView;

    public void initTelaCadastroViewController(Model model, TelaCadastroView telaCadastroView) {
        this.model = model;
        this.telaCadastroView = telaCadastroView;
        model.attachObserver(this);
    }


    public void handleEvent() {
        model.cadastrarCliente(telaCadastroView.getNome(), telaCadastroView.getCpf(), telaCadastroView.getSenha());

        if(telaCadastroView.getCriarConta()) {
            model.cadastrarConta(telaCadastroView.getCpf(), telaCadastroView.getSenha());
        }
        model.exibirObservacoes();
        model.detachObserver(this);
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

