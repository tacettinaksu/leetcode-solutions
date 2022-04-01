import java.util.Stack;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
		ListNode temp=head;
		int size = 0;
		while(temp!=null){
			size++;
			temp=temp.next;
		}

		Stack<ListNode> stack = new Stack<>();

		for (int i = 0; i < size/2; i++) {
			stack.push(head);
			head=head.next;
		}
		if(size%2 ==1){
			head=head.next;
		}

		while(head!=null){
			ListNode l = stack.pop();
			if(l.val != head.val){
				return false;
			}
			head=head.next;
		}
		return true;
    }
	class ListNode {
		int val;
		ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
   }
}