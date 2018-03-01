package com.sipgate.type.rest.api;

import static org.apache.commons.lang3.StringUtils.trimToEmpty;

import java.util.Optional;
import java.util.stream.Stream;

public enum Header {
	AUTH_WEBUSERID("X-Sipgate-Auth-WebuserId"),
	AUTH_MASTERSIPID("X-Sipgate-Auth-Mastersipid"),
	AUTH_DOMAIN("X-Sipgate-Auth-Domain"),
	AUTH_REQUIRED("X-Sipgate-Auth-Required"),
	AUTH_SCOPE("X-Sipgate-Auth-Scope"),
	CLIENT_IP_ADDRESS("X-Sipgate-Client-Ip-Address"),
	ADMIN("X-Sipgate-Admin"),
	NQ("X-Sipgate-NQ");

	private final String key;

	private Header(final String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	@Override
	public String toString() {
		return this.key;
	}

	public static Optional<Header> parse(final String key) {
		return Stream.of(Header.values())
				.filter(e -> e.key.equals(trimToEmpty(key).toLowerCase()))
				.findFirst();
	}
}
