package com.sipgate.type.subscriber;

import static org.apache.commons.lang3.StringUtils.trimToEmpty;

import java.util.Optional;
import java.util.stream.Stream;

public enum AccountType {
	BUSINESS("business"),
	PRIVATE("private");

	private final String key;

	private AccountType(final String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return this.key;
	}


	public static Optional<AccountType> parse(final String accountType) {
		return Stream.of(AccountType.values())
				.filter(e -> e.key.equals(trimToEmpty(accountType).toLowerCase()))
				.findFirst();
	}

}
