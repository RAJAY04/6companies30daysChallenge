package day17;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);
        lists[0] = head1;

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        lists[1] = head2;

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);
        lists[2] = head3;

        ListNode result = new MergeKSortedList().mergeKLists(lists);
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> c = Comparator.comparingInt(a -> a.val);
        PriorityQueue<ListNode> pq = new PriorityQueue<>(c);
        for(ListNode list : lists){
            if(list != null)
                pq.offer(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(!pq.isEmpty()){
            ListNode list = pq.poll();
            head.next = list;
            head = head.next;
            if(list.next != null){
                pq.offer(list.next);
            }
        }
        return dummy.next;
    }
}
