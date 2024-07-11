package sf;

import java.util.*;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-09
 * @Description: 分割链表
 */
public class Work_03 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode partition = partition(node1, 10);
        System.out.println(partition);
    }
    public static ListNode partition(ListNode head, int x) {

        ListNode min = new ListNode();
        ListNode max = new ListNode();
        ListNode curMin = min;
        ListNode curMax = max;
        while (head!=null){
            if(head.val<x){
                curMin.next = head;
                curMin = head;
                head = head.next;
                curMin.next = null;
            }else {
                curMax.next = head;
                curMax = head;
                head = head.next;
                curMax.next = null;
            }
        }
        min = min.next;
        max = max.next;
        if(min!=null){
            curMin.next = max;
        }else {
            min=max;
        }
        return min;
    }

}
