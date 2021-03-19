package linkedlist;

public class Sword02_ReversePrintLinkedList {
    public int[] reversePrint(ListNode head) {
        // 获取链表的长度
        int headLength=0;
        ListNode headNode=head;

        while(headNode!=null){
            headLength++;
            headNode=headNode.next;
        }

        // 根据链表长度进行创建数组
        int[] a=new int[headLength];
        int index=0;
        // 对数组反向赋值
        while(head!=null){
            a[headLength-1-index]=head.val;
            index++;
            head=head.next;
        }
        return a;
    }
}
