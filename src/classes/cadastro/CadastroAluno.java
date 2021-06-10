package classes.cadastro;

import java.util.Scanner;

import classes.Aluno;

public class CadastroAluno {
    private Scanner scanner;
    private Aluno aluno;

    public CadastroAluno(Aluno aluno){
        super();
        this.aluno = aluno;
    }

    public void cadAluno() {
        System.out.println("Cadastrar Aluno\n\n" + "Digite o nome do aluno:");
        aluno.setNome(scanner.nextLine());
        System.out.println("Digite seu estado:");
        aluno.setEstado(scanner.nextLine());
        System.out.println("Digite sua Cidade:");
        aluno.setCidade(scanner.nextLine());
        System.out.println();
    }

    public void altAluno() {
        System.out.println("Alterar Aluno\n\n" + "Qual ID do Aluno:");
        aluno.setIdaluno(scanner.nextInt());
        System.out.println("Digite o novo nome do Aluno:");
        aluno.setNome(scanner.nextLine());
        System.out.println("Digite o novo estado:");
        aluno.setEstado(scanner.nextLine());
        System.out.println("Digite a nova Cidade");
        aluno.setCidade(scanner.nextLine());
        System.out.println();
    }

    public void exAluno() {
        System.out.println("Excluir Aluno\n\n" + "Digite o Id do aluno: ");
        aluno.setIdaluno(scanner.nextInt());
        System.out.println();
    }
}
