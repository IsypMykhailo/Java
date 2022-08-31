import MyThreads.MyExchanger.WorkExchanger;
import MyThreads.MyMainThread;
import MyThreads.MySemaphore.MySemaphoreWork;
import MyThreads.MySynchronized.WorkSync;
import MyThreads.MyWaitNotify.WorkWait;
import fileOperations.SimpleFile;
import fileSerializable.StandartSerializable;
import phoneBook.PhoneBookView;

public class Main {
    public static void main(String[] args) {
        WorkExchanger work = new WorkExchanger();
        work.run();

        System.out.println("\n\n -- Main finish \n -- \n\n");
    }
}