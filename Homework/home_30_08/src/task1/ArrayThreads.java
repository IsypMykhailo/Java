package task1;

import java.util.Random;

public class ArrayThreads extends Thread{
    public ArrayThreads(String name) {
        super(name);
    }

    public int[] fill(int[] arr) {
        Random rnd = new Random();
        for(int i=0; i<arr.length; i++){
            arr[i] = rnd.nextInt();
        }
        return arr;
    }

    public int sum(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        return sum;
    }

    public int avg(int[] arr) {
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        return sum / arr.length;
    }
}
