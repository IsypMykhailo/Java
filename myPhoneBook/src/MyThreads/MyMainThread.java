package MyThreads;

public class MyMainThread implements Runnable{
    @Override
    public void run() {
        //thisThread();
        runOtherThread();
    }

    void runOtherThread(){
        MyFirstThread t1 = new MyFirstThread("жив");
        MyFirstThread t2 = new MyFirstThread("мертв");

        t1.start();
        t2.start();

        try{
            // √лавный поток будет ждать пока не завершитс€ t1
            t1.join(1000, 0);
            t1.interrupt();

            // √лавный поток будет ждать пока не завершитс€ t2
            t2.join(1000);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        //t1.run();
        ///t2.run();
    }

    void thisThread() {
        System.out.println("ѕопробую поспать");

        try {
            Thread.sleep(1000);
            int p = Thread.currentThread().getPriority();
            System.out.println(p);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("я поспал");
    }
}
