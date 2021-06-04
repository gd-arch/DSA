
package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author g
 */
public class GeeksAdjacentSum {
   


     static int t[]=new int[10000];
    public static int subsum(int arr[],int size){
        if(size<=0)return 0;
        if(t[size]!=0)return t[size];
        int val= t[size]=Math.max(subsum(arr,size-2)+arr[size-1], subsum(arr,size-1));
       return val;
    }
	public static void main (String[] args) {
	          
	            Scanner s = new Scanner(System.in);
                int test= s.nextInt();
                int n=0;
while(test--!=0){
    n=s.nextInt();
      int a[] = new int[n];
        for(int i = 0; i < n; i++)

        {

            a[i] = s.nextInt();

        }
        System.out.println("Array is:");
        for(int x:a)System.out.println(x+"  ");
        System.out.println(subsum(a,n));
       Arrays.fill(t,0);
     
}

	}
}

