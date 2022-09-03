package task1;

import java.util.List;
import java.util.Scanner;

public class FileComparerView implements Runnable{
    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first file path: ");
        String firstPath = in.nextLine();
        System.out.print("Enter second file path: ");
        String secondPath = in.nextLine();
        FileComparer fc = new FileComparer();
        List<String> nonMatchingStrings = fc.compare(firstPath, secondPath);
        for(String line: nonMatchingStrings){
            System.out.println(line);
        }
    }
}
