/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Determine if there's a cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {
                // Phase 2: Find the start of the cycle
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        // No cycle found
        return null;
    }
}



//However this solution is not at all optimla the optimal solution is above floyed alorithm : (up)
// /**
//  * Definition for singly-linked list.
//  * class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) {
//  *         val = x;
//  *         next = null;
//  *     }
//  * }
//  */
// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         // ListNode dummy = new ListNode(0);
//         // dummy.next = head; //i dont think we need dummy
        
//         //i have gotta make sure the list is empty, now i have to creata a list and add elements in it uptil we get any repeated index and return repeated index or return null
//         ListNode q = head;
//         List<ListNode> list = new ArrayList<>(); 
//         while(q!=null){

//             if(list.contains(q)){
//                 return q;
//             }
//             else{
//                 list.add(q);
//             }

//             q = q.next;
//         }

//         //Holp up real quick i didn't read the question carefully
//         // ListNode fast = head;
//         // ListNode slow = head;

//         // if(head == null){
//         //     return head;
//         // }

//         // while(fast!=null && fast.next!=null){




//         //     fast = fast.next.next;
//         //     slow = slow.next;

//         //     if(fast == slow){
//         //         return fast;
//         //     }
//         // }

//         return null;
//     }
// }
