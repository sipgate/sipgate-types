package com.sipgate.type.user;

import java.util.Locale;

import static org.apache.commons.lang3.StringUtils.trimToEmpty;

public enum Domain
{
	DE("sipgate.de", Locale.GERMAN),
	CO_UK("sipgate.co.uk", Locale.ENGLISH),
	UNKNOWN("", Locale.GERMAN);

	private final String key;
	private final Locale locale;

	private Domain(final String key, final Locale locale)
	{
		this.key = key;
		this.locale = locale;
	}

	public Locale getLocale()
	{
		return locale;
	}

	@Override
	public String toString()
	{
		return key;
	}

	public static Domain parse(final String input)
	{
		final String key = trimToEmpty(input).toLowerCase();

		for (final Domain domain : values())
		{
			if (domain.key.equals(key))
			{
				return domain;
			}
		}

		return UNKNOWN;
	}
}
