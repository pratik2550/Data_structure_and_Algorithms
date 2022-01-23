package Heap;

import java.io.*;
import java.util.*;

public class ReorganizeString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
        String s = "ababab";
        reorganizeString(s);
    }

    private static void reorganizeString(String s) {
        int count[] = new int[26];
        int n = s.length();
        for(int i=0; i<s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        PriorityQueue<Key> heap = new PriorityQueue<>(new KeyComparator());
        for(char c='a'; c<='z'; c++) {
            int val = c-'a';
            if(count[val]>0) {
                heap.add(new Key(count[val], c));
            }
        }
        s = "";
        Key prev = new Key(-1, '#');
        while (!heap.isEmpty()) {
            Key k = heap.poll();
            s = s+k.ch;
            if(prev.freq>0) {
                heap.add(prev);
            }
            (k.freq)--;
            prev = k;
        }
        if(s.length()!=n) {
            System.out.println("\"\"");
        } else {
            System.out.println(s);
        }

    }
}
class Key {
    int freq; // store frequency of character
    char ch;
    Key(int val, char c)
    {
        freq = val;
        ch = c;
    }
}
class KeyComparator implements Comparator<Key> {

    public int compare(Key k1, Key k2)
    {
        if (k1.freq < k2.freq)
            return 1;
        else if (k1.freq > k2.freq)
            return -1;
        return 0;
    }
}
