package classes.cadastro;

import java.util.Scanner;

import classes.Telefone;

public class CadastroTelefone {
    private Scanner scanner;
    private Telefone telefone;

    public CadastroTelefone(Telefone telefone) {
        super();
        this.telefone = telefone;
    }

    public void cadTelefone() {
        System.out.println("Cadastro Telefone\n\n" + "Digite o numero do aluno:");
        telefone.setNumero(scanner.nextLine());
        System.out.println();
    }

    public void altTelefone() {
        System.out.println("Alterar Telefone\n\n" + "Digite o novo numero do aluno:");
        telefone.setNumero(scanner.nextLine());
        System.out.println();
    }

    
}
