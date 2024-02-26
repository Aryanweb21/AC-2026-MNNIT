/**
 * Link - https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/
 * 2816. Double a Number Represented as a Linked List
Solved
Medium
Topics
Companies
Hint
You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.

Return the head of the linked list after doubling it.

 

Example 1:


Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.
Example 2:


Input: head = [9,9,9]
Output: [1,9,9,8]
Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998. 
 

Constraints:

The number of nodes in the list is in the range [1, 104]
0 <= Node.val <= 9
The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.
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
    //APPROACH 1

    // public ListNode doubleIt(ListNode head) {
    //     Stack<Integer> stack1 = new Stack<>();
    //     Stack<Integer> stack2 = new Stack<>();
    //     ListNode dummy = new ListNode(0);
    //     ListNode dummyHead = dummy;
    //     while(head!=null){
    //         stack1.push(head.val);
    //         head=head.next;
    //     }
    //     int carry=0;
    //     while(!stack1.isEmpty() || carry!=0){
    //         int mul = carry;
    //         if(!stack1.isEmpty())
    //             mul+=stack1.pop()*2;
    //         carry = mul/10;
    //         mul%=10;
    //         stack2.push(mul);
    //     }
    //     while(!stack2.isEmpty()){
    //         dummy.next = new ListNode(stack2.pop());
    //         dummy = dummy.next;
    //     }
    //     return dummyHead.next;
    // }

    //APPROACH 2
    
    public ListNode doubleIt(ListNode head){
        head = reverse(head);
        ListNode dummy = new ListNode(0);
        ListNode dummyHead = dummy;
        int carry = 0;
        while(head!=null || carry!=0){
            int mul = carry;
            if(head!=null){
                mul+=head.val*2;
                head = head.next;
            }
            carry = mul/10;
            mul%=10;
            dummy.next = new ListNode(mul);
            dummy = dummy.next;
        }
        dummyHead.next = reverse(dummyHead.next);
        return dummyHead.next;
    }

    ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode revHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return revHead;
    }
}