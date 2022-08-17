package oop;

public class BaseClass {
    public BaseClass(int a){
        System.out.println("BaseClass Constructor");
    }

    public void IsVirtual(){
        System.out.println("BaseClass IsVirtual");
    }

    final void IsNotVirtual(){
        System.out.println("BaseClass IsVirtual");
    }
}
