import java.util.Scanner;
import java.util.Stack;

public class postfixEvaluationAndConversion {
     private static final Scanner scanner = new Scanner(System.in);

         public static void main(String[] args)  	{
             String postExp = scanner.nextLine();
             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
             Stack<String> infix=new Stack<>();
             Stack<String> prefix=new Stack<>();
             Stack<Integer> value=new Stack<>();

             //cause there are no brackets in the postfix expression the no of cases will be less
             for (int i = 0; i <postExp.length() ; i++) {
                 char ch=postExp.charAt(i);
                 //character is digit or alphabet
                 if(Character.isDigit(ch)||Character.isAlphabetic(ch)){
                     infix.push(ch+"");
                     prefix.push(ch+"");
                     value.push(ch-'0');


                 }
                 //character is an operator
                 else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                     //pop two elements perform operations on them and push to the stack
                     //process prefix
                     String preV2=prefix.pop();
                     String preV1=prefix.pop();
                     String preExp=ch+preV1+preV2;
                     prefix.push(preExp);
                     //process Infix

                     String inV2=infix.pop();
                     String inV1=infix.pop();
                     String inExp='('+inV1+ch+inV2+')';
                     infix.push(inExp);

                     //process Value
                     int v2=value.pop();
                     int v1=value.pop();
                     int result=operation(v1,v2,ch);
                     value.push(result);
                 }
             }

             System.out.println(value.pop());
             System.out.println(infix.pop());
             System.out.println(prefix.pop());


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
