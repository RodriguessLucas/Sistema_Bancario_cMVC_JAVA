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

    public void handleEvent() {
        if(telaLoginView.getCpf() == null){
            telaLoginView.ebixirMsg("CPF vazio! Tente novamente!");
        }
        if(telaLoginView.getSenha() == null){
            telaLoginView.ebixirMsg("Senha vazia! Tente novamente!");
        }

        if(!model.validarCpf(telaLoginView.getCpf())){
            telaLoginView.ebixirMsg(("CPF inválido! Tente novamente!"));
        }

        if(!model.validarCpf(telaLoginView.getSenha())){
            telaLoginView.ebixirMsg("Senha inválida! Tente novamente!");
        }

        //continuar aqui
        // é o handle event para fazer o login na conta bancária


    }



    @Override
    public void update() {

    }
}
