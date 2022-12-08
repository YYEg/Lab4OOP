public class About {
    private String message;

    public String aboutDetail(){
        this.message = "Я деталь";
        return message;
    }

    public String aboutUnit(){
        this.message = "Я устройство";
        return message;
    }

    public String aboutItem(){
        this.message = "Я изделие";
        return message;
    }

}
