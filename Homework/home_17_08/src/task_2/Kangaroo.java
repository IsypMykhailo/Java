package task_2;

public class Kangaroo extends Animal {
    boolean HasChild;
    public Kangaroo(String Name, int Age, boolean hasChild) {
        super(Name, Age);
        HasChild = hasChild;
    }

    public void jump () {
        System.out.println("Kangaroo is jumping");
    }
}
