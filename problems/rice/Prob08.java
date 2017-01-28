/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.rice;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import problems.Input;

/**
 *
 * @author rootie
 */
public class Prob08 {

    public static void main(String[] args) throws FileNotFoundException {
        // get file obj
        Scanner scanner = new Scanner(new File(Input.JPATH + "Prob08.in.txt"));
        int testCaseAmt = Integer.parseInt(scanner.nextLine());
        for (int tCa = 0; tCa < testCaseAmt; tCa++) {
            int subTestCaseAmt = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < subTestCaseAmt; i++) {
                String name = scanner.nextLine();
                String aircraft = scanner.nextLine();
                String points[] = {scanner.nextLine(), scanner.nextLine()};
                for (int i2 = 0; i2 < 2; i2++) {
                    Point aircraftP = new Point(Integer.parseInt(aircraft.split(",")[0]), Integer.parseInt(aircraft.split(",")[1]));
                    Point point = new Point(Integer.parseInt(points[i2].split(",")[0]), Integer.parseInt(points[i2].split(",")[1]));
                    if (checkSlope(aircraftP, point) == -1) {
                        System.out.println(name + ", Abort Landing!");
                        break;
                    } else {
                        if (i2 == 1) {
                            System.out.println(name + ", Clear To Land!");
                        }
                    }
                }
            }
        }
        scanner.close();
    }
    
    private static int checkSlope(Point p1, Point p2) {
        double slope = ((double)(p2.y - p1.y)) / ((double)(p2.x - p1.x));
        return (slope <= -.8 && slope >= -1.6)? 0 : -1;
    }

}
