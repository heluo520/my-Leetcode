package sf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-18
 * @Description: 链表中有环，找环的起始节点间
 * 思路：哈希表存储在查找
 */
public class Work_20 implements PrintRunTime{
    public ListNode detectCycle(ListNode head) {
        ListNode t = head;
        Set<ListNode> list = new HashSet<>();
        while (t!=null){
            if (list.contains(t)) {
                return t;
            }
            list.add(t);
            t = t.next;
        }
        return null;
    }
    @Override
    public void run(Object... args) {

    }
}
