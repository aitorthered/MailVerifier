import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.csd.day2.MailVerifier;

public class VerificadorMailTest {

	final MailVerifier verificador = new MailVerifier();

	@Test
	public void testOnlyOneAt() {
		assertTrue(verificador.isValidEmailAddress("juan@mail.com"));
		assertFalse(verificador.isValidEmailAddress("juan@aitor@mail.com"));
		assertFalse(verificador.isValidEmailAddress("juan.com"));
	}

	@Test
	public void testNoSpacesNorCommas() throws Exception {
		assertFalse(verificador.isValidEmailAddress("juan@aitor mail.com"));
		assertFalse(verificador.isValidEmailAddress("juan@co,m"));
	}

	@Test
	public void testADotAfterAt() throws Exception {
		assertFalse(verificador.isValidEmailAddress("juan@mailcom"));
	}

}
