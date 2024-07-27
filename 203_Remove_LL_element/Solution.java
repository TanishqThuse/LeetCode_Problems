//WHat is the difference between the below code and my code below it??

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = null;
        ListNode temp2 = head;

        while(temp2 != null){
            if(temp2.val == val){ // Value found
                if(temp == null){ // If value found at 1st position
                    if(head.next == null){  // And the linked list contains only 1 element i.e val
                        return null; // return empty linked list
                    }
                    head = head.next; // More than 1 element in LL
                    temp2 = head; // Deleting the head node.
                }
                else if(temp2.next == null){ // If the element is the last element
                    temp.next = null; // delete that node
                    break;  // break the loop
                }
                else{
                    temp2 = temp2.next; // Neither the first element, nor the last element
                    temp.next = temp2; // Just delete the element
                }
            }
            else{
                temp = temp2; // Element not found, jumping to next node
                temp2 = temp.next;
            }
            
        }
        return head; // Returning the head
    }
}

// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode removeElements(ListNode head, int val) {
//         ListNode newHead = head;
//         ListNode temp = null;
//         while(newHead.next != null){
//             if(newHead.val == val){
//                 if(temp==null){
//                     //I missed cases with these values
//                     if(head.next == null){
//                         return null;
//                     }
//                     head = head.next;
//                     newHead = head;
//                 }
//                 else{
//                     if(newHead.next == null){
//                         temp.next = null;
//                         break;
//                     }
//                     newHead = newHead.next;
//                     temp.next = newHead;
//                 }
//             }
//             else{
//                 temp = newHead;
//                 newHead = newHead.next;
//             }
            
            
//         }
//         return newHead;
//     }
// }
