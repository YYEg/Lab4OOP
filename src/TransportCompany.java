import java.util.ArrayList;
import java.util.Scanner;

public class TransportCompany {
        private final String transportName;
        private ArrayList<transportVehicle> transport = new ArrayList<>();

        public TransportCompany(String s){
            transportName = s;
        }

        public void start(){
            Scanner in = new Scanner(System.in);
            int usrInput = 0;
            do{
                System.out.println(transportName);
                System.out.println("____________________________________");
                printVehicles();
                System.out.println("0 - Выход");
                usrInput = Integer.parseInt(in.nextLine());
                if (usrInput == 0) { break;}
                System.out.println(transport.get(usrInput-1).sound());
            }while(usrInput != 0);

            System.out.println("Finished");
        }
        public void startEngine(){
            MyVehicles myVehicles = new MyVehicles();
            TransportCompany transportCompany = new TransportCompany("Список доступного транспорта");
            transportCompany.addVehicle(new TransportCompany.Car(myVehicles));
            transportCompany.addVehicle(new TransportCompany.Train(myVehicles));
            transportCompany.addVehicle(new TransportCompany.Ecspress(myVehicles));

            transportCompany.start();
        }

        private void printVehicles() {
            for (int i = 0; i < transport.size(); i++) {
                System.out.println((i+1) + " - " + transport.get(i).getTitle());
            }
        }

        public void addVehicle(transportVehicle vehicles) {
            this.transport.add(vehicles);
        }

        public interface transportVehicle {
            String getTitle();
            String sound();
        }

        public static class Car implements transportVehicle {
            MyVehicles myVehicles;
            public Car(MyVehicles myVehicles){
                this.myVehicles = myVehicles;
            }
            @Override
            public String getTitle() {
                return "Автомобили";
            }

            @Override
            public String sound() {
                return  myVehicles.carsSound();
            }
        }

        public static class Train implements transportVehicle {
            MyVehicles myVehicles;
            public Train(MyVehicles myVehicles){
                this.myVehicles = myVehicles;
            }

            public Train() {
            }

            String trainForOverride(){
                return "По́езд в современном понятии — сформированный и сцеплённый состав," +
                        " состоящий из группы вагонов, с одним или несколькими действующими локомотивами или моторными вагонами," +
                        " приводящими его в движение, и имеющий установленные сигналы";
            }
            @Override
            public String getTitle() {
                return "Поезда";
            }

            @Override
            public String sound() {
                return myVehicles.trainSound();
            }
        }
        public static class Ecspress extends Train{
            MyVehicles myVehicles;

            public Ecspress(MyVehicles myVehicles) {
                this.myVehicles = myVehicles;
            }

            @Override
            public String getTitle() {
                return "Экспрессы";
            }
            @Override
            public String trainForOverride() {
                return myVehicles.ecspressSound();
            }
            @Override
            public String sound() {
                return trainForOverride();
            }

        }
}
