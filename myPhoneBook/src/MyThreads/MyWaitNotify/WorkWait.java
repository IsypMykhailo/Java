package MyThreads.MyWaitNotify;

public class WorkWait implements Runnable{
    @Override
    public void run() {
        Store store=new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
