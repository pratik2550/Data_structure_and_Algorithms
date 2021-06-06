package LinkedList;
/*
    Program to Flatten a Multilevel Doubly Linked List.
 */

public class FlattenDoublyLinkedList {
    public Node flatten(Node head) {
        flattenChild(head);
        return head;
    }

    private Node flattenChild(Node head) {
        Node pre = null, curr = head, nex = null, c = null;
        while (curr!= null) {
            nex = curr.next;
            pre = curr.prev;
            Node ch = curr.child;
            if (ch!= null) {
                c = flattenChild(curr.child);
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                c.next = nex;
                if(nex!=null) {
                    nex.prev = c;
                }
            }
            pre = curr;
            curr = curr.next;
        }
        return pre;
    }


}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};