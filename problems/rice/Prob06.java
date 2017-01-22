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
public class Prob06 {

    static class usableCharacter {

        char c;
        Point p;

        public usableCharacter(char c, Point p) {
            this.c = c;
            this.p = p;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        // get file obj
        Scanner scanner = new Scanner(new File(Input.JPATH + "Prob06.in.txt"));
        int testCaseAmt = Integer.parseInt(scanner.nextLine());
        for (int tCa = 0; tCa < testCaseAmt; tCa++) {
            // create crossword puzzle in mem
            String size = scanner.nextLine();
            int rows = Integer.parseInt(size.split(" ")[0]);
            int colums = Integer.parseInt(size.split(" ")[1]);
            char grid[][] = new char[rows][colums];
            // read in crossword puzzle to mem
            for (int row = 0; row < rows; row++) {
                String charArrayRow[] = scanner.nextLine().split(" ");
                for (int col = 0; col < colums; col++) {
                    grid[row][col] = charArrayRow[col].charAt(0);
                }
            }
            // read in words
            int amtWords = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < amtWords; i++) {
                // if word is in crossword puzzle this function will print it
                findWordInPuzzle(grid, scanner.nextLine(), 0, new ArrayList<>());
            }
        }
        scanner.close();
    }

    private static int findWordInPuzzle(char grid[][], String word, int posInWord, ArrayList<usableCharacter> useableCharactersBank) {
        if (posInWord == 0) {
            loop:
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == word.charAt(0)) {
                        if (word.length() == 1) {
                            // Yey were done here!
                            System.out.println(word);
                            break loop;
                        } else if (findWordInPuzzle(grid, word, 1, getBlob(grid, new Point(row, col))) == 1) {
                            break loop;
                        }
                    }
                }
            }
        } else {
            for (usableCharacter uC : useableCharactersBank) {
                if (uC.c == word.charAt(posInWord)) {
                    if (posInWord == word.length() - 1) {
                        System.out.println(word);
                        return 1;
                    }
                    if (findWordInPuzzle(grid, word, posInWord + 1, getBlob(grid, uC.p)) == 1) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    private static ArrayList<usableCharacter> getBlob(char grid[][], Point p) {
        ArrayList<usableCharacter> charactersBank = new ArrayList<>();
        charactersBank.add(new usableCharacter(getCharacter(grid, new Point(p.x - 1, p.y)), new Point(p.x - 1, p.y)));
        charactersBank.add(new usableCharacter(getCharacter(grid, new Point(p.x - 1, p.y + 1)), new Point(p.x - 1, p.y + 1)));
        charactersBank.add(new usableCharacter(getCharacter(grid, new Point(p.x, p.y + 1)), new Point(p.x, p.y + 1)));
        charactersBank.add(new usableCharacter(getCharacter(grid, new Point(p.x + 1, p.y + 1)), new Point(p.x + 1, p.y + 1)));
        charactersBank.add(new usableCharacter(getCharacter(grid, new Point(p.x + 1, p.y)), new Point(p.x + 1, p.y)));
        charactersBank.add(new usableCharacter(getCharacter(grid, new Point(p.x + 1, p.y - 1)), new Point(p.x + 1, p.y - 1)));
        charactersBank.add(new usableCharacter(getCharacter(grid, new Point(p.x, p.y - 1)), new Point(p.x, p.y - 1)));
        charactersBank.add(new usableCharacter(getCharacter(grid, new Point(p.x - 1, p.y - 1)), new Point(p.x - 1, p.y - 1)));
        return charactersBank;
    }

    private static char getCharacter(char grid[][], Point p) {
        try {
            return grid[p.x][p.y];
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            return ' ';
        }
    }
}
