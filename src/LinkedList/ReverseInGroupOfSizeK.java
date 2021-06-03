package LinkedList;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseInGroupOfSizeK {
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

//        head = reverseInK(head, k);
        head = reverseInK2(head, k);
        LinkedListNode.printList(head);
    }

    private static LinkedListNode reverseInK(LinkedListNode head, int k) {
        int size = size(head);
        if (k>size) {
            return head;
        }
        int count = 0;
        LinkedListNode curr = head;
        LinkedListNode pre = null;
        LinkedListNode next = null;
        while (count<k && curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            count++;
        }
        if (next!= null) {
            head.next = reverseInK(next, k);
        }
        return pre;
    }

    private static int size(LinkedListNode head) {
        int count = 0;
        while (head!= null) {
            count++;
            head = head.next;
        }
        return count;
    }

    private static LinkedListNode reverseInK2(LinkedListNode head, int k) {
        Stack<LinkedListNode> stack = new Stack<>();
        LinkedListNode curr = head;
        LinkedListNode pre = null;
        while (curr!= null) {
            int count = 0;
            LinkedListNode tempHead = curr;
            while (count<k && curr!= null) {
                stack.push(curr);
                curr = curr.next;
                count++;
            }
            if (count == k) {
                while (stack.size() > 0) {
                    if (pre == null) {
                        pre = stack.peek();
                        head = pre;
                    } else {
                        pre.next = stack.peek();
                        pre = pre.next;
                    }
                    stack.pop();
                }
            } else {
                while (stack.size()>0) {
                    pre.next = tempHead;
                    tempHead = tempHead.next;
                    pre = pre.next;
                    stack.pop();
                }
            }
        }
        pre.next = null;
        return head;
    }
}
