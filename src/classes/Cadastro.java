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
        System.out.println("Cadastro Aluno\n\n" + "Digite o nome do aluno:");
        aluno.setNome(scanner.next());
        System.out.println("Digite a Cidade:");
        aluno.setCidade(scanner.next());
        System.out.println("Digite o estado:");
        aluno.setEstado(scanner.next());
        alunoDAO.setAluno(aluno);
        System.out.println();
    }

    public void cadTelefone() {
        telefone = new Telefone();
        System.out.println("Cadastro Telefone\n\n" + "Digite o ID do aluno:");
        telefone.setIdaluno(scanner.nextInt());
        System.out.println("Digite o numero do aluno:");
        telefone.setNumero(scanner.next());
        alunoDAO.setTelefone(telefone);
        System.out.println();
    }

    public void exibirAluno() {
        System.out.println("Alunos\n\n");
        for (Aluno aluno : (alunoDAO.getAlunos())) {
            System.out.println("ID Aluno: " + aluno.getIdaluno() + "\nAluno: " + aluno.getNome() + "\nCidade: "
                    + aluno.getCidade() + "\nEstado: " + aluno.getEstado() + "\n");
        }
        System.out.println();
    }

    public void attAluno() throws Exception {
        Aluno aluno = new Aluno();
        System.out.println("Atualizar Aluno\n\n" + "Qual ID do Aluno:");
        aluno.setIdaluno(scanner.nextInt());
        System.out.println("Digite o nome do Aluno:");
        aluno.setNome(scanner.next());
        System.out.println("Digite o estado:");
        aluno.setEstado(scanner.next());
        System.out.println("Digite a Cidade");
        aluno.setCidade(scanner.next());
        alunoDAO.updtAluno(aluno);
        System.out.println();
    }

    public void delAluno() throws Exception {
        System.out.println("Deletar Aluno\n\n" + "Digite o Id do aluno: ");
        alunoDAO.delAluno(scanner.nextInt());
        System.out.println();
    }

    public void exibirTelefonesAluno() throws Exception {
        System.out.println("Exibir Telefones do Aluno\n\n" + "Digite o id do aluno: ");
        for (Telefone telefone : alunoDAO.getTelefone(scanner.nextInt())) {
            System.out.println("ID Aluno: " + telefone.getIdaluno() + " ID Telefone: " + telefone.getIdtelefone()
                    + "\n Numero: " + telefone.getNumero() + "\n");
        }
        System.out.println();
    }

    public void ultimoId() {
        System.out.println("Id do Ultimo Aluno\n\n" + alunoDAO.getLastId());
        System.out.println();
    }
}
