package task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestLine implements Runnable{

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String filePath = in.nextLine();
        String longestLine = findLongestLine(filePath);
        System.out.println("Length: " + longestLine.length() + "\n" + longestLine);
    }

    private String findLongestLine(String filePath){
        String longestLine = "";
        try {
            Scanner sc = new Scanner(new File(filePath));
            List<String> lines = new ArrayList<String>();
            while(sc.hasNextLine()){
                lines.add(sc.nextLine());
            }
            int m = lines.get(0).length();
            for(String line: lines){
                if(line.length() > m)
                    m = line.length();
            }
            for(String line: lines){
                if(line.length() == m)
                    longestLine = line;
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return longestLine;
    }
}
