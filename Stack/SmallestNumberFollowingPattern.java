import java.util.Scanner;

public class SmallestNumberFollowingPattern {
     private static final Scanner scanner = new Scanner(System.in);

         public static void main(String[] args) 	{





              String pattern=scanner.nextLine();
              int arr[]=new int[pattern.length()+1];
             for (int i = 0; i < arr.length; i++) {
                arr[i]=i+1;
             }
             for (int i = 0; i < pattern.length(); i++) {
                 char ch=pattern.charAt(i);
                 if(ch=='d'){
                     int st=i;

                     while(i+1<pattern.length()&&pattern.charAt(i+1)=='d'){
                         i++;
                     }
                     int end=i+1;

                     reverse(arr,st,end);

                 }
             }

             for (int i = 0; i < arr.length; i++) {
                 int i1 = arr[i];
                 System.out.print(i1);
             }









         }

    private static void reverse(int[] arr, int st, int end) {
     int i=st,j=end;

             while(i<j){
         int temp=arr[i];
         arr[i]=arr[j];
         arr[j]=temp;
         i++;
         j--;
     }
    }
}
