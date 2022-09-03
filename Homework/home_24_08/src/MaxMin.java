import java.util.function.Function;

interface MaxOperation<T> {
    T max(T[] arr);
}

interface MinOperation<T> {
    T min(T[] arr);
}

public class MaxMin implements Runnable{
    @Override
    public void run() {
        runInt();
        runDouble();
        runFloat();
        runLong();
    }

    private void runInt(){
        MaxOperation<Integer> intMaxOp;
        intMaxOp = (arr) -> {
            int max = arr[0];
            for(int i=0; i<arr.length; i++){
                if(arr[i] > max)
                    max = arr[i];
            }
            return max;
        };
        MinOperation<Integer> intMinOp;
        intMinOp = (arr) -> {
            int min = arr[0];
            for(int i = 0; i < arr.length; i++){
                if(arr[i] < min)
                    min = arr[i];
            }
            return min;
        };
        Integer[] arrInt = {5,323,432523,5423};
        System.out.println("Int operations: max: " + intMaxOp.max(arrInt) + " min: " + intMinOp.min(arrInt));
    }

    private void runDouble(){
        MaxOperation<Double> doubleMaxOp;
        doubleMaxOp = (arr) -> {
            double max = arr[0];
            for(int i=0; i<arr.length; i++){
                if(arr[i] > max)
                    max = arr[i];
            }
            return max;
        };
        MinOperation<Double> doubleMinOp;
        doubleMinOp = (arr) -> {
            double min = arr[0];
            for(int i = 0; i < arr.length; i++){
                if(arr[i] < min)
                    min = arr[i];
            }
            return min;
        };
        Double[] arrDouble = {0.5, 0.34232, 12342.4342, 0.2312};
        System.out.println("Int operations: max: " + doubleMaxOp.max(arrDouble) + " min: " + doubleMinOp.min(arrDouble));
    }

    private void runFloat(){
        MaxOperation<Float> floatMaxOp;
        floatMaxOp = (arr) -> {
            float max = arr[0];
            for(int i=0; i<arr.length; i++){
                if(arr[i] > max)
                    max = arr[i];
            }
            return max;
        };
        MinOperation<Float> floatMinOp;
        floatMinOp = (arr) -> {
            float min = arr[0];
            for(int i = 0; i < arr.length; i++){
                if(arr[i] < min)
                    min = arr[i];
            }
            return min;
        };
        Float[] arrFloat = {0.5f,0.323f,0.432523f,0.5423f};
        System.out.println("Int operations: max: " + floatMaxOp.max(arrFloat) + " min: " + floatMinOp.min(arrFloat));
    }

    private void runLong(){
        MaxOperation<Long> longMaxOp;
        longMaxOp = (arr) -> {
            long max = arr[0];
            for(int i=0; i<arr.length; i++){
                if(arr[i] > max)
                    max = arr[i];
            }
            return max;
        };
        MinOperation<Long> longMinOp;
        longMinOp = (arr) -> {
            long min = arr[0];
            for(int i = 0; i < arr.length; i++){
                if(arr[i] < min)
                    min = arr[i];
            }
            return min;
        };
        Long[] arrLong = {5424234242L, 32355435425L, 432523325345325L, 54235453532532L};
        System.out.println("Int operations: max: " + longMaxOp.max(arrLong) + " min: " + longMinOp.min(arrLong));
    }
}
