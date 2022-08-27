package fileSerializable;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class StandartSerializable implements Runnable{

    void jsonSerializable () throws IOException {
        JsonPerson j = new JsonPerson("Misha",17,183,false);
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, j);
        String result = writer.toString();
        System.out.println(result);
    }

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
        try{
            jsonSerializable();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
