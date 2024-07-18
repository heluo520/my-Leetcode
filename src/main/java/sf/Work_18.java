package sf;


import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-18
 * @Description: 找链表交点
 * 思路：因为两个链表的长度总和是一样的，而且交点之后的节点都是地址相同的节点
 * 所以当两个指针分别遍历其总长度的链表时一定会在某一时刻遍历到同一个节点，如果没有交点则会在
 * 同一时刻遍历完，即为null，太妙了，想不出来，果然计算机的尽头是数学。
 */
public class Work_18 implements PrintRunTime{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //方法一、
        if(headA==null || headB==null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a!=b){//目的是使得a与b距离交点的距离相等，即消除两个头节点的距离差
            a = a==null?headB:a.next;
            b = b==null?headA:b.next;
        }
        return a;

        //方法二、简单的遍历查找
        /*if(headA==null || headB==null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        Set<ListNode> set = new HashSet<>();
        while (a!=null){
            set.add(a);
            a = a.next;
        }
        while (b!=null){
            if(set.contains(b)){
                break;
            }
            b = b.next;
        }
        return b;*/
    }


    @Override
    public void run(Object... args) {

    }
}
