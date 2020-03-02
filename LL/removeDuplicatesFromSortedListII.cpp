/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
*/

 ListNode* deleteDuplicates(ListNode* head) {
      if(!head || !head->next)
      {
        return head;  
      }
        while(head && head->next && head->val==head->next->val)
        {
            int temp = head->val;
            head=head->next->next;
            while(head && head->val==temp)
            {
                head= head->next;
            }
        }
        if (head)
            head->next = deleteDuplicates(head->next);
        return head;
    }