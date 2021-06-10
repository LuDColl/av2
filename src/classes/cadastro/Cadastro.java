package classes.cadastro;

import classes.Aluno;
import classes.Telefone;
import classes.dao.Dao;

public class Cadastro {
    private Aluno aluno;
    private Telefone telefone;

    public Cadastro() {
        super();
    }

    public void incluir() {
        aluno = new Aluno();
        new CadastroAluno(aluno).cadAluno();
        new Dao().inAluno(aluno);

        telefone = new Telefone(new Dao().getLastId());
        new CadastroTelefone(telefone).cadTelefone();
        new Dao().inTelefone(telefone);
    }

    public void alterar() {
        aluno = new Aluno();
        new CadastroAluno(aluno).altAluno();
        new Dao().upAluno(aluno);

        telefone = new Telefone(aluno.getId());
        new CadastroTelefone(telefone).altTelefone();
        new Dao().upTelefone(telefone);
    }

    public void consultar() {

    }

    public void excluir() {
        aluno = new Aluno();
        new CadastroAluno(aluno).exAluno();
        new Dao().delTelefone(aluno.getId());
        new Dao().delAluno(aluno.getId());
    }

    public void exibirAlunos() throws Exception {
        System.out.println("Alunos\n\n");
        for (Aluno aluno : (new Dao().getAlunos())) {
            System.out.println("ID Aluno: " + aluno.getId() + "\nAluno: " + aluno.getNome() + "\nCidade: "
                    + aluno.getCidade() + "\nEstado: " + aluno.getEstado() + "\n");
            exibirTelefonesAluno(aluno.getId());
        }
        System.out.println();
    }

    private void exibirTelefonesAluno(int id) throws Exception {
        System.out.println("Telefones do Aluno com o id: " + id + ".\n\n");
        for (Telefone telefone : new Dao().getTelefones(id)) {
            System.out.println("ID Aluno: " + telefone.getIdaluno() + " ID Telefone: " + telefone.getId()
                    + "\n Numero: " + telefone.getNumero() + "\n");
        }
        System.out.println();
    }
}
