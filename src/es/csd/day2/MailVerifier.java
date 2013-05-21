package es.csd.day2;

public class MailVerifier {

	public boolean isValidEmailAddress(String mail) {
		boolean isValid = false;
		if (hasOnlyOneAt(mail) && hasNotSpacesAndNotCommas(mail)) {
			isValid = true;
		}
		return isValid;
	}

	private boolean hasNotSpacesAndNotCommas(String mail) {
		return !mail.contains(" ") && !mail.contains(",");
	}

	private boolean hasOnlyOneAt(String mail) {
		if ((mail.split("@")).length != 2) {
			return false;
		}
		return true;
	}

}
