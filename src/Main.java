public class Main {
    public static void main(String[] args) {
        //Garage garage = new Garage();
        /*Menu menu = new Menu("Главное меню");
        MyArray arr = new MyArray();

        menu.addCommand(new Menu.GenerateArrComand(arr));
        menu.addCommand(new Menu.InputArrComand(arr));
        menu.addCommand(new Menu.SortArrComand(arr));
        menu.addCommand(new Menu.PrintArrComand(arr));*/
        MyVehicles myVehicles = new MyVehicles();
        TransportCompany transportCompany = new TransportCompany("Список доступного транспорта");
        transportCompany.addVehicle(new TransportCompany.Car(myVehicles));
        transportCompany.addVehicle(new TransportCompany.Train(myVehicles));
        transportCompany.addVehicle(new TransportCompany.Ecspress(myVehicles));

        transportCompany.start();
    }
}