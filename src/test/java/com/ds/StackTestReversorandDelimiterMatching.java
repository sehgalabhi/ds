package com.ds;

import java.beans.FeatureDescriptor;

public class StackTestReversorandDelimiterMatching {

	public static void main(String[] args) throws Exception {
		StackReversorAndDelimiterMatching stack = new StackReversorAndDelimiterMatching(30);

		
		//reversing a word
		
		String word = "Ayaansh is a good boy";
		
		StringBuffer reversedString  = new StringBuffer();
		
		for (int i = 0; i < word.toCharArray().length; i++) {
			stack.push(word.charAt(i));
			
		}
		
		while(stack.size() >0){
			reversedString.append(stack.pop());
		}
		
		System.out.println(reversedString.toString());
		
		String limiterSring = "a{b(c}d}e";	
		
		for (int i = 0; i < limiterSring.length(); i++) {
			char character = limiterSring.charAt(i);
			switch(character){
			case '{':
			case '[':
			case '(':
				stack.push(character);
				break;
			case '}':
			case ']':
			case ')':
				char chx = stack.pop();
				if((character=='}' && chx!='{') ||
						(character==']' && chx!='[') ||
						(character==')' && chx!='(')){
					System.out.println(character);
					throw new Exception();
				}
				break;
			default:
				break;
			}
			
		}
		
	}
	
}
