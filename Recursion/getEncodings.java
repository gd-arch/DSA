package PepCode.src;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author g
 */
public class getEncodings {
    
    public static void main(String[] args) throws Exception {
Scanner sc=new Scanner(System.in);
String str=sc.next();
printEncodings("",str);
    }

    public static void printEncodings(String ans,String quest) {
        if(quest.length()==0) 
        {System.out.println(ans);
          return ;  
        }
        String one=quest.substring(0,1);
        if(one=="0") return;
        String two="";
        if(quest.length()>1){
         two=quest.substring(0,2);}
        if(decoded(one)){
            String a=String.valueOf((char)(Integer.parseInt(one)+'a'-1));
            printEncodings(ans+a,quest.substring(1));
            
        }
        else return;
        
         
        if(quest.length()>1){if(decoded(two)){
            char ch=(char)(Integer.parseInt(two)+'a'-1);
            
            String b=String.valueOf(ch);
                    
            
            printEncodings(ans+b,quest.substring(2));}
        else return;
        }
        
        
        
    }
    public static boolean decoded(String str){
        int no=Integer.parseInt(str);
        return no>0&&no<=26;
    }

}
