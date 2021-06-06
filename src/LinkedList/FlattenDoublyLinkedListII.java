package LinkedList;
/*
    Program to Flatten a Singly Linked List where each node represent a singly linked list.
 */

import java.util.*;

public class FlattenDoublyLinkedListII {

    NodeBottom head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FlattenDoublyLinkedListII list = new FlattenDoublyLinkedListII();
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        NodeBottom temp = null;
        NodeBottom tempB = null;
        NodeBottom pre = null;
        NodeBottom preB = null;
        int flag = 1;
        int flag1 = 1;
        for (int i = 0; i < N; i++) {
            int m = arr[i];
            m--;
            int a1 = sc.nextInt();
            temp = new NodeBottom(a1);
            if (flag == 1) {
                list.head = temp;
                pre = temp;
                flag = 0;
                flag1 = 1;
            } else {
                pre.next = temp;
                pre = temp;
                flag1 = 1;
            }

            for (int j = 0; j < m; j++) {
                int a = sc.nextInt();
                tempB = new NodeBottom(a);
                if (flag1 == 1) {
                    temp.bottom = tempB;
                    preB = tempB;
                    flag1 = 0;
                } else {
                    preB.bottom = tempB;
                    preB = tempB;
                }
            }
        }
        list.head = flatten(list.head);
    }

    private static NodeBottom flatten(NodeBottom head) {
        if (head == null || head.next== null) {
            return head;
        }
        head.next = flatten(head.next);
        head = mergeTwoList(head, head.next);
        return head;
    }

    private static NodeBottom mergeTwoList(NodeBottom a, NodeBottom b) {
        NodeBottom temp = new NodeBottom(0);
        NodeBottom res = temp;
        while (a!=null || b!=null) {
            if (a.data<b.data) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            } else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }
        if (a!=null) temp.bottom = a;
        else temp.bottom = b;
        return res.bottom;
    }
}

class NodeBottom {
    int data;
    NodeBottom next;
    NodeBottom bottom;

    NodeBottom(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}
