import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuList {
    private String title;
    private List<String> items;
    private int itemSelected;

    public MenuList(String title) {
        super();
        setTitle(title);
        items = new ArrayList<String>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public int getItemSelected() {
        return itemSelected;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title + "\n");
        for (int index = 0; index < items.size(); index++) {
            System.out.println((index + 1) + " - " + items.get(index) + ";");
        }
        System.out.println("0 - Exit.\n\n" +

                "Enter the option number:");
        itemSelected = scanner.nextInt();
        scanner.close();
    }
}