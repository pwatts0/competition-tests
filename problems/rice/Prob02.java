/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.rice;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import problems.Input;

/**
 *
 * @author rootie
 */
public class Prob02 {

    public static void main(String[] args) throws IOException {
        // get file obj
        Scanner scanner = new Scanner(new File(Input.JPATH + "Prob02.in.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            try {
                // try to convert string to int if converstion fails we know its not an int 
                // if it works and is less than 100 then is probably N <- code quest denotion of amount of input to come
                int n;
                if ((n = Integer.parseInt(line)) <= 100) {
                    doCalc(scanner, n);
                }
            } catch (NumberFormatException e) {
                System.out.println("i'v been bambozzled -> " + line);
                System.exit(-1);
            }
        }
    }

    private static void doCalc(Scanner scanner, int n) {
        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            try {
                // if it works and is less than 100 the judges r yankin my chain with another N denotion nice tryyyy -u-
                int nD;
                if ((nD = Integer.parseInt(line)) <= 100) {
                    doCalc(scanner, nD);
                    return;
                } else {
                    sum = sum.add(new BigInteger(line));
                }
            } catch (NumberFormatException e) {
                // if not in save as bigNumber
                sum = sum.add(new BigInteger(line));
            }
        }
        System.out.println(sum);
    }

}
