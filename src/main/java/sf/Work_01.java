package sf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-09
 * @Description: 合并链表
 */


public class Work_01 {
    public static void main(String[] args) {
        /*List<Integer> L1 = Arrays.asList(-9,3);
        List<Integer> L2 = Arrays.asList(5,7);
        List<Integer> marge = marge(L1, L2);*/
        ListNode node1 = new ListNode(-9);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        node1.next = node2;
        node3.next = node4;
        ListNode L1 = node1;
        ListNode L2 = node3;
        ListNode listNode = margeTwoListsPlus(L1, L2);

        System.out.println(listNode);
    }

    /**
     *
     * @param L1 第一个链表，不含空链首
     * @param L2 第二个链表，不含空链首
     * @return 合并后的链表，不含空链首
     */
    public static ListNode margeTwoListsPlus(ListNode L1,ListNode L2){
        ListNode listNode = new ListNode();
        ListNode cur = listNode;
        while (L1 != null && L2 != null) {
            if (L1.val < L2.val) {
                cur.next = L1;
                L1 = L1.next;
            } else {
                cur.next = L2;
                L2 = L2.next;
            }
            cur=cur.next;
        }
        if(L1==null){
            cur.next = L2;
        }else {
            cur.next = L1;
        }
        listNode = listNode.next;
        return listNode;
    }

    public static ListNode margeTwoLists(ListNode L1,ListNode L2){
        ListNode listNode = new ListNode();
        ListNode p1 = L1;
        ListNode p2 = L2;
        ListNode cur = listNode;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                ListNode newNode = new ListNode(p1.val);
                cur.next = newNode;
                cur = newNode;
                p1 = p1.next;
            } else {
                ListNode newNode = new ListNode(p2.val);
                cur.next = newNode;
                cur = newNode;
                p2 = p2.next;
            }
        }
        if(p1==null){
            cur.next = p2;
        }else {
            cur.next = p1;
        }
        listNode = listNode.next;
        return listNode;
    }

    public static List<Integer> marge(List<Integer> L1, List<Integer> L2){
        List<Integer> L = new ArrayList<>();
        int size1 = L1.size();
        int size2 = L2.size();
        int count = size1+size2;
        int i1 = 0,i2 = 0;
        for (int i = 0; i < count; i++) {
            Integer l1 = L1.get(i1);
            Integer l2 = L2.get(i2);
            if(l1<l2){
                L.add(l1);
                i1++;
            }else{
                L.add(l2);
                i2++;
            }
            if(i1==size1 || i2==size2){
                break;
            }
        }
        if(i1==size1){
            for (int i = i2; i < L2.size(); i++) {
                L.add(L2.get(i));
            }
        }
        if(i2==size2){
            for (int i = i1; i < L1.size(); i++) {
                L.add(L1.get(i));
            }
        }
        return L;
    }
}
