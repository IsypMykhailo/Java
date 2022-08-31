package MyThreads.MyExchanger;

import java.util.concurrent.Exchanger;

public class PutThread implements Runnable {
    Exchanger<String> exchanger;
    String message;

    PutThread(Exchanger<String> ex){

        this.exchanger=ex;
        message = "Put Thread!";
    }
    @Override
    public void run(){

        try{
            message=exchanger.exchange(message);
            System.out.println("PutThread has received: " + message);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}
