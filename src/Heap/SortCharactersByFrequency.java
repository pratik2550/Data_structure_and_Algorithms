package Heap;

import java.util.*;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "cccaaa";
        System.out.println(frequencySort(s));
    }

    private static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        PriorityQueue<CharPair> heap = new PriorityQueue<>(new CharKeyComparable());
        for (Map.Entry<Character,Integer> entry : map.entrySet())
            heap.add(new CharPair(entry.getKey(), entry.getValue()));
        StringBuffer sb = new StringBuffer();
        while (!heap.isEmpty()){
            Character c = heap.peek().c;
            int count = heap.peek().val;
            for(int i=0; i<count; i++) {
                sb.append(c);
            }
            heap.remove();
        }
        return sb.toString();
    }
}
class CharPair{
    Character c;
    int val;
    CharPair(Character i, int v) {
        c = i;
        val = v;
    }
}
class CharKeyComparable implements Comparator<CharPair>{

    @Override
    public int compare(CharPair o1, CharPair o2) {
        if(o1.val<o2.val) {
            return 1;
        } if (o1.val> o2.val) {
            return -1;
        }
        return 0;
    }
}
