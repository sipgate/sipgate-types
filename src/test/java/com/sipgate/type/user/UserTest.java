package com.sipgate.type.user;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserTest
{
	@Test
	public void testSerialization()
	{
		final User user = User.of("2030302", "sipgate.de");

		final byte[] bytes = SerializationUtils.serialize(user);

		assertThat(SerializationUtils.deserialize(bytes), is(user));
	}
}
