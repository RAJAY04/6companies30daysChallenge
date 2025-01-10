package day9;

public class DeleteNnodesafterMnodesofalinkedlist {
    public static void main(String[] args) {
        Node head = new Node();
        head.data = 1;
        head.next = new Node();
        head.next.data = 2;
        head.next.next = new Node();
        head.next.next.data = 3;
        head.next.next.next = new Node();
        head.next.next.next.data = 4;
        head.next.next.next.next = new Node();
        head.next.next.next.next.data = 5;
        head.next.next.next.next.next = new Node();
        head.next.next.next.next.next.data = 6;
        head.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.data = 7;
        head.next.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.next.data = 8;
        int M = 2, N = 1;
        linkdelete(head, M, N);
        while (head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    static class Node {
        int data;
        Node next;
    }
    static void linkdelete(Node head, int n, int m) {
        Node temp = head, t;
        int count = 0;
        while (temp != null)
        {
            for (count = 1; count < m && temp != null; count++)
                temp = temp.next;

            if (temp == null)
                return;
            t = temp.next;
            for (count = 1; count <= n && t != null; count++)
            {

                t = t.next;
            }
            temp.next = t;
            temp = t;
        }
    }
}
