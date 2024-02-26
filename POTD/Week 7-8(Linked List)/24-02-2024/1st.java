/**
 * Link - https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 25. Reverse Nodes in k-Group
Solved
Hard
Topics
Companies
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 

Follow-up: Can you solve the problem in O(1) extra memory space?
 */

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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            ListNode kthNode = getKthNode(temp,k);
            if(kthNode==null){
                if(prev!=null)
                    prev.next = temp;
                break;
            }
            ListNode next = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            if(head==temp){
                head = kthNode;
            }
            else{
                prev.next = kthNode;
            }
            prev = temp;
            temp=next;
        }
        return head;
    }

    ListNode getKthNode(ListNode head, int k){
        while(head!=null && k-- > 1){
            head=head.next;
        }
        return head;
    }

    ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}