import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
     private static final Scanner scanner = new Scanner(System.in);

         public static void main(String[] args) throws IOException {




//just push index on stack
                 int n = scanner.nextInt();
             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                             int arr[]=new int[n];
                        for(int i=0;i<arr.length;i++){
                            arr[i]=scanner.nextInt();
                        }
             Stack <Map.Entry<Integer,Integer>> stack=new Stack<>();
                        int ans[]=new int[n];
                        stack.push(new AbstractMap.SimpleEntry<>(arr[0], 0));
                        ans[0]=1;

             for (int i = 1; i <n ; i++) {

                 while(stack.size()>0&&stack.peek().getKey()<=arr[i]){
                     stack.pop();

                 }
                 ans[i]=stack.isEmpty()?i+1:i-stack.peek().getValue();
                 stack.push(new AbstractMap.SimpleEntry<>(arr[i], i));
             }
             for(int k:ans){
                 System.out.println(k);
             }












         }
}
