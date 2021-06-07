import classes.Cadastro;
import classes.MenuList;

public class App {
    public static void main(String[] args) throws Exception {
        MenuList menu = new MenuList("Banco de Dados");
        menu.addItem("Cadastrar Aluno");
        menu.addItem("Atualizar Aluno");
        menu.addItem("Deletar Aluno");
        menu.addItem("Exibir Alunos");
        menu.addItem("Exibir Telefones do Aluno");
        menu.addItem("Exibir Id do Ultimo Aluno Cadastrado");

        Cadastro cadastro = new Cadastro();

        boolean run = true;
        while (run) {
            menu.print();
            switch (menu.getItemSelected()) {
                case 1:
                    cadastro.cadAluno();
                    break;
                case 2:
                    cadastro.attAluno();
                    break;
                case 3:
                    cadastro.delAluno();
                    break;
                case 4:
                    cadastro.exibirAlunos();
                    break;
                case 5:
                    cadastro.exibirTelefonesAluno();
                    break;
                case 6:
                    cadastro.ultimoId();
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
