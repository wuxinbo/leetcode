/**
 * @author wuxinbo
 * @version 1.0
 * @since 2019/7/17
 */
public class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode (int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(0);
        ListNode currentL1Node = l1;
        ListNode currentL2Node = l2;
        int carry =0;
        //计算出来的结果
        ListNode current = resultNode;
        while (currentL1Node != null ||currentL2Node!=null) {
            currentL1Node =currentL1Node==null?new ListNode(0):currentL1Node;
            currentL2Node =currentL2Node==null?new ListNode(0):currentL2Node;
            if (current.next==null){
                current.next =new ListNode(0);
            }
            int result = current.next.val+currentL1Node.val + currentL2Node.val;
            carry =result/10;
            current.next = new ListNode(result%10);
            current =current.next;
            if (carry==1){
                if (current.next==null){
                    current.next =new ListNode(carry);
                }
            }
            currentL1Node =currentL1Node.next;
            currentL2Node =currentL2Node.next;
        }
        return resultNode.next;
    }

    public static void main (String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}


