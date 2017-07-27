package com.sipgate.type.user.calls;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.sipgate.type.calls.SessionId;
import com.sipgate.type.extension.Extension;
import org.junit.Test;

public class SessionIdTest {
	private final String id = "click2api-0049163777-1168212e1-0.465734058138079-hasel";
	private final String idExpected = "click2api-0049163777-1168212e1-0.465734058138079";
	private final Extension owner = Extension.parse("1168212w0").get();
	private final String tos = "api-voice";
	private final String encoded = "52046B02140C4329160C1709410D2606020851041202485C7E5D5C52575043564559445C1C5F575F410A5F68594D4D5D70547E5153085C505D57564E565A06593213034A5455635F605E443945";

	@Test
	public void encodeDecode() throws Exception {
		SessionId fromDecoded = new SessionId(id, owner, tos);
		SessionId fromEncoded = new SessionId(fromDecoded.getEncoded());

		assertThat(fromEncoded.getId(), is(idExpected));
		assertThat(fromEncoded.getOwner(), is(owner));
		assertThat(fromEncoded.getTos(), is(tos));
	}

	@Test
	public void encodesToApiDCompatible() {
		SessionId sessionId = new SessionId(id, owner, tos);
		assertThat(
			sessionId.getEncoded(),
			is(encoded)
		);
	}

	@Test
	public void decodesToApiDCompatible() throws Exception {
		SessionId sessionId = new SessionId(encoded);
		assertThat(sessionId.getId(), is(idExpected));
		assertThat(sessionId.getOwner(), is(owner));
		assertThat(sessionId.getTos(), is(tos));
	}
}
