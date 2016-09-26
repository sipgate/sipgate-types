package com.sipgate.type.number;

import org.junit.Test;

import static com.sipgate.type.number.E164Number.parse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class E164NumberTest
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
		assertThat(parse("00492089939152"), is(parse("02089939152")));
	}
}
