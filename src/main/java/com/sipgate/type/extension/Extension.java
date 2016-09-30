package com.sipgate.type.extension;

import com.sipgate.type.user.MasterSipid;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.text.MessageFormat.format;

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

	public abstract String getDescription();

	public static Extension build(String masterSipid, ExtensionType type, String extensionId)
	{
		return type.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildA(String masterSipid, String extensionId)
	{
		return ExtensionType.A.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildC(String masterSipid, String extensionId)
	{
		return ExtensionType.C.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildE(String masterSipid, String extensionId)
	{
		return ExtensionType.E.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildF(String masterSipid, String extensionId)
	{
		return ExtensionType.F.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildG(String masterSipid, String extensionId)
	{
		return ExtensionType.G.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildH(String masterSipid, String extensionId)
	{
		return ExtensionType.H.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildI(String masterSipid, String extensionId)
	{
		return ExtensionType.I.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildQ(String masterSipid, String extensionId)
	{
		return ExtensionType.Q.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildR(String masterSipid, String extensionId)
	{
		return ExtensionType.R.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildS(String masterSipid, String extensionId)
	{
		return ExtensionType.S.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildT(String masterSipid, String extensionId)
	{
		return ExtensionType.T.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildV(String masterSipid, String extensionId)
	{
		return ExtensionType.V.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildW(String masterSipid, String extensionId)
	{
		return ExtensionType.W.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildX(String masterSipid, String extensionId)
	{
		return ExtensionType.X.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildY(String masterSipid, String extensionId)
	{
		return ExtensionType.Y.buildExtension(masterSipid, extensionId);
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

	@Override
	public String toString()
	{
		return format("{0}{1}{2}", masterSipid, type.getKey(), id);
	}
}
