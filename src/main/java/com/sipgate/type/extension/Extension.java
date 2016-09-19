package com.sipgate.type.extension;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Extension
{
	public static Optional<Extension> parse(String extension)
	{
		final Matcher matcher = Pattern.compile("(\\d+)(\\D+)(\\d+)").matcher(extension);

		if (matcher.matches())
		{
			final String extensionType = matcher.group(2).toLowerCase();

			try
			{
				final Class<?> type = Class.forName("com.sipgate.type.extension." + extensionType.toUpperCase());

				if (Extension.class.isAssignableFrom(type))
				{
					return Optional.ofNullable((Extension)type.newInstance());
				}
			}
			catch (final ReflectiveOperationException e)
			{
				return Optional.empty();
			}
		}

		return Optional.empty();
	}
}
