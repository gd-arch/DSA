import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class SlidingMaxForWindow {
     private static final Scanner scanner = new Scanner(System.in);

         public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
        arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    int nge[]=new int[n];
    Stack <Integer> st =new Stack<>();
    nge[n-1]=n;
                        st.push(n-1);
             for (int i = n-2; i >=0 ; i--) {
        //-a+

        while(!st.isEmpty()&&arr[st.peek()]<=arr[i]){
            st.pop();


        }
        nge[i]=st.isEmpty()?n:st.peek();
        st.push(i);

    }
//             for (int i = 0; i <n ; i++) {
//                 System.out.println(nge[i]+",");
//             }

    //find out maximum for the window
    //change j to arr[j] till it is inside the window length and print it
    //j value starts from i value
    int j=0;
             for (int i = 0; i <=n-k ; i++) {
        j=i;
        int windowLastIndex=i+k;
        while(nge[j]<windowLastIndex){
            j=nge[j];
        }
        System.out.println(arr[j]);
    }
}



}
