package MyThreads.MySynchronized;

class CountThread implements Runnable {

    CommonResource res;

    CountThread(CommonResource res) {
        this.res = res;
    }

    public void run() {

        System.out.printf("Started: %s \n", Thread.currentThread().getName());

        synchronized (res) {

            System.out.printf("Work: %s \n", Thread.currentThread().getName());

            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}

