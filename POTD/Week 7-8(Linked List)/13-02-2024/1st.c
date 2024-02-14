/*
    Link - https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
    19. Remove Nth Node From End of List
Solved
Medium
Topics
Companies
Hint
Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 

Follow up: Could you do this in one pass?
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
int countNodes(struct ListNode* head){
    int count=0;
    while(head){
        count++;
        head=head->next;
    }
    return count;
}

struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    if(head->next==NULL){
        head = NULL;
        return head;
    }
    int size = countNodes(head);
    int idx = size-n;
    if(idx==0){
        head = head->next;
        return head;
    }
    int i=0;
    struct ListNode* temp = head;
    while(i!=idx-1){
        temp=temp->next;
        i++;
    }
    temp->next = temp->next->next;
    return head;
}