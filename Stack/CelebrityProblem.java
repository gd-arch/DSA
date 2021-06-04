import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {
     private static final Scanner scanner = new Scanner(System.in);

         public static void main(String[] args) 	{




                 int n = scanner.nextInt();
             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                             int arr[][]=new int[n][n];


             for (int j = 0; j < n; j++) {
                 String line = scanner.nextLine();
                 for (int k = 0; k < n; k++) {
                     arr[j][k] = line.charAt(k) - '0';
                 }
             }
                        boolean zeroKnowsNoBody=true;
             for (int i = 0; i <arr[0].length ; i++) {
                 if(arr[0][i]==1){
                     zeroKnowsNoBody=false;
                     if(isCeleb(i,arr)){
                         System.out.println(i);
                     }




                 }

             }
             if(zeroKnowsNoBody){
                 if(everyBodyKnows(0,arr)){
                     System.out.println(0);
                     return;

                 }


             }else

             System.out.println("none");

         }
    private static boolean everyBodyKnows(int i, int[][] arr) {
        for (int k = 0; k <arr[0].length ; k++) {
            if(k!=i)
                if(arr[k][i]==0){
                    return false;
                }

        }
        return true;

    }
    private static boolean isCeleb(int i, int[][] arr) {
        for (int k = 0; k <arr[0].length ; k++) {
            if (k != i)
                if (arr[k][i] == 0||arr[i][k] == 1) {
                        return false;
                    }

                }

            return true;

         }


}
//5
//01111
//10110
//11011
//00000
//00010