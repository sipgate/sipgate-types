package com.sipgate.type.extension;

import com.sipgate.type.user.MasterSipid;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.text.MessageFormat.format;

/*
+------------------------------------------------------------------------------------------------------+--------+
| description                                                                                          | prefix |
+------------------------------------------------------------------------------------------------------+--------+
| Application Extension For CallAPID                                                                   | a      |
| A conference room                                                                                    | c      |
| SIP-Client-Extension.                                                                                | e      |
| Webfax-Extension, in+out                                                                             | f      |
| Callgroup-Extension                                                                                  | g      |
| Enables IVR                                                                                          | h      |
| Extension for SIM                                                                                    | i      |
| Group-Extension for a person (a Webuser in most cases)                                               | p      |
| Allows customer to enable incoming queue on groups for                                               | q      |
| Groucall-Announcement-extension for sipgate.de only. Technically the same as callthrough, but with d | r      |
| SMS-Extension                                                                                        | s      |
| Trunking extension for custom PBXes (10 channels)                                                    | t      |
| Voicemail-Extension                                                                                  | v      |
| Webuser-Extension, can be admin or not                                                               | w      |
| Generic External phone extension, e.g. for mobiles                                                   | x      |
| y(i) for mobile extensions                                                                           | y      |
+------------------------------------------------------------------------------------------------------+--------+
*/

public abstract class Extension
{
	private final MasterSipid masterSipid;
	private final ExtensionType type;
	private final String id;

	public Extension(MasterSipid masterSipid, ExtensionType type, String id)
	{
		this.masterSipid = masterSipid;
		this.type = type;
		this.id = id;
	}

	public Extension(String masterSipid, ExtensionType type, String id)
	{
		this.masterSipid = MasterSipid.of(masterSipid);
		this.type = type;
		this.id = id;
	}

	public ExtensionType getType() {
		return type;
	}

	public MasterSipid getMasterSipid()
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
		return format("{0}{1}{2}", masterSipid, type.getKey(), id);
	}
}
