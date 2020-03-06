package com.sri.algo.string.leet;

public class LicenseKeyFormatting {

	public String licenseKeyFormatting(String S, int K) {

		S = S.toUpperCase().replace("-", "");

		StringBuilder sb = new StringBuilder();
		int k = 0;
		for (int i = S.length() - 1; i >= 0; i--) {
			sb.insert(0, S.charAt(i));
			if (++k % K == 0) {
				sb.insert(0, '-');
			}
		}
		
		if(sb.length() > 0 && sb.charAt(0) == '-')
		{
			sb.deleteCharAt(0);
		}

		return sb.toString();

	}
	
	public static void main(String[] args) {
		
		LicenseKeyFormatting lkf = new LicenseKeyFormatting();
		System.out.println(
				lkf.licenseKeyFormatting("5F3Z-2e-9-w", 4));
		
	}

}
