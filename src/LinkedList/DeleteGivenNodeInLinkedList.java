package LinkedList;
/*
    Program to delete a given node from a linked-list in O(1) time complexity.
 */

import java.io.*;

public class DeleteGivenNodeInLinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        LinkedListNode head = new LinkedListNode(Integer.parseInt(inputLine[0]));
        LinkedListNode tail = head;
        for (int i = 1; i < inputLine.length; i++) {
            tail.next = new LinkedListNode(Integer.parseInt(inputLine[i]));
            tail = tail.next;
        }
        int n = Integer.parseInt(br.readLine());
        LinkedListNode temp = head;
        while (temp.data != n) {
            temp = temp.next;
        }

        deleteNode(temp);
        LinkedListNode.printList(head);
    }

    private static void deleteNode(LinkedListNode node) {
        node.data = node.next.data;
        if(node.next.next != null) {
            node.next = node.next.next;
        } else{
            node.next = null;
        }
    }
}
