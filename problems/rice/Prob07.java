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

/**
 *
 * @author rootie
 */
public class Prob07 {

    static class Ship {

        public int x;
        public int y;
        public int speed;
        public String name;

        public Ship(String info) {
            this.name = info.substring(0, info.indexOf("_"));
            switch (info.substring(info.indexOf("_") + 1, info.indexOf(":"))) {
                case "A":
                    this.speed = 10;
                    break;
                case "B":
                    this.speed = 20;
                    break;
                case "C":
                    this.speed = 30;
                    break;
            }
            this.x = Integer.parseInt(info.split(":")[1].split(",")[0]);
            this.y = Integer.parseInt(info.split(":")[1].split(",")[1]);
        }

        public void stepShip() {
            x -= speed;
        }

        public void destroyShip() {
            System.out.println("Destroyed Ship: " + name + " xLoc: " + x);
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        // get file obj
        Scanner scanner = new Scanner(new File(Input.JPATH + "Prob07.in.txt"));
        int testCaseAmt = Integer.parseInt(scanner.nextLine());
        for (int tCa = 0; tCa < testCaseAmt; tCa++) {
            ArrayList<Ship> ships = new ArrayList<>();
            // load ships from file
            int subTestCaseAmt = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < subTestCaseAmt; i++) {
                String data = scanner.nextLine();
                ships.add(new Ship(data));
            }
            // run sim with ships
            while (ships.size() > 1) {
                Ship target = new Ship("BOGUSSHIP_A:-1,-1");
                target.x = Integer.MAX_VALUE;
                // find closest ship
                for (Ship ship : ships) {
                    if (ship.x < target.x) {
                        target = ship;
                    } else if (ship.x == target.x) {
                        target = (ship.y > target.y) ? ship : target;
                    }
                }
                // destroy ship
                target.destroyShip();
                ships.remove(target);
                // step all ships
                for (Ship ship : ships) {
                    ship.stepShip();
                }
            }
            ships.get(0).destroyShip();
        }
        scanner.close();
    }

}
