package DP;

import java.util.HashMap;
import java.util.Map;

public class CountNoOfSortedVowelStringsOfLengthN {
    public int countVowelStrings(int n) {
        if(n==1) return 5;
        Map <Character,Integer> prev=new HashMap<>();
        prev.put('a',1);
        prev.put('e',1);
        prev.put('i',1);
        prev.put('o',1);
        prev.put('u',1);
        Map<Character,Integer> next=new HashMap<>();
        next.put('a',0);
        next.put('e',0);
        next.put('i',0);
        next.put('o',0);
        next.put('u',0);
        for(int i=2;i<=n;i++){
            next.put('a',prev.get('u')+prev.get('o')+prev.get('i')+prev.get('e')+prev.get('a'));
            next.put('e',prev.get('u')+prev.get('o')+prev.get('i')+prev.get('e'));
            next.put('i',prev.get('u')+prev.get('o')+prev.get('i'));
            next.put('o',prev.get('u')+prev.get('o'));
            next.put('u',prev.get('u'));
            prev=next;

        }
        int sum=0;
        for(Map.Entry<Character, Integer> entry:prev.entrySet()){
            sum+= entry.getValue();
        }
        return sum;
    }
}
