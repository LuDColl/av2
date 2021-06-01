package classes;

import java.util.Scanner;

import dao.AlunoDAO;

public class Controle {
    private int idAluno;
    private String nome, cidade, estado, numero;
    private AlunoDAO alunoDAO;
    private Scanner sc;

    public Controle() {
        alunoDAO = new AlunoDAO();
        sc = new Scanner(System.in);
    }

    public void cad_aluno() {

        Aluno aluno = new Aluno();
        System.out.println("Digite o nome do aluno: ");
        nome = sc.next();
        aluno.setNome(nome);
        System.out.println("Digite a Cidade: ");
        cidade = sc.next();
        aluno.setCidade(cidade);
        System.out.println("Digite o estado: ");
        estado = sc.next();
        aluno.setEstado(estado);

        alunoDAO.save(aluno);
        sc.close();
    }

    public void cad_telefone() {
        Telefone telefone = new Telefone();
        System.out.println("Digite o ID do aluno: ");
        idAluno = sc.nextInt();
        telefone.setIdaluno(idAluno);
        System.out.println("Digite o numero do aluno: ");
        numero = sc.next();
        telefone.setNumero(numero);

        alunoDAO.savetelefone(telefone);
        sc.close();
    }

    public void dados_aluno() throws Exception {
        for (Aluno aluno : (alunoDAO.getaluno())) {
            System.out.println("ID Aluno: " + aluno.getIdaluno() + "\nAluno: " + aluno.getNome() + "\nCidade: "
                    + aluno.getCidade() + "\nEstado: " + aluno.getEstado());
        }
    }

    public void atualizar_aluno() throws Exception {
        Aluno aluno = new Aluno();
        System.out.println("Qual ID do Aluno: ");
        idAluno = sc.nextInt();
        aluno.setIdaluno(idAluno);
        System.out.println("Digite o nome do Aluno: ");
        nome = sc.next();
        aluno.setNome(nome);
        System.out.println("Digite o estado: ");
        estado = sc.next();
        aluno.setEstado(estado);
        System.out.println("Digite a Cidade");
        cidade = sc.next();
        aluno.setCidade(cidade);

        alunoDAO.update_aluno(aluno);
        sc.close();
    }

}
