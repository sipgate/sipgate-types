package com.sipgate.type.user;

import static org.apache.commons.lang3.SerializationUtils.deserialize;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

public class MasterSipidTest {
	@Test
	public void testInstantiationSucceedsOnValidInput() {
		assertThat(MasterSipid.of("1000000"), notNullValue());
		assertThat(MasterSipid.of("1000000").toString(), is("1000000"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInstantiationFailsOnNull() throws Exception {
		MasterSipid.of(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInstantiationFailsOnEmptyInput() throws Exception {
		MasterSipid.of("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInstantiationFailsOnInvalidInput()
			throws Exception {
		MasterSipid.of("abcdefg");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInstantiationFailsOnTooLongInput()
			throws Exception {
		MasterSipid.of("12345678");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInstantiationFailsOnTooShortInput()
			throws Exception {
		MasterSipid.of("123456");
	}

	@Test
	public void testSerialization() throws Exception {
		final MasterSipid masterSipid = MasterSipid.of("2030302");

		final byte[] bytes = SerializationUtils.serialize(masterSipid);

		assertThat(deserialize(bytes), is(masterSipid));
	}
}
