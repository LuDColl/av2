package classes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.Aluno;
import classes.Telefone;

public class RunSql {
    PreparedStatement pstm;
    ResultSet rset;
    ArrayList<Aluno> alunos;
    ArrayList<Telefone> telefones;

    Aluno aluno;
    Telefone telefone;
    int id;

    public void setId(int id) {
        this.id = id;
    }

    public void inAluno(Aluno aluno) {
        pstm = new PreparePstm(new Sql().inAluno()).getPstm();
        try {
            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getCidade());
            pstm.setString(3, aluno.getEstado());
            pstm.execute();
            System.out.println("Executado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inTelefone(Telefone telefone) {
        pstm = new PreparePstm(new Sql().inTelefone()).getPstm();
        try {
            pstm.setInt(1, telefone.getIdaluno());
            pstm.setString(2, telefone.getNumero());
            pstm.execute();
            System.out.println("Executado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void upAluno(Aluno aluno) {
        pstm = new PreparePstm(new Sql().upAluno()).getPstm();
        try {
            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getCidade());
            pstm.setString(3, aluno.getEstado());
            pstm.setInt(4, aluno.getId());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void upTelefone(Telefone telefone) {
        pstm = new PreparePstm(new Sql().upTelefone()).getPstm();
        try {
            pstm.setString(1, telefone.getNumero());
            pstm.setInt(2, telefone.getIdaluno());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delAluno(int id) {
        pstm = new PreparePstm(new Sql().delAluno()).getPstm();
        try {
            pstm.setInt(1, id);
            pstm.execute();
            System.out.println("Aluno de ID " + id + " apagado, com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delTelefones(int id) {
        pstm = new PreparePstm(new Sql().delTelefones()).getPstm();
        try {
            pstm.setInt(1, id);
            pstm.execute();
            System.out.println("Telefones do aluno de ID " + id + " apagados com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Aluno> getAlunos() {
        pstm = new PreparePstm(new Sql().getAlunos()).getPstm();
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
        return alunos;
    }

    public ArrayList<Telefone> getTelefones() {
        pstm = new PreparePstm(new Sql().getTelefones()).getPstm();
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
        return telefones;
    }

    public int getLastId() {
        pstm = new PreparePstm(new Sql().getLastId()).getPstm();
        try {
            rset = pstm.executeQuery();
            rset.next();
            id = rset.getInt("max(idaluno)");
            System.out.println("Executado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}
