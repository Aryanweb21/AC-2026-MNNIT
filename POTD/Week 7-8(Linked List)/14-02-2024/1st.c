/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode* dummy = (struct ListNode*)malloc(sizeof(struct ListNode));
    struct ListNode* ans = dummy;
    int carry = 0;
    while(l1 || l2 || carry!=0){
        int sum = carry;
        if(l1){
            sum+=l1->val;
            l1 = l1->next;
        }
        if(l2){
            sum+= l2->val;
            l2 = l2->next;
        }
        carry = sum/10;
        sum = sum%10;
        struct ListNode* newNode = (struct ListNode*)malloc(sizeof(struct ListNode));
        newNode->val = sum;
        newNode->next = NULL;
        ans->next = newNode;
        ans = ans->next;
    }
    return dummy->next;
}