interface FractionOperations {
    double sum(double a, double b);
    double difference(double a, double b);
    double product(double a, double b);
    double quotient(double a, double b);
}

public class Fraction implements Runnable{
    @Override
    public void run() {
        FractionOperations fp;
        fp = createFractionOperationsObject(
                (a,b) -> {return a+b;},
                (a,b) -> {return a-b;},
                (a,b) -> {return a*b;},
                (a,b) -> {return a/b;}
        );
        System.out.println(fp.sum(0.5, 105.78));
        System.out.println(fp.difference(0.5, 105.78));
        System.out.println(fp.product(0.5, 105.78));
        System.out.println(fp.quotient(0.5, 105.78));
    }

    public FractionOperations createFractionOperationsObject (
            Function2<Double, Double, Double> sumAction,
            Function2<Double, Double, Double> differenceAction,
            Function2<Double, Double, Double> productAction,
            Function2<Double, Double, Double> quotientAction
    ) {
        return new FractionOperations() {
            @Override
            public double sum(double a, double b) {
                return sumAction.apply(a, b);
            }

            @Override
            public double difference(double a, double b) {
                return differenceAction.apply(a, b);
            }

            @Override
            public double product(double a, double b) {
                return productAction.apply(a, b);
            }

            @Override
            public double quotient(double a, double b) {
                return quotientAction.apply(a, b);
            }
        };
    }
}
