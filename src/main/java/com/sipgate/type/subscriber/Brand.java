package com.sipgate.type.subscriber;

import static org.apache.commons.lang3.StringUtils.defaultIfBlank;
import static org.apache.commons.lang3.StringUtils.trimToEmpty;

import java.util.Optional;
import java.util.stream.Stream;

public enum Brand {
	TEAM("team"),
	TRUNKING("trunking"),
	SATELLITE("satellite"),
	SIMQUADRAT("simquadrat"),
	GO("go"),
	IO("io"),
	UNKNOWN("unknown");

	private final String key;

	private Brand(final String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	@Override
	public String toString() {
		return this.key;
	}

	public static Optional<Brand> parse(final String brand) {
		return Stream.of(Brand.values())
				.filter(e -> e.key.equals(defaultIfBlank(trimToEmpty(brand), TEAM.key).toLowerCase()))
				.findFirst();
	}

	public static Brand of(final String brand) {
		return Stream.of(Brand.values())
				.filter(e -> e.key.equals(defaultIfBlank(trimToEmpty(brand), TEAM.key).toLowerCase()))
				.findFirst()
				.orElse(UNKNOWN);
	}
}
