public class App {
    public static void main(String[] args) throws Exception {
        MenuList menu = new MenuList("Banco de Dados");
        menu.addItem("Incluir");
        menu.addItem("Alterar");
        menu.addItem("Excluir");
        menu.addItem("Consultar");

        boolean run = true;
        while (run) {
            menu.run();
            switch (menu.getItemSelected()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    break;
            }
        }
    }
}
