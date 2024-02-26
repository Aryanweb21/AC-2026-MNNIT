/**
 * Link - https://www.geeksforgeeks.org/problems/subtraction-in-linked-list/1
 * Subtraction in Linked List
HardAccuracy: 12.94%Submissions: 73K+Points: 8
Internship Alert!
Become an SDE Intern by topping this monthly leaderboard! 

banner
You are given two linked lists that represent two large positive numbers. From the two numbers represented by the linked lists, subtract the smaller number from the larger one. Look at the examples to get a better understanding of the task.

Example 1:

Input:
L1 = 1->0->0
L2 = 1->2
Output: 88
Explanation:  
First linked list represents 100 and the
second one represents 12. 12 subtracted from 100
gives us 88 as the result. It is represented
as 8->8 in the linked list.
Example 2:

Input:
L1 = 0->0->6->3
L2 = 7->1->0
Output: 647
Explanation: 
First linked list represents 0063 => 63 and 
the second one represents 710. 63 subtracted 
from 710 gives us 647 as the result. It is
represented as 6->4->7 in the linked list.
Your Task:
You do not have to take any input or print anything. The task is to complete the function subLinkedList() that takes heads of two linked lists as input parameters and which should subtract the smaller number from the larger one represented by the given linked lists and return the head of the linked list representing the result.

n and m are the length of the two linked lists respectively.
Expected Time Complexity:  O(n+m)
Expected Auxiliary Space: O(n+m)

Constraints:
1 <= n <= 10000
0 <= values represented by the linked lists < 10n
0 <= values represented by the linked lists < 10m
 */

class Solution {
    public Node subLinkedList(Node head1, Node head2) {
        // code here
        Node dummy = new Node(0);
        Node dummyHead=dummy;
        while(head1!=null && head1.data == 0)
            head1=head1.next;
        while(head2!=null && head2.data==0)
            head2 = head2.next;
        if(head1==null && head2==null)
            return dummyHead;
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
            
        Node grt=head1,less=head2;
        int l1 = countNodes(head1);
        int l2 = countNodes(head2);
        int greater = findGtr(head1,head2);
        if(l1<l2){
            grt = head2;
            less=head1;
        }
        else if(l1==l2){
            if(greater==2){
                grt = head2;
                less=head1;
            }
            else if(greater==0)
                return dummyHead;
        }
        grt = reverse(grt);
        less = reverse(less);

        while(less!=null){
            if(grt.data>=less.data){
                dummy.next = new Node(grt.data-less.data);
            }
            else{
                dummy.next = new Node(grt.data+10-less.data);
                Node next = grt.next;
                while(next.data==0){
                    next.data=9;
                    next = next.next;
                }
                next.data = next.data-1;
            }
            dummy = dummy.next;
            grt=grt.next;
            less=less.next;
        }
        while(grt!=null){
            dummy.next = new Node(grt.data);
            dummy = dummy.next;
            grt = grt.next;
        }
        
        dummyHead = reverse(dummyHead.next);
        while(dummyHead!=null && dummyHead.data==0)
            dummyHead=dummyHead.next;
        return dummyHead;
    }
    
    int findGtr(Node head1, Node head2){
        while(head1!=null && head2!=null){
            if(head1.data>head2.data)
                return 1;
            else if(head2.data>head1.data)
                return 2;
            head1=head1.next;
            head2 = head2.next;
        }
        return 0;
    }
    
    Node reverse(Node head) {
    Node prev = null;
    Node current = head;
    Node next = null;
    while (current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    head = prev;
    return head;
}

    
    int countNodes(Node head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
}