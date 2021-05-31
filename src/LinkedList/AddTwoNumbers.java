package LinkedList;
/*
    Program to add two linked-list representing number in reverse order.
 */

import java.io.*;

public class AddTwoNumbers {
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

        head1 = addTwoNumbers(head1, head2);
        head1 = addTwoNumbers2(head1, head2);
        LinkedListNode.printList(head1);

    }

    private static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode res = new LinkedListNode(0);
        LinkedListNode tail = res;

        int carry = 0;
        int sum;
        while (head1!= null && head2!= null) {
            sum = head1.data + head2.data + carry;
            carry = sum>9?sum/10:0;
            tail.next = new LinkedListNode(sum%10);
            tail = tail.next;
            head1 = head1.next;
            head2 = head2.next;
        }

        while (head1!= null) {
            sum = head1.data + carry;
            carry = sum>9?sum/10:0;
            tail.next = new LinkedListNode(sum%10);
            tail = tail.next;
            head1 = head1.next;
        }
        while (head2!=null) {
            sum = head2.data + carry;
            carry = sum>9?sum/10:0;
            tail.next = new LinkedListNode(sum%10);
            tail = tail.next;
            head2 = head2.next;
        }
        if (carry!=0) {
            tail.next = new LinkedListNode(carry);
            tail = tail.next;
        }
       return res.next;
    }

    private static LinkedListNode addTwoNumbers2(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode dummyHead = new LinkedListNode(0);
        LinkedListNode p = head1, q = head2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.data : 0;
            int y = (q != null) ? q.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new LinkedListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new LinkedListNode(carry);
        }
        return dummyHead.next;
    }
}
