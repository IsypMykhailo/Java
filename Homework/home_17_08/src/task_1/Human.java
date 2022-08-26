package task_1;

import lombok.Data;

import java.util.Scanner;

@Data
public class Human {
    String Name;
    int Age;
    String Gender;
    Scanner in = new Scanner(System.in);

    public Human() {

    }

    public void birth() {
        System.out.println("Я родился!");

        System.out.print("Дай мне имя: ");
        Name = in.next();

        System.out.print("Сколько мне лет: ");
        Age = in.nextInt();

        System.out.print("Кто я по гендеру: ");
        Gender = in.next();

        System.out.println("Меня зовут " + Name + ". Мне " + Age + " лет. Я " + Gender);
    }
}
