package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Aluno;
import classes.Telefone;
import factory.Factory;

public class AlunoDAO {
    private PreparedStatement pstm = null;
    private String sql;
    private List<Aluno> alunos;
    private ResultSet rset;
    private Aluno aluno;
    private List<Telefone> telefones;
    private Telefone telefone;
    private int id;

    private void setPstm() {
        pstm = null;
        try {
            pstm = (PreparedStatement) new Factory().createConnectionToMySQL().prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void save(Aluno aluno) {
        sql = "INSERT INTO aluno(nome,cidade,estado) VALUES(?, ?, ?)";
        try {
            setPstm();
            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getCidade());
            pstm.setString(3, aluno.getEstado());
            pstm.execute();
            System.out.println("Executado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void savetelefone(Telefone telefone) {
        sql = "INSERT INTO telefone(idaluno,numero) VALUES(?, ?)";
        try {
            setPstm();
            pstm.setInt(1, telefone.getIdaluno());
            pstm.setString(2, telefone.getNumero());
            pstm.execute();
            System.out.println("Executado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Aluno> getAluno() throws Exception {
        sql = "SELECT * FROM aluno";
        alunos = new ArrayList<Aluno>();
        rset = null;
        try {
            setPstm();
            rset = pstm.executeQuery();
            aluno = new Aluno();
            while (rset.next()) {
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

    public void updateAluno(Aluno aluno) throws Exception {
        sql = "UPDATE aplicativo_java.aluno SET nome=? ,cidade =?, estado= ?" + " WHERE (idaluno = ?)";
        try {
            setPstm();
            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getCidade());
            pstm.setString(3, aluno.getEstado());
            pstm.setInt(4, aluno.getIdaluno());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletarAluno(int idaluno) throws Exception {
        sql = "DELETE FROM aluno WHERE idaluno=?";
        try {
            setPstm();
            pstm.setInt(1, idaluno);
            pstm.execute();
            System.out.println("Aluno de ID " + idaluno + " apagado, com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Telefone> getTelefone(int Idaluno) throws Exception {
        sql = "SELECT * FROM telefone WHERE idaluno IN (?)";
        telefones = new ArrayList<Telefone>();
        rset = null;
        try {
            setPstm();
            pstm.setInt(1, Idaluno);
            rset = pstm.executeQuery();
            telefone = new Telefone();
            while (rset.next()) {
                telefone.setIdaluno(rset.getInt("idaluno"));
                telefone.setIdtelefone(rset.getInt("idtelefone"));
                telefone.setNumero(rset.getString("numero"));
                telefones.add(telefone);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return telefones;
    }

    public int lastId() {
        sql = "select max(idaluno) from aluno";
        id = 0;
        rset = null;
        try {
            setPstm();
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
