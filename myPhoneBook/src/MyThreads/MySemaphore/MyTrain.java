package MyThreads.MySemaphore;

import java.util.concurrent.Semaphore;

public class MyTrain implements Runnable{
    Semaphore sem;

    public MyTrain(Semaphore sem){
        this.sem = sem;
    }

    @Override
    public void run() {
        try{
            System.out.printf(" ����� ������ � �������� %s \n", Thread.currentThread().getName());
            sem.acquire();
            System.out.printf("++ ����� ������� ���������� ����� %s \n", Thread.currentThread().getName());
            move();
            System.out.printf("-- ����� ������� %s \n", Thread.currentThread().getName());
            sem.release();
        } catch (InterruptedException ex){
            //throw new RuntimeException();
        }
    }

    public void move(){
        for (int i = 1; i < 5; i++) {
            //System.out.printf(" ������ ����� %s \n", Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }
    }
}
