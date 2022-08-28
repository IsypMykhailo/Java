package task_3;

import lombok.Data;

import static java.lang.Integer.parseInt;

@Data
public class Product extends Money{
    String Name;
    public void reducePrice(double amount) {
        try {
            int iPart = (int) amount;
            String numberD = String.valueOf(amount);
            numberD = numberD.substring ( numberD.indexOf ( "." ) );
            numberD = numberD.replace(".","");
            //System.out.println(numberD);
            Cash = Cash - iPart;
            Coins = Coins - parseInt(numberD);
            print();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
