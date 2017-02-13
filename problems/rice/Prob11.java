/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.rice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import problems.Input;

/**
 *
 * @author rootie
 */
public class Prob11 {

    // soundex encoding 
    private static String sEnc[] = {"bfpv", "cgjkqsxz", "dt", "l", "mn", "r", "wh", "aeiouy"};

    // place to store names
    private static ArrayList<String> names;

    public static void main(String[] args) throws FileNotFoundException {
        // get file obj 
        Scanner scanner = new Scanner(new File(Input.JPATH + "Prob11.in.txt"));
        int testCaseAmt = Integer.parseInt(scanner.nextLine());
        for (int tCa = 0; tCa < testCaseAmt; tCa++) {
            names = new ArrayList<>();
            System.out.println("OUTPUT");
            int subTestCaseAmt = Integer.parseInt(scanner.nextLine());
            for (int stca = 0; stca < subTestCaseAmt; stca++) {
                // read in name from file
                String name = scanner.nextLine();
                // do step one
                name = stepOne(name.toLowerCase(), 0);
                // do step two
                String vh = sEnc[6] + sEnc[7];
                for (int i = 0; i < vh.length(); i++) {
                    name = name.charAt(0) + name.substring(1).replaceAll(Character.toString(vh.charAt(i)), "");
                }
                // do step 3 and 4 then add to names list
                names.add(doLastTwoSteps(name));
            }
            // sort alpabetacly
            Collections.sort(names);
            names.add("END");
            outputNames();
        }
        scanner.close();
    }

    public static void outputNames() {
        for (int i = 0; i < names.size() - 1; i++) {
            int amt = 1;
            while (names.get(i).equals(names.get(i + amt))) {
                amt++;
            }
            i += amt - 1;
            System.out.println(names.get(i) + " " + amt);
        }
    }

    public static String stepOne(String name, int startP) {
        while (getGroupNum(name.charAt(startP)) != 7 && getGroupNum(name.charAt(startP)) == getGroupNum(name.charAt(startP + 1)) || getGroupNum(name.charAt(startP + 1)) == 6) {
            if (startP + 2 >= name.length()) {
                name = name.substring(0, startP + 1);
                break;
            } else {
                name = name.substring(0, startP + 1) + name.substring(startP + 2);
            }
        }
        startP++;
        if (startP >= name.length() - 1) {
            return name;
        } else {
            return stepOne(name, startP);
        }
    }

    public static String doLastTwoSteps(String name) {
        String formated = name.substring(0, 1).toUpperCase();
        for (int i = 1; i < name.length(); i++) {
            formated += getGroupNum(name.charAt(i)) + 1;
            if (formated.length() > 3) {
                return formated;
            }
        }
        return (formated + "000").substring(0, 4);
    }

    public static int getGroupNum(char c) {
        for (int i = 0; i < sEnc.length; i++) {
            for (int i2 = 0; i2 < sEnc[i].length(); i2++) {
                if (c == sEnc[i].charAt(i2)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
