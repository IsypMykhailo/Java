import java.util.Random;
import java.util.Scanner;

public class Array<E> {
    private Object[] arr;
    Scanner in = new Scanner(System.in);
    public Array(int length) {
        arr = new Object[length];
    }

    public void fillFromKeyboard() {
        try {
            for (int i = 0; i < arr.length; i++) {
                System.out.print("Enter " + (i+1) + " element: ");
                E e = (E) in.next();
                arr[i] = e;
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void fillRandomInt(int min, int max) {
        try{
            Random rnd = new Random();
            for(int i = 0; i < arr.length; i++) {
                arr[i] = rnd.nextInt(min, max+1);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void print() {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int getMin() {
        int min = (int)arr[0];
        try{
            for(int i=0; i < arr.length; i++){
                if((int)arr[i] < min)
                    min = (int)arr[i];
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return min;
    }

    public int getMax() {
        int max = (int)arr[0];
        try{
            for(int i=0; i<arr.length; i++){
                if((int)arr[i] > max)
                    max = (int)arr[i];
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return max;
    }

    public double avg() {
        double avg = 0;
        try{
            int sum = 0;
            for(int i = 0; i < arr.length; i++) {
                sum += (int)arr[i];
            }
            avg = (double)sum/arr.length;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return avg;
    }

    public void sortAscending() {
        try {
            for (int i = 0; i < arr.length; i++) {
                int min = (int) arr[i];
                int min_i = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if ((int) arr[j] < min) {
                        min = (int) arr[j];
                        min_i = j;
                    }
                }
                if (i != min_i) {
                    int tmp = (int) arr[i];
                    arr[i] = arr[min_i];
                    arr[min_i] = tmp;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sortDescending() {
        try{
            for (int i = 0; i < arr.length; i++) {
                int max = (int)arr[i];
                int max_i = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if ((int)arr[j] > max) {
                        max = (int)arr[j];
                        max_i = j;
                    }
                }
                if (i != max_i) {
                    int tmp = (int)arr[i];
                    arr[i] = arr[max_i];
                    arr[max_i] = tmp;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int searchElement(int el) {
        int j = 0;
        sortAscending();
        try{
            int first = 0;
            int last = arr.length - 1;
            while(first <= last){
                int middle = first + (last - first)/2;
                if((int)arr[middle] == el)
                    return (int) arr[middle];
                else if ((int)arr[middle] < el) {
                    first = middle + 1;
                } else {
                    last = middle - 1;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Number was not found!");
        return -1;
    }

    public int searchElementIndex(int el) {
        int j = 0;
        sortAscending();
        try{
            int first = 0;
            int last = arr.length - 1;
            while(first <= last){
                int middle = first + (last - first)/2;
                if((int)arr[middle] == el)
                    return middle;
                else if ((int)arr[middle] < el) {
                    first = middle + 1;
                } else {
                    last = middle - 1;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Number was not found!");
        return -1;
    }

    public void replaceElement(int source, int result) {
        try {
            if(searchElementIndex(source) != -1)
                arr[searchElementIndex(source)] = result;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
