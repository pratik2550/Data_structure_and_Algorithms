package LinkedList;
/*
    Program to detect starting point of loop in a linked-list.
 */

import java.io.*;
import java.util.Scanner;

public class FirstNodeOfLoop {
    public static void makeLoop(LinkedListNode head, LinkedListNode tail, int x){
        if (x == 0)
            return;

        LinkedListNode curr = head;
        for(int i=1; i<x; i++)
            curr = curr.next;

        tail.next = curr;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int num = sc.nextInt();
        LinkedListNode head = new LinkedListNode(num);
        LinkedListNode tail = head;

        for (int i = 0; i < n - 1; i++) {
            num = sc.nextInt();
            tail.next = new LinkedListNode(num);
            tail = tail.next;
        }

        int pos = sc.nextInt();
        makeLoop(head, tail, pos);

        System.out.print(detectLoop(head).data);
    }

    private static LinkedListNode detectLoop(LinkedListNode head) {
        LinkedListNode slow = head, fast = head;
        boolean flag = false;
        while (fast.next != null && fast.next.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return null;
        }
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
