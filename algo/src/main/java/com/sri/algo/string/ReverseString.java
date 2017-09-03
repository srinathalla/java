package com.sri.algo.string;

public class ReverseString {

	public String reverse(String str) {
		String[] words = str.split("\\.");

		StringBuilder strBuilder = new StringBuilder();
		for (int index = words.length -1; index >= 0; index--) {
			strBuilder.append(words[index]);
			if (index != 0) {
				strBuilder.append('.');
			}
		}
		return strBuilder.toString();
	}
	
	
	public static void main(String[] args) {
		
		ReverseString rs = new ReverseString();
		
		System.out.println(rs.reverse("i.like.this.program.very.much"));
		
	}

}
