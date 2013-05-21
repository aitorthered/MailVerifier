package es.csd.day2;

import java.util.HashSet;
import java.util.Set;

public class MailList {

	public Set<String> getMails(String mailList) {

		Set<String> mailsSet = new HashSet<String>();
		String[] mails = mailList.split(",");
		MailVerifier myMailVerifier = new MailVerifier();
		for (String mail : mails) {
			if (myMailVerifier.isValidEmailAddress(mail.trim())) {
				mailsSet.add(mail.trim());
			}
		}

		return mailsSet;

	}
}
