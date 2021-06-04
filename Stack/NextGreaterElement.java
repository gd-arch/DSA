
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
     private static final Scanner scanner = new Scanner(System.in);

         public static void main(String[] args) throws IOException {




             try{

                 int n = scanner.nextInt();
             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                             int arr[]=new int[n];
                        for(int i=0;i<arr.length;i++){
                            arr[i]=scanner.nextInt();
                        }
                 System.out.println();
                 for(int i:solve(arr)){
                     System.out.print(i+" ");
                 }








          scanner.close();
                }catch(Exception e){
                    System.out.println("Exception occured:"+e);
                       }
         }
         //complexity o(2n) element is popped and pushed atmost once
    public static int[] solve(int[] arr){
             int ans[]=new int[arr.length];
//             peeche se start karke pop those element which are smaller then current element set the ans of current element in ans array as the peek of array if it is not empty else -1 puch current element in the stack
//    order- -a+
        Stack <Integer>st=new Stack();
        //last element always -1
        ans[arr.length-1]=-1;
        st.push(arr[arr.length-1]);
        for (int i=arr.length-2;i>=0;i--){
            int ele=arr[i];
            //check if any element is smaller or equal than the current element in stack and pop it
            System.out.println("element is "+ele);
            while(!st.isEmpty()&&st.peek()<=ele){
                System.out.println("popped element is "+ st.pop());
            }
            //set value of peek as the next greatest element for the index i
            ans[i]=st.isEmpty()?-1:st.peek();
            //push the current element in the stack as it can be the greatest element in the stack
            st.push(ele);
        }

        return ans;
    }
}
