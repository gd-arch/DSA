package DP;
// the count of subsequences of the nature a+b+c+.

import java.util.Scanner;

public class CountA_B_C_subs {
    public static void main(String[] args) {
        String s = new Scanner(System.in).next();
        int a = 0;//count of subsequences of the nature a+
        int ab = 0;// count of subsequences of the nature a+b+
        int abc = 0;//the count of subsequences of the nature a+b+c+
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                a = 2 * a + 1;
            } else if (ch == 'b') {
                ab = 2 * ab + a;
                //(ab)=ab considered +ab not considered + no of a subs in which b can be added in the last
            } else {
                //ch==c
                abc = 2 * abc + ab;

            }
        }
        System.out.println(abc);
    }
}
