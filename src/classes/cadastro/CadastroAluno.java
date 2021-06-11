package classes.cadastro;

import java.util.InputMismatchException;
import java.util.Scanner;

import classes.Aluno;

public class CadastroAluno {
    private Scanner scanner;
    private Aluno aluno;

    public CadastroAluno(){
        super();
        scanner = new Scanner(System.in);
    }

    public Aluno cadAluno() {
        aluno = new Aluno();
        System.out.println("Cadastrar Aluno\n\n" + "Digite o nome do aluno:");
        aluno.setNome(scanner.nextLine());
        System.out.println("Digite seu estado:");
        aluno.setEstado(scanner.nextLine());
        System.out.println("Digite sua Cidade:");
        aluno.setCidade(scanner.nextLine());
        System.out.println();
        return aluno;
    }

    public Aluno altAluno() {
        aluno = new Aluno();
        System.out.println("Alterar Aluno\n\n" + "Qual ID do Aluno:");
        try {
            aluno.setIdaluno(scanner.nextInt());
        } catch (InputMismatchException e) {
            boolean run;
            do {
                run = false;
                aluno = new Aluno();
                scanner = new Scanner(System.in);
                System.out.println("Digite apenas números!");
                try {
                    aluno.setIdaluno(scanner.nextInt());
                } catch (Exception f) {
                    run = true;
                }
            } while (run);
        } finally {
            scanner.nextLine();
        }
        System.out.println("Digite o novo nome do Aluno:");
        aluno.setNome(scanner.nextLine());
        System.out.println("Digite o novo estado:");
        aluno.setEstado(scanner.nextLine());
        System.out.println("Digite a nova Cidade");
        aluno.setCidade(scanner.nextLine());
        System.out.println();
        return aluno;
    }

    public Aluno exAluno() {
        aluno = new Aluno();
        System.out.println("Excluir Aluno\n\n" + "Digite o Id do aluno: ");
        try {
            aluno.setIdaluno(scanner.nextInt());
        } catch (InputMismatchException e) {
            boolean run;
            do {
                run = false;
                aluno = new Aluno();
                scanner = new Scanner(System.in);
                System.out.println("Digite apenas números!");
                try {
                    aluno.setIdaluno(scanner.nextInt());
                } catch (Exception f) {
                    run = true;
                }
            } while (run);
        } finally{
            System.out.println();
        }
        return aluno;
    }
}
