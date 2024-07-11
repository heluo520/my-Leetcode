package sf;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-09
 * @Description: 反转链表
 */

public class Work_02 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = reverseList(node1);
        System.out.println(node);
    }

    public static ListNode reverseList(ListNode head) {
        if(head==null){//空链表
            return null;
        }
        ListNode y = head.next;//链首后一节点
        ListNode z = head.next;//初始时与y指向相同
        head.next = null;
        while (y!=null){//如果有两个以上节点
            z = y.next;//保存y的next节点
            y.next = head;//反转指向
            head = y;//相对链首后移
            y = z;//y后移
        }
        return head;
    }
}
