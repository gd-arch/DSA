import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class InfixConversion {
     private static final Scanner scanner = new Scanner(System.in);

         public static void main(String[] args) throws IOException {
             String exp = scanner.nextLine();
             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
             Stack<String> prefix=new Stack<>();
             Stack<String> postfix=new Stack<>();
             Stack<Character> operator=new Stack<>();
            //5 parts
             for(int i=0;i<exp.length();i++){
                 char ch=exp.charAt(i);

                 if(ch=='('){
                     operator.push(ch);



                 }
                 else if(ch==')'){
                     //pop till stack is empty or stack.peek()!='('
                     while(!operator.isEmpty()&&operator.peek()!='('){
                         char currentOpr=operator.pop();
                         //process the prefix and postfix using the popped operator
                         String preV2=prefix.pop();
                         String preV1=prefix.pop();
                         String finalExp=currentOpr+preV1+preV2;
                         prefix.push(finalExp);
//                         System.out.println(finalExp);

                         String postV2=postfix.pop();
                         String postV1=postfix.pop();
                         String finalExp2=postV1+postV2+currentOpr;
                         postfix.push(finalExp2);
//                         System.out.println(finalExp2);



                     }
                     //pop the last (
                     operator.pop();

                 }
                 else if(ch>='A'&&ch<='Z'||ch>='a'&&ch<='z'||ch>='0'&&ch<='9'){
                     postfix.push(ch+"");
                     prefix.push(ch+"");



                 }
                 else if(ch=='+'||ch=='-'||ch=='/'||ch=='*'){
                     //pop if !stack.isEmpty()&&stack.peek()!='('&&precedence(ch)<=precedence(stack.peek())
                     while(!operator.isEmpty()&&operator.peek()!='('&&precedence(ch)<=precedence(operator.peek())){
                         char currentOpr=operator.pop();
                         //process the prefix and postfix using the popped operator
                         String preV2=prefix.pop();
                         String preV1=prefix.pop();
                         String finalExp=currentOpr+preV1+preV2;
                         prefix.push(finalExp);

                         String postV2=postfix.pop();
                         String postV1=postfix.pop();
                         String finalExp2=postV1+postV2+currentOpr;
                         postfix.push(finalExp2);




                     }
                     //push the current character (operator)

                     operator.push(ch);


                 }





             }
             if(!operator.isEmpty()){
                 char currentOpr=operator.pop();
                 //process the prefix and postfix using the popped operator
                 String preV2=prefix.pop();
                 String preV1=prefix.pop();
                 String finalExp=currentOpr+preV1+preV2;
                 prefix.push(finalExp);

                 String postV2=postfix.pop();
                 String postV1=postfix.pop();
                 String finalExp2=postV1+postV2+currentOpr;
                 postfix.push(finalExp2);

             }
             System.out.println(postfix.pop());
             System.out.println(prefix.pop());

//a*(b-c+d)/e







         }

    private static int precedence(char ch) {
             if(ch=='+'||ch=='-'){
                 return 1;
             }else if(ch=='*'||ch=='/'){
                 return 2;
             }else{
                 return 0;
             }
    }
}
