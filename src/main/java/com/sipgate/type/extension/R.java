package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class R extends Extension
{
	static final String DESCRIPTION = "Groucall-Announcement-extension for sipgate.de only. Technically the same as callthrough, but with d";


	R(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
