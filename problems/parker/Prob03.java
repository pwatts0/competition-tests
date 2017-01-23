/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prob03;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;


public class Prob03{

    public static void main(String... args) throws IOException {
     String problem = "Prob03.in.txt";
     String path = "C:\\Users\\pwatts\\Documents\\NetBeansProjects\\practice\\src\\JudgingInputs\\" + problem;
     File file = new File(path);
     
     boolean leap;
     Scanner scanner = new Scanner(file);
     scanner.nextLine();
     int caseAmount;
     int year;
     
     while(scanner.hasNextInt()){
         caseAmount = scanner.nextInt();
         for(int i = 0; i < caseAmount; i++){
             year = scanner.nextInt();
       
             if(year < 1582){
                 leap = false;
             System.out.println("No");}
            else if(!(year%4 == 0)){
                 leap = false;
                 System.out.println("No");
             }
            else if(!(year%100 == 0)){
                    leap = true; 
                    System.out.println("Yes");
                     }
            else if(!(year%400 == 0)){
                 leap = false;
                 System.out.println("No");
          
                         
                         }
             else{
                 leap = true;
                 System.out.println("Yes");
             
             }
         
            
            }
        
         }
     }
     
     
     
        
        
    }
    

