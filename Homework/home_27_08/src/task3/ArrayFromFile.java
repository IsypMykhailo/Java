package task3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayFromFile implements Runnable{
    @Override
    public void run() {
        putToArray();
    }

    private void putToArray(){
        try{
            Scanner sc = new Scanner(new File("array.txt"));
            List<String> lines = new ArrayList<String>();
            while(sc.hasNextLine()){
                lines.add(sc.nextLine());
            }
            String[][] arrays = new String[lines.size()][];
            for(int i=0; i< arrays.length; i++){
                arrays[i] = lines.get(i).split(" ");
                for(int j=0; j<arrays[i].length;j++){
                    System.out.print(arrays[i][j] + " ");
                }
                System.out.println();
            }

            int maxLength = arrays[0].length;
            for(int i=0; i<arrays.length; i++){
                if(arrays[i].length > maxLength){
                    maxLength = arrays[i].length;
                }
            }

            int[][] intArrays = new int[arrays.length][maxLength];
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int i=0; i<arrays.length; i++){
                for (int j = 0; j < arrays[i].length; j++) {
                    intArrays[i][j] = Integer.parseInt(arrays[i][j]);
                    tmp.add(Integer.parseInt(arrays[i][j]));
                }
            }
            int[] overallArray = new int[tmp.size()];
            for(int i=0; i<overallArray.length; i++){
                overallArray[i] = tmp.get(i);
            }

            for(int i=0; i< arrays.length; i++){
                System.out.println("Max: " + getMax(overallArray) + " Min: " + getMin(overallArray) + " Sum: " + getSum(overallArray));
            }

            System.out.println("\n----- Overall -----");
            int[] cutOverall = cutArr(overallArray);
            System.out.println("Max: " + getMax(cutOverall) + " Min: " + getMin(cutOverall) + " Sum: " + getSum(cutOverall));
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private int getMax(int[] array){
        int max = array[0];
        for(int i=0; i<array.length; i++){
            if(array[i] > max)
                max = array[i];
        }
        return max;
    }

    private int getMin(int[] array){
        int min = array[0];
        for(int i=0; i < array.length; i++){
            if(array[i] < min)
                min = array[i];
        }
        return min;
    }

    private int getSum(int[] array){
        int sum = 0;
        for(int i=0; i< array.length; i++){
            sum += array[i];
        }
        return sum;
    }

    public static int[] cutArr(int[] array){
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
