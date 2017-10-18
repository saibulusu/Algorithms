package stacks;

import java.util.Stack;

import org.junit.Test;

public class ReverseStack {

	//Reverse a satck of any type
	public static <T> Stack<T> reverse(Stack<T> stack){
		//place everything into a first copy stack, removing all elements from stack
		Stack<T> first = new Stack<T>();
		while(!stack.isEmpty()){
			first.push(stack.pop());
		}
		//these elements appear in reverse order
		
		//place everything into a second copy stack, removing all elements from first
		Stack<T> second = new Stack<T>();
		while(!first.isEmpty()){
			second.push(first.pop());
		}
		//these elements appear in the same order as they do in stack
		
		//place everything into the original stack from second, which will make it in reverse order
		while(!second.isEmpty()){
			stack.push(second.pop());
		}
		return stack;
	}
	
	@Test
	public void test(){
		Stack<Integer> a = new Stack<Integer>();
		a.push(0);
		a.push(1);
		a.push(2);
		a.push(3);
		
		reverse(a);	
		
		assert(a.peek() == 0);
		a.pop();
		assert(a.peek() == 1);
		a.pop();
		assert(a.peek() == 2);
		a.pop();
		assert(a.peek() == 3);
		a.pop();
		assert(a.isEmpty());
	
		
		Stack<String> b = new Stack<String>();
		b.push("");
		b.push("hello");
		b.push("Hello, World!");
		b.push("Programming in Java is great");
		
		reverse(b);		
		
		assert(b.peek() == "");
		b.pop();
		assert(b.peek() == "hello");
		b.pop();
		assert(b.peek() == "Hello, World!");
		b.pop();
		assert(b.peek() == "Programming in Java is great");
		b.pop();
		assert(b.isEmpty());
	}
	
}























