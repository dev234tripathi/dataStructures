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