package MyThreads;

public class MyFirstThread extends Thread{
    public MyFirstThread(String name) {
        super(name);
    }

    public void run() {
        while(!isInterrupted()) {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(500);
                    System.out.println(i + " " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
                }
            } catch (InterruptedException ex) {
                System.out.println("Меня хотят прервать");
                //interrupt();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
