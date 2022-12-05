import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private String menuTitle;
    private ArrayList<MenuCommand> commands = new ArrayList();

    public Menu(String s){
        menuTitle = s;
    }

    public void start(){
        Scanner in = new Scanner(System.in);
        int usrInput = 0;
        do{
            System.out.println(menuTitle);
            System.out.println("____________________________________");
            printCommands();
            System.out.println("0 - Выход");
            usrInput = Integer.parseInt(in.nextLine());
            if (usrInput == 0) { break;}
            System.out.println(commands.get(usrInput-1).execute());
        }while(usrInput != 0);

        System.out.println("Finished");
    }

    private void printCommands() {
        for (int i = 0; i < commands.size(); i++) {
            System.out.println((i+1) + " - " + commands.get(i).getTitle());
        }
    }

    public void addCommand(MenuCommand command) {
        this.commands.add(command);
    }

    public interface  MenuCommand{
        String getTitle();
        String execute();
    }

    public static class StartTransport implements MenuCommand{
        TransportCompany transportCompany = new TransportCompany("Список доступного транспорта");
        @Override
        public String getTitle() {
            return "Список доступного транспорта";
        }

        @Override
        public String execute() {
            transportCompany.startEngine();
            return "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+";
        }
    }
}
