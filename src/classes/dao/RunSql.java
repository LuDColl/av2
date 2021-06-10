package classes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.Aluno;
import classes.Telefone;

public class RunSql {
    private PreparedStatement pstm;
    private ResultSet rset;
    private Aluno aluno;
    private ArrayList<Aluno> alunos;
    private Telefone telefone;
    private ArrayList<Telefone> telefones;
    private int id;

    public RunSql(PreparedStatement pstm){
        super();
        this.pstm = pstm;
    }

    public RunSql setAluno() {
        return null;
    }

    public void runInAluno(Aluno aluno) {
        try {
            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getCidade());
            pstm.setString(3, aluno.getEstado());
            pstm.execute();
            System.out.println("Executado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };

    public void runInTelefone(Telefone telefone) {
        try {
            pstm.setInt(1, telefone.getIdaluno());
            pstm.setString(2, telefone.getNumero());
            pstm.execute();
            System.out.println("Executado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    };

    public void runUpAluno(Aluno aluno) {
        try {
            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getCidade());
            pstm.setString(3, aluno.getEstado());
            pstm.setInt(4, aluno.getId());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runUpTelefone(Telefone telefone) {
        try {
            pstm.setString(1, telefone.getNumero());
            pstm.setInt(2, telefone.getIdaluno());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runDelAluno(int id) {
        try {
            pstm.setInt(1, id);
            pstm.execute();
            System.out.println("Aluno de ID " + id + " apagado, com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runGetAlunos() {
        alunos = new ArrayList<Aluno>();
        try {
            rset = pstm.executeQuery();
            while (rset.next()) {
                aluno = new Aluno();
                aluno.setIdaluno(rset.getInt("idaluno"));
                aluno.setNome(rset.getString("nome"));
                aluno.setCidade(rset.getString("cidade"));
                aluno.setEstado(rset.getString("estado"));
                alunos.add(aluno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runGetTelefone() {
        telefones = new ArrayList<Telefone>();
        try {
            pstm.setInt(1, id);
            rset = pstm.executeQuery();
            while (rset.next()) {
                telefone = new Telefone(rset.getInt("idaluno"));
                telefone.setId(rset.getInt("idtelefone"));
                telefone.setNumero(rset.getString("numero"));
                telefones.add(telefone);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runGetLastId() {
        id = 0;
        try {
            rset = pstm.executeQuery();
            rset.next();
            id = rset.getInt("max(idaluno)");
            System.out.println("Executado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
