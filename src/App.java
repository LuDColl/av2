import classes.Cadastro;
import classes.MenuList;

public class App {
    public static void main(String[] args) throws Exception {
        MenuList menu = new MenuList("Banco de Dados");
        menu.addItem("Incluir");
        menu.addItem("Alterar");
        menu.addItem("Excluir");
        menu.addItem("Consultar");

        Cadastro cadastro = new Cadastro();

        boolean run = true;
        while (run) {
            menu.run();
            switch (menu.getItemSelected()) {
                case 1:
                    cadastro.cadAluno();
                    cadastro.cadTelefone();
                    break;
                case 2:
                    cadastro.attAluno();
                    break;
                case 3:
                    System.out.println("Em produção");
                    break;
                case 4:
                    cadastro.dadosAluno();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    break;
            }
        }
    }
}
