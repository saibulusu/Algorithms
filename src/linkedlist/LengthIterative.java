package linkedlist;

import org.junit.Test;

public class LengthIterative {
	
	//doubly linked list
	public class ListNode {
		private int data;
		private ListNode next;
		private ListNode prev;
		
		public ListNode(){
			
		}
		
		public ListNode(int data){
			this.data = data;
		}
	}
	
	//find the length to the end of a linked list from a given node
	public int length(ListNode a){
		//set the current node to the given node
		ListNode current = a;
		//set count to 0
		int count = 0;
		//while the current node is not null, increment count and set current to the next node
		while(current != null){
			count++;
			current = current.next;
		}
		return count;
	}
	
	@Test
	public void test(){
		ListNode a = new ListNode();
		ListNode b = new ListNode();
		ListNode c = new ListNode();
		
		a.next = b;
		b.next = c;
		c.prev = b;
		b.prev = a;
		
		assert(a.next.next == c);
		assert(c.prev.prev == a);
		assert(length(a) == 3);
		assert(length(b) == 2);
		assert(length(c) == 1);
		
		
		ListNode alpha = new ListNode();
		ListNode beta = new ListNode();
		
		alpha.next = beta;
		assert(length(alpha) == 2);
		assert(length(beta) == 1);
		
		alpha.next = null;
		beta.prev = alpha;
		assert(length(alpha) == 1);
		assert(length(beta) == 1);
	}
}










