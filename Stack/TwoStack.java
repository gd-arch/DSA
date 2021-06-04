import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TwoStack {


        public static class TwoStackEx {
            int[] data;
            int top1;
            int top2;

            public TwoStackEx(int cap) {
                data=new int[cap];
                top1=-1;
                top2=cap;
            }

            int size1() {
                return top1+1;
            }

            int size2() {
                return data.length-top2;
            }

            void push1(int val) {
                if(top1+1==top2){
                    System.out.println("Stack overflow");
                    return;
                }
                else {
                    top1++;
                    data[top1] = val;
                }

            }

            void push2(int val) {
                if(top1==top2-1){
                    System.out.println("Stack overflow");
                    return;
                }
                else{
                    top2--;
                    data[top2]=val;
                }

            }

            int pop1() {
                if(size1()==0){
                    System.out.println("Stack underflow");
                    return -1;
                }
                else {
                    int ele=data[top1];
                    top1--;
                    return ele;
                }
            }

            int pop2() {
                if(size2()==0){
                    System.out.println("Stack underflow");
                    return -1;
                }
                else {
                    int ele=data[top2];
                    top2++  ;
                    return ele;
                }
            }

            int top1() {
                if(size1()==0){
                    System.out.println("Stack underflow");
                    return -1;
                }
                else return data[top1];

            }

            int top2() {
                if(size2()==0){
                    System.out.println("Stack underflow");
                    return -1;
                }
                else return data[top2];
            }
        }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            TwoStackEx st = new TwoStackEx(n);

            String str = br.readLine();
            while (str.equals("quit") == false) {
                if (str.startsWith("push1")) {
                    int val = Integer.parseInt(str.split(" ")[1]);
                    st.push1(val);
                } else if (str.startsWith("pop1")) {
                    int val = st.pop1();
                    if (val != -1) {
                        System.out.println(val);
                    }
                } else if (str.startsWith("top1")) {
                    int val = st.top1();
                    if (val != -1) {
                        System.out.println(val);
                    }
                } else if (str.startsWith("size1")) {
                    System.out.println(st.size1());
                } else if (str.startsWith("push2")) {
                    int val = Integer.parseInt(str.split(" ")[1]);
                    st.push2(val);
                } else if (str.startsWith("pop2")) {
                    int val = st.pop2();
                    if (val != -1) {
                        System.out.println(val);
                    }
                } else if (str.startsWith("top2")) {
                    int val = st.top2();
                    if (val != -1) {
                        System.out.println(val);
                    }
                } else if (str.startsWith("size2")) {
                    System.out.println(st.size2());
                }
                str = br.readLine();
            }
        }
    }

