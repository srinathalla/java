package com.sri.algo.string.leet;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

	public int numUniqueEmails(String[] emails) {

		Set<String> set = new HashSet<>();

		for (String mail : emails) {
			int sepIdx = mail.indexOf('@');
			String l = mail.substring(0, sepIdx);
			l = l.replace(".", "");

			if (l.indexOf('+') > 0) {
				l = l.substring(0, l.indexOf('+'));
			}

			set.add(l + mail.substring(sepIdx));

		}

		return set.size();

	}
	
	public static void main(String[] args) {
		
		UniqueEmailAddress ue = new UniqueEmailAddress();
		String[] mails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		
		System.out.println(ue.numUniqueEmails(mails));
		
	}

}
