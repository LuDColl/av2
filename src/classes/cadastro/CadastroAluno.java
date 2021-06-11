package classes.cadastro;

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
        String t = scanner.nextLine();
        System.out.println(t);
        aluno.setNome(t);
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
        aluno.setIdaluno(scanner.nextInt());
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
        aluno.setIdaluno(scanner.nextInt());
        System.out.println();
        return aluno;
    }
}
