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

    public static class GenerateArrComand implements MenuCommand{
        MyArray myArray;
        public GenerateArrComand(MyArray myArray){
            this.myArray = myArray;
        }
        @Override
        public String getTitle() {
            return "Сгенерировать массив";
        }

        @Override
        public String execute() {
            myArray.generate();
            return "Массив сгенерирован успешно";
        }
    }

    public static class PrintArrComand implements MenuCommand{
        MyArray myArray;
        public PrintArrComand(MyArray myArray){
            this.myArray = myArray;
        }
        @Override
        public String getTitle() {
            return "Вывести массив на печать";
        }

        @Override
        public String execute() {
            return myArray.toString();
        }
    }

    public static class InputArrComand implements MenuCommand{
        MyArray myArray;
        public InputArrComand(MyArray myArray){
            this.myArray = myArray;
        }
        @Override
        public String getTitle() {
            return "Задать массив вручную";
        }

        @Override
        public String execute() {
            Scanner input = new Scanner(System.in);
            System.out.println("Размер массива?");
            int size = Integer.parseInt(input.nextLine());
            int[] temp = new int[size];
            for (int i = 0; i < size; i++) {
                System.out.println("Введите " + i + " элемент массива");
                temp[i] = Integer.parseInt(input.nextLine());
            }
            myArray.setData(temp);
            return myArray.toString();
        }
    }

    public static class SortArrComand implements MenuCommand{
        MyArray myArray;
        public SortArrComand(MyArray myArray){
            this.myArray = myArray;
        }
        @Override
        public String getTitle() {
            return "Отсортировать массив";
        }

        @Override
        public String execute() {
            myArray.sort();
            return "Сортировка выполнена";
        }
    }
}
