package com.sipgate.type.extension;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExtensionTypeTest
{

	@Test
	public void testEnumToExtensionMapping()
	{
		for (final ExtensionType type : ExtensionType.values())
		{
			assertThat("Checking type mapping for type " + type + ":", type.buildExtension("1234567", "1").getClass().getSimpleName(), is(type.toString()));
		}
	}

	@Test
	private void testToString()
	{
		for (final ExtensionType type : ExtensionType.values())
		{
			assertThat("Checking toString for type " + type + ":", type.buildExtension("1234567", "1").toString(), is("1234567" + type.toString().toLowerCase() + "1"));
		}
	}
}
