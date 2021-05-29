package Hashing;
/*
    Program to find the length of longest sub string without repeating.
 */

import java.io.*;
import java.util.*;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(longestSubString(str));
    }

    private static int longestSubString(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        int left = 0;
        int right =0;
        while (right<str.length()) {
            if (map.containsKey(str.charAt(right))) {
                left = Math.max(map.get(str.charAt(right))+1, left);
            }
            map.put(str.charAt(right), right);
            count = Math.max(count, right-left+1);
            right++;
        }
        return count;
    }
}
