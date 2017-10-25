package com.sipgate.type.subscriber;

import static com.sipgate.type.subscriber.Brand.TEAM;
import static com.sipgate.type.subscriber.Brand.UNKNOWN;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Optional;
import org.junit.Test;

public class BrandTest {
	@Test
	public void testParseShouldReturnTeam() {

		assertThat(Brand.parse("team").get(), is(TEAM));
		assertThat(Brand.parse("team        ").get(), is(TEAM));
		assertThat(Brand.parse("      team").get(), is(TEAM));
	}

	@Test
	public void testParseEmptyStringShouldReturnTeam() {

		assertThat(Brand.parse("").get(), is(TEAM));
		assertThat(Brand.parse("         ").get(), is(TEAM));
	}

	@Test
	public void testParseShouldReturnEmptyOptional() {
		assertThat(Brand.parse("non-existant-brand"), is(Optional.empty()));
	}

	@Test
	public void testOfShouldReturnUnknown() {
		assertThat(Brand.of("non-existant-brand"), is(UNKNOWN));
	}

	@Test
	public void testOfShouldReturnTeam() {
		assertThat(Brand.of(""), is(TEAM));
		assertThat(Brand.of("team"), is(TEAM));
	}
}
