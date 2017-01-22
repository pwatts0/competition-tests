package problems.rice;

import java.util.*;
import java.io.File;
import java.io.IOException;
import problems.Input;

public class Prob01 {

    public static void main(String... aArgs) throws IOException {
        // get file obj
        Scanner scanner = new Scanner(new File(Input.JPATH + "Prob01.in.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            try {
                // try to convert string to int if converstion fails we know its not an int
                Integer.parseInt(line);
            } catch (NumberFormatException e) {
                // if not number print monogram
                System.out.println((line.split(" ")[0]).toUpperCase().substring(0, 1) + (line.split(" ")[2]).toUpperCase().substring(0, 1) + (line.split(" ")[1]).toUpperCase().substring(0, 1));
            }
        }
        scanner.close();
    }
}
