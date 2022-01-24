package Heap;

import java.io.*;
import java.util.*;

public class MergeKSortedLinkedLists {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();

            Node []a = new Node[N];

            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();

                Node head = new Node(sc.nextInt());
                Node tail = head;

                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }

                a[i] = head;
            }

            MergeKList g = new MergeKList();

            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }
}
class MergeKList
{
    //Function to merge K sorted linked list.
    Node mergeKList(Node[]arr,int K)
    {
        //Add your code here.
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
        Node at[] = new Node[K];
        Node head = new Node(0);
        Node last = head;
        for(int i=0; i<K; i++) {
            if(arr[i] != null) {
                queue.add(arr[i]);
            }
        }
        if(queue.isEmpty())
            return null;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.println(curr.data);
            last.next = curr;
            last = last.next;
            if(curr.next!=null){
                queue.add(curr.next);
            }
        }
        return head.next;
    }
}
class NodeComparator implements Comparator<Node> {

    public int compare(Node k1, Node k2)
    {
        if (k1.data > k2.data)
            return 1;
        else if (k1.data < k2.data)
            return -1;
        return 0;
    }
}