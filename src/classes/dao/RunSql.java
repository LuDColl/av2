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

    public void inAluno(Aluno aluno) throws NullPointerException {
        pstm = new PreparePstm(new Sql().inAluno()).getPstm();
        try {
            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getCidade());
            pstm.setString(3, aluno.getEstado());
            pstm.execute();
            System.out.println("Aluno " + aluno.getNome() + " adicionado com sucesso!\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println();
        }
    }

    public void inTelefones(ArrayList<Telefone> telefones) {
        pstm = new PreparePstm(new Sql().inTelefone()).getPstm();
        for (Telefone telefone : telefones) {
            try {
                pstm.setInt(1, telefone.getIdaluno());
                pstm.setString(2, telefone.getNumero());
                pstm.execute();
                System.out.println("Número " + telefone.getNumero() + " adicionado com sucesso!\n");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                System.out.println();
            }
        }
    }

    public void upAluno(Aluno aluno) throws NullPointerException, Exception {
        pstm = new PreparePstm(new Sql().upAluno()).getPstm();
        try {
            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getCidade());
            pstm.setString(3, aluno.getEstado());
            pstm.setInt(4, aluno.getId());
            pstm.execute();
            System.out.println("Aluno " + aluno.getNome() + " atualizado com sucesso!\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delAluno(int id) {
        pstm = new PreparePstm(new Sql().delAluno()).getPstm();
        try {
            pstm.setInt(1, id);
            pstm.execute();
            System.out.println("Aluno de id " + id + " apagado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delTelefones(int id) throws NullPointerException {
        pstm = new PreparePstm(new Sql().delTelefones()).getPstm();
        try {
            pstm.setInt(1, id);
            pstm.execute();
            System.out.println("Telefones do aluno de id " + id + " apagados com sucesso!");
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
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Consulta falhou!");
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
            System.out.println("Ultimo aluno selecionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}
