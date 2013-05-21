import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
		assertEquals(1, mySet.size());
	}
}
