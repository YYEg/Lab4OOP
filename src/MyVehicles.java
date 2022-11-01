public class MyVehicles {
    private String message;

    public String carsSound(){
        this.message = "Вжвжвжвжвжжжж!!! Так звучат наши машины!";
        return message;
    }

    public String trainSound(){
        this.message = "Чучух-чучух!!! Так звучат наши поезда!";
        return message;
    }

    public String ecspressSound(){
        this.message = "**Но этот поезд электрический и он еще не работает**";
        return message;
    }

}
