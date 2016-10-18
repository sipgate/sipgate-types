package com.sipgate.type.extension;

import com.sipgate.type.user.MasterSipid;

import static com.sipgate.type.extension.ExtensionType.R;

public final class R extends Extension
{
	static final String DESCRIPTION = "Groucall-Announcement-extension for sipgate.de only. Technically the same as callthrough, but with d";


	R(MasterSipid masterSipid, String id)
	{
		super(masterSipid, R, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
