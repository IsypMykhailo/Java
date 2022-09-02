package Dictionary;

import lombok.Data;

import java.util.ArrayList;
import java.util.Scanner;

@Data
public class Word {
    String word;
    public ArrayList<String> translations;
    public int usages = 0;
    Scanner in = new Scanner(System.in);

    public Word() {
        translations = new ArrayList<String>();
    }


}
