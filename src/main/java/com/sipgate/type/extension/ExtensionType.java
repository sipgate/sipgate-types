package com.sipgate.type.extension;

import java.util.Optional;

public enum ExtensionType
{
	V("v")
	{
		@Override
		public Extension buildExtension(String masterSipid, String extensionId)
		{
			return new V(masterSipid, extensionId);
		}
	},

	W("w")
	{
		@Override
		public Extension buildExtension(String masterSipid, String extensionId)
		{
			return new W(masterSipid, extensionId);
		}
	};

	private String key;

	private ExtensionType(String key)
	{
		this.key = key;
	}

	abstract Extension buildExtension(String masterSipid, String extensionId);

	public String getKey()
	{
		return key;
	}

	public static Optional<ExtensionType> parse(String key)
	{
		for (final ExtensionType type : values())
		{
			if (type.getKey().equalsIgnoreCase(key))
			{
				return Optional.of(type);
			}
		}

		return Optional.empty();
	}
}
