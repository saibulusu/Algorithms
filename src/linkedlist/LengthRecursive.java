package linkedlist;

import org.junit.Test;

import linkedlist.LengthIterative.ListNode;

public class LengthRecursive {
	
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
	
	
	//length of a Linked List recursively
	public int length(ListNode a){
		
		if(a == null){
			//base case: if the current node is null, then return 0
			return 0;
		} else {
			//recursive: return 1 + length called on everything after the current node
			return length(a.next) + 1;
		}
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
