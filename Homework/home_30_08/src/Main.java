import task1.ArrayThreads;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        ArrayThreads a1 = new ArrayThreads("Fill");
        ArrayThreads a2 = new ArrayThreads("Sum");
        ArrayThreads a3 = new ArrayThreads("Avg");

        int[] arr = new int[10];
        a1.start();
        a2.start();
        a3.start();
        try {
            a1.join();
            arr = a1.fill(arr);
            int sum = a2.sum(arr);
            int avg = a3.avg(arr);
            for(int i=0; i<arr.length; i++){
                System.out.println(arr[i]+" ");
            }
            System.out.println("Sum: " + sum + " Avg: " + avg);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}