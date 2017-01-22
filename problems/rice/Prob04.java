package problems.rice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import problems.Input;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rootie
 */
public class Prob04 {

    public static void main(String[] args) throws FileNotFoundException {
        // get file obj
        Scanner scanner = new Scanner(new File(Input.JPATH + "Prob04.in.txt"));
        int testCaseAmt = Integer.parseInt(scanner.nextLine());
        for (int tCa = 0; tCa < testCaseAmt; tCa++) {
            int subTestCaseAmt = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < subTestCaseAmt; i++) {
                String line = scanner.nextLine();
                if (line.split(" ")[1].equals("C")) {
                    double f = (Double.parseDouble(line.split(" ")[0]) / (5.0 / 9.0)) + 32.0;
                    System.out.println(line + " = " + String.valueOf(Math.round(f * 10.0) / 10.0) + " F");
                } else {
                    double c = (5.0 / 9.0) * (Double.parseDouble(line.split(" ")[0]) - 32.0);
                    System.out.println(line + " = " + String.valueOf(Math.round(c * 10.0) / 10.0) + " C");
                }
            }
        }
        scanner.close();
    }
}
