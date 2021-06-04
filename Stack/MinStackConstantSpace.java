import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class MinStackConstantSpace {
    //we use min to store the min value and when the min changes we use some special value in stack to show that the min has changed
    //and the original value at that point is in min.this facilitate popping mechanism so we can obtain prev min value from the special value
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("min")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }

    static class MinStack {

        Stack < Integer > data;
        int min;

        public MinStack() {
            data = new Stack<>();
        }

        int size() {
            return data.size();
        }

        void push(int val) {
            //case 0 when there is no value in the stack
            if (data.size() == 0) {
                data.push(val);
                min = val;
            }
            //case 1 when the val is greater than min
            else if (val > min) {
                data.push(val);

            }
            //case 2 when value is smaller than current min
            else {
                //   val-min is negative
                int flag = val + val - min;
                data.push(flag);
                min = val;
            }
        }

        int pop() {
            if (data.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            //case 1 if stack.peek()>min everything is fine just pop the top element because min is below the current position
            else if (data.peek() >= min) {
                return data.pop();
            }


            //Case 2: if stack.peek()<min that means min has been changed so we need to extract prev min from val at stack top
            else {
                //min was holding the actual value which caused min change
                int actualVal = min;
                int prevMin = 2 * actualVal - data.peek();
                min = prevMin;
                data.pop();
                return actualVal;

            }

        }

        int top() {
            if (data.size() > 0) {
                if (data.peek() >= min) {
                    return data.peek();
                } else return min;
            } else {
                System.out.println("Stack underflow");
                return -1;
            }
        }

        int min() {
            if (data.size() > 0) {
                return min;
            } else {
                System.out.println("Stack underflow");
                return -1;
            }
        }


    }
}
