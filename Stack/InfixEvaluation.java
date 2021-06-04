import java.util.Scanner;
import java.util.Stack;

//             1)'('  ayega to kya hoga
//             2)')'  ayega to kya hoga
//             3)operands 1,2,3.. 1 digit no
//             4)operator ayega to kya hoga
//             5)kuch elements opertor stack me  bachenge to kya hoga

//3 / (6 * 8 - 4) + 9
public class InfixEvaluation {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String expr = scanner.nextLine();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        Stack <Character> operator=new Stack<>();
        Stack <Integer> operand=new Stack<>();
        for (int i = 0; i <expr.length() ; i++) {
            char ch=expr.charAt(i);
            if(ch=='('){
                operator.push(ch);

            }else if(ch==')'){
                //pop till stack is empty or stack.peek()=='('
                while(!operator.isEmpty()&&operator.peek()!='('){
                    char popedOpr=operator.pop();
                    //perform operation with this popped operator
                    //take out last 2 digits from operand stack

                    int opd2=operand.pop();
                    int opd1=operand.pop();

                    int result=operation(opd1,opd2,popedOpr);
                    operand.push(result);

                }
                //finally pop ')'
                operator.pop();



            }
                else if(Character.isDigit(ch)){
                    //push the digit as integer to operand
                int digit=ch-'0';
                operand.push(digit);

            }
//                ch is +,-,*,/
                else if(ch=='+'||ch=='-'||ch=='*'||ch=='/') {
                    //based on equal or greater precedence of stack.peek() pop and push the element similar to left smallest element
                //popping till precedence(stack.peek())>=precedence(ch) or we get stack.peek() ==')' or stack got empty
                while(!operator.isEmpty()&& precedence(operator.peek())>=precedence(ch)&&operator.peek()!='('){
                    char popedOpr=operator.pop();
                    //perform operation with this popped operator
                    //take out last 2 digits from operand stack
                    int opd2=operand.pop();
                    int opd1=operand.pop();

                    int result=operation(opd1,opd2,popedOpr);
                    operand.push(result);


                }

                //pushing the current ch in the operator
                operator.push(ch);



            }
        }
        //if some operators are left then pop them out one by one
        while(!operator.isEmpty()){
            char popedOpr=operator.pop();
            //perform operation with this popped operator
            //take out last 2 digits from operand stack
            int opd2=operand.pop();
            int opd1=operand.pop();
            int result=operation(opd1,opd2,popedOpr);
            operand.push(result);
        }

//final result is in operand.peek()
        System.out.println(operand.peek());

    }

    private static int operation(int opd1, int opd2, char opr) {
        if(opr=='+'){
            return opd1+opd2;
        }else if(opr=='-'){
            return opd1-opd2;
        }else if(opr=='*'){
            return opd1*opd2;
        }else{
            return opd1/opd2;
        }
    }

    private static int precedence(char ch) {
        if(ch=='+'||ch=='-'){
            return 1;
        }
        //ch is * or /
        else {
            return 2;
        }
    }

}
