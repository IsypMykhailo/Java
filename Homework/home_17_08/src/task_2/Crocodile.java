package task_2;

public class Crocodile extends Animal {
    double Length;
    public Crocodile(String Name, int Age, double length) {
        super(Name, Age);
        Length = length;
    }

    public void bite() {
        System.out.println("Crocodile bites you");
    }
}
