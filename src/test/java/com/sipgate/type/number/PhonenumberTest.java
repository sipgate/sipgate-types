package com.sipgate.type.number;

import static com.sipgate.type.number.Phonenumber.isValidE164;
import static com.sipgate.type.number.Phonenumber.of;
import static com.sipgate.type.number.Phonenumber.parseSafe;
import static com.sipgate.type.user.Domain.CO_UK;
import static com.sipgate.type.user.Domain.UNKNOWN;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.sipgate.type.user.Domain;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

public class PhonenumberTest {

	@Test
	public void testParser() {
		assertThat(of("02089939152").toString(), is("492089939152"));
		assertThat(of("00492089939152").toString(), is("492089939152"));
		assertThat(of("+492089939152").toString(), is("492089939152"));
		assertThat(of("492089939152").toString(), is("492089939152"));
		assertThat("Telefonnummer Borkum von local", of("04922579").toString(), is("494922579"));
		assertThat("Telefonnummer Borkum von local ohne führende 0", of("4922579").toString(), is("494922579"));
		assertThat("Telefonnummer Borkum von e164", of("494922579").toString(), is("494922579"));
		assertThat("Telefonnummer Borkum von e164 dekoriert", of("00494922579").toString(), is("494922579"));
		assertThat("Telefonnummer Borkum von e164 dekoriert", of("+494922579").toString(), is("494922579"));
	}

	@Test
	public void testParserSipgateMobileNumber() {
		assertThat(of("015797788135").toString(), is("4915797788135"));
		assertThat(of("004915797788135").toString(), is("4915797788135"));
		assertThat(of("+4915797788135").toString(), is("4915797788135"));
		assertThat(of("4915797788135").toString(), is("4915797788135"));
	}

	@Test
	public void testParserShouldGenerateGermanNumberObject() throws Exception {
		assertThat(of("492074228400"), instanceOf(GermanPhonenumber.class));
		assertThat(of("492074228400", Domain.DE), instanceOf(GermanPhonenumber.class));
		assertThat(of("4915797788135"), instanceOf(GermanPhonenumber.class));
		assertThat(of("4915797788135", Domain.DE), instanceOf(GermanPhonenumber.class));
	}

	@Test
	public void testGetCountryCode() throws Exception {
		assertThat(of("02089939152").getCountryCode(), is("49"));
		assertThat(of("04922579").getCountryCode(), is("49"));
		assertThat(of("020656254").getCountryCode(), is("49"));
		assertThat(of("015797788135").getCountryCode(), is("49"));
	}

	@Test
	public void testGetAreaCode() throws Exception {
		assertThat(of("02089939152").getAreaCode(), is("208"));
		assertThat(of("04922579").getAreaCode(), is("4922"));
		assertThat(of("020656254").getAreaCode(), is("2065"));
		assertThat(of("015797788135").getAreaCode(), is("1579"));
	}

	@Test
	public void testGetSubscriberNumber() throws Exception {
		assertThat(of("02089939152").getSubscriberNumber(), is("9939152"));
		assertThat(of("04922579").getSubscriberNumber(), is("579"));
		assertThat(of("020656254").getSubscriberNumber(), is("6254"));
		assertThat(of("015797788135").getSubscriberNumber(), is("7788135"));
	}

	@Test
	public void testToLocal() throws Exception {
		assertThat(of("02089939152").toLocal(), is("0208 9939152"));
		assertThat(of("04922579").toLocal(), is("04922 579"));
		assertThat(of("015797788135").toLocal(), is("01579 7788135"));
	}

	@Test
	public void testEquals() throws Exception {
		assertThat(of("02089939152").toString(), is("492089939152"));
	}

	@Test
	public void testParserShouldGenerateBritishNumberObject() throws Exception {
		assertThat(of("442074228400", CO_UK), instanceOf(BritishPhonenumber.class));
		assertThat(of("442072663311", CO_UK), instanceOf(BritishPhonenumber.class));
	}

	@Test
	public void testParsingBritishNumber() throws Exception {
		assertThat(of("442074228400", CO_UK).toString(), is("442074228400"));
		assertThat(of("442072663311", CO_UK).toString(), is("442072663311"));
		assertThat(of("02074228400", CO_UK).toString(), is("442074228400"));
		assertThat(of("02074228400", CO_UK).toLocal(), is("020 7422 8400"));
	}

	@Test
	public void testParsingInternationslNumber() throws Exception {
		assertThat(of("+972559163653").getCountryCode(), is("972"));
		assertThat(of("+972559163653").getAreaCode(), is("55"));
		assertThat(of("+972559163653").getSubscriberNumber(), is("9163653"));
	}

	@Test
	public void testBritishNumberToLocal() throws Exception {
		assertThat(of("02074228400", CO_UK).toLocal(), is("020 7422 8400"));
	}

	@Test()
	public void testExceptionSaveParsingNumberWithUnknownLocal() throws Exception {
		assertThat(parseSafe("02074228400", UNKNOWN), hasProperty("present", is(false)));
	}

	@Test
	public void testFetchingAreaCodeFromBritishNumber() throws Exception {
		assertThat(of("02074228400", CO_UK).getAreaCode(), is("20"));
	}

	@Test
	public void testFetchingCountryCodeFromBritishNumber() throws Exception {
		assertThat(of("02074228400", CO_UK).getCountryCode(), is("44"));
	}

	@Test
	public void testFetchingSubscriberNumber() throws Exception {
		assertThat(of("02074228400", CO_UK).getSubscriberNumber(), is("74228400"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParsingNumberWithUnknownLocal() throws Exception {
		of("02074228400", UNKNOWN);
	}

	@Test
	public void testSerialization() throws Exception {
		final Phonenumber number = Phonenumber.of("491796249000");

		final byte[] bytes = SerializationUtils.serialize(number);

		assertThat(SerializationUtils.deserialize(bytes), is(number));
	}

	@Test
	public void testIsValidE164() throws Exception {
		assertTrue(isValidE164("+492116355550"));
		assertTrue(isValidE164("+442072725777"));
		assertTrue(isValidE164("+48 22 853 00 07"));

		assertFalse(isValidE164(null));
		assertFalse(isValidE164(""));
		assertFalse(isValidE164("442072725777"));
		assertFalse(isValidE164("02116355550"));
	}
}
