package classes;

public class Telefone {
    private int idAluno;
    private int idTelefone;
    private String numero;
    private String numero2;
    private String numero3;

    public Telefone(int idAluno){
        this.idAluno = idAluno;
    }

    public String getNumero() {
        return numero;
    }

    public String getNumero3() {
        return numero3;
    }

    public void setNumero3(String numero3) {
        this.numero3 = numero3;
    }

    public String getNumero2() {
        return numero2;
    }

    public void setNumero2(String numero2) {
        this.numero2 = numero2;
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
