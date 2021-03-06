package com.sipgate.type.user;

import static java.text.MessageFormat.format;
import static org.apache.commons.lang3.StringUtils.trimToEmpty;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

import com.sipgate.type.extension.Extension;
import com.sipgate.type.extension.ExtensionType;
import java.io.Serializable;
import java.util.Optional;

public class MasterSipid implements Serializable {

	/**
	 * Convenient way to build a new MasterSipid instance.
	 * The given input will be validated and result in an {@link IllegalArgumentException} if the check fails.
	 *
	 * <p>MasterSipid is serializable, a json serializer/deserializer will be provided.
	 *
	 * @param masterSipid String representation of a mastersipid.
	 * @return An MasterSipid instance
	 * @throws IllegalArgumentException in case of any invalid input that doesn't
	 */
	public static MasterSipid of(String masterSipid) {
		final String input = trimToEmpty(masterSipid);

		if (invalid(input)) {
			throw new IllegalArgumentException(format("Cannot validate {0} to a valid masterSipid", masterSipid));
		}

		return new MasterSipid(input);
	}

	/**
	 * allows RestEasy automatic parameter unmarshalling.
	 * This just wraps {@link #of(String masterSipid) of()}.
	 *
	 * <p>MasterSipid is serializable, a json serializer/deserializer will be provided.
	 *
	 * @param masterSipid String representation of a mastersipid.
	 * @return An MasterSipid instance
	 * @throws IllegalArgumentException in case of any invalid input that doesn't
	 */
	public static MasterSipid fromString(String masterSipid) {
		return MasterSipid.of(masterSipid);
	}

	public static Optional<MasterSipid> parse(String masterSipid) {
		final String input = trimToEmpty(masterSipid);

		if (invalid(input)) {
			return Optional.empty();
		}

		return Optional.of(new MasterSipid(input));
	}

	private static boolean invalid(String masterSipid) {
		return !masterSipid.matches("^\\d{7}$");
	}

	private final String masterSipid;

	private MasterSipid(String key) {
		this.masterSipid = key;
	}

	public String getKey() {
		return masterSipid;
	}

	public Extension deriveExtension(ExtensionType type, String id) {
		return Extension.build(this, type, id);
	}

	@Override
	public String toString() {
		return masterSipid;
	}

	@Override
	public int hashCode() {
		return reflectionHashCode(this, false);
	}

	@Override
	public boolean equals(Object that) {
		return reflectionEquals(this, that, false);
	}
}
