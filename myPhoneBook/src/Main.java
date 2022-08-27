import fileOperations.SimpleFile;
import fileSerializable.StandartSerializable;
import phoneBook.PhoneBookView;

public class Main {
    public static void main(String[] args) {
        try {
            StandartSerializable w = new StandartSerializable();
            w.run();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}