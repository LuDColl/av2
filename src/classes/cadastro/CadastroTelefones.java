package classes.cadastro;

import java.util.ArrayList;
import java.util.Scanner;

import classes.Menu;
import classes.Telefone;

public class CadastroTelefones {
    private Scanner scanner;
    private Boolean run;
    private ArrayList<Telefone> telefones;

    private Menu menu;
    private Telefone telefone;

    public CadastroTelefones() {
        super();
        scanner = new Scanner(System.in);
    }

    public ArrayList<Telefone> cadTelefones(int id) {
        menu = new Menu("Cadastrar Telefones");
        menu.addItem("Adicionar 1 telefone");
        menu.addItem("Adicionar 2 telefone");
        menu.addItem("Adicionar 3 telefone");

        telefones = new ArrayList<Telefone>();
        run = true;
        while (run) {
            menu.print();
            switch (menu.getItemSelected()) {
                case 1:
                    addTelefone(id);
                    run = false;
                    break;
                case 2:
                    addTelefone(id);
                    addTelefone(id);
                    run = false;
                    break;
                case 3:
                    addTelefone(id);
                    addTelefone(id);
                    addTelefone(id);
                    run = false;
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println(menu.getItemSelected() + " não é um escolha válida.");
                    break;
            }
        }
        System.out.println();
        return telefones;
    }

    public ArrayList<Telefone> altTelefones(int id) {
        menu = new Menu("Deseja atualizar também os telefones desse aluno?");
        menu.addItem("Sim");
        
        telefones = new ArrayList<Telefone>();
        run = true;
        while (run) {
            menu.print();
            switch (menu.getItemSelected()) {
                case 1:
                    cadTelefones(id);
                    run = false;
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println(menu.getItemSelected() + " não é um escolha válida.\n");
                    break;
            }
        }
        return telefones;
    }

    private void addTelefone(int id) {
        telefone = new Telefone(id);
        System.out.println("Digite o numero do aluno:");
        telefone.setNumero(scanner.nextLine());
        telefones.add(telefone);
    }
}
