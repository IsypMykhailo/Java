import MyThreads.MyMainThread;
import MyThreads.MySynchronized.WorkSync;
import MyThreads.MyWaitNotify.WorkWait;
import fileOperations.SimpleFile;
import fileSerializable.StandartSerializable;
import phoneBook.PhoneBookView;

public class Main {
    public static void main(String[] args) {
        WorkWait work = new WorkWait();
        work.run();

        System.out.println("\n\n -- Main finish \n -- \n\n");
    }
}