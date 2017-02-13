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
public class Prob12 {

    private static ArrayList<Bit> bits;

    private static class Bit {

        public int pos_dec;
        public String pos_bin;
        public char data;
        public char parity;
        public String encodedData;

        public Bit(int pos_dec, String pos_bin, char data, char parity) {
            this.pos_dec = pos_dec;
            this.pos_bin = pos_bin;
            this.data = data;
            this.parity = parity;
            this.encodedData = null;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        // get file obj 
        Scanner scanner = new Scanner(new File(Input.JPATH + "Prob12.in.txt"));
        int testCaseAmt = Integer.parseInt(scanner.nextLine());
        for (int tCa = 0; tCa < testCaseAmt; tCa++) {
            int subTestCaseAmt = Integer.parseInt(scanner.nextLine());
            for (int stca = 0; stca < subTestCaseAmt; stca++) {
                bits = new ArrayList<>();
                String bin = scanner.nextLine();
                // load data into array
                int pos = 3;
                bits.add(new Bit(pos - 2, addZero(Integer.toBinaryString(pos - 2), bin.length()), '\0', 'y'));
                bits.add(new Bit(pos - 1, addZero(Integer.toBinaryString(pos - 1), bin.length()), '\0', 'y'));
                int indexBeforeNextP = 1;
                for (Character c : bin.toCharArray()) {
                    if (indexBeforeNextP == 0) {
                        bits.add(new Bit(pos, addZero(Integer.toBinaryString(pos), bin.length()), '\0', 'y'));
                        indexBeforeNextP = pos - 1;
                        pos++;
                    }
                    bits.add(new Bit(pos, addZero(Integer.toBinaryString(pos), bin.length()), c, 'n'));
                    pos++;
                    indexBeforeNextP--;
                }
                // calc parity values 
                for (int i = 0; i < bits.size(); i++) {
                    if (bits.get(i).parity == 'y') {
                        int pBinPos = bits.get(i).pos_bin.indexOf("1");
                        int val = 0;
                        val = bits.stream().filter((bit) -> (bit.parity == 'n' && bit.pos_bin.charAt(pBinPos) == '1')).map((bit) -> Integer.parseInt(String.valueOf(bit.data))).reduce(val, Integer::sum);
                        bits.get(i).data = ((val % 2) == 0) ? '0' : '1';
                    }
                }
                String hamBinOutput = "";
                hamBinOutput = bits.stream().map((bit) -> String.valueOf(bit.data)).reduce(hamBinOutput, String::concat);
                System.out.println(hamBinOutput);
            }
        }
    }

    public static String addZero(String bin, int len) {
        while (bin.length() < len) {
            bin = "0" + bin;
        }
        return bin;
    }
}
