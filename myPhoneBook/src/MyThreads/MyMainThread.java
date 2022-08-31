package MyThreads;

public class MyMainThread implements Runnable{
    @Override
    public void run() {
        //thisThread();
        runOtherThread();
    }

    void runOtherThread(){
        MyFirstThread t1 = new MyFirstThread("���");
        MyFirstThread t2 = new MyFirstThread("�����");

        t1.start();
        t2.start();

        try{
            // ������� ����� ����� ����� ���� �� ���������� t1
            t1.join(1000, 0);
            t1.interrupt();

            // ������� ����� ����� ����� ���� �� ���������� t2
            t2.join(1000);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        //t1.run();
        ///t2.run();
    }

    void thisThread() {
        System.out.println("�������� �������");

        try {
            Thread.sleep(1000);
            int p = Thread.currentThread().getPriority();
            System.out.println(p);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("� ������");
    }
}
