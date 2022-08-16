package work;

import exceptions.DivException;

public class MyFirstWork {

    public void DoCalc(){
        try{
            int a = 10;
            System.out.println(a / 0);
        } catch (Exception ex){
            // Обработка исключения внутри метода
            System.out.println(ex.getMessage());
        }
    }

    public void DoMyCalc() throws DivException {
        int a = 10;
        int b = 0;
        if(b == 0) throw new DivException(" MyEx / 0"); // Обработка исключения снаружи
        System.out.println(a / b);
    }

    public void DoAnyCalc(){
        int a = 10;
        System.out.println(a / 0);
    }
}
