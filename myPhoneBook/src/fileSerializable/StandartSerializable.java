package fileSerializable;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class StandartSerializable implements Runnable{

    void jsonSerialize () throws IOException {
        JsonPerson j = new JsonPerson("Misha",17,183,false);
        //StringWriter writer = new StringWriter();
        File f = new File("jsonSerializable.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(f, j);
        //String result = writer.toString();
        //System.out.println(result);
    }

    void jsonDeserialize () throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File f = new File("jsonSerializable.json");
        JsonPerson j = mapper.readValue(f,JsonPerson.class);
        System.out.println(j.toString());
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
            jsonSerialize();
            jsonDeserialize();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
