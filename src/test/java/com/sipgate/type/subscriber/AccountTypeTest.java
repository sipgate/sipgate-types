package com.sipgate.type.subscriber;

import static com.sipgate.type.subscriber.AccountType.BUSINESS;
import static com.sipgate.type.subscriber.AccountType.PRIVATE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Optional;
import org.junit.Test;

public class AccountTypeTest {
	@Test
	public void testParseShouldReturnBusiness() {
		assertThat(AccountType.parse("business").get(), is(BUSINESS));
	}

	@Test
	public void testParseShouldReturnPrivate() {
		assertThat(AccountType.parse("private").get(), is(PRIVATE));
	}

	@Test
	public void testParseShouldReturnEmptyOptional() {
		assertThat(AccountType.parse(""), is(Optional.empty()));
		assertThat(AccountType.parse("non-existant-brand"), is(Optional.empty()));
	}
}
