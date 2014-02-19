public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // Start typing your Java solution below
            // DO NOT write main() function
            ListNode temp = new ListNode(0);
            ListNode prev = temp;
            
            while(l1!=null && l2!=null){
                if(l1.val>l2.val){
                    prev.next=l2;
                    l2=l2.next;
                }else{
                    prev.next=l1;
                    l1=l1.next;
                }
                prev=prev.next;
            }
            if(l1!=null) prev.next=l1;
            else if(l2!=null) prev.next=l2;
            return temp.next;
        }
}
