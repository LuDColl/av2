package classes.dao;

public class Sql {

    public String inAluno() {
        return "INSERT INTO aluno(nome,cidade,estado) VALUES(?, ?, ?)";
    }

    public String inTelefone() {
        return "INSERT INTO telefone(idaluno,numero) VALUES(?, ?)";
    }

    public String upAluno() {
        return "UPDATE aplicativo_java.aluno SET nome=? ,cidade =?, estado= ?" + " WHERE (idaluno = ?)";
    }

    public String upTelefone() {
        return "UPDATE aplicativo_java.telefone SET numero = ? " + "WHERE (idaluno = ?)";
    }

    public String delAluno() {
        return "DELETE FROM aluno WHERE idaluno=?";
    }

    public String delTelefones() {
        return "DELETE FROM telefone WHERE idaluno=?";
    }

    public String getAlunos() {
        return "SELECT * FROM aluno";
    }

    public String getTelefones() {
        return "SELECT * FROM telefone WHERE idaluno IN (?)";
    }

    public String getLastId() {
        return "select max(idaluno) from aluno";
    }
}
