import java.util.Scanner;
import java.util.Stack;

class MyStack {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        boolean result = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);


            int cnt = 0;
            if (ch == ')') {


                while (stack.peek() != '(') {
                    System.out.println(stack.pop());
                    cnt++;
                }
                for(char k:stack){
                    System.out.print(k+" ");

                }
                System.out.println("count ="+cnt);
                if (cnt >= 1) {
                    stack.pop();
                    continue;

                } else {
                    System.out.println(true);
                    return;

                }


            } else {
               if(ch!=' ') stack.push(ch);
            }
        }
        System.out.println(false);
    }
}

