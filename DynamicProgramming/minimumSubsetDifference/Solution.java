
package DynamicProgramming.minimumSubsetDifference;

import java.util.ArrayList;

public class Solution {
    public static boolean t[][]=new boolean[15][15];
    
    public static boolean subsetSum(int arr[],int sum,int size){
     if(size-1<0) return false;
           if(sum==0&&size-1>0) { t[0][size-1]=true;
           return t[0][size-1];
           
           }
//      if(sum>0&&size-1==0) { t[sum][size-1]=false;
//           return t[sum][size-1];
//           
//           }
      else  if(sum>=arr[size-1])  t[sum][size-1]=subsetSum(arr,sum-arr[size-1],size-1)|subsetSum(arr,sum,size-1);
        else  t[sum][size-1]=subsetSum(arr,sum,size-1); 
        System.out.println(t[size-1][sum]);
        return t[size-1][sum];
    }
    
    public static void main(String[] args) {
        int arr[]={1,2,7};
          int length=arr.length;
          int sum=0;
          //sum of  given array
          
          for(int x:arr){
          sum = sum+x;
        }
//            t=new boolean[length+1][sum+1];

//trying to find all possible subsets within the range of total sum 
          subsetSum(arr,sum,length);
          
//          printing 2d array


       for(boolean x[]:t){
              for(boolean y: x){
              System.out.print(y+" ");
          }System.out.println("");
          }

//storing only possible subsets sum  by checking the row of 2d array generated by subset sum
//last row represent possible subset sum when size of array is equal to its original length
//Min value of subset s1+s2=Range => s2-s1=Min difference => min sum diff=Range -2*S1
          ArrayList<Integer> subset=new ArrayList<>();
        for(int i=0;i<(sum/2+1);i++){
            System.out.println("t[i][length]"+t[i][length]);
          if(t[i][length]==true)subset.add(i);
                  }
       int min=Integer.MAX_VALUE;
       for(int i=0;i<subset.size();i++){
           min=Math.min(min, sum-2*subset.get(i));
       }
        System.out.println("Minimum subset difference is"+min);
    }
}
