import entities.Contact;

public class MyArray implements Runnable{
    @Override
    public void run() {
        try {
           simpleArray();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void simpleArray() throws Exception {
        Contact val = new Contact("Valentin", "+380971234567");
        Contact svet = new Contact("Svetlana", "+380661234567");

        Contact[] myFriends = new Contact[2];
        myFriends[0] = val;
        myFriends[1] = svet;

        System.out.println("My Friends");
        for (int i = 0; i < myFriends.length; i++) {
            System.out.println(myFriends[i]);
        }

        val.setName("Valentin");

        System.out.println("---------------");
        for (int i = 0; i < myFriends.length; i++) {
            System.out.println(myFriends[i]);
        }
    }
}
