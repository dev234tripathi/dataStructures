/*
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.
*/


int getDecimalValue(ListNode* head) {
        int res = 0;
        while(head)
        {
            res <<= 1;
            res |= head->val;
            head = head->next;
        }
        return res;
    }