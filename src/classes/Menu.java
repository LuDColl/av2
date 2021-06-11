package classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String title;
    private List<String> items;
    private int itemSelected;
    private Scanner scanner;

    public Menu(String title) {
        super();
        this.title = title;
        items = new ArrayList<String>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public int getItemSelected() {
        return itemSelected;
    }

    public void printIn() {
        scanner = new Scanner(System.in);
        System.out.println(title + "\n");
        for (int index = 0; index < items.size(); index++) {
            System.out.println((index + 1) + " - " + items.get(index) + ";");
        }
        System.out.println("0 - Sair.\n\n" +

                "Escolha uma opção:");

        try {
            itemSelected = scanner.nextInt();
        } catch (InputMismatchException e) {
            boolean run;
            do {
                run = false;
                scanner = new Scanner(System.in);
                System.out.println("Digite apenas números!");
                try {
                    itemSelected = scanner.nextInt();
                } catch (Exception f) {
                    run = true;
                }
            } while (run);
        } finally {
            System.out.println();
        }
    }

}
