/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.rice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import problems.Input;

/**
 *
 * @author rootie
 */
public class Prob03 {
    public static void main(String[] args) throws FileNotFoundException {
        // get file obj
        Scanner scanner = new Scanner(new File(Input.JPATH + "Prob03.in.txt"));
        int testCaseAmt = Integer.parseInt(scanner.nextLine());
        for (int tCa = 0; tCa < testCaseAmt; tCa++) {
            int amtOfYears = Integer.parseInt(scanner.nextLine());
            for (int aOy = 0; aOy < amtOfYears; aOy++) {
                int year = Integer.parseInt(scanner.nextLine());
                // determin if leap year
                if (year < 1582) {
                    System.out.println("No");
                } else if (year % 4 != 0) {
                    System.out.println("No");
                } else if (year % 100 != 0) {
                    System.out.println("Yes");
                } else if (year % 400 != 0) {
                    System.out.println("No");
                } else {
                    System.out.println("Yes");
                }
            }
        }
    }
}
