package LinkedList;

import java.io.*;

public class MiddleOfLinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        LinkedListNode head = new LinkedListNode(Integer.parseInt(inputLine[0]));
        LinkedListNode tail = head;
        for (int i = 1; i < inputLine.length; i++) {
            tail.next = new LinkedListNode(Integer.parseInt(inputLine[i]));
            tail = tail.next;
        }

        head = findMiddle(head);
        System.out.println(head.data);
    }

    private static LinkedListNode findMiddle(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;
        while (fast!=null && fast.next!= null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
