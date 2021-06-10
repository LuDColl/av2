package classes;

public class Aluno {
    private int id;
    private String nome;
    private String cidade;
    private String estado;

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setIdaluno(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
