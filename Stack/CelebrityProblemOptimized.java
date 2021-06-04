import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblemOptimized {

    public static void findCelebrity(int[][] arr) {
        //if i know j then i is not a celeb
        //if i dont know j then j is not a celeb

      Stack <Integer> possibleCeleb=new Stack<>();
        for (int p = 0; p <arr[0].length ; p++) {
            //push all person in stack
            possibleCeleb.push(p);
        }
        while(possibleCeleb.size()>=2){
            int p1=possibleCeleb.pop();
            int p2=possibleCeleb.pop();
            if(arr[p1][p2]==1){
                //p1 cant be a celeb
                possibleCeleb.push(p2);
            }
            else {
              //  p2 can be a celeb cause p1 doesnt know him
                possibleCeleb.push(p1);
            }

        }
        //Last element of the stack can be a celeb
        int lastPer=possibleCeleb.pop();
        //check for celebrity
        for (int k = 0; k <arr[0].length ; k++) {
            if (k != lastPer)
                if (arr[k][lastPer] == 0||arr[lastPer][k] == 1) {
                    System.out.println("none");
                    return;
                }

        }
        System.out.println(lastPer);

    }



}
