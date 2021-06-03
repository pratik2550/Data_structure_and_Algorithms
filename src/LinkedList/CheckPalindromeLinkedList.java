package LinkedList;
/*
    Program to check given linked list is palindrome or not.

 */

import java.io.*;

public class CheckPalindromeLinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        LinkedListNode head = new LinkedListNode(Integer.parseInt(inputLine[0]));
        LinkedListNode tail = head;
        for (int i = 1; i < inputLine.length; i++) {
            tail.next = new LinkedListNode(Integer.parseInt(inputLine[i]));
            tail = tail.next;
        }

        System.out.print(checkPalindrome(head));
    }

    private static boolean checkPalindrome(LinkedListNode head) {
        LinkedListNode fast = head, slow = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = reverse(slow.next);
        slow = slow.next;
        while (slow != null) {
            if (slow.data != head.data) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    private static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode curr = head, pre = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
