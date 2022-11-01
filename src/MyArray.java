import java.util.Arrays;
import java.util.Random;

public class MyArray {
    private int[] data;

    public MyArray(){
        data = new int[5];
        generate();
    }

    public void generate() {
        Random random = new Random();
        for (int i = 0; i < data.length; i++){
            data[i] = random.nextInt(20);
        }
    }

    public  void setData(int[] newData){
        this.data = newData;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (int datum : data) {
            result.append(datum + " ");
        }
        return  result.toString();
    }

    public void sort(){
        Arrays.sort(this.data);
    }
}
