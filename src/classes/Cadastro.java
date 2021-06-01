package classes;

import java.util.Scanner;

import dao.AlunoDAO;

public class Cadastro {
    private AlunoDAO alunoDAO;
    private Aluno aluno;
    private Telefone telefone;
    private Scanner scanner;

    public Cadastro() {
        alunoDAO = new AlunoDAO();
        scanner = new Scanner(System.in);
    }

    public void cadAluno() {
        aluno = new Aluno();
        System.out.println("Digite o nome do aluno:");
        aluno.setNome(scanner.next());
        System.out.println("Digite a Cidade:");
        aluno.setCidade(scanner.next());
        System.out.println("Digite o estado:");
        aluno.setEstado(scanner.next());

        alunoDAO.save(aluno);
    }

    public void cadTelefone() {
        telefone = new Telefone();
        System.out.println("Digite o ID do aluno:");
        telefone.setIdaluno(scanner.nextInt());
        System.out.println("Digite o numero do aluno:");
        telefone.setNumero(scanner.next());

        alunoDAO.savetelefone(telefone);
    }

    public void dadosAluno() throws Exception {
        for (Aluno aluno : (alunoDAO.getaluno())) {
            System.out.println("ID Aluno: " + aluno.getIdaluno() + "\nAluno: " + aluno.getNome() + "\nCidade: "
                    + aluno.getCidade() + "\nEstado: " + aluno.getEstado());
        }
    }

    public void attAluno() throws Exception {
        Aluno aluno = new Aluno();
        System.out.println("Qual ID do Aluno:");
        aluno.setIdaluno(scanner.nextInt());
        System.out.println("Digite o nome do Aluno:");
        aluno.setNome(scanner.next());
        System.out.println("Digite o estado:");
        aluno.setEstado(scanner.next());
        System.out.println("Digite a Cidade");
        aluno.setCidade(scanner.next());

        alunoDAO.update_aluno(aluno);
    }

}
