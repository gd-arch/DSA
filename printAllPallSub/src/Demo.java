public class Demo {
    static void  printAllPallindromes(String str){
        for(int i=0;i<str.length();i++)   {
            for(int j=i+1;j<str.length();j++){
                String s=str.substring(i, j);
                if(isPallindrome(s)) {
                    System.out.println(s);
                }

            }
        }
    }


    public static void main(String[] args) {
        String s="abcddcb";
        printAllPallindromes(s);


    }

    private static boolean isPallindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }

            i++;j--;
        }
        return true;

    }
}

