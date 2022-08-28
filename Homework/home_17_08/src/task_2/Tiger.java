package task_2;

public class Tiger extends Animal {
    String Subspecies;
    String Color;
    public Tiger(String Name, int Age, String subspecies, String color) {
        super(Name, Age);
        Subspecies = subspecies;
        Color = color;
    }

    public void hunt() {
        System.out.println("Tiger is hunting");
    }
}
