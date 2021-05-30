package LinkedList;
/*
    Program to reverse linked list node in a given range.
 */

import java.io.*;

public class ReverseLinkedListInRange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        LinkedListNode head = new LinkedListNode(Integer.parseInt(inputLine[0]));
        LinkedListNode tail = head;
        for (int i = 1; i < inputLine.length; i++) {
            tail.next = new LinkedListNode(Integer.parseInt(inputLine[i]));
            tail = tail.next;
        }
        String range[] = br.readLine().trim().split(" ");
        int left = Integer.parseInt(range[0]);
        int right = Integer.parseInt(range[1]);

        head = reverseInRange(head, left, right);
        LinkedListNode.printList(head);
    }

    private static LinkedListNode reverseInRange(LinkedListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        LinkedListNode cur = head, prev = null;
        while (left > 1) {
            prev = cur;
            cur = cur.next;
            left--;
            right--;
        }
        LinkedListNode con = prev, tail = cur;
        LinkedListNode third;
        while (right > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            right--;
        }
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}
