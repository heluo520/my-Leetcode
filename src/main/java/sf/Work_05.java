package sf;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-10
 * @Description: 复制链表
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Work_05 {
    public static void main(String[] args) {
        //TODO
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = new Node(0);
        node3.random = new Node(4);
        node4.random = new Node(2);
        node5.random = new Node(0);

        Node node = copyRandomList(node1);



    }
    public static Node copyRandomList(Node head) {
        Node top = new Node(0);
        Node curTop = top;
        while (head!=null){
            Node node = new Node(head.val);
            Node oldRandom = head.random;
            if(oldRandom==null){
                node.random = null;
            }else{
                node.random = new Node(oldRandom.val);
            }
            curTop.next = node;
            curTop = curTop.next;
            head = head.next;
        }

        Node cur = top.next;
        while (cur!=null){
            Node oldRandom = cur.random;
            if(oldRandom==null){
                cur.random = null;
            }else{
                int val = oldRandom.val;
                Node temp = top.next;
                for (int i = 0; i < val; i++) {
                    temp = temp.next;
                }
                cur.random.random = temp;
            }
            cur = cur.next;
        }
        return top.next;
    }
}
