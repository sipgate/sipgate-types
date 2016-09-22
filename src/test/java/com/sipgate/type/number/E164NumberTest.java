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
	public void testName() throws Exception
	{
		assertThat(parse("02089939152").toLocal(), is("0208 9939152"));
		assertThat(parse("04922579").toLocal(), is("04922 579"));
	}
}
