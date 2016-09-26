package com.sipgate.type.number;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

import java.util.Optional;

public class GermanPhonenumber extends Phonenumber
{
	public static Optional<Phonenumber> parseFrom(String number)
	{
		try
		{
			final PhoneNumberUtil utils = PhoneNumberUtil.getInstance();
			final PhoneNumber phonenumber = utils.parse(sanitizeGermanNumber(number), "DE");
	
			return Optional.of(new GermanPhonenumber(phonenumber));
		}
		catch (final NumberParseException e)
		{
			return Optional.empty();
		}
	}

	private static String sanitizeGermanNumber(String number)
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

	private GermanPhonenumber(PhoneNumber number)
	{
		super(number);
	}
}
