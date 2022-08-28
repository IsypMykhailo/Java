package task_2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Animal {
    String Name;
    int Age;

    public void eat () {
        System.out.println("I'm eating");
    }

    public void play () {
        System.out.println("I'm playing");
    }

    public void sleep () {
        System.out.println("I'm sleeping");
    }
}
