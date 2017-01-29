package prob06;

import java.io.IOException;
import java.io.File;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Prob06 {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\pwatts\\Documents\\NetBeansProjects\\practice\\src\\ExampleInputs\\Prob06.in.txt");
        Scanner scanner = new Scanner(file);
        int totalCases = scanner.nextInt();
        
        for (int i = 0; i < totalCases; i++) {
            
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            
            String lineByLine[] = new String[rows]; //holds the characters temporarily
            String chars[][] = new String[rows][columns]; //all the letters i gotta search through
            
            scanner.nextLine();//prevents from printing out an empty line
            

            for (int l = 0; l < rows; l++) {
                String nextRow = scanner.nextLine(); //scan dem muh fukin characters
                lineByLine[l] = nextRow; //put em in
                chars[l] = lineByLine; //transfer them to a 2d array
                
                System.out.println(chars[l][l]);

            }
            int keyWords = scanner.nextInt();
            for(int p = 0; p < keyWords; p++){
                String currentWord = scanner.next();
                for(int x = 0; x< rows-1; x++){
                    for(int y = 0; y< columns-1; y++){
                        if (chars[x][y].contains(currentWord)){
                            System.out.println("HI");
                        }
                        
                    }
               
                        
                    }
                }
                
            }
           
           
        }
}
    


        
        
    




