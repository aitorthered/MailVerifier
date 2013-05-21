import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.csd.day2.MailVerifier;

public class VerificadorMailTest {

	final MailVerifier verificador = new MailVerifier();

	@Test
	public void testOnlyOneAt() {
		assertTrue(verificador.isValidEmailAddress("ju.an@mail.com"));
		assertFalse(verificador.isValidEmailAddress("ju.an@aitor@mail.com"));
		assertFalse(verificador.isValidEmailAddress("juan.com"));
	}

	@Test
	public void testNoSpacesNorCommas() throws Exception {
		assertFalse(verificador.isValidEmailAddress("ju.an@aitor mail.com"));
		assertFalse(verificador.isValidEmailAddress("ju.an@co,m"));
	}

	@Test
	public void testADotAfterAt() throws Exception {
		assertFalse(verificador.isValidEmailAddress("ju.an@mailcom"));
		assertTrue(verificador.isValidEmailAddress("ju.an@mail.patata.com"));
	}

	@Test
	public void testADotBeforeAt() throws Exception {
		assertFalse(verificador.isValidEmailAddress("juan@mail.com"));
		assertTrue(verificador
				.isValidEmailAddress("juan.apellido@mail.patata.com"));
	}

}
