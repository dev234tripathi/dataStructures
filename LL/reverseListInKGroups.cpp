/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/

 ListNode* reverseKGroup(ListNode* head, int k) {
        // if NULL
        if (head == NULL) return NULL;
        
        // if less than k nodes
        ListNode *p = head;
        for (int i = 1; i < k; ++i) {
            p = p->next;
            if (p == NULL) return head;
        }
        
        // reverse first k nodes
        ListNode *oldHead = head;
        for (int i = 1; i < k; ++i) {
            p = oldHead->next;
            if (p == NULL) return oldHead;
            oldHead->next = p->next;
            p->next = head;
            head = p;
        }
        
        // reverse remaining nodes
        oldHead->next = reverseKGroup(oldHead->next, k);
        
        return head;  }