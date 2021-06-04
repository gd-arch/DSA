/*
DP solution 
time complexity =O(N)
space complexity=O(N)
 */
package nthfibonnaci;

import java.util.Scanner;

/**
 *
 * @author g
 */
public class Fib {
  
static int fib(int n,int dp[]){
        if(n==0)return dp[0]=0;
        if(n==1) return dp[1]=1;
        else
       return dp[n]=fib(n-1,dp)+fib(n-2,dp);
        
        
    }
	public static void main (String[] args) {
Scanner s=new Scanner(System.in);

int t=s.nextInt();
while(t!=0){
    int no=s.nextInt();
    int []dp=new int[no+1];
 
   
    
    System.out.println(fib(no,dp));
    
    
    
    t--;
}



	}
}