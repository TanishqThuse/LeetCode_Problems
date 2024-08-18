class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = head;
        ListNode prev = dummy;

        while (start != null) {
            if (numSet.contains(start.val)) {
                prev.next = start.next;
            } else {
                prev = start;
            }
            start = start.next;
        }

        return dummy.next;
    }
}




//Unnecedsary com[iocated]
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
//     public boolean isPresent(int val, int nums[]){
//         for(int i=0; i<nums.length; i++){
//             if(nums[i]==val){
//                 return true;
//             }
//         }
//         return false;
//     }

//     public ListNode modifiedList(int[] nums, ListNode head) {
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
//         ListNode start = head;
//         ListNode prev = dummy;
//         while(start!=null){
//             if(isPresent(start.val, nums)){
//                 prev.next = start.next;
//                 start=start.next;
//                 continue;
//             //  0,1
//             //  0->2 
//             //  
//             }
//             prev = start;
//             start = start.next;
//         }
//         return dummy.next;
//     }
// }