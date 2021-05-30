package LinkedList;

import java.io.*;

public class RemoveNthNode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        int n = Integer.parseInt(br.readLine());
        LinkedListNode head = new LinkedListNode(Integer.parseInt(inputLine[0]));
        LinkedListNode tail = head;
        for (int i = 1; i < inputLine.length; i++) {
            tail.next = new LinkedListNode(Integer.parseInt(inputLine[i]));
            tail = tail.next;
        }

        head = removeNthNode(head, n);
        LinkedListNode.printList(head);
    }

    private static LinkedListNode removeNthNode(LinkedListNode head, int n) {
        int size=0;
        LinkedListNode temp = head;
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        while (temp!=null) {
            size++;
            temp = temp.next;
        }
        size -= n;
        temp = dummy;
        while (size > 0) {
            size--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }
}
