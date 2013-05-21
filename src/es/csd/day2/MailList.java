package es.csd.day2;

import java.util.HashSet;
import java.util.Set;

public class MailList {

	public Set<String> getMails(String mailList) {

		return separateMails(mailList);
	}

	private Set<String> separateMails(String mailList) {

		Set<String> mailsSet = new HashSet<String>();
		String[] mails = mailList.split(",");

		for (String mail : mails) {
			mailsSet.add(mail);
		}

		return mailsSet;

	}
}
