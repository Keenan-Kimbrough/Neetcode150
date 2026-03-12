package org.Kimbroughtech.slidingWindow;

import javax.security.auth.login.AccountException;
import javax.swing.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestRepeatingCharacterReplacement {

    public static Integer longestRepeatingCharacter(String s, Integer k){
/*
        You are given a string s consisting of only uppercase english characters
        and an integer k. You can choose up to k characters of the string and replace them
        with any other uppercase English character.

        After performing at most k replacements, return the length of the
        longest substring which contains only one distinct character.

        Example 1:
        Input s : "XYYX" k = 2
        output 4

        either replace X's with Y's or replace Y's with X's
 */
        Set<Character> characterSet = new HashSet<>();

        char[] charArray= s.toCharArray();

        for (char c : charArray){
            characterSet.add(c);
        }
        int result = 0;

        for ( char c : charArray){
            int l = 0;
            int count = 0;
            for (int r = 0; r < charArray.length; r++){

                if (charArray[r] == c){
                    count += 1;
                }
                // once replacements exceeds k then slide window
                while((r - l + 1) - count > k){
                    if ( charArray[l] == c){
                        count -= 1;
                    }
                    l += 1;
                }
                result = Math.max(result, r - l + 1);
            }

        }
        return result;
    }


   public static void main(String[] args){
        String inputOneString = "XYYX";
        int inputOneK = 4;
        int result = longestRepeatingCharacter(inputOneString,inputOneK);

        System.out.println(result); // expected 4

        String inputTwoString = "AAABABB";
        int inputTwoK = 1;
        int resultTwo = longestRepeatingCharacter(inputTwoString,inputTwoK);
        System.out.println(resultTwo); // expected 5
    }
}
