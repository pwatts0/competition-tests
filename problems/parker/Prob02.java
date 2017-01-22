/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prob02;
import java.io.IOException;
import java.util.*;
import java.lang.*;
import java.io.File;
import java.math.BigInteger;

     
public class Prob02 {

    public static void main(String... args) throws IOException {
     String problem = "Prob02.in.txt";
     String path = "C:\\Users\\pwatts\\New folder\\ExampleInputs\\" + problem;
     File file = new File(path);
     Scanner scanner = new Scanner(file);
     int x = 0;
     BigInteger sum = BigInteger.valueOf(0);
     while (scanner.hasNextBigInteger()){
         x ++;
         if (x < 3){
             scanner.nextLine();
         }
         if (x >= 3){
             BigInteger bill = scanner.nextBigInteger();
             sum = sum.add(bill);
            }
        
 }     
        System.out.println(sum);
    }  
}
