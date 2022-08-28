import task_1.Builder;
import task_1.Pilot;
import task_1.Sailor;
import task_2.Crocodile;
import task_2.Kangaroo;
import task_2.Tiger;
import task_3.Product;

public class Main {
    public static void main(String[] args) {
        //run_1();
        //run_2();
        //run_3();
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
    public static void run_2(){
        System.out.println("----- Tiger -----");
        Tiger s = new Tiger("tiger", 12, "amur", "white");
        s.eat();
        s.play();
        s.sleep();
        s.hunt();
        System.out.println("-----------------");

        System.out.println("\n----- Kangaroo -----");
        Kangaroo b = new Kangaroo("kangaroo", 10, true);
        b.eat();
        b.play();
        b.sleep();
        b.jump();
        System.out.println("----------------------");

        System.out.println("\n----- Crocodile -----");
        Crocodile p = new Crocodile("crocodile", 8, 1.60);
        p.eat();
        p.play();
        p.sleep();
        p.bite();
        System.out.println("-----------------");
    }
    public static void run_3() {
        Product iPhone = new Product();
        iPhone.setCurrency("USD");
        iPhone.setCash(1199);
        iPhone.setCoins(99);
        iPhone.print();
        iPhone.reducePrice(10.28);
    }
}