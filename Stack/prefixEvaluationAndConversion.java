import java.util.Scanner;
import java.util.Stack;

public class prefixEvaluationAndConversion {
     private static final Scanner scanner = new Scanner(System.in);

         public static void main(String[] args) {
            //ab+
             String preExp = scanner.nextLine();
             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
             Stack<String> infix=new Stack<>();
             Stack<String> postfix=new Stack<>();
             Stack<Integer> value=new Stack<>();
             //only difference is that we need to iterate i from backside so we get b first than a than operator
             for (int i = preExp.length()-1; i >=0 ; i--) {
                 char ch=preExp.charAt(i);
                 //character is digit or alphabet
                 if(Character.isDigit(ch)||Character.isAlphabetic(ch)){
                     infix.push(ch+"");
                     postfix.push(ch+"");
                     value.push(ch-'0');


                 }
                 //character is an operator
                 else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                     //pop two elements perform operations on them and push to the stack
                     //process prefix
                     String postV1=postfix.pop();
                     String postV2=postfix.pop();

                     String postExp=postV1+postV2+ch;
                     postfix.push(postExp);
                     //process Infix
                     String inV1=infix.pop();
                     String inV2=infix.pop();

                     String inExp='('+inV1+ch+inV2+')';
                     infix.push(inExp);

                     //process Value
                     int v1=value.pop();
                     int v2=value.pop();

                     int result=operation(v1,v2,ch);
                     value.push(result);
                 }
             }

             System.out.println(value.pop());
             System.out.println(infix.pop());
             System.out.println(postfix.pop());

         }
    private static int operation(int v1, int v2, char ch) {
        if(ch=='+'){
            return v1+v2;
        }
        else if(ch=='-'){
            return v1-v2;
        }
        else if(ch=='*'){
            return v1*v2;
        }
        else if(ch=='/'){
            return v1/v2;
        }
        return 0;
    }
}
