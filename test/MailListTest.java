import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import es.csd.day2.MailList;

public class MailListTest {
	MailList myMailList = new MailList();

	// ,mail@erroneo@punto.com,"

	@Test
	public void testReturnSetOfStrings() {
		assertNotNull(myMailList.getMails(""));
	}

	@Test
	public void testCheckMailSeparatedByComas() throws Exception {
		Set<String> mySet = myMailList
				.getMails("mail@primero.com,mail@segundo.com,"
						+ "mail@este.estabien.com");
		assertEquals(3, mySet.size());
		mySet = myMailList.getMails("mail@primero.com mail@segundo.com;"
				+ "mail@este.estabien.com");
		assertEquals(0, mySet.size());
	}

	@Test
	public void testCheckMailSeparatedByComasWithWhiteSpaces() throws Exception {
		Set<String> mySet = myMailList
				.getMails(" mail@primero.com ,mail@segundo.com ,"
						+ " mail@este.estabien.com ");
		assertEquals(3, mySet.size());
		assertTrue(mySet.contains("mail@primero.com"));
		assertFalse(mySet.contains(" mail@primero.com "));

	}

	@Test
	public void testCheckOnlyVerifiedMailsOnSet() throws Exception {
		Set<String> mySet = myMailList
				.getMails("mail@primero.com,mail@segundocom,"
						+ "mail@este@.estabien.com");
		assertTrue(mySet.contains("mail@primero.com"));
		assertEquals(1, mySet.size());
		assertFalse(mySet.contains("mail@segundocom"));
		assertFalse(mySet.contains("mail@este@.estabien.com"));

	}

	@Test
	public void testNotDuplicatedEmails() throws Exception {
		Set<String> mySet = myMailList
				.getMails(" mail@primero.com ,mail@segundo.com ,"
						+ " mail@este.estabien.com, mail@primero.com ,mail@segundo.com ,"
						+ " mail@este.estabien.com ");
		assertEquals(3, mySet.size());

	}
}
