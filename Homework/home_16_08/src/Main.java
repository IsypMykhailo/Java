import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int num;

    private static Scanner in = new Scanner(System.in);

    private static Random rnd = new Random();

    public static void main(String[] args) throws Exception {
        // printJobs();
        // calcPercent();
        // formNumber();
        // replaceNum();
        // month();
        // convertMeters();
        // oddRange();
        // multiplicationTable();
        // arrayStats();
        // arrOperations();
        // drawSymbolLine();
        // sortArr();
    }

    private static void printJobs(){
        System.out.println("\"Your time is limited,\n\tso don't waste it\n\t\tliving someone else's life\"\n\t\t\tSteve Jobs");
    }

    private static void calcPercent(){
        try {
            double a;
            double b;

            //Scanner in = new Scanner(System.in);

            System.out.println("Enter number: ");
            a = in.nextDouble();

            System.out.println("Enter percent: ");
            b = in.nextDouble();

            System.out.println(a*b/100);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void formNumber(){
        try {
            int a, b, c;
            //Scanner in = new Scanner(System.in);
            System.out.print("Enter first num: ");
            a = in.nextInt();

            System.out.print("Enter second num: ");
            b = in.nextInt();

            System.out.print("Enter third num: ");
            c = in.nextInt();

            int num = a * 100 + b * 10 + c;

            System.out.println(num);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void replaceNum(){
        try {
            int num;
            //Scanner in = new Scanner(System.in);
            System.out.print("Enter a six-digit number: ");
            num = in.nextInt();

            if (num <= 999999 && num >= 100000) {
                int firstNum = num/100000;
                int secondNum = num%100000 / 10000;
                int fifthNum = num%100 / 10;
                int lastNum = num%10;
                int nonChangeable = num%10000 / 100;

                int result = lastNum*100000 + fifthNum*10000 + nonChangeable*100 + secondNum*10 + firstNum;

                System.out.println(result);
            } else {
                System.out.println("Invalid number");
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void month(){
        try{
            int num;
            //Scanner in = new Scanner(System.in);
            System.out.print("Enter the number of the month: ");
            num = in.nextInt();
            if(num == 1 || num == 2 || num == 12){
                System.out.println("Winter");
            } else if (num >= 3 && num <= 5) {
                System.out.println("Spring");
            } else if (num >= 6 && num <= 8) {
                System.out.println("Summer");
            } else if (num >= 9 && num <= 11) {
                System.out.println("Autumn");
            } else {
                System.out.println("Invalid number");
            }
        } catch (Exception ex){
            System.out.println(num);
        }
    }

    private static void convertMeters(){
        try {
            float meter;
            //Scanner in = new Scanner(System.in);
            System.out.print("Enter length in meters: ");
            meter = in.nextFloat();
            String resultType;
            System.out.print("Enter what do you want to convert to (mile, inch, yard): ");
            resultType = in.next();
            if(resultType.equals("mile") || resultType.equals("Mile")){
                System.out.println(meter/1609);
            } else if (resultType.equals("inch") || resultType.equals("Inch")) {
                System.out.println(meter*39.37);
            } else if (resultType.equals("yard") || resultType.equals("Yard")) {
                System.out.println(meter*1.094);
            } else {
                System.out.println("Invalid type");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void oddRange(){
        try{
            int a, b;
            //Scanner in = new Scanner(System.in);

            System.out.print("Enter lower bound: ");
            a = in.nextInt();

            System.out.print("Enter higher bound: ");
            b = in.nextInt();

            ArrayList<Integer> result = new ArrayList<Integer>();
            if(a==b){
                result.add(a);
                if(a % 2 != 0)
                    System.out.println(result);
                else
                    System.out.println("No odds found");
            } else if (a<b) {
                do{
                    if(a % 2 != 0)
                        result.add(a);
                    a++;
                } while(a<=b);
                System.out.println(result);
            } else if (b<a) {
                do{
                    if(b % 2 != 0)
                        result.add(b);
                    b++;
                } while(b<=a);
                System.out.println(result);
            } else {
                System.out.println("Unknown number");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void multiplicationTable(){
        try{
            int a, b;
            System.out.print("Enter first number: ");
            a = in.nextInt();
            System.out.print("Enter second number: ");
            b = in.nextInt();
            for(int i = a; i <= b; i++) {
                for (int j = 1; j <= 10; j++) {
                    System.out.print(i + " * " + j + " = " + i * j + " ");
                }
                System.out.println("");
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void arrayStats(){
        try {
            int[] arr = new int[100];
            int positive = 0;
            int negative = 0;
            int zeros = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rnd.nextInt();
                if (arr[i] < 0) {
                    negative++;
                } else if (arr[i] == 0) {
                    zeros++;
                } else if (arr[i] > 0) {
                    positive++;
                }
            }
            System.out.println("Min: " + getMin(arr));
            System.out.println("Max: " + getMax(arr));
            System.out.println("Negative nums: " + negative);
            System.out.println("Positive nums: " + positive);
            System.out.println("Zero nums: " + zeros);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static int getMax(int[] array){
        int max = array[0];
        for(int i=0; i<array.length; i++){
            if(array[i] > max)
                max = array[i];
        }
        return max;
    }

    public static int getMin(int[] array){
        int min = array[0];
        for(int i=0; i < array.length; i++){
            if(array[i] < min)
                min = array[i];
        }
        return min;
    }

    private static void arrOperations(){
        try {
            int[] arr = new int[100];
            int[] even = new int[100];
            int[] odd = new int[100];
            int[] positive = new int[100];
            int[] negative = new int[100];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rnd.nextInt();
                if (arr[i] % 2 == 0) {
                    even[i] = arr[i];
                } else if (arr[i] % 2 != 0) {
                    odd[i] = arr[i];
                }

                if (arr[i] < 0) {
                    negative[i] = arr[i];
                } else if (arr[i] > 0) {
                    positive[i] = arr[i];
                }
            }

            even = cutArr(even);
            System.out.println("----- Even elements -----");
            for (int i = 0; i < even.length; i++) {
                System.out.println(even[i]);
            }
            System.out.println("-------------------------");

            odd = cutArr(odd);
            System.out.println("----- Odd elements -----");
            for (int i = 0; i < odd.length; i++) {
                System.out.println(odd[i]);
            }
            System.out.println("------------------------");

            positive = cutArr(positive);
            System.out.println("----- Positive elements -----");
            for (int i = 0; i < positive.length; i++) {
                System.out.println(positive[i]);
            }
            System.out.println("-----------------------------");

            negative = cutArr(negative);
            System.out.println("----- Negative elements -----");
            for (int i = 0; i < negative.length; i++) {
                System.out.println(negative[i]);
            }
            System.out.println("-----------------------------");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
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

    private static void drawSymbolLine(){
        try {
            char symbol;
            int length;
            String direction;

            System.out.print("Enter symbol: ");
            symbol = in.nextLine().charAt(0);

            System.out.print("Enter length: ");
            length = in.nextInt();
            if (length <= 0) {
                throw new Exception("Invalid length");
            }

            System.out.print("Enter direction: ");
            direction = in.next();
            if(direction.equals("vertical")){
                char[] arr = new char[length];
                for(int i = 0; i < arr.length; i++){
                    arr[i] = symbol;
                    System.out.println(arr[i]);
                }
            } else if (direction.equals("horizontal")) {
                char[] arr = new char[length];
                for(int i = 0; i < arr.length; i++){
                    arr[i] = symbol;
                    System.out.print(arr[i]);
                }
            } else {
                throw new Exception("Invalid direction");
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void sortArr(){
        try {
            int[] arr = {5, 3, 13, 9, 35, 2, 19};
            String mode;
            System.out.print("How do you want the array to be sorted: ");
            mode = in.next();
            switch (mode) {
                case "ascending":
                    for (int i = 0; i < arr.length; i++) {
                        int min = arr[i];
                        int min_i = i;
                        for (int j = i + 1; j < arr.length; j++) {
                            if (arr[j] < min) {
                                min = arr[j];
                                min_i = j;
                            }
                        }
                        if (i != min_i) {
                            int tmp = arr[i];
                            arr[i] = arr[min_i];
                            arr[min_i] = tmp;
                        }
                    }
                    break;
                case "descending":
                    for (int i = 0; i < arr.length; i++) {
                        int max = arr[i];
                        int max_i = i;
                        for (int j = i + 1; j < arr.length; j++) {
                            if (arr[j] > max) {
                                max = arr[j];
                                max_i = j;
                            }
                        }
                        if (i != max_i) {
                            int tmp = arr[i];
                            arr[i] = arr[max_i];
                            arr[max_i] = tmp;
                        }
                    }
                    break;
                default:
                    throw new Exception("Invalid mode");
            }

            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}