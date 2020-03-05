public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode walker = head;
        ListNode runner = head;
        ListNode pre = null;
        while(runner!=null && runner.next!=null) {
            runner = runner.next.next; //move runner first, otherwise the next of the head will be already changed
            //reverse linked list
            ListNode nextWalker = walker.next;
            walker.next = pre;
            pre = walker;
            walker = nextWalker;
        }//after this the pre would be the head of our first half, while walker at the head of second half
        if(runner != null) { // odd number length
            walker = walker.next;    
        }
        while(pre!=null && walker!=null) {
            if(pre.val != walker.val) return false;
            pre = pre.next;
            walker = walker.next;
        }
        return true;
        
    }
}