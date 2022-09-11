package task4;

import java.io.FileWriter;
import java.util.Scanner;

public class PutToFile implements Runnable{
    @Override
    public void run() {
        put();
    }

    private void put() {
        int[] arr = new int[10];
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = in.nextLine();
        for(int i=0; i<arr.length; i++){
            System.out.println("Enter "+(i+1)+" number: ");
            arr[i] = Integer.parseInt(in.nextLine());
        }
        try (FileWriter writer = new FileWriter(filePath, false)) {
            int[] even = new int[arr.length];
            int[] odd = new int[arr.length];
            for(int i=0; i<arr.length; i++){
                writer.write(String.valueOf(arr[i])+" ");
                if(arr[i]%2 == 0){
                    even[i] = arr[i];
                } else {
                    odd[i] = arr[i];
                }
            }
            even = cutArr(even);
            odd = cutArr(odd);
            for (int i = 0; i < arr.length / 2; i++) {
                int tmp = arr[i];
                arr[i] = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = tmp;
            }
            writer.append("\n");
            for(int i=0; i<even.length; i++){
                writer.write(String.valueOf(even[i]) + " ");
            }
            writer.append("\n");
            for(int i=0; i<odd.length; i++){
                writer.write(String.valueOf(odd[i])+" ");
            }
            writer.append("\n");
            for(int i=0; i<arr.length; i++){
                writer.write(String.valueOf(arr[i])+" ");
            }
            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static int[] cutArr(int[] array){
        int j = 0;
        for( int i=0;  i<array.length;  i++ )
        {
            if (array[i] != 0)
                array[j++] = array[i];
        }
        int [] newArray = new int[j];
        System.arraycopy( array, 0, newArray, 0, j );
        return newArray;
    }
}
