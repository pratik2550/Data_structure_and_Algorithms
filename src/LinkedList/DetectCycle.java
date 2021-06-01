package LinkedList;
/*
    Program to detect loop in linked-list.
 */

import java.util.*;

public class DetectCycle {
    public static void makeLoop(LinkedListNode head, LinkedListNode tail, int x){
        if (x == 0)
            return;

        LinkedListNode curr = head;
        for(int i=1; i<x; i++)
            curr = curr.next;

        tail.next = curr;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int num = sc.nextInt();
            LinkedListNode head = new LinkedListNode(num);
            LinkedListNode tail = head;

            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = new LinkedListNode(num);
                tail = tail.next;
            }

            int pos = sc.nextInt();
            makeLoop(head, tail, pos);

            if( detectLoop(head))
                System.out.println("True");
            else
                System.out.println("False");
    }

    private static boolean detectLoop(LinkedListNode head) {
        LinkedListNode slow = head, fast = head;
        while (fast.next!= null && fast.next.next!= null && slow!= null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
