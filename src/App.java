import classes.Menu;
import classes.cadastro.Cadastro;

public class App {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu("Banco de Dados");
        menu.addItem("Incluir");
        menu.addItem("Alterar");
        menu.addItem("Excluir");
        menu.addItem("Consultar");

        Cadastro cadastro = new Cadastro();

        boolean run = true;
        while (run) {
            menu.print();
            switch (menu.getItemSelected()) {
                case 1:
                    cadastro.incluir();
                    break;
                case 2:
                    cadastro.alterar();
                    break;
                case 3:
                    cadastro.excluir();
                    break;
                case 4:
                    cadastro.consultar();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println(menu.getItemSelected() + " não é um valor válido.\n");
                    break;
            }
        }
    }
}
