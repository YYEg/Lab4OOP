public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu("Главное меню");

        menu.addCommand(new Menu.WorkshopList());

        menu.start();

    }
}