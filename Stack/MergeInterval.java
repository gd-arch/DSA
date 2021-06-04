import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class MergeInterval {


         public static void main(String[] args) throws IOException {

             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             int n = Integer.parseInt(br.readLine());
             int[][] arr = new int[n][2];

             for (int j = 0; j < n; j++) {
                 String line = br.readLine();
                 arr[j][0] = Integer.parseInt(line.split(" ")[0]);
                 arr[j][1] = Integer.parseInt(line.split(" ")[1]);
             }
             mergeOverlappingIntervals(arr);



         }


    private static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        //create pair array
        Pair []pairs=new Pair[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            pairs[i]=new Pair(arr[i][0],arr[i][1]);
        }
        Arrays.sort(pairs);
//      for(Pair p:pairs){
//          System.out.println(p);
//      }

        Stack<Pair> stack=new Stack();


        for (int i = 0; i < arr.length; i++) {
            if(i==0){
                stack.push(pairs[0]);
            }
            else {
                Pair top=stack.peek();
                if(top.end<pairs[i].st){
                    stack.push(pairs[i]);
                }
                else {
                    stack.pop();
                    stack.push(new Pair(top.st,Math.max(pairs[i].end,top.end)));
                }

            }


        }
        //never use it unless necessary
        for (int i = 0; i <stack.size() ; i++) {
            System.out.println(stack.get(i).st+" "+stack.get(i).end);

        }




    }


}
    class Pair  implements Comparable<Pair>{
         final int st;
         final int end;
Pair(int st,int end){
    this.st=st;
    this.end=end;
        }


        @Override
        public int compareTo(Pair pair) {
    if(this.st!=pair.st){
        return this.st-pair.st;
    }
    else return this.end-pair.end;

        }

        @Override
        public String toString() {
            return "Pair{" +
                    "st=" + st +
                    ", end=" + end +
                    '}';
        }
    }