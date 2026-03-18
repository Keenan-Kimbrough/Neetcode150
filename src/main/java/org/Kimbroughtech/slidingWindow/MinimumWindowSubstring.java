package org.Kimbroughtech.slidingWindow;

import java.awt.dnd.DropTargetContext;
import java.util.HashMap;
import java.util.Objects;

public class MinimumWindowSubstring {
    public static String minWindow(String s,  String t){
        if(t.isEmpty()){
            return "";
        }
        HashMap<Character, Integer> tCount = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        for ( char c : t.toCharArray()){
            tCount.put(c, tCount.getOrDefault(c,0) + 1);
        }

            int have = 0, need = tCount.size();


        int[] res = {-1,-1};

        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for ( int r = 0; r<s.length(); r++){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c,0) + 1);

            if (tCount.containsKey(c) && window.get(c).equals(tCount.get(c))){
                have++;
            }

            while (have == need){
                 if ((r - l + 1) < resLen)
                {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char leftChar = s.charAt(l);
                window.put(leftChar,window.get(leftChar) - 1);
                if (tCount.containsKey(leftChar) && window.get(leftChar) < tCount.get(leftChar)){
                    have--;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "": s.substring(res[0], res[1] + 1);
    }


    public static void main(String[] args){
        String s = "OUZODYXAZV";
        String string ="XYZ";

        String result = minWindow(s,string);

        System.out.println("The expected output is YXAZ, the actual out is : "+ result);
    }
}
