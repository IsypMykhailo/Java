package fileSerializable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;

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

    void xml() {
        XStream xstream = new XStream();
        XmlPerson s = new XmlPerson("Misha", 17, 183, false);

        System.out.println(xstream.toXML(s));
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
            xml();
            //jsonSerialize();
            //jsonDeserialize();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
