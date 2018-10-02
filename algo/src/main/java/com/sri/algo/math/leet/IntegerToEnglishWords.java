package com.sri.algo.math.leet;

public class IntegerToEnglishWords {

	private final String[] LESS_THAN_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };
	private final String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };
	private final String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

	public String numberToWordsLeetSolution(int num) {

		if (num == 0) {
			return "Zero";
		}

		int i = 0;
		StringBuilder builder = new StringBuilder();

		while (num > 0) {
			if (num % 1000 != 0) {

				StringBuilder sb = new StringBuilder();
				helper(num % 1000, sb);

				sb.append(THOUSANDS[i]).append(" ").append(builder);

				builder.setLength(0);
				builder.append(sb);
			}

			num = num / 1000;
			i++;
		}

		return builder.toString().trim();
	}

	private void helper(int num, StringBuilder builder) {

		if (num == 0) {
			return;
		}

		if (num < 20) {
			builder.append(LESS_THAN_20[num]).append(" ");
		}

		else if (num < 100) {
			builder.append(TENS[num / 10]).append(" ");
			helper(num % 10, builder);
		} else {
			builder.append(LESS_THAN_20[num / 100]).append(" ").append("Hundred").append(" ");
			helper(num % 100, builder);
		}

		return;
	}

	public String numberToWords(int num) {

		if (num == 0) {
			return "Zero";
		}

		StringBuilder sb = new StringBuilder();
		int i = 0;

		// Bring the number to less than 1000.
		while (num > 0) {

			if (num % 1000 != 0) {
				StringBuilder sbr = new StringBuilder();
				lessThanThousand(num % 1000, sbr);
				sbr.append(THOUSANDS[i]).append(' ').append(sb);
				sb = sbr;
			}

			num /= 1000;
			i++;

		}

		return sb.toString().trim();
	}

	private void lessThanThousand(int num, StringBuilder sb) {

		while (num > 0) {
			if (num < 20) {
				sb.append(LESS_THAN_20[num]).append(' ');
				break;
			}

			else if (num < 100) {
				sb.append(TENS[num / 10]).append(' ');
				num = num % 10;
			}

			else if (num < 1000) {
				sb.append(LESS_THAN_20[num / 100]).append(' ').append("Hundred").append(' ');
				num = num % 100;
			}
		}

	}

	public static void main(String[] args) {

		IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();

		System.out.println(integerToEnglishWords.numberToWords(100));

		System.out.println(integerToEnglishWords.numberToWords(999));

		System.out.println(integerToEnglishWords.numberToWords(9));

		System.out.println(integerToEnglishWords.numberToWords(19));

		System.out.println(integerToEnglishWords.numberToWords(89));

		System.out.println(integerToEnglishWords.numberToWords(10009));

		System.out.println(integerToEnglishWords.numberToWords(100009));

		System.out.println(integerToEnglishWords.numberToWords(0));

		System.out.println(integerToEnglishWords.numberToWords(1000000));
		System.out.println(integerToEnglishWords.numberToWords(1000000000));

	}

}
