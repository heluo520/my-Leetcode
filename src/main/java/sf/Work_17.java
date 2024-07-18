package sf;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-17
 * @Description: 找链表中点节点，为为偶数返回后一个节点
 * 思路：两个指针，一个统计链表长度算出中点，另一个通过算出的中点索引遍历到中点
 */
public class Work_17 implements PrintRunTime{
    public ListNode middleNode(ListNode head) {
        ListNode l = head;
        ListNode t = head;
        int len = 0;
        while (l!=null){
            len++;
            l = l.next;
        }
        for (int i = 0; i < len / 2; i++) {
            t = t.next;
        }
        return t;
    }
    @Override
    public void run(Object... args) {

    }
}
