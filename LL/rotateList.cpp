/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
*/

ListNode* rotateRight(ListNode* head, int k) {
        if(!head)
            return head;
        
        ListNode* temp = head;
        int len=1;
        while(temp->next!=NULL)
        {
            temp=temp->next;
            len++;
        }
        if(k>len)
            k=k%len;
        
        k=len-k;
        
        if(k==0)
            return head;
        
        ListNode* curr= head;
        int count=1;
        while(count<k && curr!=NULL)
        {
            curr=curr->next;
            count++;
        }
        if(curr==NULL)
            return head;
        
        ListNode* temp1= curr;
        temp->next=head;
        head=temp1->next;
        temp1->next=NULL;
        
        return head;
    }