/*
Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.
*/

 int getLength(ListNode* head) {
        int count = 0;
        if(head==NULL) {
            return 0;
        }
        else
        {
            while(head!=NULL) {
                count++;
                head = head->next;
            }
        }
        return count;
    }
    ListNode* middleNode(ListNode* head) {
        int len = getLength(head);
        if(len == 0) {
            return NULL;
        }
        else if(len==1) {
            return head;
        }
        else {
            ListNode* temp = head;
            for(int i=0;i<len/2;i++) {
                temp = temp->next;
            }
            return temp;
        }
    }