/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.rice;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import problems.Input;

/**
 *
 * @author rootie
 */
public class Prob09 {

    public static void main(String[] args) throws IOException {
        // get file obj
        Scanner scanner = new Scanner(new File(Input.JPATH + "Prob09.in.txt"));
        int testCaseAmt = Integer.parseInt(scanner.nextLine());
        for (int tCa = 0; tCa < testCaseAmt; tCa++) {
            int subTestCaseAmt = Integer.parseInt(scanner.nextLine());
            String asciiPic[] = new String[subTestCaseAmt];
            int largestElement = Integer.MIN_VALUE;
            for (int i = 0; i < subTestCaseAmt; i++) {
                asciiPic[i] = scanner.nextLine();
                largestElement = (asciiPic[i].length() > largestElement) ? asciiPic[i].length() : largestElement;
            }
            // read in what way to reflect
            switch (scanner.nextLine()) {
                case "X":
                    for (int i = asciiPic.length - 1; i > -1; i--) {
                        System.out.println(asciiPic[i]);
                    }
                    break;
                case "Y":
                    for (int i = 0; i < asciiPic.length; i++) {
                        String reflectedLine = "";
                        while (reflectedLine.length() + asciiPic[i].length() != largestElement) {
                            reflectedLine += " ";
                        }
                        for (int n = asciiPic[i].length() - 1; n > -1; n--) {
                            reflectedLine += asciiPic[i].charAt(n);
                        }
                        System.out.println(reflectedLine);
                    }
                    break;
                case "INVERSE":
                    int rowsDone = 0,
                     col = 0;
                    while (true) {
                        String reflectedLine = "";
                        for (int i = 0; i < asciiPic.length; i++) {
                            if (asciiPic[i].length() > col) {
                                reflectedLine += asciiPic[i].charAt(col);
                            } else if (!asciiPic[i].equals("NIL")) {
                                asciiPic[i] = "NIL";
                                reflectedLine += " ";
                                rowsDone++;
                            } else {
                                reflectedLine += " ";
                            }
                        }
                        if (rowsDone == asciiPic.length) {
                            break;
                        }
                        System.out.println(reflectedLine);
                        col++;
                    }
                    break;
            }
        } 
        scanner.close();
    }

}
