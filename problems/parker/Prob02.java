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
     BigInteger sum = new BigInteger("0");
     int cases = 0;
     BigInteger maxCaseNumber = new BigInteger("100"); //there cant be more than 100 cases at a time right?
     scanner.nextLine();
     BigInteger sand = new BigInteger("0");
     
     while (scanner.hasNextInt() || scanner.hasNextBigInteger()){
        if (scanner.hasNextInt()){
            
            cases = scanner.nextInt();
            for (int x = 0; x < cases; x++){
                if (scanner.hasNextBigInteger()){
                    sum = sum.add(scanner.nextBigInteger());
                    
                    
                }
                sand = sand.add(sum);
              
                sum = BigInteger.valueOf(0);
               
               
            }
             
        }
  
   System.out.println(sand);
   sand = BigInteger.valueOf(0);
 }     
    
    }
}

