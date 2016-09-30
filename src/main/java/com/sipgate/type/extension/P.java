package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.P;

public final class P extends Extension
{
	static final String DESCRIPTION = "Group-Extension for a person (a Webuser in most cases)";

	P(String masterSipid, String id)
	{
		super(masterSipid, P, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
