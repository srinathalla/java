package com.sri.algo.dp.leet.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumDistanceToTypeAWord {

	private Map<Character, int[]> keyboard = new HashMap<>();
	private String word = null;
	private Map<State, Integer> memo = new HashMap<>();

	public int minimumDistance(String word) {
		this.word = word;
		
		
		for(int i=0; i< 26;i++)
		{
			char ch = (char)(65 + i);
			keyboard.put(ch,new int[] {i/6, i %6});
		}
		
		return helper(0,null,null);

	}

	private int dist(Character c1, Character c2) {
		if (c1 == null) {
			return 0;
		}
		int[] c1p = keyboard.get(c1);
		int[] c2p = keyboard.get(c2);

		return Math.abs(c1p[0] - c2p[0]) + Math.abs(c1p[1] - c2p[1]);
	}

	private int helper(int i, Character f1, Character f2) {
		if (i == word.length()) {
			return 0;
		}
		
		State state = new State(i,f1,f2);
		if(memo.containsKey(state))
		{
			return memo.get(state);
		}

		int choice1 = dist(f1, word.charAt(i)) + helper(i + 1, word.charAt(i), f2);
		int choice2 = dist(f2, word.charAt(i)) + helper(i + 1, f1, word.charAt(i));
		memo.put(state, Math.min(choice1, choice2));

		return memo.get(state);

	}

	private static class State {
		int pos;
		Character f1;
		Character f2;

		public State(int pos, Character f1, Character f2) {
			super();
			this.pos = pos;
			this.f1 = f1;
			this.f2 = f2;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((f1 == null) ? 0 : f1.hashCode());
			result = prime * result + ((f2 == null) ? 0 : f2.hashCode());
			result = prime * result + pos;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			State other = (State) obj;
			if (f1 == null) {
				if (other.f1 != null)
					return false;
			} else if (!f1.equals(other.f1))
				return false;
			if (f2 == null) {
				if (other.f2 != null)
					return false;
			} else if (!f2.equals(other.f2))
				return false;
			if (pos != other.pos)
				return false;
			return true;
		}

	}
	
	public static void main(String[] args) {
		
		MinimumDistanceToTypeAWord minimumDistanceToTypeAWord = new MinimumDistanceToTypeAWord();
		System.out.println(
			minimumDistanceToTypeAWord.minimumDistance("CAKE"));
		
	}

}
