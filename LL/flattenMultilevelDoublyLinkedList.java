/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
   public Node flatten(Node head) {
        if(head == null) return head;
        Stack<Node> st = new Stack<>();
        Node curr = head;
        while(true){
            if(curr.next != null)
                st.push(curr.next);
            if(curr.child != null){
                st.push(curr.child);
                curr.child = null;
            }
            if(st.size() == 0)
                break;
            curr.next = st.pop();
            curr.next.prev = curr;
            curr = curr.next;
        }
        return head;
    }
}



/**
Initial State
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL
			 
Stack[]


Step 1: 

 1---2---3
         |
         7---8---9---10--NULL
             |
             11--12--NULL
			 
Stack[4---5---6--NULL]


Step 2:

 1---2---3
         |
         7---8
             |
             11--12--NULL
			 
			 
Stack[4---5---6--NULL, 9---10--NULL]



Step 3:

1---2---3---7---8---11---12---9---10---NULL


Stack[4---5---6--NULL]



Step 4: 

1---2---3---7---8---11---12---9---10---4---5---6---NULL


Stack[]
*/