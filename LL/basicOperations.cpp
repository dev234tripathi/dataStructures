#include <bits/stdc++.h>
using namespace std;
struct Node {
   int data;
   Node *next;
};
Node* insertAtFront(Node **head,int data) {
    Node* temp = new Node();
    temp->data = data;
    temp->next = *head;
    *head = temp;
}
Node* insertAfter(Node *prevNode,int data) {
    if(prevNode==NULL) {
        cout<<"Previous Node can not be NULL";
    }
    Node *temp = new Node();
    temp->data = data;
    temp->next = prevNode->next;
    prevNode->next = temp;
}
Node *insertAtEnd(Node **head,int data) {
    Node *temp = new Node();
    Node *tra = *head;
    temp->data = data;
    temp->next = nullptr;
    if(*head==NULL) {
        *head = temp;
        return NULL;
    }
    while(tra->next!=NULL) {
        tra = tra->next;
    }
    tra->next = temp;
}
void deleteNode(Node **head,int key) {
    if(*head == NULL) {
        cout<<"Nothing to delete";
    }
    Node *temp =  *head;
    Node *prev;
    while(temp->data!=key) {
        temp = temp->next;
        prev = temp;
    }
    prev->next = temp->next;
    delete(temp);
    
}
int getcount(Node *head) {
    Node *temp = head;
    int count = 0;
    while(temp!=NULL) {
        count++;
        temp = temp->next;
    }
    return count;
}
void swapNodes(Node **head,int x,int y) {
    if(x==y) {
        return;
    }
    Node **a = NULL, **b = NULL;
    while(*head) {
        if((*head)->data == x) {
            a = head;
        }
        else if((*head)->data == y) {
            b = head;
        }
        head = &((*head)->next);
    }
    if(a && b) {
        swap(*a,*b);
        swap((*a)->next,(*b)->next);
    }
}
void reverse(Node **head) {
    Node *curr = *head;
    Node *prev = NULL,*next = NULL;
    while(curr!=NULL) {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }
    *head = prev;
}
void swapNodesInPairs(Node *head) {
    Node *temp = head;
    if(temp!=NULL && temp->next!=NULL) {
        swap(temp->data,temp->next->data);
        swapNodesInPairs(temp->next->next);
    }
}
void printLL(Node* head) {
        while(head!=NULL) {
            cout<<head->data<<" ";
            head = head->next;
        }
}
int main() {
	// your code goes here
	Node *head = NULL;
	insertAtFront(&head,1);
	insertAtFront(&head,2);
	insertAtFront(&head,3);
	insertAfter(head->next,4);
	insertAtEnd(&head,5);
	printLL(head);
	cout<<endl;
	cout<<"Length of LL : "<<getcount(head)<<endl;
	deleteNode(&head,1);
	printLL(head);
	cout<<"\nLength of LL : "<<getcount(head)<<endl;
	swapNodes(&head,3,2);
	cout<<"After Swapping : ";
	printLL(head);
	cout<<"\nAfter Reversing : ";
	reverse(&head);
	printLL(head);
	cout<<endl;
	swapNodesInPairs(head);
	printLL(head);
	return 0;
}
