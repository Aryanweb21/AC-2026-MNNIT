/**
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 * 445. Add Two Numbers II
Solved
Medium
Topics
Companies
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 

Follow up: Could you solve it without reversing the input lists?
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
    // APPROACH 1
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> list1 = new Stack<>();
        Stack<Integer> list2 = new Stack<>();
        Stack<Integer> ansList = new Stack<>();
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        while(l1!=null){
            list1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            list2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        while(!list1.isEmpty() || !list2.isEmpty() || carry!=0){
            int sum = carry;
            if(!list1.isEmpty())
                sum+=list1.pop();
            if(!list2.isEmpty())
                sum+=list2.pop();
            carry = sum/10;
            sum = sum%10;
            ansList.push(sum);
        }
        while(!ansList.isEmpty()){
            ans.next = new ListNode(ansList.pop());
            ans = ans.next;
        }
        return dummy.next;
    }


    // APPROACH 2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        Stack<Integer> list1 = new Stack<>();
        Stack<Integer> list2 = new Stack<>();
        while(l1!=null){
            list1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            list2.push(l2.val);
            l2 = l2.next;
        }
        ListNode ans = null;
        int carry = 0;
        while(!list1.isEmpty() || !list2.isEmpty() || carry!=0){
            int sum = carry;
            if(!list1.isEmpty())
                sum+=list1.pop();
            if(!list2.isEmpty())
                sum+=list2.pop();
            carry = sum/10;
            sum = sum%10;
            ListNode newNode = new ListNode(sum);
            newNode.next = ans;
            ans = newNode;
        }
        return ans;
    }
}