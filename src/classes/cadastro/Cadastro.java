package classes.cadastro;

import classes.Aluno;
import classes.Telefone;
import classes.dao.RunSql;

public class Cadastro {
    private Aluno aluno;
    private Telefone telefone;

    public Cadastro() {
        super();
    }

    public void incluir() {
        aluno = new Aluno();
        new CadastroAluno(aluno).cadAluno();
        new RunSql().inAluno(aluno);

        telefone = new Telefone(new RunSql().getLastId());
        new CadastroTelefone(telefone).cadTelefone();
        new RunSql().inTelefone(telefone);
    }

    public void alterar() {
        aluno = new Aluno();
        new CadastroAluno(aluno).altAluno();
        new RunSql().upAluno(aluno);

        telefone = new Telefone(aluno.getId());
        new CadastroTelefone(telefone).altTelefone();
        new RunSql().upTelefone(telefone);
    }

    public void excluir() {
        aluno = new Aluno();
        new CadastroAluno(aluno).exAluno();

        new RunSql().delTelefones(aluno.getId());
        new RunSql().delAluno(aluno.getId());
    }

    public void consultar() {
        System.out.println("Alunos\n\n");
        RunSql runSql;
        for (Aluno aluno : new RunSql().getAlunos()) {
            System.out.println("Aluno\nId: " + aluno.getId() + "\nNome: " + aluno.getNome() + "\nEstado: "
                    + aluno.getEstado() + "\nCidade: " + aluno.getCidade() + "\n\nTelefones");
            runSql = new RunSql();
            runSql.setId(aluno.getId());
            for (Telefone telefone : new RunSql().getTelefones()) {
                System.out.println("Id: " + telefone.getId() + "\nNumero: " + telefone.getNumero() + "\n");
            }
        }
    }
}