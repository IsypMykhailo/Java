package MyThreads.MyWaitNotify;

public class Store {
    private int product=0;

    /**
     * ������� ������
     */
    public synchronized void get() {
        while (product<1) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("���������� ����� 1 �����");
        System.out.println("������� �� ������: " + product);
        notify();
    }

    /**
     * �������� ������ �� �����
     */
    public synchronized void put() {
        while (product>=3) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("������������� ������� 1 �����");
        System.out.println("������� �� ������: " + product);
        notify();
    }
}
