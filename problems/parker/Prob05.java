
package prob05;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.math.*;
public class Prob05 {


    public static void main(String... args)throws IOException {
        String path = "C:\\Users\\pwatts\\Documents\\NetBeansProjects\\practice\\src\\JudgingInputs\\";
        String problem = "Prob05.in.txt";
        File file = new File(path + problem);
        Scanner scanner = new Scanner(file);
        DecimalFormat round = new DecimalFormat("#");
        ArrayList<Integer> yearList = new ArrayList<>();
        ArrayList<Integer> incomeList = new ArrayList<>();
        HashMap yearAndIncome = new HashMap();
        
        int TestCases = scanner.nextInt();
        int time = 0;
        ArrayList<Integer> allYears = new ArrayList<>();
        ArrayList<Float> allIncome = new ArrayList<>();
        
        while(time < TestCases){//total amount of cases
            time++;
            String Country = scanner.next();//USA! USA!
            int cases = scanner.nextInt();
            int time2 = 0;//how many times should this run before scanning for a country again
            while(time2 < cases){
                time2++;
              
            double Dincome = scanner.nextDouble();
            int year = scanner.nextInt();
            Math.round(Dincome);
            double UnRoundedIncome = Dincome/1000;
            String StringRoundedIncome = round.format(UnRoundedIncome);
            int SmallIncome = Integer.parseInt(StringRoundedIncome);
            yearAndIncome.put(year, SmallIncome);
            
            allYears.add(year);
            
            
            int Income = SmallIncome * 1000;
            
            
            }
            Collections.sort(allYears);
            System.out.println(Country + ":");
            for(int letsPrint = 0; letsPrint<cases; letsPrint++){
                int TheYear = allYears.get(letsPrint);
                System.out.print(TheYear + " ");
                Object stars = yearAndIncome.get(TheYear);
                int TheStars = (Integer) stars;
                
                for(int i = 0; i<TheStars; i++){
                    System.out.print("*");
                }
                System.out.print("\n");
            }
            
        }
    }
    
}
