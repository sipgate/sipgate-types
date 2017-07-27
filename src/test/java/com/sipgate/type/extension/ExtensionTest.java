package com.sipgate.type.extension;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.sipgate.type.user.MasterSipid;
import java.util.Arrays;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;


public class ExtensionTest {

	@Test
	public void testParseExtensionHandlesInvalidInput() {
		assertThat(Extension.parse("1234567").isPresent(), is(false));
		assertThat(Extension.parse("1234567v").isPresent(), is(false));
		assertThat(Extension.parse("1234567a0").isPresent(), is(true));
		assertThat(Extension.parse("12345678a0").isPresent(), is(false));
	}

	@Test
	public void testParseExtensionHandlesValidInput() {
		assertThat((W) Extension.parse("1234567w0").get(), isA(W.class));
		assertThat((V) Extension.parse("1234567v0").get(), isA(V.class));
	}

	@Test
	public void testSerialization() throws Exception {
		for (final ExtensionType type : ExtensionType.values()) {
			final Extension extension = MasterSipid.of("2030302").deriveExtension(type, "10");

			final byte[] bytes = SerializationUtils.serialize(extension);

			assertThat(SerializationUtils.deserialize(bytes), is(extension));
		}
	}

	@Test
	public void testIsA() {
		Arrays.stream(ExtensionType.values())
				.map(extensionType -> Extension.build(MasterSipid.of("1234567"), extensionType, "1"))
				.forEach(extension -> assertTrue(Extension.isA(extension.toString(), extension.getType())));

		Arrays.stream(ExtensionType.values())
				.map(extensionType -> Extension.build(MasterSipid.of("1234567"), extensionType, "ww"))
				.forEach(extension -> assertFalse(Extension.isA(extension.toString(), extension.getType())));

		Arrays.stream(ExtensionType.values())
				.map(extensionType -> Extension.build(MasterSipid.of("1234567"), extensionType, "-1"))
				.forEach(extension -> assertFalse(Extension.isA(extension.toString(), extension.getType())));
	}
}
