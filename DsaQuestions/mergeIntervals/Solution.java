/*
Given a collection of Intervals,merge all the overlapping Intervals.
For example:

Given [1,3], [2,6], [8,10], [15,18],

return [1,6], [8,10], [15,18].

Make sure the returned intervals are sorted.

 

Input:

The first line contains an integer T, depicting total number of test cases. 
Then following T lines contains an integer N depicting the number of Intervals and next line followed by the intervals starting and ending positions 'x' and 'y' respectively.


Output:

Print the intervals after overlapping in sorted manner.  There should be a newline at the end of output of every test case.

Constraints:

1 ≤ T ≤ 50
1 ≤ N ≤ 100
0 ≤ x ≤ y ≤ 100


Example:

Input
2
4
1 3 2 4 6 8 9 10
4
6 8 1 9 2 4 4 7

Output
1 4 6 8 9 10
1 9
 */
package DsaQuestions.mergeIntervals;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author g
 */
public class Solution {
   private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException 	{
        
        
        
        
        try{
  int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
           Integer arr[][]=new Integer[n][2];
           for(int i=0;i<n;i++){
               
               for(int j=0;j<2;j++){
                   arr[i][j]=scanner.nextInt();
                   
               }
               
           }
    
                     
       Arrays.sort(arr, (a, b) -> a[0] - b[0]);
            
//         for(Integer x[] : arr){
//             for(Integer y : x){
//              System.out.println(y+" ");   
//             } System.out.println("");
//         }
        
   
    Stack <Integer []> s1=new Stack<>();
    int flag=0;
    for(Integer currentInterval[] : arr)  {
        if(flag==0){
            flag++;
            s1.push(currentInterval);
            continue;
        }
        
    if(isOverlap(currentInterval,s1.peek())){
        Integer mergedElement[]= merge(currentInterval,s1.pop()); 
        s1.push(mergedElement);
      }else s1.push(currentInterval);
          
    }
    
          for(Integer x[] : s1){
               for(Integer y : x){
              System.out.print(y+" ");   
             } 
          }

            System.out.println("");
        
    
    }  scanner.close();
           }catch(Exception e){
               System.out.println("Exception occured:"+e);   
                  }
    }

    private static boolean isOverlap(Integer[] currentInterval, Integer[] peek) {
        return peek[1]>=currentInterval[0];
        
    }

    private static Integer[] merge(Integer[] currentInterval, Integer[] pop) {
        Integer[] mergedElement={pop[0],Math.max(pop[1], currentInterval[1])};
        return mergedElement;
    }
}
//2 4 1 3 2 4 6 8 9 10 4 6 8 1 9 2 4 4 7