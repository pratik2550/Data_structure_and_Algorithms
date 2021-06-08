package LinkedList;
/*
    Program to clone linked list with random pointer abd next pointer.
 */

import java.util.*;

public class CloneLinkedListWithRandomPointer {
    public static NodeBottom addToTheLast(NodeBottom head, NodeBottom node) {
        if (head == null) {
            head = node;
        } else {
            NodeBottom temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
        return head;
    }

    public static boolean validation(NodeBottom head, NodeBottom res) {

        NodeBottom temp1 = head;
        NodeBottom temp2 = res;

        int len1 = 0, len2 = 0;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        /*if lengths not equal */

        if (len1 != len2) return false;

        HashMap<NodeBottom, NodeBottom> a = new HashMap<NodeBottom, NodeBottom>();

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {

            if (temp1 == temp2)
                return false;

            if (temp1.data != temp2.data) return false;


            if (temp1.bottom != null && temp2.bottom != null) {
                if (temp1.bottom.data != temp2.bottom.data) return false;
            } else if (temp1.bottom != null && temp2.bottom == null)
                return false;
            else if (temp1.bottom == null && temp2.bottom != null)
                return false;
            if (!a.containsKey(temp1)) {
                a.put(temp1, temp2);
            }

            temp1 = temp1.next;
            temp2 = temp2.next;

        }

        if (a.size() != len1)
            return false;

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {

            if (temp1.bottom != null && temp2.bottom != null) {
                if (a.get(temp1.bottom) != temp2.bottom) return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NodeBottom head = null, head2 = null;
        int n = sc.nextInt();
        int q = sc.nextInt();

        int a1 = sc.nextInt();
        head = addToTheLast(head, new NodeBottom(a1));
        head2 = addToTheLast(head2, new NodeBottom(a1));
        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            head = addToTheLast(head, new NodeBottom(a));
            head2 = addToTheLast(head2, new NodeBottom(a));
        }

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            NodeBottom tempA = head;
            NodeBottom temp2A = head2;
            int count = -1;

            while (tempA != null) {
                count++;
                if (count == a - 1) break;
                tempA = tempA.next;
                temp2A = temp2A.next;
            }
            NodeBottom tempB = head;
            NodeBottom temp2B = head2;
            count = -1;

            while (tempB != null) {
                count++;
                if (count == b - 1) break;
                tempB = tempB.next;
                temp2B = temp2B.next;
            }

            // when both a is greater than N
            if (a <= n) {
                tempA.bottom = tempB;
                temp2A.bottom = temp2B;
            }
        }

        NodeBottom res = copyList(head);

        if (validation(head, res) == true && validation(head2, res))
            System.out.println("1");
        else
            System.out.println("0");
    }

    private static NodeBottom copyList(NodeBottom head) {
        NodeBottom curr = head;
        while (curr != null) {
            NodeBottom temp = new NodeBottom(curr.data);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }
        curr = head;
        NodeBottom head2 = head.next;
        while (curr != null) {
            if (curr.bottom == null)
                curr.next.bottom = null;
            else {
                curr.next.bottom = curr.bottom.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        while (curr != null) {
            head = curr.next.next;
            if (head != null) {
                curr.next.next = head.next;
            }
            else {
                curr.next.next = null;
            }

            curr.next = head;
            curr = head;
        }

        return head;
    }
}
