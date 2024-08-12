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
//  Time complexity is O(n) where n is nodes since we traverse till fast reaches n O(n/2) = O(n)
// Space = O(1) since we use two ListNodes irrespective of n
class Solution {
    public ListNode middleNode(ListNode head) {
        //We will use two pointer method (tortoise and heir method)
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;






    }
}
        // ListNode slow = head;
        // ListNode fast = head;
        // //Since the fast pointer is moving twice the speed the slow pointer when the fast or it's next is null , the slow is pointeing at middle
        // while(fast!=null && fast.next!=null){
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }
        // return slow;