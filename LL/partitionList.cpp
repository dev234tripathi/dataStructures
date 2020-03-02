/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
*/

ListNode* partition(ListNode* head, int x) {
        ListNode *head1=new ListNode(0);
        ListNode *head2=new ListNode(0);
        ListNode *h1 = head1;
        ListNode *h2 = head2;
        while(head)
        {
            if(head->val <x)
            {
                head1->next = head;
                head1 = head1->next;
            }
            else
            {
                head2->next = head;
                head2 = head2->next;
            }
            head = head->next;
        }
        head2->next = NULL;
        head1->next = h2->next;
        return h1->next;
    }