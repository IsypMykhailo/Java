package phoneBook;

import java.io.IOException;
import java.util.Scanner;

public class PhoneBookView implements Runnable {

    PhoneBookModel model = new PhoneBookModel();

    Scanner in = new Scanner(System.in);

    /**
     * Добавление записи в книжку
     */
    private void add()
    {
        try{
            System.out.println("Create Contact");
            Contact c = new Contact();

            System.out.print("Name: ");
            c.setName(in.nextLine());

            if(model.searchByName(c.getName()) != null){
                throw new Exception("Name is Using");
            }

            System.out.print("Phone: ");
            c.setPhone(in.nextLine());

            if(model.searchByPhone(c.getPhone()) != null){
                throw new Exception("Phone is Using");
            }

            model.add(c);
        } catch (Exception ex) {
            Ex(ex);
        }
    }

    /**
     * Вывод на экран всей книжки
     */
    private void printAll(){
        for (Contact c:model) {
            System.out.println(c);
        }
        System.out.println("\n ----- ");
        model.printAll();
    }



    /**
     * ОБработка ошибок внутри класса
     * @param ex
     */
    private void Ex(Exception ex){
        System.out.println("\n\n!!! ----- Error ----- !!!");
        System.out.println(ex.getMessage());
        System.out.println("!!! ----- ----- ----- !!!\n\n");

    }


    @Override
    public void run() {
        char input = ' ';
        do {
            System.out.println("\n\n!!! ----- Menu ----- !!!");
            System.out.println("Select Operation: ");
            System.out.println("1 - Add Contact");
            System.out.println("p - Print All");
            System.out.println("--------");
            System.out.println("x - Exit");
            try {
                input = in.nextLine().charAt(0);

            } catch (Exception e) {
                Ex(e);
            }

            switch (input) {
                case '1':
                case 'a':
                    System.out.println("\n\n!!! ----- Create ----- !!!");
                    add(); break;
                case 'p':
                    System.out.println("\n\n!!! ----- All ----- !!!");
                    printAll(); break;

            }

        } while (input != 'x');

    }
}