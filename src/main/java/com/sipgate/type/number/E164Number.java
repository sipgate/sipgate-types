package com.sipgate.type.number;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class E164Number
{
	private final PhoneNumber number;

	private static final Map<String, String> ONKZ = new HashMap<>();

	static
	{
		try (
				final InputStream input = E164Number.class.getResourceAsStream("/onkz");
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
			throw new RuntimeException("Cannot initialize ONKZ databse from resource '/onkz'");
		}
	}

	public E164Number(PhoneNumber number)
	{
		this.number = number;
	}

	public static E164Number parse(String number)
	{
		try
		{
			final PhoneNumberUtil utils = PhoneNumberUtil.getInstance();
			final PhoneNumber phonenumber = utils.parse(sanitize(number), "DE");

			return new E164Number(phonenumber);
		}
		catch (final NumberParseException e)
		{
			throw new IllegalArgumentException("Cannot parse {} to e164 format");
		}
	}

	private static String sanitize(String number)
	{
		String sanitized;

		if ((number.startsWith("49") && (number.length() > 10)))
		{
			sanitized = "+" + number;
		}
		else
		{
			sanitized = number;
		}
		return sanitized;
	}

	public String toLocal()
	{
		return PhoneNumberUtil.getInstance().format(number, PhoneNumberFormat.NATIONAL).replaceAll("^\\+", "");
	}

	@Override
	public String toString()
	{
		return PhoneNumberUtil.getInstance().format(number, PhoneNumberFormat.E164).replaceAll("^\\+", "");
	}
}
