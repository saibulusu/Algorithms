package Strings;

import java.util.Stack;

import org.junit.Test;

public class ReverseWords {

	//Reverse the words in a sentence
	public static String reverse(String sentence){
		//Create a stack to hold every word in the sentence
		Stack<String> stack = new Stack<String>();
		//the previous index of the last word
		int last = 0;
		//iterate through the whole sentence
		for(int i = 0; i < sentence.length(); i++){
			//if the current character is a space
			if(sentence.charAt(i) == ' '){
				//push on everything from last to the current index
				stack.push(sentence.substring(last, i).trim());
				//update last
				last = i;
				//if the current index is the last character in the sentence
				//no spaces will follow - this is an edge case
			} else if(i == sentence.length() - 1){
				//just push everything from the last index to this current index
				stack.push(sentence.substring(last).trim());
			}
		}
		
		//set output, which pulls from the stack
		//pushing into a stack and then popping reverses the order
		String output = "";
		//while the stack is not empty, keep popping elements of the top of the stack
		while(!stack.isEmpty()){
			output += stack.pop() + " ";
		}
		//remove leading and following spaces
		output = output.trim();
		return output;
	}
	
	@Test
	public void test(){
		String a = "Hello world";
		a = reverse(a);
		
		assert(a.equals("world Hello"));
		
		String b = "Really makes you think";
		b = reverse(b);
		
		assert(b.equals("think you makes Really"));
		
		String c = "programming is great";
		c = reverse(c);
		
		assert(c.equals("great is programming"));
	}
	
}
