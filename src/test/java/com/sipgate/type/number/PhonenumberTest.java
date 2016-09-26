package com.sipgate.type.number;

import org.junit.Test;

import static com.sipgate.type.number.Phonenumber.parse;
import static com.sipgate.type.number.Phonenumber.parseSave;
import static com.sipgate.type.user.Domain.CO_UK;
import static com.sipgate.type.user.Domain.UNKNOWN;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class PhonenumberTest
{
	@Test
	public void testParser()
	{
		assertThat(parse("02089939152").toString(), is("492089939152"));
		assertThat(parse("00492089939152").toString(), is("492089939152"));
		assertThat(parse("+492089939152").toString(), is("492089939152"));
		assertThat(parse("492089939152").toString(), is("492089939152"));
		assertThat("Telefonnummer Borkum von local", parse("04922579").toString(), is("494922579"));
		assertThat("Telefonnummer Borkum von local ohne führende 0", parse("4922579").toString(), is("494922579"));
		assertThat("Telefonnummer Borkum von e164", parse("494922579").toString(), is("494922579"));
		assertThat("Telefonnummer Borkum von e164 dekoriert", parse("00494922579").toString(), is("494922579"));
		assertThat("Telefonnummer Borkum von e164 dekoriert", parse("+494922579").toString(), is("494922579"));
	}

	@Test
	public void testGetCountryCode() throws Exception
	{
		assertThat(parse("02089939152").getCountryCode(), is("49"));
		assertThat(parse("04922579").getCountryCode(), is("49"));
		assertThat(parse("020656254").getCountryCode(), is("49"));
	}

	@Test
	public void testGetAreaCode() throws Exception
	{
		assertThat(parse("02089939152").getAreaCode(), is("208"));
		assertThat(parse("04922579").getAreaCode(), is("4922"));
		assertThat(parse("020656254").getAreaCode(), is("2065"));
	}

	@Test
	public void testGetSubscriberNumber() throws Exception
	{
		assertThat(parse("02089939152").getSubscriberNumber(), is("9939152"));
		assertThat(parse("04922579").getSubscriberNumber(), is("579"));
		assertThat(parse("020656254").getSubscriberNumber(), is("6254"));
	}

	@Test
	public void testToLocal() throws Exception
	{
		assertThat(parse("02089939152").toLocal(), is("0208 9939152"));
		assertThat(parse("04922579").toLocal(), is("04922 579"));
	}

	@Test
	public void testEquals() throws Exception
	{
		assertThat(parse("02089939152").toString(), is("492089939152"));
	}

	@Test
	public void testParsingBritishNumber() throws Exception
	{
		assertThat(parse("442074228400", CO_UK).toString(), is("442074228400"));
		assertThat(parse("02074228400", CO_UK).toString(), is("442074228400"));
		assertThat(parse("02074228400", CO_UK).toLocal(), is("020 7422 8400"));
	}

	@Test
	public void testBritishNumberToLocal() throws Exception
	{
		assertThat(parse("02074228400", CO_UK).toLocal(), is("020 7422 8400"));
	}

	@Test()
	public void testExceptionSaveParsingNumberWithUnknownLocal() throws Exception
	{
		assertThat(parseSave("02074228400", UNKNOWN), hasProperty("present", is(false)));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testParsingNumberWithUnknownLocal() throws Exception
	{
		parse("02074228400", UNKNOWN);
	}
}
