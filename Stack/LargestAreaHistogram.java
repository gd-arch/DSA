import java.util.Scanner;
import java.util.Stack;

public class LargestAreaHistogram {
     private static final Scanner scanner = new Scanner(System.in);

         public static void main(String[] args)  	{





                 int n = scanner.nextInt();
             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                             int arr[]=new int[n];
                        for(int i=0;i<arr.length;i++){
                            arr[i]=scanner.nextInt();
                        }
                        //smallest element on the left
             int left[]=new int[n];

                        Stack<Integer> stack =new Stack<>();
                        left[0]=-1;
                        stack.push(0);
             for (int i = 1; i <n ; i++) {
                 while(!stack.isEmpty()&&arr[stack.peek()]>=arr[i]){
                     stack.pop();
                 }
                left[i]= stack.isEmpty()?-1:stack.peek();
                 stack.push(i);

             }


             //smallest element on the right
             int right[]=new int[n];
             Stack<Integer> st =new Stack<>();
             right[n-1]=n;
             st.push(n-1);
             for (int i = n-1; i >=0 ; i--) {
                 while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                     st.pop();
                 }
                 right[i]= st.isEmpty()?n:st.peek();
                 st.push(i);

             }
//             System.out.println("Left smallest");
//             for(int k:left){
//                 System.out.print(k+",");
//             }
//             System.out.println("right smallest");
//             for(int k:right){
//                 System.out.print(k+",");
//             }
             int max=Integer.MIN_VALUE;
             for (int i = 1; i < n; i++) {
                int length= (right[i]-left[i]-1);
                int area=arr[i]*length;
                max=Math.max(area,max);

             }
             System.out.println(max);











         }
}
