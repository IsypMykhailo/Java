package MyThreads.MySynchronized;

public class WorkSync implements Runnable{
    @Override
    public void run() {
        CommonResource commonResource = new CommonResource();
        for (int i = 1; i < 5; i++){

            System.out.printf("Create: %d \n", i);

            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Thread "+ i);
            t.start();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }

            System.out.println("Change \n");
            commonResource.x = 10;

            /*try{
                t.join();
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }*/
        }
    }
}
