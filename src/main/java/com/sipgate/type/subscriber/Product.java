package com.sipgate.type.subscriber;

import static org.apache.commons.lang3.StringUtils.defaultIfBlank;
import static org.apache.commons.lang3.StringUtils.trimToEmpty;

import java.util.Optional;
import java.util.stream.Stream;

public enum Product {
	TEAM("team"),
	PANAMA("panama"),
	SATELLITE("satellite");

	private final String key;

	private Product(final String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return this.key;
	}


	public static Optional<Product> parse(final String product) {
		return Stream.of(Product.values())
				.filter(e -> e.key.equals(defaultIfBlank(trimToEmpty(product), TEAM.key).toLowerCase()))
				.findFirst();
	}

}
