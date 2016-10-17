package com.sipgate.type.extension;

import com.sipgate.type.user.MasterSipid;

import static com.sipgate.type.extension.ExtensionType.P;

public final class P extends Extension
{
	static final String DESCRIPTION = "Group-Extension for a person (a Webuser in most cases)";

	P(MasterSipid masterSipid, String id)
	{
		super(masterSipid, P, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
