package com.sipgate.type.extension;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Extension
{
	private final String masterSipid;
	private final ExtensionType type;
	private final String id;

	public Extension(String masterSipid, ExtensionType type, String id)
	{
		super();
		this.masterSipid = masterSipid;
		this.type = type;
		this.id = id;
	}

	public ExtensionType getType() {
		return type;
	}

	public String getMasterSipid()
	{
		return masterSipid;
	}

	public String getId()
	{
		return id;
	}

	public static Extension build(String masterSipid, ExtensionType type, String extensionId)
	{
		return type.buildExtension(masterSipid, extensionId);
	}

	public static Extension getV(String masterSipid, String extensionId)
	{
		return ExtensionType.V.buildExtension(masterSipid, extensionId);
	}

	public static Extension getW(String masterSipid, String extensionId)
	{
		return ExtensionType.W.buildExtension(masterSipid, extensionId);
	}

	public static Optional<Extension> parse(String extension)
	{
		final Matcher matcher = Pattern.compile("(\\d+)(\\D+)(\\d+)").matcher(extension);

		if (!matcher.matches())
		{
			return Optional.empty();
		}

		final Optional<ExtensionType> type = ExtensionType.parse(matcher.group(2));

		if (!type.isPresent())
		{
			return Optional.empty();
		}

		final String extensionId = matcher.group(3);
		final String masterSipid = matcher.group(1);

		return Optional.ofNullable(type.get().buildExtension(masterSipid, extensionId));
	}

	@Override
	public String toString()
	{
		return masterSipid + type.getKey()  + id;
	}
}
