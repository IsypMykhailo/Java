package task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileComparer {
    public List<String> compare(String firstPath, String secondPath) {
        List<String> nonMatchingStrings = new ArrayList<String>();

        try {
            Scanner sc1 = new Scanner(new File(firstPath));
            List<String> lines1 = new ArrayList<String>();
            while(sc1.hasNextLine()){
                lines1.add(sc1.nextLine());
            }

            Scanner sc2 = new Scanner(new File(secondPath));
            List<String> lines2 = new ArrayList<String>();
            while(sc2.hasNextLine()){
                lines2.add(sc2.nextLine());
            }

            nonMatchingStrings = getDiffrent(lines1, lines2);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return nonMatchingStrings;
    }

    private static List<String> getDiffrent(List<String> list1,
                                            List<String> list2) {
        long st = System.nanoTime();
        Map<String, Integer> map = new HashMap<String, Integer>(list1.size()
                + list2.size());
        List<String> diff = new ArrayList<String>();
        for (String string : list1) {
            map.put(string, 1);
        }
        for (String string : list2) {
            Integer cc = map.get(string);
            if (cc != null)
            {
                map.put(string, ++cc);
                continue;
            }
            map.put(string, 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            if (entry.getValue() == 1)
            {
                diff.add(entry.getKey());
            }
        }
        return diff;

    }
}
