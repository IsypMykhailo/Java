package fileSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StandartSerializable implements Runnable{

    void simpleSerializable () {
        StandartPerson m = new StandartPerson("Misha", 17, 183, false);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("standartSerializable.dat")))
        {
            oos.writeObject(m);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("standartSerializable.dat")))
        {
            StandartPerson p=(StandartPerson)ois.readObject();
            System.out.printf(p.toString());
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void run() {
        simpleSerializable();
    }
}
