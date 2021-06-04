/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DsaQuestions;

/**
 *
 * @author g
 */
public class Permutation {
    //to deal with duplicates store data in set
   static void permute(String s,int l,int r){
       if(l==r){
          System.out.println(s);
           return ;
       }
       
       for(int i=l;i<=r;i++){
         s=  swap(s,i,l);
           permute(s,l+1,r);
           //backtrack
          
           s=swap(s,i,l);
           
       }
      
       
       
   }
   static String swap (String s,int l,int r){
      char[] word=s.toCharArray();
      //swap l with r
      char temp=word[l];
      word[l]=word[r];
      word[r]=temp;
     return  s=String.valueOf(word);
   }
    
    public static void main(String[] args) {
        
        String s="12345";
        permute(s,0,s.length()-1);
        
        
        
        
    }
}
