package classes;

import java.util.Scanner;

import dao.AlunoDAO;

public class Cadastro {
    private AlunoDAO alunoDAO;
    private Aluno aluno;
    private Telefone telefone;
    private Scanner sc;

    public Cadastro() {
        alunoDAO = new AlunoDAO();
        sc = new Scanner(System.in);
    }

    public void cadAluno() {

        aluno = new Aluno();
        System.out.println("Digite o nome do aluno:");
        aluno.setNome(sc.next());
        System.out.println("Digite a Cidade:");
        aluno.setCidade(sc.next());
        System.out.println("Digite o estado:");
        aluno.setEstado(sc.next());

        alunoDAO.save(aluno);
        sc.close();
    }

    public void cadTelefone() {
        telefone = new Telefone();
        System.out.println("Digite o ID do aluno:");
        telefone.setIdaluno(sc.nextInt());
        System.out.println("Digite o numero do aluno:");
        telefone.setNumero(sc.next());

        alunoDAO.savetelefone(telefone);
        sc.close();
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
        aluno.setIdaluno(sc.nextInt());
        System.out.println("Digite o nome do Aluno:");
        aluno.setNome(sc.next());
        System.out.println("Digite o estado:");
        aluno.setEstado(sc.next());
        System.out.println("Digite a Cidade");
        aluno.setCidade(sc.next());

        alunoDAO.update_aluno(aluno);
        sc.close();
    }

}
