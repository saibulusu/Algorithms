package linkedlist;

import org.junit.Test;

public class Deletion {
	
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

	//delete a certain node in a linked list
	public void delete(ListNode a, int index) throws Exception{
		//the current node
		ListNode current = a;
		//edge case: if the desired removable index is 0, then just set the next node to the head
		if(index == 0){
			a.next.prev = null;
			a = null;
		}
		//iterate through the nodes
		for(int i = 0; i < index; i++){
			//if the current node is null, throw an exception, because the index was never reached
			if(current == null){
				throw new Exception();
			}
			if(i != index){
				//if the current index is not the target, then continue
				current = a.next;
			} else{
				//if the current index is the target, then remove it by changing next and prev
				current.next = a.next;
				a.next.prev = current;
				a = null;
				break;
			}
		}
	}
	
	@Test
	public void test() throws Exception{
		ListNode a = new ListNode();
		ListNode b = new ListNode();
		a.next = b;
		b.prev = a;
		ListNode c = new ListNode();
		b.next = c;
		c.prev = b;
		assert(c == a.next.next);
		delete(a, 0);
		assert(b.next == c);
		assert(c.prev == b);
		assert(b.prev == null);
		assert(c != null);
		assert(b != null);
		
		ListNode alpha = new ListNode();
		alpha.data = 100;
		ListNode beta = new ListNode();
		beta.data = 2;
		ListNode gamma = new ListNode();
		gamma.data = -4;
		alpha.next = beta;
		
	}
}







