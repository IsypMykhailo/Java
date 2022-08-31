package MyThreads.MyExchanger;

import java.util.concurrent.Exchanger;

public class WorkExchanger implements Runnable{
    @Override
    public void run() {
        Exchanger<String> ex = new Exchanger<String>();
        new Thread(new PutThread(ex)).start();
        new Thread(new GetThread(ex)).start();
    }
}
