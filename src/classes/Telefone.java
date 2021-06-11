package classes;

public class Telefone {
    private int idAluno;
    private int idTelefone;
    private String numero;

    public Telefone(int idAluno){
        this.idAluno = idAluno;
    }

    public String getNumero() {
        return numero;
    }

    public int getId() {
        return idTelefone;
    }

    public void setId(int idtelefone) {
        this.idTelefone = idtelefone;
    }

    public int getIdaluno() {
        return idAluno;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
