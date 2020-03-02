/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
*/

 ListNode* deleteDuplicates(ListNode* head) {
       ListNode *cur = head;
    while (cur && cur->next) {
        if (cur->val == cur->next->val)
        {
            ListNode* temp = cur->next;
            cur->next = cur->next->next;
            delete temp;        
        }
        else
            cur = cur->next;
    }
    return head;
    }