package problems.rice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
public class Prob05 {

    static class DataW {
        public double d;
        public int i;

        public DataW(double d, int i) {
            this.d = d;
            this.i = i;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        // get file obj
        Scanner scanner = new Scanner(new File(Input.JPATH + "Prob05.in.txt"));
        int testCaseAmt = Integer.parseInt(scanner.nextLine());
        for (int tCa = 0; tCa < testCaseAmt; tCa++) {
            ArrayList<DataW> dataP = new ArrayList<DataW>();
            String countryName = scanner.nextLine();
            int subTestCaseAmt = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < subTestCaseAmt; i++) {
                String data = scanner.nextLine();
                dataP.add(new DataW(Double.parseDouble(data.split(" ")[0]), Integer.parseInt(data.split(" ")[1])));
            }
            // sort in accending order
            for (int i = dataP.size(); i > 0; i--) {
                for (int j = 1; j < i; j++) {
                    if (dataP.get(j - 1).i > dataP.get(j).i) {
                        DataW temp = dataP.get(j);
                        dataP.remove(j);
                        dataP.add(j, dataP.get(j - 1));
                        dataP.remove(j - 1);
                        dataP.add(j - 1, temp);
                    }
                }
            }
            // output country data
            System.out.println(countryName + ":");
            for (DataW d : dataP) {
                String bar = "";
                d.d = Math.round(d.d / 1000.0) * 1000.0;
                for (int i = 0; i < d.d / 1000.0; i++) {
                    bar += "*";
                }
                System.out.println(d.i + " " + bar);
            }
        }
        scanner.close();
    }
}
