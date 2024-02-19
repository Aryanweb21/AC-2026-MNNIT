/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/submissions/1179861753/
 * 82. Remove Duplicates from Sorted List II
Solved
Medium
Topics
Companies
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

 

Example 1:


Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            if(curr.next.val == curr.next.next.val){
                int var = curr.next.val;
                while(curr.next !=null && curr.next.val == var)
                    curr.next = curr.next.next;
            }
            else
                curr = curr.next;
        }
        return dummy.next;
    }
}
