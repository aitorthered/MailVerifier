package es.csd.day2;

public class MailVerifier {

	public boolean isValidEmailAddress(String mail) {

		int positionOfAt = indexOfOnlyAt(mail);
		return positionOfAt != -1 && hasNotSpacesAndNotCommas(mail)
				&& dotAfterAt(mail.substring(positionOfAt));
	}

	private boolean dotAfterAt(String mailAfterAt) {
		return mailAfterAt.contains(".");
	}

	private boolean hasNotSpacesAndNotCommas(String mail) {
		return !mail.contains(" ") && !mail.contains(",");
	}

	/**
	 * Check if has only one at. Returns -1 if more than one or none were found.
	 * Returns position of the AT in case only one At is found
	 * 
	 * @param mail
	 * @return
	 */
	private int indexOfOnlyAt(String mail) {
		String[] splitStr = mail.split("@");
		if (splitStr.length != 2) {
			return -1;
		}
		return splitStr[0].length();
	}
}
