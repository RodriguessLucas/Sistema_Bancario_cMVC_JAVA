package telaCliente;

import TelaExtrato.TelaExtratoView;
import model.Model;
import model.Observer;
import telaDeposito.TelaDepositoView;
import telaSaque.TelaSaqueView;
import telaTransferancia.TelaTransferenciaView;

public class TelaClienteLogadoController implements Observer {
    private Model model;
    private TelaClienteLogadoView telaClienteLogadoView;

    public void initTelaClienteLogadoViewController(Model model, TelaClienteLogadoView loginView) {
        this.model = model;
        this.telaClienteLogadoView = loginView;
        model.attachObserver(this);


    }

    public void carregarDadosCliente(){
        if(model.getClienteAtivo().getConta() == null){
            String resposta = "Bem-Vindo! " + model.getClienteAtivo().getNome() + "\n"
                    + "Voce ainda não possui conta corrente\n"
                    +"Deseja ativar a conta?\n"
                    +"[1] Sim\n"
                    +"[2] Não\n"
                    +"[0] Sair\n"
                    + "Opcao -> ";
            telaClienteLogadoView.telaCliente(resposta);
        }
        else{
            String resposta = "Bem-Vindo! " + model.getNomeClienteAtivo() + "\n"
                    + "Saldo: " + model.getSaldoClienteAtivo() + "\n"
                    +"Operações: \n"
                    +"[1] Saque\n"
                    +"[2] Deposito\n"
                    +"[3] Extrato\n"
                    +"[4] Transferencia\n"
                    +"[0] Sair\n"
                    + "Opcao -> ";;
            telaClienteLogadoView.telaCliente(resposta);
        }
    }

    public void handleEvent(String event) {


        switch (event) {
            case "1": // SAQUE ou CRIAR CONTA CORRENTE
                if(model.getClienteAtivo().getConta() == null){
                    // aqui criará uma conta ativa para o cliente
                    break;
                }

                // SACAR
                TelaSaqueView telaSaqueView = new TelaSaqueView();
                telaSaqueView.initTelaSaqueview(model);
                telaClienteLogadoView.update();

                break;

            case "2":// DEPOSITO OU NEGAR CRIAR CONTA CORRENTE
                if(model.getContaClienteAtivo() == null){
                    break; // aqui é para caso a conta do cliente esteja inativa e continuar nesse estado
                }

                //DEPOSITAR
                TelaDepositoView telaDepositoView = new TelaDepositoView();
                telaDepositoView.initTelaDepositoView(model);
                telaClienteLogadoView.update();
                break;

            case "3":
                if(model.getContaClienteAtivo() == null){
                    telaClienteLogadoView.exibirMsg("Opção inválida! Tente novamente!");
                    break;
                }

                //EXTRATO DA CONTA
                TelaExtratoView telaExtratoView = new TelaExtratoView();
                telaExtratoView.initTelaExtratoView(model);

                break;

            case "4":// TRANSFERENCIA OU NEGAR TRANSFERIR
                if(model.getContaClienteAtivo() == null){
                    telaClienteLogadoView.exibirMsg("Opção inválida! Tente novamente!");
                    break;
                }

                TelaTransferenciaView telaTransferenciaView = new TelaTransferenciaView();
                telaTransferenciaView.initTelaTransferenciaView(model);
                telaClienteLogadoView.update();

                break;

            case "0":
                model.deslogarCliente();
                telaClienteLogadoView.finalizar();
                model.detachObserver(this);
                System.out.println("finalizado irá para tela de login" );
                break;

            default:
                telaClienteLogadoView.exibirMsg("Opção inválida! Tente novamente!");
                System.out.println("Passou no default de telaClienteLogadoController");
                break;
        }

    }

    @Override
    public void update() {
    }
}
