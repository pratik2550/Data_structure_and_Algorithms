package LinkedList;
/*
    Program to merge two sorted Linked list
 */

import java.io.*;

public class MergeTwoSortedLinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine1[] = br.readLine().split(" ");
        String inputLine2[] = br.readLine().split(" ");
        LinkedListNode head1 = new LinkedListNode(Integer.parseInt(inputLine1[0]));
        LinkedListNode head2 = new LinkedListNode(Integer.parseInt(inputLine2[0]));
        LinkedListNode tail = head1;
        for (int i = 1; i < inputLine1.length; i++) {
            tail.next = new LinkedListNode(Integer.parseInt(inputLine1[i]));
            tail = tail.next;
        }
        tail = head2;
        for (int i = 1; i < inputLine2.length; i++) {
            tail.next = new LinkedListNode(Integer.parseInt(inputLine2[i]));
            tail = tail.next;
        }

        head1 = mergeLinkedList(head1, head2);
        LinkedListNode.printList(head1);

    }

    private static LinkedListNode mergeLinkedList(LinkedListNode head1, LinkedListNode head2) {

        if (head1==null || head2==null) {
            return head1;
        } else if (head1==null) {
            return head2;
        }
        LinkedListNode pre = null, next1=null, next2, curr1 = head1, curr2 = head2;
        while (curr1 != null && curr2 != null) {
            if (curr1.data>curr2.data) {
                next1 = curr1.next;
                next2 = curr2.next;
                if (pre == null) {
                    pre = curr2;
                    head1 = curr2;
                } else {
                    pre.next = curr2;
                    pre = curr2;
                }
                curr2.next = curr1;
                curr2 = next2;
            } else {
                pre = curr1;
                curr1 = curr1.next;
            }
        }
        if (curr2!=null && pre != null) {
            pre.next = curr2;
        }
        return head1;
    }
}
