/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        
        ListNode forward = temp; //the ahead pointer
        ListNode backward = temp;

        /**IMP: I forgot to handle edge cases when testing, for that we will check beforehand */
        
        /**Logic is to traverse the forward pointer by n nodes and then stop
        Then traverse both forward pointers until forward!=null as then the backward node points to the nth node(from back) now simple delete the next node*/
        for(int i=0; i<=n; i++){
            forward = forward.next;
        }


        //now forward is at nthh node, let's move both nodes now
        while(forward!=null){
            forward = forward.next;
            backward = backward.next;
        }
        
        backward.next = backward.next.next;
        return temp.next;

    }
}