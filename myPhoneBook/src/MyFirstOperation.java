
interface OperSum {
    int sum (int x, int y);
}

public class MyFirstOperation implements Runnable{
    private void SimpleLambda(){
        OperSum cp;
        cp = (x,y) -> x + y;
        System.out.println(cp.sum(10,5));
    }

    @Override
    public void run() {
        SimpleLambda();
    }
}
