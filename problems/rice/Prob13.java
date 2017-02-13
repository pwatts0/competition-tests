/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.rice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import problems.Input;
import static problems.rice.Prob12.addZero;

/**
 *
 * @author rootie
 */
public class Prob13 {

    private static ArrayList<String> blocks;

    public static void main(String[] args) throws FileNotFoundException {
        // get file obj 
        Scanner scanner = new Scanner(new File(Input.PATH + "Prob13.in.txt"));
        int testCaseAmt = Integer.parseInt(scanner.nextLine());
        for (int tCa = 0; tCa < testCaseAmt; tCa++) {
            blocks = new ArrayList<>();
            int subTestCaseAmt = Integer.parseInt(scanner.nextLine());
            for (int stca = 0; stca < subTestCaseAmt; stca++) {
                blocks.add(scanner.nextLine());
                System.out.println( "blocks " + blocks.get(stca));
            }
            // try every order of blocks
            System.out.println(factorial(4));
            for (int i = 0; i < factorial(blocks.size()); i++) {

            }
            String block_s[] = new String[blocks.size()];
            for (int i = 0; i < blocks.size(); i++) {
                block_s[i] = blocks.get(i);
            }
            System.out.println(block_s.length);
            rearangeBlockOrder(block_s, 0, block_s.length - 1);
            break;
        }
    }

    public static int outputs = 0;

    public static void rearangeBlockOrder(String blocks[], int lvl, int size) {
        if (lvl == size) {
            for (int i = 0; i < size + 1; i++) {
                System.out.print(blocks[i] + " ");
            }
            System.out.println("");
            outputs++;
        } else {
            for (int i = lvl; i <= size; i++) {
                String b = blocks[lvl];
                blocks[lvl] = blocks[i];
                blocks[i] = b;
                rearangeBlockOrder(blocks, lvl + 1, size);
                b = blocks[lvl];
                blocks[lvl] = blocks[i];
                blocks[i] = b;
            }
        }
        //System.out.println(outputs);
    }

    public static int factorial(int num) {
        int factorial = num;
        for (int i = num - 1; i > 0; i--) {
            factorial *= i;
        }
        return factorial;
    }

}
