package telaLogin;

import model.Model;
import model.Observer;

public class TelaLoginViewController implements Observer {
    private Model model;
    private TelaLoginView telaLoginView;

    public void initTelaLoginViewController(Model model, TelaLoginView telaLoginView) {
        this.model = model;
        this.telaLoginView = telaLoginView;
        model.attachObserver(this);
    }

    public boolean validarLogin() {
        if(telaLoginView.getCpf() == null){
            telaLoginView.ebixirMsg("CPF vazio! Tente novamente!");
            return false;
        }
        if(telaLoginView.getSenha() == null){
            telaLoginView.ebixirMsg("Senha vazia! Tente novamente!");
            return false;
        }

        if(!model.validarCpf(telaLoginView.getCpf())){
            telaLoginView.ebixirMsg(("CPF inválido! Tente novamente!"));
            return false;
        }

        if(!model.validarSenha(telaLoginView.getSenha())){
            telaLoginView.ebixirMsg("Senha inválida! Tente novamente!");
            return false;
        }

        if(!model.validarCliente(telaLoginView.getCpf(), telaLoginView.getSenha())){
            telaLoginView.ebixirMsg("Cliente não existe no banco!");
            return false;
        }

        return true;
    }

    public void handleEvent() {
        System.out.println("Chegou no handleEvent na TelaLoginViewController poha!");
        //continuar aqui
        // é o handle event para fazer o login na conta bancária
    }



    @Override
    public void update() {

    }
}
