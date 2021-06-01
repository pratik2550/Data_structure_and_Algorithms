package LinkedList;
/*
    Program to find intersecting node of a Y shaped linked-list.
 */

import java.util.*;

public class IntersectionPointOfYLinkedList {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        IntersectionPointOfYLinkedList llist1 = new IntersectionPointOfYLinkedList();
        IntersectionPointOfYLinkedList llist2 = new IntersectionPointOfYLinkedList();
        IntersectionPointOfYLinkedList llist3 = new IntersectionPointOfYLinkedList();

        int a1 = sc.nextInt();
        LinkedListNode head1 = new LinkedListNode(a1);
        LinkedListNode tail1 = head1;

        for (int i = 1; i < n1; i++) {
            int a = sc.nextInt();
            tail1.next = (new LinkedListNode(a));
            tail1 = tail1.next;
        }


        int b1 = sc.nextInt();
        LinkedListNode head2 = new LinkedListNode(b1);
        LinkedListNode tail2 = head2;
        for (int i = 1; i < n2; i++) {
            int b = sc.nextInt();
            tail2.next = (new LinkedListNode(b));
            tail2 = tail2.next;
        }

        int c1 = sc.nextInt();
        LinkedListNode head3 = new LinkedListNode(c1);
        tail1.next = head3;
        tail2.next = head3;
        LinkedListNode tail3 = head3;
        for (int i = 1; i < n3; i++) {
            int c = sc.nextInt();
            tail3.next = (new LinkedListNode(c));
            tail3 = tail3.next;
        }

//        System.out.println(intersectPoint(head1, head2));
        System.out.println(intersectPoint2(head1, head2));
    }

    private static int intersectPoint(LinkedListNode head1, LinkedListNode head2) {
        HashSet<LinkedListNode> set = new HashSet<>();
        LinkedListNode temp = head1;
        while (temp!= null) {
            set.add(temp);
            temp = temp.next;
        }
        temp = head2;
        while (temp!= null) {
            if (set.contains(temp)) {
                return temp.data;
            }
            temp = temp.next;
        }
        return -1;
    }

    private static int intersectPoint2(LinkedListNode head1, LinkedListNode head2) {
        int size1 = size(head1);
        int size2 = size(head2);
        LinkedListNode temp1 = head1, temp2 = head2;

        int diff = Math.abs(size1-size2);
        if (size1>size2) {
            while (diff>0 && temp1!= null) {
                temp1 = temp1.next;
                diff--;
            }
        } else if (size2>size1){
            while (diff>0 && temp2!= null) {
                temp2 = temp2.next;
                diff--;
            }
        }

        while (temp1!=null && temp2!= null) {
            if (temp1 == temp2) {
                return temp1.data;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return -1;
    }

    private static int size(LinkedListNode temp) {
        int size = 0;
        while (temp!= null) {
            size++;
            temp = temp.next;
        }
        return size;
    }
}
