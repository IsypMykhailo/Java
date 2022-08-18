import entities.Book;
import entities.Contact;

import java.util.ArrayList;

public class MyArrayList implements Runnable{
    @Override
    public void run() {
        try{
            work();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void work() throws Exception{
        ArrayList<Contact> myPhoneBook = new ArrayList<>();

        Contact val = new Contact("Valentin", "+380971234567");
        Contact svet = new Contact("Svetlana", "+380661234567");

        myPhoneBook.add(val);
        myPhoneBook.add(svet);

        print(myPhoneBook);

        val.setName("Valek");
        svet.setName("Svetka");

        print(myPhoneBook);
        System.out.println();
    }

    private void print (ArrayList<Contact> myPhoneBook){
        System.out.println(myPhoneBook);
    }
}
