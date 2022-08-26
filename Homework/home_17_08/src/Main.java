import task_1.Builder;
import task_1.Human;
import task_1.Pilot;
import task_1.Sailor;

public class Main {
    public static void main(String[] args) {
        run_1();
    }

    public static void run_1(){
        System.out.println("----- Sailor -----");
        Sailor s = new Sailor();
        s.birth();
        s.shipCleaning();
        System.out.println("------------------");

        System.out.println("\n----- Builder -----");
        Builder b = new Builder();
        b.birth();
        b.build();
        System.out.println("-------------------");

        System.out.println("\n----- Pilot -----");
        Pilot p = new Pilot();
        p.birth();
        p.fly();
        System.out.println("-----------------");
    }
}