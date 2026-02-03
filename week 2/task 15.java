class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode currentnode,nextnode,prevnode;
        prevnode=null;
        nextnode=null;
        currentnode=head;
        while(currentnode!=null){
            nextnode=currentnode.next;
            currentnode.next=prevnode;
            prevnode=currentnode;
            currentnode=nextnode;
        }
        return  prevnode;
        
    }
}
