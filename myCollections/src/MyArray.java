import entities.Contact;

public class MyArray implements Runnable{
    @Override
    public void run() {
        Contact val = new Contact("Valentin", "+380971234567");
        Contact svet = new Contact("Svetlana", "+380661234567");

        Contact[] myFriends = new Contact[2];
        myFriends[0] = val;
        myFriends[1] = svet;

        System.out.println("My Friends");
        for(int i = 0; i < myFriends.length; i++){
            System.out.println(myFriends[i]);
        }
    }
}
