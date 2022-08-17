package oop;

public class ChildrenClass
        extends BaseClass // Наследуются
        implements HDMI // Реализовываются
        ,Runnable
{
    @Override
    public void doHDMI(){

    }

    @Override
    public void run() {

    }

    public ChildrenClass(){
        super(2); // Вызов базового конструктора
        System.out.println("BaseClass Constructor");
    }

    public void IsVirtual(){
        super.IsVirtual();
        System.out.println("ChildrenClass IsVirtual");
    }
}
