package prob04;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.lang.*;
import java.text.DecimalFormat;


public class Prob04 {
    

 
    public static void main(String... args)throws IOException {
    String Path = ("C:\\Users\\pwatts\\Documents\\NetBeansProjects\\practice\\src\\JudgingInputs\\Prob04.in.txt");
    File file = new File(Path);
    Scanner scanner = new Scanner(file);
    DecimalFormat df1 = new DecimalFormat(".#");

    int TotalCases = scanner.nextInt();
    int times = 0;

    
    while (times < TotalCases){  
        int numbOfConversions = scanner.nextInt();
        int run = 0;
        while(run < numbOfConversions){
        String line = scanner.nextLine();
        
        if(line.endsWith("F")){
            String Faren = line.replace("F", "").replace(" ", "");
            float newF = Float.parseFloat(Faren);
            float newf1 =(float) ((newF - 32.0)*(5.0/9.0));
            System.out.println(line + " = " + df1.format(newf1)+ " " + "C");
            run++;
        }
        if(line.endsWith("C")){
            String Celc = line.replace("C", "").replace(" ", "");
            float newC = Float.parseFloat(Celc);
            float newc1 =(float) ((newC)*(9.0/5.0) + 32.0);
            System.out.println(line + " = " + df1.format(newc1) + " F");
            Double.parseDouble(Celc);
            
            run++;
        }
    
       
        }
        times++;
        
  
        
        }
    
       
    }
}
         

    
     

    

 
