package classes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Aluno;
import classes.Telefone;
import classes.factory.Factory;

public class Dao {
    private List<Aluno> alunos;
    private List<Telefone> telefones;
    private String sql;
    private int id;

    public void inAluno(Aluno aluno) {
        sql = "INSERT INTO aluno(nome,cidade,estado) VALUES(?, ?, ?)";
        runSql("inAluno");
    }

    public void inTelefone(Telefone telefone) {
        sql = "INSERT INTO telefone(idaluno,numero) VALUES(?, ?)";
        runSql("setTelefone");
    }

    public void upAluno(Aluno aluno) {
        this.aluno = aluno;
        sql = "UPDATE aplicativo_java.aluno SET nome=? ,cidade =?, estado= ?" + " WHERE (idaluno = ?)";
        runSql("upAluno");
    }

    public void upTelefone(Telefone telefone) {
        this.telefone = telefone;
        sql = "UPDATE aplicativo_java.telefone SET numero = ? " + "WHERE (idaluno = ?)";
        runSql("upTelefone");
    }

    public void delAluno(int id) {
        this.id = id;
        sql = "DELETE FROM aluno WHERE idaluno=?";
        runSql("delAluno");
    }

    public void delTelefone(int id) {
        this.id = id;
        sql = "DELETE FROM telefone WHERE idaluno=?";
        runSql("delTelefone");
    }

    public List<Aluno> getAlunos() {
        sql = "SELECT * FROM aluno";
        runSql("getAlunos");
        return alunos;
    }

    public List<Telefone> getTelefones(int id) {
        sql = "SELECT * FROM telefone WHERE idaluno IN (?)";
        runSql("getTelefones");
        return telefones;
    }

    public int getLastId() {
        sql = "select max(idaluno) from aluno";
        runSql("getLastId");
        return id;
    }
}
