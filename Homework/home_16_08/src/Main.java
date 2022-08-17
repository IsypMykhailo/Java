import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int num;

    public static void main(String[] args) throws Exception {
        // printJobs();
        // calcPercent();
        // formNumber();
        // replaceNum();
        // month();
        // convertMeters();
        // oddRange();
    }

    public static void printJobs(){
        System.out.println("\"Your time is limited,\n\tso don't waste it\n\t\tliving someone else's life\"\n\t\t\tSteve Jobs");
    }

    public static void calcPercent(){
        try {
            int a;
            int b;

            Scanner in = new Scanner(System.in);

            System.out.println("Enter number: ");
            a = in.nextInt();

            System.out.println("Enter percent: ");
            b = in.nextInt();

            System.out.println(a*b/100);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void formNumber(){
        try {
            int a, b, c;
            Scanner in = new Scanner(System.in);
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

    public static void replaceNum(){
        try {
            int num;
            Scanner in = new Scanner(System.in);
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

    public static void month(){
        try{
            int num;
            Scanner in = new Scanner(System.in);
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

    public static void convertMeters(){
        try {
            float meter;
            Scanner in = new Scanner(System.in);
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

    public static void oddRange(){
        try{
            int a, b;
            Scanner in = new Scanner(System.in);

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
}