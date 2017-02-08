package prob06;

import java.io.IOException;
import java.io.File;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class Prob06 {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\pwatts\\Documents\\NetBeansProjects\\practice\\src\\ExampleInputs\\Prob06.in.txt");
        Scanner scanner = new Scanner(file);
        int totalCases = scanner.nextInt();
        

        for (int i = 0; i < totalCases; i++) {

            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            int h;
            Character[][] chars = new Character[rows][columns];
            scanner.nextLine();
            for (int j = 0; j < rows; j++) {
                String line = scanner.nextLine().replaceAll(" ", "");
                for (h = 0; h < columns; h++) {
                    chars[j][h] = line.charAt(h);
                }

            }
            
            
            
            List<Map.Entry<Integer, Integer>> pairList = new ArrayList<>();
            List<Map.Entry<Integer, Integer>> Coordinates = new ArrayList<>();
            int keywords = scanner.nextInt();
            
             for (int g = 0; g < keywords; g++) {
                String key = scanner.next();
                for(int z = 0; z<key.length(); z++){
                    int v = 0;
                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < columns; c++) { 
                       if (chars[r][c] == key.charAt(z)) {
                           Entry<Integer,Integer> pair1=new SimpleEntry<>(r,c);
                           Coordinates.add(pair1);
                           
                       }
                    }
                }
                }
             
            
            

                for(int z = 0; z<key.length(); z++){
                    int v = 0;
                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < columns; c++) { 
                       if (chars[r][c] == key.charAt(z)) {
                           Entry<Integer,Integer> pair2=new SimpleEntry<>(r,c);
                           pairList.add(pair2);
                           v++;
                           
                            
                            //findTheNextLetter(chars, r, c, key, 0);
                                        
                           

                        }
                    }
                    
                    }
                for(int u = 0; u < v; u++){
                    String yString = pairList.get(u).toString().split("=")[0];
                    Integer y = Integer.valueOf(yString);
                    String xString = pairList.get(u).toString().split("=")[1];
                    Integer x = Integer.valueOf(xString);
                    String checkTheX = Coordinates.get(u+1).toString().split("=")[1];
                    Integer checkX = Integer.valueOf(checkTheX);
                    String checkTheY = Coordinates.get(u+1).toString().split("=")[0];
                    Integer checkY = Integer.valueOf(checkTheY);
                    System.out.println(x + " " + y + "  " + checkX + " " + checkY);
                }  
              
               // System.out.println(key.charAt(z) +" "+ v + "\n" + pairList);
                pairList.clear();
                }
               
            }
 
        }

    }
    public static boolean isItNear(int firstx, int firsty, int secx, int secy) {
        if (secx == firstx && secy == firsty) {
            return true;
        }
        if (secx + 1 == firstx && secy == firsty) {
            return true;
        } else if (secx - 1 == firstx && secy == firsty) {
            return true;
        } else if (secx == firstx && secy - 1 == firsty) {
            return true;
        } else if (secx == firstx && secy + 1 == firsty) {
            return true;
        } else if (secx + 1 == firstx && secy + 1 == firsty) {
            return true;
        } else if (secx + 1 == firstx && secy - 1 == firsty) {
            return true;
        } else if (secx - 1 == firstx && secy - 1 == firsty) {
            return true;
        } else if (secx - 1 == firstx && secy + 1 == firsty) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean findTheNextLetter(Character[][] chars, int x, int y, String word, int iteration){
       
       while(iteration < word.length()){
          
       findTheNextLetter(chars, x, y, word, iteration+=1);    
       }
       return true;
    }
    
    
    static class coords{
        int x;
        int y;
        
        public coords(int x, int y){
            this.x = x;
            this.y = y;
        }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
}

    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   /* public static int findWord(Character[][] chars, String word, int x, int y, int rows, int columns) {

        int checkingx = 0;
        int checkingy = 0;
        int t = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    if (chars[r][c] == word.charAt(i)) {
                        if (i == 0) {
                            checkingx = r;
                            checkingy = c;
                            t += 1;
                        }

                        if (i > 0) {
                            if (isItNear(checkingx, checkingy, r, c)) {
                                checkingx = r;
                                checkingy = c;
                                t += 1;
                                

                            }

                        }
                    }

                }
            }
        }
        return word.length();
    }

   */ 


/*boolean not = chars[x][y] == word.charAt(i);
                for(int j = 0; j < amntOfChecks; j++){
                   
                    if(chars[x][y] == word.charAt(i)){
                        t+=1;
                        
                       
                        
                    }
                    
                    else if(!not && p ==0){// x + 1 or right
                        p = 1;
                       findWord(chars, word, x+1, y, rows, columns);
                        
                    }
                    else if(!not && p == 1){ // x -1 or left
                        
                        p = 2;
                        findWord(chars, word, x-1, y, rows, columns);
                }
                    else if(!not && p == 2){// x normal y + 1 or down
                       
                       
                         p = 3;
                         findWord(chars, word, x, y+1, rows, columns);
                    }
                    else if(!not && p == 3){// y -1 or up
                    
                        p = 4;
                        findWord(chars, word, x, y-1, rows, columns);
                    }
                    else if(!not && p == 4){ // x + 1 and y -1 or up right
                        
                         p = 5;
                         findWord(chars, word, x+1, y-1, rows, columns);
                    }
                    else if(!not && p == 5){// x+1 and y+1 or down right
                       
                        p = 6;
                        findWord(chars, word, x+1, y+1, rows, columns);
                    }
                    else if(!not && p == 6){// x - 1 and y + 1 or down left
                        
                        p = 7;
                        findWord(chars, word, x-1, y+1, rows, columns);
                    }
                    else if(!not && p ==7){// x - 1 and y - 1 or up left
                     
                        p = 8;
                        findWord(chars, word, x-1, y-1, rows, columns);
                    }
                    else if(p == 8){
                        
                    }
                    
                        
                    
                }
            }
          return t == word.length()+2;
    }       
    
     public static String getString(ArrayList<Character> list){
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch:list){
            builder.append(ch);
        }
        return builder.toString();
    }*/
