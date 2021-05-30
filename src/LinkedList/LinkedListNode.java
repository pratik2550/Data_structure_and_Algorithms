package LinkedList;

public class LinkedListNode {

        int data;
    LinkedListNode next;

    LinkedListNode(int d) {
            data = d;
            next = null;
    }

    public static void printList(LinkedListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
