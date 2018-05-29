package com.sipgate.type.user;

import static java.text.MessageFormat.format;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

import com.sipgate.type.extension.ExtensionType;
import com.sipgate.type.extension.W;
import java.io.Serializable;
import java.util.Optional;

/**
 * Convenience class bundling {@link W} and {@link Domain}.
 */
public class Webuser implements Serializable {
	private final W webuserId;
	private final Domain domain;

	public static Webuser of(final W webuserId, final Domain domain) {
		return new Webuser(webuserId, domain);
	}

	public static Optional<Webuser> of(final String webuserId, final  String domain) {
		return W.parse(webuserId)
				.filter(extension -> extension.getType() == ExtensionType.W)
				.map(extension -> (W)extension)
				.map(w -> new Webuser(w, Domain.parse(domain)));
	}

	public Webuser(W webuserId, Domain domain) {
		this.webuserId = webuserId;
		this.domain = domain;
	}

	public W getWebuserId() {
		return webuserId;
	}

	public Domain getDomain() {
		return domain;
	}

	public User toUser() {
		return User.of(webuserId.getMasterSipid(), domain);
	}

	@Override
	public String toString() {
		return format("{0} ({1})", webuserId, domain);
	}

	@Override
	public boolean equals(Object obj) {
		return reflectionEquals(this, obj, false);
	}

	@Override
	public int hashCode() {
		return reflectionHashCode(this, false);
	}
}
