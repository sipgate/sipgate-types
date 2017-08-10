package com.sipgate.type.number;

import static com.sipgate.type.user.Domain.DE;
import static java.text.MessageFormat.format;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.sipgate.type.user.Domain;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Represents any phonenumber and is a convenient object to grant valid phonenumbers and ass them pass phonenumbers in a
 * typesafe way. <br>
 * Phonenumber objects can be instantiated using several static buider methods:
 * <li>{@link #of(String)}</li>
 * <li>{@link #of(String, Domain)}</li>
 * <li>{@link #parseSafe(String)}</li>
 * <li>{@link #parseSafe(String, Domain)}</li>
 * TODO: Should implement Serializable
 */
public abstract class Phonenumber implements Serializable {
	private final PhoneNumber number;

	private static final Map<String, String> ONKZ = new HashMap<>();

	static {
		try (
				final InputStream input = Phonenumber.class.getResourceAsStream("/onkz");
				final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				final String[] parts = line.split("\\t");
				ONKZ.put(parts[0], parts[1]);
			}
		} catch (final IOException e) {
			throw new RuntimeException("Cannot initialize ONKZ database from resource '/onkz'", e);
		}
	}

	public Phonenumber(PhoneNumber number) {
		this.number = number;
	}

	/**
	 * Builds a {@link Phonenumber}-instance by parsing a given String representation. <br>
	 * Example: <br>
	 * <code>Phonenumber.of("021155555555");</code> returns a Phonenumber instance representating
	 * the given number.
	 *
	 * @param number String representation of a valid phonenumber. The String can be formatted in local notation or
	 *               e164.
	 * @return Phonenumber object representing the given input.
	 * @throws IllegalArgumentException if the given String cannot be parsed to a {@link Phonenumber}. Use
	 *                                  {@link #parseSafe(String)} if this behaviour is inconvenient.
	 */
	public static Phonenumber of(String number) {
		return of(number, DE);
	}

	public static Phonenumber of(String number, Domain domain) {
		if (domain == null) {
			throw new IllegalArgumentException("Invalid localization given: NULL");
		}

		final Optional<Phonenumber> result = parseSafe(number, domain);

		if (result.isPresent()) {
			return result.get();
		}

		throw new IllegalArgumentException(format("Cannot parse {0} to a valid telephone number", number));
	}

	public static Phonenumber fromString(String phonenumber) {
		return Phonenumber.of(phonenumber);
	}

	public static Optional<Phonenumber> parseSafe(String number) {
		return parseSafe(number, DE);
	}

	public static Optional<Phonenumber> parseSafe(String number, Domain domain) {
		if (domain == null) {
			return Optional.empty();
		}

		switch (domain) {
			case CO_UK:
				return BritishPhonenumber.parse(number);

			case DE:
				return GermanPhonenumber.parse(number);

			default:
				return Optional.empty();
		}
	}

	public static Boolean isValid(String number) {
		return parseSafe(number).isPresent();
	}

	public static Boolean isValid(String number, Domain domain) {
		return parseSafe(number, domain).isPresent();
	}

	public String toLocal() {
		return PhoneNumberUtil.getInstance().format(number, PhoneNumberFormat.NATIONAL).replaceAll("^\\+", "");
	}

	public String getE164() {
		return PhoneNumberUtil.getInstance().format(number, PhoneNumberFormat.E164).replaceAll("^\\+", "");
	}

	public String getCountryCode() {
		return String.valueOf(number.getCountryCode());
	}

	public String getAreaCode() {
		final String nationalSignificantNumber = PhoneNumberUtil.getInstance().getNationalSignificantNumber(number);
		final int length = PhoneNumberUtil.getInstance().getLengthOfNationalDestinationCode(number);

		if (length > 0) {
			return String.valueOf(nationalSignificantNumber.substring(0, length));
		}

		return "";
	}

	public String getSubscriberNumber() {
		final String nationalSignificantNumber = PhoneNumberUtil.getInstance().getNationalSignificantNumber(number);
		final int length = PhoneNumberUtil.getInstance().getLengthOfNationalDestinationCode(number);

		if (length > 0) {
			return String.valueOf(nationalSignificantNumber.substring(length));
		}

		return "";
	}

	@Override
	public String toString() {
		return getE164();
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Phonenumber) {
			return ((Phonenumber) other).getE164().equals(getE164());
		}

		return false;
	}

	@Override
	public int hashCode() {
		return getE164().hashCode();
	}
}
