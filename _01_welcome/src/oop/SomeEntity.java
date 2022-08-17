package oop;

public record SomeEntity(String name, int age) {
    public void doSome(){
        // this.name = "Kolya"; // В этом типе нельзя изменять данные назначеные в момент создания Record
        System.out.println(this.name);
    }
}
