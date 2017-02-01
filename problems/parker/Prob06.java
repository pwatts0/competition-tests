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
            String[][] trimmed = new String[chars.length][chars.length];
            for (int z = 0; z < chars.length; z++) {
                trimmed[z][z] = chars[z][z].replaceAll(" ", "");
            }
            
            ArrayList<Character> checkChars = new ArrayList<>();
            ArrayList<Character> poop = new ArrayList<>();
            boolean isItTrue;
            for (int j = 0; j < keyWords; j++) {
                String currentWord = scanner.next();
                for(int g = 0; g < currentWord.length(); g++){
                         checkChars.add(currentWord.charAt(g));
                    }
                for (int a = 0; a < currentWord.length(); a++) {

                    char currentCharacter = currentWord.charAt(a);
                    Coords coordinatesStart = lookRow(trimmed, 0, 0, currentCharacter);
                    Coords coordinatesCheck = lookRow(trimmed, 0, 0, checkChars.get(a));
                    isItTrue = charCheck(coordinatesStart.getX(), coordinatesStart.getY(), coordinatesCheck.getX(), coordinatesCheck.getY());
                    if(isItTrue){
                        poop.add(currentCharacter);
                    }
                    
                }
                System.out.print(poop); //PROBLEM IS DUPLICATES
            }
        }
    }
   

    public static Coords lookRow(String[][] characters, int row, int charPlace, char KeyChar) {

        int length = characters[row][row].length();
        int TotalLength = characters.length;
        int p = 0;
        if (charPlace >= length - 1) {
            charPlace = 0;
            p += 1;

        }

        if (row >= TotalLength - 1) {
            row = 0;
            p += 2;
        }

        Character currentChar = characters[row][row].charAt(charPlace);

        if (currentChar == KeyChar) {
            int x = charPlace;
            int y = row;
            return new Coords(x, y);
        }

        if (!(currentChar == KeyChar) && p == 0) {
            return lookRow(characters, row, charPlace += 1, KeyChar);
        }

        if (!(currentChar == KeyChar) && p == 1) {
            return lookRow(characters, row += 1, charPlace, KeyChar);
        } else {
            return null;
        }

    }
    
    
    public static boolean charCheck(int charX, int charY, int checkX, int checkY){
        int X = charX;
        int Y = charY;
        int cX = checkX;
        int cY = checkY;
        
        if(X - cX == 1 && Y - cY == 0){
            return true;
        }
        else if(X - cX == -1 && Y - cY == 0){
            return true;
        }
        else if(X - cX == 0 && Y - cY == 0){
            return true;
        }
        else if( X - cX == 0 && Y - cY == 1){
            return true;
        }
        else if(X - cX == 0 && Y - cY == -1){
            return true;
        }
        else if(X - cX == 1 && Y - cY == 1){
            return true;
        }
        else if(X - cX == 1 && Y - cY == -1){
            return true;
        }
        else if(X - cX == -1 && Y - cY == 1){
            return true;
        }
        else if(X - cX == -1 && Y - cY == -1){
            return true;
        }
        return false;
}
    

}
final class Coords{
    private final int xx;
    private final int yy;
    
    public Coords(int xx, int yy){
        this.xx = xx;
        this.yy = yy;
    }
    public int getX(){
        return xx;
    }
    public int getY(){
        return yy;
    }
}
