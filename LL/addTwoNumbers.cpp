/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.


*/



ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
      if (l1 == NULL and l2 == NULL) return NULL;
			else if (l1 == NULL) return l2; 
			else if (l2 == NULL) return l1; 

			int a = l1->val + l2->val;
			ListNode *temp = new ListNode(a % 10);
			temp->next = addTwoNumbers(l1->next,l2->next);
			if (a >= 10) temp->next = addTwoNumbers(temp->next, new ListNode(1));
			return temp;
    }