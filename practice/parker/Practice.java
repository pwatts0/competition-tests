

package Practice.parker;
import java.util.*;
import java.nio.*;
import java.io.IOException;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;





public class Practice {

 
    public static void main(String... aArgs) throws IOException {
        File file = new File("C:\\Users\\pwatts\\New folder\\ExampleInputs\\Prob01.in.txt");
        Scanner scanner = new Scanner(file);
        List<String> numbers = new ArrayList<>();
        List<Integer> bob = new ArrayList<>();
        
        
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()){
                numbers.add(scanner.next());
            }
            scanner.nextLine();
            
        }
        Scanner scanner2 = new Scanner(file);
        while(scanner2.hasNext()){
            if (scanner2.hasNextInt()){
                bob.add(scanner2.nextInt());
            }
            scanner2.nextLine();
        }
        
      
        List<String> words = new ArrayList<>();
        Scanner wordScanner = new Scanner(file);
        
       
        while (wordScanner.hasNext()){
            words.add(wordScanner.next());
            
        }
      
        words.removeAll(numbers);
        List<Character> initials = new ArrayList<>();
        int sum = 0;
        
        
        for (String string : words){
           char doo = Character.toUpperCase(string.charAt(0));
           initials.add(doo);
    }
      
         for(Integer d : bob){
           sum += d;
          
      
       } 
        int setsOfInits = sum - bob.get(0);
       int s;
       int incrementStart = 0;
       int incrementEnd = 3;
         
       List<List<Character>> fooly = new ArrayList<>();
       for(s = 0; s < setsOfInits; s++){
           fooly.add(initials.subList(incrementStart,incrementEnd));
           incrementStart += 3;
           incrementEnd += 3;
            
        }
      for(int l = 0; l<setsOfInits; l++){           
       Collections.swap(fooly.get(l), 2, 2 - 1);
      
    }
       for(int q = 0; q < setsOfInits; q++){
           System.out.println(fooly.get(q));
       }
}
}


   
    



      
       
    

            
        
        
        
   

     
            
    







