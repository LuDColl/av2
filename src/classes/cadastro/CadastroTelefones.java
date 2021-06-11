package classes.cadastro;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
        do {
            run = false;
            menu.printIn();
            switch (menu.getItemSelected()) {
                case 1:
                    addTelefone(id);
                    break;
                case 2:
                    addTelefone(id);
                    addTelefone(id);
                    break;
                case 3:
                    addTelefone(id);
                    addTelefone(id);
                    addTelefone(id);
                    break;
                case 0:
                    break;
                default:
                    System.out.println(menu.getItemSelected() + " não é um escolha válida.\n");
                    run = true;
                    break;
            }
        } while (run);
        System.out.println();
        return telefones;
    }

    public ArrayList<Telefone> altTelefones(int id) {
        menu = new Menu("Deseja atualizar os telefones desse aluno?");
        menu.addItem("Sim");

        telefones = new ArrayList<Telefone>();
        do {
            run = false;
            menu.printIn();
            switch (menu.getItemSelected()) {
                case 1:
                    cadTelefones(id);
                    break;
                case 0:
                    break;
                default:
                    System.out.println(menu.getItemSelected() + " não é um escolha válida.\n");
                    run = true;
                    break;
            }
        } while (run);
        return telefones;
    }

    private void addTelefone(int id) {
        telefone = new Telefone(id);
        System.out.println("Digite o numero do aluno:");

        try {
            telefone.setNumero(scanner.nextLine());
        } catch (InputMismatchException e) {
            do {
                run = false;
                telefone = new Telefone(id);
                scanner = new Scanner(System.in);
                System.out.println("Digite apenas números!");
                try {
                    telefone.setNumero(scanner.nextLine());
                } catch (Exception f) {
                    run = true;
                }
            } while (run);
        } finally {
            System.out.println();
        }
        if (telefone.getNumero() != "0") {
            telefones.add(telefone);
        }
    }

    public boolean exTelefone() {
        boolean escolha = false;

        menu = new Menu("Deseja apagar os telefones desse aluno?");
        menu.addItem("Sim");

        do {
            run = false;
            menu.printIn();
            switch (menu.getItemSelected()) {
                case 1:
                    escolha = true;
                    break;
                case 0:
                    break;
                default:
                    System.out.println(menu.getItemSelected() + " não é um escolha válida.\n");
                    run = true;
                    break;
            }
        } while (run);
        return escolha;
    }
}
