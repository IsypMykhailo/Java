package task_3;

import lombok.Data;

@Data
public class Money {
    String Currency;
    int Cash;
    int Coins;

    public void print() {
        System.out.println("Your balance:");
        System.out.println(Cash+"."+Coins+" "+Currency);
    }
}
