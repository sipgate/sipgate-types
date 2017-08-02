package com.sipgate.type.subscriber;

import static com.sipgate.type.subscriber.Product.TEAM;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Optional;
import org.junit.Test;

public class ProductTest {
	@Test
	public void testParseShouldReturnTeam() {
		assertThat(Product.parse("team").get(), is(TEAM));
	}

	@Test
	public void testParseEmptyStringShouldReturnTeam() {
		assertThat(Product.parse("").get(), is(TEAM));
	}

	@Test
	public void testParseShouldReturnEmptyOptional() {
		assertThat(Product.parse("non-existant-product"), is(Optional.empty()));
	}
}
