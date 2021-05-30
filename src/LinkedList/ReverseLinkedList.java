package LinkedList;
/*
    Program to Reverse Linked List
 */

import java.io.*;

public class ReverseLinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        LinkedListNode head = new LinkedListNode(Integer.parseInt(inputLine[0]));
        LinkedListNode tail = head;
        for (int i = 1; i < inputLine.length; i++) {
            tail.next = new LinkedListNode(Integer.parseInt(inputLine[i]));
            tail = tail.next;
        }

        head = reverseLinkedList(head);
        LinkedListNode.printList(head);
    }

    private static LinkedListNode reverseLinkedList(LinkedListNode head) {
        LinkedListNode pre = null;
        LinkedListNode curr = head;
        LinkedListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
