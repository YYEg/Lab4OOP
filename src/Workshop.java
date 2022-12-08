import java.util.ArrayList;
import java.util.Scanner;

public class Workshop {
        private final String type;
        private ArrayList<industry>fabric = new ArrayList<>();

        public Workshop(String s){
            type = s;
        }

        public void start(){
            Scanner in = new Scanner(System.in);
            int usrInput = 0;
            do{
                System.out.println(type);
                System.out.println("____________________________________");
                printVehicles();
                System.out.println("0 - Выход");
                usrInput = Integer.parseInt(in.nextLine());
                if (usrInput == 0) { break;}
                System.out.println(fabric.get(usrInput-1).iAm());
            }while(usrInput != 0);

            System.out.println("Finished");
        }
        public void startWorking(){
            About about = new About();
            Workshop workshop = new Workshop("Составляющие фабрики");
            workshop.addFactoryComponent(new Detail(about));
            workshop.addFactoryComponent(new Unit(about));
            workshop.addFactoryComponent(new Item(about));

            workshop.start();
        }

        private void printVehicles() {
            for (int i = 0; i < fabric.size(); i++) {
                System.out.println((i+1) + " - " + fabric.get(i).getTitle());
            }
        }

        public void addFactoryComponent(industry factoryComponent) {
            this.fabric.add(factoryComponent);
        }

        public interface industry {
            String getTitle();
            String iAm();
        }

        public static class Detail implements industry {
            About about;
            public Detail(About about){
                this.about = about;
            }
            @Override
            public String getTitle() {
                return "Деталь";
            }

            @Override
            public String iAm() {
                return  about.aboutDetail();
            }
        }

        public static class Unit implements industry {
            About about;
            public Unit(About about){
                this.about = about;
            }

            public Unit() {
            }

            String unitForOverride(){
                return " ";
            }
            @Override
            public String getTitle() {
                return "Устройство";
            }

            @Override
            public String iAm() {
                return about.aboutUnit();
            }
        }
        public static class Item extends Unit {
            About about;

            public Item(About about) {
                this.about = about;
            }

            @Override
            public String getTitle() {
                return "Изделие";
            }
            @Override
            public String unitForOverride() {
                return about.aboutItem();
            }
            @Override
            public String iAm() {
                return unitForOverride();
            }

        }
}
