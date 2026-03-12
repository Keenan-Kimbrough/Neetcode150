package org.Kimbroughtech.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    /*
    Given a string s, find the length of the longest substring without duplicate characters.

    A substring is a contiguous sequence of characters within a string.


    example 1:
    input: s = "zxyzxyz"
    output: 3
    string "xyz" is the longest without duplicates

    example 2:
    input: s = "xxx"
    output: 1


     */

    public static Integer longestSubstring(String s){

        int l = 0;
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();

        for ( int r = 0 ; r < s.length(); r ++){

            while(charSet.contains(s.charAt(r))){

                charSet.remove(s.charAt(l));
                l += 1;
            }
            charSet.add(s.charAt(r));

            maxLength = Math.max(maxLength, r - l + 1);


        }


        return maxLength;
    }

    public static void main(String[] args) {

        String inputOne = "zxyzxyz";

        int result = longestSubstring(inputOne);

        System.out.println("Test one " + result );

        String inputTwo = "xxx";
        int resultTwo = longestSubstring(inputTwo);
        System.out.println("Test two " + resultTwo);
    }
}
