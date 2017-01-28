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
public class Prob10 {

    public static void main(String[] args) throws FileNotFoundException {
        // get file obj
        Scanner scanner = new Scanner(new File(Input.JPATH + "Prob10.in.txt"));
        String scoreLengo[] = {"love", "15", "30", "40"};
        int pl[] = new int[2];
        boolean deuce = false;
        while (scanner.hasNextLine()) {
            // do logic on game
            if (pl[0] + pl[1] == 0) {
                System.out.println("Game start");
            }
            pl[(Integer.parseInt(scanner.nextLine()) - 1)]++;
            if ((pl[0] > 3 || pl[1] > 3) || pl[0] == 3 && pl[1] == 3) {
                switch (Math.abs(pl[0] - pl[1])) {
                    case 0:
                        System.out.println("deuce");
                        deuce = true;
                        break;
                    case 1:
                        if (deuce) {
                            System.out.println((pl[0] > pl[1]) ? "Advantage Player 1" : "Advantage Player 2");
                        } else {
                            System.out.println((pl[0] > pl[1]) ? "Game Player 1" : "Game Player 2");
                            pl = new int[2];
                        }
                        break;
                    case 2:
                        System.out.println((pl[0] > pl[1]) ? "Game Player 1" : "Game Player 2");
                        deuce = false;
                        pl = new int[2];
                        break;
                    default:
                        System.out.println((pl[0] > pl[1]) ? "Game Player 1" : "Game Player 2");
                        pl = new int[2];
                        break;
                }
                continue;
            }
            System.out.println((pl[0] == pl[1]) ? scoreLengo[pl[0]] + "-all" : scoreLengo[pl[0]] + "-" + scoreLengo[pl[1]]);
        }
        scanner.close();
    }

}
