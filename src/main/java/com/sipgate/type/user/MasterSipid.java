package com.sipgate.type.user;

import static java.text.MessageFormat.format;
import static org.apache.commons.lang3.StringUtils.trimToEmpty;

public class MasterSipid
{
	/**
	 * Convenient way to build a new MasterSipid instance.
	 * The given input will be validated and result in an {@link IllegalArgumentException} if the check fails.
	 *
	 * @param masterSipid String representation of a mastersipid.
	 *
	 *  @throws IllegalArgumentException in case of any invalid input that doesn't
	 *
	 * @return An MasterSipid instance
	 */
	public static MasterSipid of(String masterSipid)
	{
		final String input = trimToEmpty(masterSipid);

		if (invalid(input))
		{
			throw new IllegalArgumentException(format("Cannot validate {0} to a valid masterSipid", masterSipid));
		}

		return new MasterSipid(input);
	}

	private static boolean invalid(String masterSipid)
	{
		return ! masterSipid.matches("^\\d{7}$");
	}

	private final String masterSipid;

	private MasterSipid(String key)
	{
		this.masterSipid = key;
	}

	public String getKey()
	{
		return masterSipid;
	}

	@Override
	public String toString()
	{
		return masterSipid;
	}

	@Override
	public int hashCode()
	{
		return masterSipid.hashCode();
	}

	@Override
	public boolean equals(Object that)
	{
		return masterSipid.equals(that);
	}
}
