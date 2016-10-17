package com.sipgate.type.extension;

import com.sipgate.type.user.MasterSipid;

import static com.sipgate.type.extension.ExtensionType.E;

public final class E extends Extension
{
	static final String DESCRIPTION = "SIP-Client-Extension";

	E(MasterSipid masterSipid, String id)
	{
		super(masterSipid, E, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
