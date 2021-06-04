import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
//[(a + b) + {(c + d) * (e / f)}] True
//[(a + b) + {(c + d) * (e / f)]} False
public class BalancedBrackets {
     private static final Scanner scanner = new Scanner(System.in);

         public static void main(String[] args) throws IOException {




             try{

                 String str=scanner.nextLine();
                 Stack<Character> s=new Stack();
                 for (int i = 0; i <str.length() ; i++) {
                     char ch = str.charAt(i);
                     //push opening brackets
                     if(ch=='('||ch=='['||ch=='{'){
                         s.push(ch);
                     }
                     //closing brackets pop approperiately
                     else if(ch==')'){
                        boolean result= handleBrackets(s,'(');
                        if(result==false){
                            System.out.println(false);
                            return;
                        }
                     }
                     else if(ch==']')
                     {
                         boolean result= handleBrackets(s,'[');
                         if(result==false){
                             System.out.println(false);
                             return;
                         }
                     }
                      else if(ch=='}'){
                         boolean result= handleBrackets(s,'{');
                         if(result==false){
                             System.out.println(false);
                             return;
                         }
                     }

                 }

                 if(s.isEmpty()){
                     //All brackets properly cancelled each other
                     System.out.println(true);
                 }else {
                     //stack has some element ,extra starting bracket
                     System.out.println(false);
                 }
                }catch(Exception e){
                    System.out.println("Exception occured:"+e);
                       }
         }
public static boolean handleBrackets(Stack<Character> stack,char appropCh){
    if(stack.isEmpty()){
      return false;
        //extra closing bracket
    }
    else if(stack.peek()==appropCh){
        stack.pop();
        return true;
    }
    else {
        return false;
        //Mismatched brackets
    }
}
}
