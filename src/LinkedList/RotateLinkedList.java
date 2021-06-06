package LinkedList;
/*
    Program to rotate nodes of a linked list.
 */

import java.io.*;

public class RotateLinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        LinkedListNode head = new LinkedListNode(Integer.parseInt(inputLine[0]));
        LinkedListNode tail = head;
        for (int i = 1; i < inputLine.length; i++) {
            tail.next = new LinkedListNode(Integer.parseInt(inputLine[i]));
            tail = tail.next;
        }
        int k = Integer.parseInt(br.readLine());

//        head = rotateLikedList(head, k);
        head = rotateLikedList2(head, k);
        head = rotateLikedList3(head, k);
        LinkedListNode.printList(head);
    }

    //rotate last node k times
    private static LinkedListNode rotateLikedList(LinkedListNode head, int k) {
        if(head==null || head.next==null || k==0) {
            return head;
        }
        while (k-->0) {
            LinkedListNode curr = head, pre= null;
            while (curr!=null && curr.next!=null) {
                pre = curr;
                curr = curr.next;
            }
            curr.next = head;
            head = pre.next;
            pre.next = null;
        }
        return head;
    }

    //rotate last node k times
    private static LinkedListNode rotateLikedList2(LinkedListNode head, int k) {
        if(head==null || head.next==null || k==0) {
            return head;
        }
        LinkedListNode curr = head;
        int len = 1;
        while (curr.next!=null){
            len++;
            curr = curr.next;
        }
        curr.next = head;
        k = len - k%len;
        while (k-->0) curr = curr.next;
        head = curr.next;
        curr.next = null;
        return head;
    }


    //rotate node after k elements
    private static LinkedListNode rotateLikedList3(LinkedListNode head, int k) {
        if (head==null || head.next == null || k==0) {
            return head;
        }
        LinkedListNode curr= head, temp;
        while (k-->0 && curr!=null) {
            curr = curr.next;
        }
        temp = curr;
        while (curr.next!=null) {
            curr = curr.next;
        }
        curr.next = head;
        head = temp.next;
        temp.next = null;
        return head;
    }
}
