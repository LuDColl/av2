package classes.cadastro;

import java.util.ArrayList;

import classes.Aluno;
import classes.Telefone;
import classes.dao.RunSql;

public class Cadastro {
    private Aluno aluno;
    private ArrayList<Telefone> telefones;

    public Cadastro() {
        super();
    }

    public void incluir() {
        new RunSql().inAluno(new CadastroAluno().cadAluno());

        telefones = new CadastroTelefones().cadTelefones(new RunSql().getLastId());
        if (telefones != null) {
            new RunSql().inTelefones(telefones);
        }
    }

    public void alterar() {
        aluno = new CadastroAluno().altAluno();
        new RunSql().upAluno(aluno);

        telefones = new CadastroTelefones().altTelefones(aluno.getId());
        if(telefones != null){
            new RunSql().delTelefones(aluno.getId());
            new RunSql().inTelefones(telefones);
        }
    }

    public void excluir() {
        aluno = new CadastroAluno().exAluno();

        new RunSql().delTelefones(aluno.getId());
        new RunSql().delAluno(aluno.getId());
    }

    public void consultar() {
        System.out.println("Alunos\n\n");
        RunSql runSql;
        for (Aluno aluno : new RunSql().getAlunos()) {
            System.out.println("Aluno\nId: " + aluno.getId() + "\nNome: " + aluno.getNome() + "\nEstado: "
                    + aluno.getEstado() + "\nCidade: " + aluno.getCidade());
            runSql = new RunSql();
            runSql.setId(aluno.getId());
            for (Telefone telefone : runSql.getTelefones()) {
                System.out.println("\n\nTelefones de " + aluno.getNome() + "\nId: " + telefone.getId() + "\nNumero: "
                        + telefone.getNumero() + "\n");
            }
        }
    }
}