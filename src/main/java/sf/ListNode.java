package sf;

public class ListNode{
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode next = this.next;
        String s = "->";
        StringBuilder builder = new StringBuilder("["+val+"]" + s);
        while (next!=null){
            builder.append("[").append(next.val).append("]").append(s);
            next=next.next;
        }
        return builder.toString();
    }
}