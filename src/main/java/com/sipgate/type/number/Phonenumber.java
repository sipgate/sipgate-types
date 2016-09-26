package com.sipgate.type.number;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.sipgate.type.user.Domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.sipgate.type.user.Domain.DE;
import static java.text.MessageFormat.format;

public abstract class Phonenumber
{
	private final PhoneNumber number;

	private static final Map<String, String> ONKZ = new HashMap<>();

	static
	{
		try (
				final InputStream input = Phonenumber.class.getResourceAsStream("/onkz");
				final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));)
		{
			String line;
			while ((line = bufferedReader.readLine()) != null)
			{
				final String[] parts = line.split("\\t");
				ONKZ.put(parts[0], parts[1]);
			}
		}
		catch (final IOException e)
		{
			throw new RuntimeException("Cannot initialize ONKZ database from resource '/onkz'");
		}
	}

	public Phonenumber(PhoneNumber number)
	{
		this.number = number;
	}

	public static Optional<Phonenumber> parseSave(String number)
	{
		return parseSave(number, DE);
	}

	public static Phonenumber parse(String number)
	{
		return parse(number, DE);
	}

	public static Phonenumber parse(String number, Domain domain)
	{
		if (domain == null)
		{
			throw new IllegalArgumentException("Invalid localization given: NULL");
		}
	
		final Optional<Phonenumber> result = parseSave(number, domain);
	
		if (result.isPresent())
		{
			return result.get();
		}
	
		throw new IllegalArgumentException(format("Cannot parse {0} to a valid british telephone number", number));
	
	}

	public static Optional<Phonenumber> parseSave(String number, Domain domain)
	{
		if (domain == null)
		{
			return Optional.empty();
		}

		switch (domain)
		{
			case CO_UK:

				return BritishPhonenumber.parseFrom(number);

			case DE:

				return GermanPhonenumber.parseFrom(number);

			default:

				return Optional.empty();
		}
	}

	public String toLocal()
	{
		return PhoneNumberUtil.getInstance().format(number, PhoneNumberFormat.NATIONAL).replaceAll("^\\+", "");
	}

	public String getE164()
	{
		return PhoneNumberUtil.getInstance().format(number, PhoneNumberFormat.E164).replaceAll("^\\+", "");
	}

	public String getCountryCode()
	{
		return String.valueOf(number.getCountryCode());
	}

	public String getAreaCode()
	{
		final String nationalSignificantNumber = PhoneNumberUtil.getInstance().getNationalSignificantNumber(number);
		final int length = PhoneNumberUtil.getInstance().getLengthOfNationalDestinationCode(number);

		if (length > 0)
		{
			return String.valueOf(nationalSignificantNumber.substring(0, length));
		}

		return "";
	}

	public String getSubscriberNumber()
	{
		final String nationalSignificantNumber = PhoneNumberUtil.getInstance().getNationalSignificantNumber(number);
		final int length = PhoneNumberUtil.getInstance().getLengthOfNationalDestinationCode(number);

		if (length > 0)
		{
			return String.valueOf(nationalSignificantNumber.substring(length));
		}

		return "";
	}

	@Override
	public String toString()
	{
		return getE164();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other instanceof Phonenumber)
		{
			return ((Phonenumber) other).getE164().equals(getE164());
		}

		return false;
	}

	@Override
	public int hashCode()
	{
		return getE164().hashCode();
	}
}
