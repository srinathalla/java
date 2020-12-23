package com.sri.algo.array.leet.medium;

public class AlphabetBoardPath {

	int[] dist(char ch) {
		int no = ch - 'a';
		return new int[] { no / 5, no % 5 };
	}

	public String alphabetBoardPath(String t) {

		int cr = 0, cc = 0;
		StringBuilder res = new StringBuilder();

		for (char ch : t.toCharArray()) {
			int[] a = dist(ch);
			int nr = a[0], nc = a[1];

			if (cr == 5 && nr < 5) {
				res.append('U');
				cr -= 1;
			}

			while (cc < nc) {
				res.append('R');
				cc += 1;
			}

			while (cc > nc) {
				res.append('L');
				cc -= 1;
			}

			while (nr > cr) {
				res.append('D');
				cr += 1;
			}

			while (nr < cr) {
				res.append('U');
				cr -= 1;
			}

			res.append('!');
		}

		return res.toString();
	}
	
	public static void main(String[] args) {
		
		AlphabetBoardPath ab = new AlphabetBoardPath();
		System.out.println(
			ab.alphabetBoardPath("leet"));
		
	}

}
