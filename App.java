import model.Model;
import telaInicial.TelaInicialView;

public class App {
    public static void main(String[] args) {
        Model model = new Model();
        TelaInicialView telaInicial = new TelaInicialView();
        telaInicial.initMainView(model);
    }
}
