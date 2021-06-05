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
    private PreparedStatement pstm;
    private String sql;
    private List<Aluno> alunos;
    private ResultSet rset;
    private Aluno aluno;
    private List<Telefone> telefones;
    private Telefone telefone;
    private int id;

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
        sql = "INSERT INTO aluno(nome,cidade,estado) VALUES(?, ?, ?)";
        runSql("setAluno");
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
        sql = "INSERT INTO telefone(idaluno,numero) VALUES(?, ?)";
        runSql("setTelefone");
    }

    public List<Aluno> getAlunos() {
        sql = "SELECT * FROM aluno";
        runSql("getAlunos");
        return alunos;
    }

    public void updtAluno(Aluno aluno) {
        this.aluno = aluno;
        sql = "UPDATE aplicativo_java.aluno SET nome=? ,cidade =?, estado= ?" + " WHERE (idaluno = ?)";
        runSql("updtAluno");
    }

    public void delAluno(int id) {
        this.id = id;
        sql = "DELETE FROM aluno WHERE idaluno=?";
        runSql("delAluno");
    }

    public List<Telefone> getTelefone(int id) {
        runSql("getTelefone");
        sql = "SELECT * FROM telefone WHERE idaluno IN (?)";
        return telefones;
    }

    public int getLastId() {
        runSql("getLastId");
        sql = "select max(idaluno) from aluno";
        return id;
    }

    private void runSql(String option) {
        try {
            pstm = (PreparedStatement) new Factory().createConnectionToMySQL().prepareStatement(sql);
            switch (option) {
                case "setAluno":
                    runSetAluno();
                    break;
                case "setTelefone":
                    runSetTelefone();
                    break;
                case "updtAluno":
                    runUpdtAluno();
                    break;
                case "delAluno":
                    runDelAluno();
                    break;
                case "getAlunos":
                    runGetAlunos();
                    break;
                case "getTelefone":
                    runGetTelefone();
                    break;
                case "getLastId":
                    runGetLastId();
                    break;
                default:
                    break;
            }
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

    private void runSetAluno() {
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

    private void runSetTelefone() {
        try {
            pstm.setInt(1, telefone.getIdaluno());
            pstm.setString(2, telefone.getNumero());
            pstm.execute();
            System.out.println("Executado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    };

    private void runGetAlunos() {
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

    private void runUpdtAluno() {
        try {
            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getCidade());
            pstm.setString(3, aluno.getEstado());
            pstm.setInt(4, aluno.getIdaluno());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void runDelAluno() {
        try {
            pstm.setInt(1, id);
            pstm.execute();
            System.out.println("Aluno de ID " + id + " apagado, com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void runGetTelefone() {
        telefones = new ArrayList<Telefone>();
        try {
            pstm.setInt(1, id);
            rset = pstm.executeQuery();
            while (rset.next()) {
                telefone = new Telefone();
                telefone.setIdaluno(rset.getInt("idaluno"));
                telefone.setIdtelefone(rset.getInt("idtelefone"));
                telefone.setNumero(rset.getString("numero"));
                telefones.add(telefone);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void runGetLastId() {
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
