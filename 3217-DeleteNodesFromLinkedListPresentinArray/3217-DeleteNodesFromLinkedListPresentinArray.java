class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Put array in HashSet for O(1) access
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode front = head;
        ListNode back = dummy;

        while (front != null) {
            if (set.contains(front.val)) {
                // Remove the node
                back.next = front.next;
            }
            else {
                // Move the back pointer only if we don't remove the node
                back = front;
            }
            // Move the front pointer forward
            front = back.next;
        }

        return dummy.next;
    }
}
