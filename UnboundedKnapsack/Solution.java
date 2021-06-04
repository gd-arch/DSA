



package UnboundedKnapsack;


public class Solution {
     static int[][] t=new int[100][100];
       public static int knapsack(int wt[], int val[], int capacity, int size) {
        if (size == 0 || capacity == 0) {
            return 0;
        }
         
        if(t[capacity][size]!=0)return t[capacity][size];
       
        
        if (capacity >= wt[size - 1]) {
            return t[capacity][size]=Math.max(val[size - 1] + knapsack(wt, val, capacity - wt[size - 1], size), knapsack(wt, val, capacity, size - 1));
        } else {
            return t[capacity][size]=knapsack(wt, val, capacity, size - 1);
        }
   
    }
    
    public static void main(String[] args) {
        
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length; 
        int[]  val = new int[size];;
        for(int i=0;i<arr.length;i++){
            val[i]=i;
        }
        
      
        System.out.println("Maximum Obtainable Value is " +  knapsack(arr,  val,  size, size)); 
        
        
        
        
    }
}
