package com.sipgate.type.extension;

import com.sipgate.type.user.MasterSipid;

import static com.sipgate.type.extension.ExtensionType.C;

public final class C extends Extension
{
	static final String DESCRIPTION = "A conference room";

	C(MasterSipid masterSipid, String id)
	{
		super(masterSipid, C, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
